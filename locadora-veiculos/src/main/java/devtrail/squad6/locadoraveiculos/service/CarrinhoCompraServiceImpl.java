package devtrail.squad6.locadoraveiculos.service;

import devtrail.squad6.locadoraveiculos.model.dto.AluguelDTO;
import devtrail.squad6.locadoraveiculos.model.dto.ResumoCarrinhoDTO;
import devtrail.squad6.locadoraveiculos.model.entity.Carro;
import devtrail.squad6.locadoraveiculos.model.entity.CarrinhoCompra;
import devtrail.squad6.locadoraveiculos.model.entity.Motorista;
import devtrail.squad6.locadoraveiculos.repository.CarrinhoCompraRepository;
import devtrail.squad6.locadoraveiculos.repository.MotoristaRepository;
import devtrail.squad6.locadoraveiculos.service.interfaces.CarrinhoCompraService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
public class CarrinhoCompraServiceImpl implements CarrinhoCompraService {

    @Autowired
    private CarrinhoCompraRepository carrinhoCompraRepository;

    @Autowired
    private CarroServiceImpl carroService;

    @Autowired
    private AluguelServiceImpl aluguelService;

    @Autowired
    private MotoristaRepository motoristaRepository;

    @Override
    public List<CarrinhoCompra> findAll() {
        return carrinhoCompraRepository.findAll();
    }

    @Override
    public CarrinhoCompra save(CarrinhoCompra carrinhoCompra) {
        try {
            return carrinhoCompraRepository.save(carrinhoCompra);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar o carrinho de compras: " + e.getMessage());
        }
    }

    public void adicionarAluguel(CarrinhoCompra carrinhoCompra, AluguelDTO aluguelDTO) {
        try {
            carrinhoCompra.getListaAlugueis().add(aluguelDTO);
            carrinhoCompraRepository.save(carrinhoCompra);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao adicionar aluguel ao carrinho: " + e.getMessage());
        }
    }

    public List<AluguelDTO> getAlugueisByMotoristaId(Long motoristaId) {
        Motorista motorista = motoristaRepository.findById(motoristaId)
                .orElseThrow(() -> new EntityNotFoundException("Motorista não encontrado"));
        CarrinhoCompra carrinho = findByMotorista(motorista);
        return carrinho.getListaAlugueis();
    }

    public void addAluguelByMotoristaId(AluguelDTO aluguelDTO) {
        Motorista motorista = motoristaRepository.findById(aluguelDTO.MotoristaId())
                .orElseThrow(() -> new EntityNotFoundException("Motorista não encontrado"));
        CarrinhoCompra carrinho = findByMotorista(motorista);
        adicionarAluguel(carrinho, aluguelDTO);
    }

    public void removeAluguelByMotoristaId(Long motoristaId, Long veiculoId) {
        Motorista motorista = motoristaRepository.findById(motoristaId)
                .orElseThrow(() -> new EntityNotFoundException("Motorista não encontrado"));
        CarrinhoCompra carrinho = findByMotorista(motorista);
        removeAluguel(carrinho, veiculoId);
    }

    public CarrinhoCompra findByMotorista(Motorista motorista) {
        try {
            return carrinhoCompraRepository.findByMotorista(motorista);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar o carrinho de compras por motorista: " + e.getMessage());
        }
    }

    @Override
    public CarrinhoCompra findById(Long carrinhoId) {
        return carrinhoCompraRepository.findById(carrinhoId)
                .orElseThrow(() -> new EntityNotFoundException("CarrinhoCompra não encontrado com o ID: " + carrinhoId));
    }

    public AluguelDTO findAluguelByCarroId(CarrinhoCompra carrinhoCompra, Long carroId) {
        return carrinhoCompra.getListaAlugueis().stream()
                .filter(aluguel -> aluguel.carroId().equals(carroId))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Aluguel não encontrado no carrinho para o carro com ID: " + carroId));
    }

    public void removeAluguel(CarrinhoCompra carrinhoCompra, Long carroId) {
        carrinhoCompra.getListaAlugueis().removeIf(aluguel -> aluguel.carroId().equals(carroId));
        save(carrinhoCompra);
    }

    public List<AluguelDTO> getAlugueisByCarrinhoId(Long carrinhoId) {
        CarrinhoCompra carrinho = carrinhoCompraRepository.findById(carrinhoId)
                .orElse(null);

        if (carrinho == null) {
            return Collections.emptyList();
        }

        return carrinho.getListaAlugueis();
    }

    public ResumoCarrinhoDTO obterResumoCarrinho(Long carrinhoId) {
        CarrinhoCompra carrinho = findById(carrinhoId);
        List<AluguelDTO> alugueis = carrinho.getListaAlugueis();
        BigDecimal total = calcularTotalCarrinho(alugueis);
        return new ResumoCarrinhoDTO(alugueis, total);
    }

    private BigDecimal calcularTotalCarrinho(List<AluguelDTO> alugueis) {
        BigDecimal total = BigDecimal.ZERO;
        for (AluguelDTO aluguel : alugueis) {
            Carro carro = carroService.findById(aluguel.carroId());
            long diasAluguel = ChronoUnit.DAYS.between(aluguel.dataPedido(), aluguel.dataEntrega()) + 1;
            BigDecimal valorAluguel = carro.getValorDiaria().multiply(BigDecimal.valueOf(diasAluguel));
            total = total.add(valorAluguel);
        }
        return total;
    }

    public void confirmarReserva(Long carrinhoId) {
        CarrinhoCompra carrinho = findById(carrinhoId);
        List<AluguelDTO> alugueis = carrinho.getListaAlugueis();

        for (AluguelDTO aluguelDTO : alugueis) {
            aluguelService.confirmarAluguel(aluguelDTO);
        }

        limparCarrinho(carrinhoId);
    }

    public void limparCarrinho(Long carrinhoId) {
        CarrinhoCompra carrinho = findById(carrinhoId);
        carrinho.getListaAlugueis().clear();
        save(carrinho);
    }
}