package devtrail.squad6.locadoraveiculos.mapper;

import devtrail.squad6.locadoraveiculos.model.dto.CarroDetalheDTO;
import devtrail.squad6.locadoraveiculos.model.entity.Carro;
import org.mapstruct.Mapper;

@Mapper
public interface CarroDetalheMapper extends MapperBase<Carro, CarroDetalheDTO>{

    @Override
    CarroDetalheDTO modelToDTO(Carro entity);

    @Override
    Carro dtoToModel(CarroDetalheDTO dto);
}
