package devtrail.squad6.locadoraveiculos.service;

import devtrail.squad6.locadoraveiculos.model.entity.Aluguel;
import devtrail.squad6.locadoraveiculos.repository.AluguelRepository;
import devtrail.squad6.locadoraveiculos.service.interfaces.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AluguelServiceImpl implements AluguelService {

    @Autowired
    private AluguelRepository aluguelRepository;

    @Override
    public Aluguel save(Aluguel aluguel) {
        return aluguelRepository.save(aluguel);
    }

    @Override
    public List<Aluguel> findAll() {
        return List.of();
    }
}
