package devtrail.squad6.locadoraveiculos.service;

import devtrail.squad6.locadoraveiculos.model.entity.Acessorio;
import devtrail.squad6.locadoraveiculos.repository.AcessorioRepository;
import devtrail.squad6.locadoraveiculos.service.interfaces.AcessorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AcessorioServiceImpl implements AcessorioService {
    @Autowired
    private AcessorioRepository acessorioRepository;

    @Override
    public List<Acessorio> findAll() {
        try {
            return acessorioRepository.findAll();
        }catch (Exception e){
            System.out.println("Não foi possível encontrar registros de acessórios!");
        }
        return null;
    }

    @Override
    public Acessorio findById(Long id){
        try{
            Optional<Acessorio> acessorioOptional = acessorioRepository.findById(id);
            if (acessorioOptional.isPresent()){
                return acessorioOptional.get();
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    @Override
    public Acessorio save(Acessorio acessorio) {
        try {
            return acessorioRepository.save(acessorio);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void deleteById(Long id){
        if (acessorioRepository.existsById(id)) {
            acessorioRepository.deleteById(id);
        } else {
            throw new RuntimeException("Acessório não encontrado com o ID: " + id);
        }
    }
}
