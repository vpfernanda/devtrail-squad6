package devtrail.squad6.locadoraveiculos.service;

import devtrail.squad6.locadoraveiculos.model.entity.ModeloCarro;
import devtrail.squad6.locadoraveiculos.model.entity.enums.Categoria;
import devtrail.squad6.locadoraveiculos.repository.ModeloCarroRepository;
import devtrail.squad6.locadoraveiculos.service.interfaces.ModeloCarroService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeloCarroServiceImpl implements ModeloCarroService {
    @Autowired
    private ModeloCarroRepository modeloCarroRepository;
    @Override
    public ModeloCarro save(ModeloCarro modeloCarro) {
        try {
            return modeloCarroRepository.save(modeloCarro);
        }catch (Exception e){
            System.out.println("Não foi possível salvar modelo de carro!");
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<ModeloCarro> findAll() {
        try {
            return modeloCarroRepository.findAll();
        }catch (Exception e){
            System.out.println("Não foi possível encontrar registros de modelos de carro!");
        }
        return null;
    }

    public List<ModeloCarro> findByCategoria(Categoria categoria){
        try{
            return modeloCarroRepository.findByCategoria(categoria);
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public ModeloCarro findById(Long id) {
        return modeloCarroRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ModeloCarro não encontrado com o ID: " + id));
    }

    @Override
    public void deleteById(Long id){
        try {
            modeloCarroRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao remover modelo de carro: " + e.getMessage());
        }
    }
}
