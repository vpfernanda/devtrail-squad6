package devtrail.squad6.locadoraveiculos.service;

import devtrail.squad6.locadoraveiculos.model.entity.enums.Categoria;
import devtrail.squad6.locadoraveiculos.service.interfaces.CategoriaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    @Override
    public List<String> getCategorias(){
        return Stream.of(Categoria.values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }
}