package devtrail.squad6.locadoraveiculos.service;

import devtrail.squad6.locadoraveiculos.mapper.CarroDetalheMapper;
import devtrail.squad6.locadoraveiculos.mapper.CarroMapper;
import devtrail.squad6.locadoraveiculos.model.dto.CarroDTO;
import devtrail.squad6.locadoraveiculos.model.dto.CarroDetalheDTO;
import devtrail.squad6.locadoraveiculos.model.entity.Acessorio;
import devtrail.squad6.locadoraveiculos.model.entity.Carro;
import devtrail.squad6.locadoraveiculos.model.entity.Fabricante;
import devtrail.squad6.locadoraveiculos.model.entity.enums.Categoria;
import devtrail.squad6.locadoraveiculos.repository.CarroRepository;
import devtrail.squad6.locadoraveiculos.service.interfaces.CarroService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CarroServiceImpl implements CarroService {

    @Autowired
    private CarroRepository carroRepository;

    private CarroMapper mapper;

    private CarroDetalheMapper detalheMapper;

    @Transactional
    @Override
    public Carro save(Carro carro) {
        try {
            if (!isPlacaMercosulValida(carro.getPlaca()) && !isPlacaComumValida(carro.getPlaca())) {
                throw new IllegalArgumentException("Placa do carro inválida!");
            }

            if (!isChassiValido(carro.getChassi())) {
                throw new IllegalArgumentException("Chassi do carro inválido!");
            }

            if (carroRepository.existsByPlaca(carro.getPlaca())) {
                throw new IllegalArgumentException("Placa do carro já existente no sistema!");
            }

            if (carroRepository.existsByChassi(carro.getChassi())) {
                throw new IllegalArgumentException("Número de chassi já existente no sistema!");
            }
            return carroRepository.save(carro);
        } catch (Exception e) {
            throw new RuntimeException( e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<CarroDTO> findAll() {
        List<Carro> response = carroRepository.findAll();
        return response.stream().map(this.mapper::modelToDTO).toList();
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
    public List<CarroDTO> findByCategoriaAndAcessorios(Categoria categoria, @NotNull List<Acessorio> acessorios){
        List<Carro> response = carroRepository.findByModelo_CategoriaAndAcessoriosIn(categoria,acessorios);
        return response.stream().map(this.mapper::modelToDTO).toList();
    }

    @Transactional(readOnly = true)
    public List<CarroDTO> findByCategoria(Categoria categoria){
        List<Carro> response = carroRepository.findByModelo_Categoria(categoria);
        return response.stream().map(this.mapper::modelToDTO).toList();
    }

    @Transactional(readOnly = true)
    public List<CarroDTO> findByAcessorios(@NotNull List<Acessorio> acessorios){
            List<Carro> response = carroRepository.findByAcessoriosIn(acessorios);
            return response.stream().map(this.mapper::modelToDTO).toList();
    }
}