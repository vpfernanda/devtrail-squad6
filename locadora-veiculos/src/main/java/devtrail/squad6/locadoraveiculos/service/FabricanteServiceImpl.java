package devtrail.squad6.locadoraveiculos.service;

import devtrail.squad6.locadoraveiculos.repository.FabricanteRepository;
import devtrail.squad6.locadoraveiculos.service.interfaces.FabricanteService;
import devtrail.squad6.locadoraveiculos.model.entity.Fabricante;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FabricanteServiceImpl implements FabricanteService {

    @Autowired
    private FabricanteRepository fabricanteRepository;

    @Override
    public Fabricante save(Fabricante fabricante) {
        try {
            return fabricanteRepository.save(fabricante);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Fabricante> findAll() {
        try {
            return fabricanteRepository.findAll();
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    @Override
    public Fabricante findById(Long id) {
        return fabricanteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Fabricante não encontrado com o ID: " + id));
    }
    @Override
    public void deleteById(Long id){
        try {
            fabricanteRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao remover fabricante: " + e.getMessage());
        }
    }
}
