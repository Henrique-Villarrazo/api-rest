package med.voll.api.modelo.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.modelo.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
