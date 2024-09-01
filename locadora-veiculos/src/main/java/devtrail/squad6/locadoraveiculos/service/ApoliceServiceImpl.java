package devtrail.squad6.locadoraveiculos.service;

import devtrail.squad6.locadoraveiculos.model.entity.ApoliceSeguro;
import devtrail.squad6.locadoraveiculos.repository.ApoliceSeguroRepository;
import devtrail.squad6.locadoraveiculos.service.interfaces.ApoliceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApoliceServiceImpl implements ApoliceService {

    @Autowired
    private ApoliceSeguroRepository apoliceSeguroRepository;


    @Override
    public List<ApoliceSeguro> findAll() {
        return apoliceSeguroRepository.findAll();
    }

    @Override
    public ApoliceSeguro findById(Long id) {
        try{
            Optional<ApoliceSeguro> apoliceSeguroOptional = apoliceSeguroRepository.findById(id);
            if (apoliceSeguroOptional.isPresent()){
                return apoliceSeguroOptional.get();
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }


    @Override
    public ApoliceSeguro save(ApoliceSeguro apoliceSeguro) {
        try {
            return apoliceSeguroRepository.save(apoliceSeguro);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            apoliceSeguroRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao remover apólice de seguro: " + e.getMessage());
        }
    }

}
