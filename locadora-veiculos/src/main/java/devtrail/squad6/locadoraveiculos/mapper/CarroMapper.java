package devtrail.squad6.locadoraveiculos.mapper;

import devtrail.squad6.locadoraveiculos.model.dto.CarroDTO;
import devtrail.squad6.locadoraveiculos.model.entity.Carro;
import org.mapstruct.Mapper;

@Mapper
public interface CarroMapper extends MapperBase<Carro, CarroDTO>{

    @Override
    CarroDTO modelToDTO(Carro entity);

    @Override
    Carro dtoToModel(CarroDTO dto);

}
