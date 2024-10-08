package devtrail.squad6.locadoraveiculos.service;

import devtrail.squad6.locadoraveiculos.model.entity.Motorista;
import devtrail.squad6.locadoraveiculos.repository.MotoristaRepository;
import devtrail.squad6.locadoraveiculos.service.interfaces.MotoristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoristaServiceImpl implements MotoristaService {
    @Autowired
    private MotoristaRepository motoristaRepository;

    @Override
    public List<Motorista> findAll() {
        try {
            return motoristaRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Motorista save(Motorista motorista) {
        try {
            if (!isCPF(motorista.getCpf())) {
                throw new IllegalArgumentException("CPF inválido");
            }

            if (!isCNH(motorista.getNumeroCNH())) {
                throw new IllegalArgumentException("CNH inválida");
            }

            if (existCPF(motorista.getCpf())) {
                throw new IllegalArgumentException("CPF já existente no sistema!");
            }
            if (existCNH(motorista.getNumeroCNH())) {
                throw new IllegalArgumentException("CNH já existente no sistema!");
            }
            if (existEmail(motorista.getEmail())) {
                throw new IllegalArgumentException("Email já existente no sistema!");
            }

            motorista.setCpf(formatCPF(motorista.getCpf()));

            return motoristaRepository.save(motorista);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private boolean isCPF(String CPF) {
        try {
            String cpf = CPF.replaceAll("[^0-9]", "");

            if (cpf.length() != 11) {
                return false;
            }

            int[] multiplicadores1 = {10, 9, 8, 7, 6, 5, 4, 3, 2};
            int[] multiplicadores2 = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};

            int soma = 0;
            for (int i = 0; i < 9; i++) {
                soma += Integer.parseInt(cpf.substring(i, i + 1)) * multiplicadores1[i];
            }
            int resto = soma % 11;
            int digito1 = resto < 2 ? 0 : 11 - resto;

            soma = 0;
            for (int i = 0; i < 10; i++) {
                soma += Integer.parseInt(cpf.substring(i, i + 1)) * multiplicadores2[i];
            }
            resto = soma % 11;
            int digito2 = resto < 2 ? 0 : 11 - resto;

            return digito1 == Integer.parseInt(cpf.substring(9, 10)) && digito2 == Integer.parseInt(cpf.substring(10));
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isCNH(String CNH) {
        try {
            String cnh = CNH.replace(".", "").replace("-", "");
            if (cnh.length() != 10) {
                return false;
            }

            Long.parseLong(cnh);

            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static String formatCPF(String CPF) {
        String cpf = CPF.replaceAll("[^0-9]", "");

        return (cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." +
                cpf.substring(6, 9) + "-" + cpf.substring(9, 11));
    }

    private boolean existCPF(String cpf) {
        return motoristaRepository.findByCpf(cpf) != null;
    }

    private boolean existCNH(String numeroCNH) {
        return motoristaRepository.findByNumeroCNH(numeroCNH) != null;
    }

    private boolean existEmail(String email) {
        return motoristaRepository.findByEmail(email) != null;
    }

    @Override
    public Motorista findByEmail(String email) {
        return motoristaRepository.findByEmail(email);
    }

    @Override
    public void deleteById(Long motoristaId) {
        try {
            motoristaRepository.deleteById(motoristaId);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao remover motorista: " + e.getMessage());
        }
    }
}
