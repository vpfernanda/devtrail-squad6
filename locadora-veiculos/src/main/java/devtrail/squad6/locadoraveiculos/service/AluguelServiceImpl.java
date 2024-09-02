package devtrail.squad6.locadoraveiculos.service;

import devtrail.squad6.locadoraveiculos.mapper.CarroDetalheMapper;
import devtrail.squad6.locadoraveiculos.mapper.CarroFormMapper;
import devtrail.squad6.locadoraveiculos.model.dto.AluguelDTO;
import devtrail.squad6.locadoraveiculos.model.dto.CarroDTO;
import devtrail.squad6.locadoraveiculos.model.dto.CarroDetalheDTO;
import devtrail.squad6.locadoraveiculos.model.dto.CarroForm;
import devtrail.squad6.locadoraveiculos.model.entity.Aluguel;
import devtrail.squad6.locadoraveiculos.model.entity.Carro;
import devtrail.squad6.locadoraveiculos.model.entity.Motorista;
import devtrail.squad6.locadoraveiculos.repository.AluguelRepository;
import devtrail.squad6.locadoraveiculos.service.interfaces.AluguelService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class AluguelServiceImpl implements AluguelService {

    @Autowired
    private AluguelRepository aluguelRepository;
    @Autowired
    private AluguelRepository motoristaRepository;
    @Autowired
    private CarroServiceImpl carroService;

    private CarroDetalheMapper detalheMapper;
    private CarroFormMapper formMapper;

    @Override
    public Aluguel save(Aluguel aluguel) {
        try {
            Carro carro = aluguel.getCarro();
            if(carro.estaDisponivel(aluguel.getDataPedido(), aluguel.getDataDevolucao())){
                carro.bloquearDatas(aluguel.getDataEntrega(), aluguel.getDataDevolucao());
                carroService.saveNewDates(carro);
            }
            return aluguelRepository.save(aluguel);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Aluguel> findAll() {
        try {
            return aluguelRepository.findAll();
        } catch (Exception e) {
            System.out.println("Não foi possível encontrar registros de alugueis!");
        }
        return null;
    }

    public List<Aluguel> findAlugueisMotorista(Motorista motorista) {
        try {
            return aluguelRepository.findByMotorista(motorista);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public boolean processPayment(String cardNumber, String expirationDate, String cvv) {
        return verifyPayment(cardNumber, expirationDate, cvv);
    }

    public boolean verifyPayment(String cardNumber, String expirationDate, String cvv) {

        if (!cardNumber.matches("\\d{13,16}")) {
            System.out.println("fui eu: Cartão");
            return false;
        }
        if (!cvv.matches("\\d{3}")) {
            System.out.println("fui eu: cvv");
            return false;
        }
        if (!isExpirationDateValid(expirationDate)) {
            System.out.println("fui eu: Data");
            return false;
        }

        return true;
    }

    private boolean isExpirationDateValid(String expirationDate) {
        String[] parts = expirationDate.split("/");
        int month = Integer.parseInt(parts[0]);
        int year = Integer.parseInt(parts[1]);

        LocalDate currentDate = LocalDate.now();
        int currentMonth = currentDate.getMonthValue();
        int currentYear = currentDate.getYear() % 100;

        System.out.println(month + " / " + currentMonth);
        System.out.println(year + " / " + currentYear);

        return ((year > currentYear) || (year == currentYear && month >= currentMonth));
    }

    public Aluguel confirmarAluguel(AluguelDTO aluguelDTO) {
        CarroDetalheDTO carroDetalheDTO = carroService.findById(aluguelDTO.carroId());
        Carro carro = this.detalheMapper.dtoToModel(carroDetalheDTO);

        Motorista motorista = motoristaRepository.findById(aluguelDTO.MotoristaId())
                .orElseThrow(() -> new EntityNotFoundException("Motorista não encontrado")).getMotorista();

        Aluguel aluguel = new Aluguel();
        aluguel.setMotorista(motorista);
        aluguel.setCarro(carro);
        aluguel.setDataPedido(LocalDate.now());
        aluguel.setDataEntrega(aluguelDTO.dataPedido());
        aluguel.setDataDevolucao(aluguelDTO.dataEntrega());

        // Calcular valor total do aluguel (implemente a lógica de cálculo)
        BigDecimal valorTotal = calcularValorTotal(carro, aluguelDTO.dataPedido(), aluguelDTO.dataEntrega());
        aluguel.setValorTotal(valorTotal);

        carro.bloquearDatas(aluguelDTO.dataPedido(), aluguelDTO.dataEntrega());
        CarroForm salvo = this.formMapper.modelToDTO(carro);
        carroService.save(salvo); // Atualiza o carro com as datas bloqueadas

        return aluguelRepository.save(aluguel);
    }

    private BigDecimal calcularValorTotal(Carro carro, LocalDate dataInicio, LocalDate dataFim) {
        long diasAluguel = ChronoUnit.DAYS.between(dataInicio, dataFim) + 1;
        return carro.getValorDiaria().multiply(BigDecimal.valueOf(diasAluguel));
    }
}