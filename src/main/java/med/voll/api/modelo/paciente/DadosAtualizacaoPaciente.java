package med.voll.api.modelo.paciente;

import jakarta.validation.constraints.NotNull;
import med.voll.api.modelo.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}

