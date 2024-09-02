package devtrail.squad6.locadoraveiculos.service;

import devtrail.squad6.locadoraveiculos.model.entity.Aluguel;
import devtrail.squad6.locadoraveiculos.model.entity.Carro;
import devtrail.squad6.locadoraveiculos.model.entity.Motorista;
import devtrail.squad6.locadoraveiculos.repository.AluguelRepository;
import devtrail.squad6.locadoraveiculos.service.interfaces.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AluguelServiceImpl implements AluguelService {

    @Autowired
    private AluguelRepository aluguelRepository;
    @Autowired
    private CarroServiceImpl carroService;

    @Override
    public Aluguel save(Aluguel aluguel) {
        try {
            Carro carro = aluguel.getCarro();
            if(carro.isDisponivelParaAlugar(aluguel.getDataPedido(), aluguel.getDataDevolucao())){
                carro.bloquearDatas(aluguel.getDataEntrega(), aluguel.getDataDevolucao());
                carroService.saveNewDates(carro);
            }
            return aluguelRepository.save(aluguel);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public boolean carroEstaDisponivel (Carro carro, LocalDate dataInicio, LocalDate dataFim) {
        LocalDate dataAluguel = dataInicio;
            while (!dataAluguel.isAfter(dataFim)) {
                if(carro.getDatasOcupadas().contains(dataAluguel))
                    return false;
                dataAluguel = dataAluguel.plusDays(1);
        }
            return true;
    }

    @Override
    public List<Aluguel> findAll() {
        try {
            return aluguelRepository.findAll();
        } catch (Exception e) {
            System.out.println("Não foi possível encontrar registros de alugueis!");
        }
        return null;
    }

    public List<Aluguel> findAlugueisMotorista(Motorista motorista) {
        try {
            return aluguelRepository.findByMotorista(motorista);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public boolean processPayment(String cardNumber, String expirationDate, String cvv) {
        return verifyPayment(cardNumber, expirationDate, cvv);
    }

    public boolean verifyPayment(String cardNumber, String expirationDate, String cvv){

        if (!cardNumber.matches("\\d{13,16}")){
            System.out.println("fui eu: Cartão");
            return false;
        }
        if (!cvv.matches("\\d{3}")){
            System.out.println("fui eu: cvv");
            return false;
        }
        if (!isExpirationDateValid(expirationDate)){
            System.out.println("fui eu: Data");
            return false;
        }

        return true;
    }

    private boolean isExpirationDateValid(String expirationDate){
        String[] parts = expirationDate.split("/");
        int month = Integer.parseInt(parts[0]);
        int year = Integer.parseInt(parts[1]);

        LocalDate currentDate = LocalDate.now();
        int currentMonth = currentDate.getMonthValue();
        int currentYear = currentDate.getYear() % 100;

        System.out.println(month + " / " + currentMonth);
        System.out.println(year + " / " + currentYear);

        return ((year > currentYear) || (year == currentYear && month >= currentMonth));
    }
}
