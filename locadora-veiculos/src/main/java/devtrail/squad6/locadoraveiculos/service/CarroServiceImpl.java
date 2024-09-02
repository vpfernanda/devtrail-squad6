package devtrail.squad6.locadoraveiculos.service;

import devtrail.squad6.locadoraveiculos.mapper.CarroDetalheMapper;
import devtrail.squad6.locadoraveiculos.mapper.CarroFormMapper;
import devtrail.squad6.locadoraveiculos.mapper.CarroMapper;
import devtrail.squad6.locadoraveiculos.model.dto.CarroDTO;
import devtrail.squad6.locadoraveiculos.model.dto.CarroDetalheDTO;
import devtrail.squad6.locadoraveiculos.model.dto.CarroForm;
import devtrail.squad6.locadoraveiculos.model.dto.FiltroCarroDTO;
import devtrail.squad6.locadoraveiculos.model.entity.Acessorio;
import devtrail.squad6.locadoraveiculos.model.entity.Carro;
import devtrail.squad6.locadoraveiculos.model.entity.enums.Categoria;
import devtrail.squad6.locadoraveiculos.repository.CarroRepository;
import devtrail.squad6.locadoraveiculos.service.interfaces.CarroService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarroServiceImpl implements CarroService {

    @Autowired
    private CarroRepository carroRepository;

    private CarroMapper mapper;
    private CarroDetalheMapper detalheMapper;
    private CarroFormMapper FormMapper;

    @Transactional
    @Override
    public CarroDetalheDTO save(CarroForm carroForm) {
        try {
            if (!isPlacaMercosulValida(carroForm.getPlaca()) && !isPlacaComumValida(carroForm.getPlaca())) {
                throw new IllegalArgumentException("Placa do carroForm inválida!");
            }

            if (!isChassiValido(carroForm.getChassi())) {
                throw new IllegalArgumentException("Chassi do carroForm inválido!");
            }

            if (carroRepository.existsByPlaca(carroForm.getPlaca())) {
                throw new IllegalArgumentException("Placa do carroForm já existente no sistema!");
            }

            if (carroRepository.existsByChassi(carroForm.getChassi())) {
                throw new IllegalArgumentException("Número de chassi já existente no sistema!");
            }

            Carro salvo = carroRepository.save(this.FormMapper.dtoToModel(carroForm));
            return this.detalheMapper.modelToDTO(salvo);

        } catch (Exception e) {
            throw new RuntimeException( e.getMessage());
        }
    }

    public List<Carro> listarCarrosDisponiveis(LocalDate dataInicio, LocalDate dataDevolucao) {
        List<Carro> carrosDisponiveis = new ArrayList<>();
        List<Carro> todosCarros = carroRepository.findAll();

        for (Carro carro : todosCarros) {
            if (carro.isDisponivelParaAlugar(dataInicio, dataDevolucao)) {
                carrosDisponiveis.add(carro);
            }
        }

        return carrosDisponiveis;
    }

    @Transactional(readOnly = true)
    @Override
    public Page<CarroDTO> findAll(Pageable pageable) {
        Page<Carro> response = carroRepository.findAll(pageable);
        return response.map(this.mapper::modelToDTO);
    }

    @Transactional(readOnly = true)
    @Override
    public CarroDetalheDTO findById(Long id) {
        Optional<Carro> carroOptional = carroRepository.findById(id);
        return this.detalheMapper.modelToDTO(carroOptional.orElseThrow(() -> new RuntimeException("Carro não encontrado com o ID: " + id)));
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        if (carroRepository.existsById(id)) {
            carroRepository.deleteById(id);
        } else {
            throw new RuntimeException("Carro não encontrado com o ID: " + id);
        }
    }

    private boolean isChassiValido(String chassi) {
        String chassiPadrao = "^[A-HJ-NPR-Z0-9]{17}$";

        return chassi.toUpperCase().matches(chassiPadrao);
    }

    private boolean isPlacaComumValida(String placa) {
        String placaPadrao = "^[A-Z]{3}-?\\d{4}$";
        return placa.toUpperCase().matches(placaPadrao);
    }

    private boolean isPlacaMercosulValida(String placa) {
        String placaPadrao = "^[A-Z]{3}\\d[A-Z]{2}\\d{2}$";
        return placa.toUpperCase().matches(placaPadrao);
    }

    @Transactional
    public void saveNewDates(Carro carro){
        try{
            carroRepository.save(carro);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    public Page<CarroDTO> findByFilter(FiltroCarroDTO filtroCarroDTO, Pageable pageable){
        Categoria categoria = filtroCarroDTO.getCategoria();
        List<Acessorio> acessorios = filtroCarroDTO.getAcessorios();

        if (categoria != null && (acessorios.isEmpty() || acessorios.contains(null))) {
            return findByCategoria(categoria, pageable);
        }

        if (categoria == null && !acessorios.isEmpty() && !acessorios.contains(null)) {
            return findByAcessorios(acessorios, pageable);
        }

        if (categoria != null && !acessorios.isEmpty() && !acessorios.contains(null)) {
            return findByCategoriaAndAcessorios(categoria, acessorios, pageable);
        }

        return findAll(pageable);

    }

    @Transactional(readOnly = true)
    protected Page<CarroDTO> findByCategoriaAndAcessorios(Categoria categoria, @NotNull List<Acessorio> acessorios, Pageable pageable){
        Page<Carro> response = carroRepository.findByModelo_CategoriaAndAcessoriosIn(categoria,acessorios, pageable);
        return response.map(this.mapper::modelToDTO);
    }

    @Transactional(readOnly = true)
    protected Page<CarroDTO> findByCategoria(Categoria categoria, Pageable pageable){
        Page<Carro> response = carroRepository.findByModelo_Categoria(categoria, pageable);
        return response.map(this.mapper::modelToDTO);
    }

    @Transactional(readOnly = true)
    protected Page<CarroDTO> findByAcessorios(@NotNull List<Acessorio> acessorios, Pageable pageable){
            Page<Carro> response = carroRepository.findByAcessoriosIn(acessorios, pageable);
            return response.map(this.mapper::modelToDTO);
    }
}