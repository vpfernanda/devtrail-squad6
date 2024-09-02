package devtrail.squad6.locadoraveiculos.mapper;

import devtrail.squad6.locadoraveiculos.model.dto.CarroDTO;
import devtrail.squad6.locadoraveiculos.model.dto.CarroForm;
import devtrail.squad6.locadoraveiculos.model.entity.Carro;
import org.mapstruct.Mapper;

@Mapper
public interface CarroFormMapper extends MapperBase<Carro, CarroForm>{

    @Override
    CarroForm modelToDTO(Carro entity);

    @Override
    Carro dtoToModel(CarroForm dto);

}
