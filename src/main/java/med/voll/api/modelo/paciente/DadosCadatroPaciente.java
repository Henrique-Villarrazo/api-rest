package med.voll.api.modelo.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.modelo.endereco.DadosEndereco;

public record DadosCadatroPaciente(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,
        @NotBlank
        @Pattern(regexp = "\\d{9,11}")
        String cpf,
        @NotNull
        Necessidade necessidade,
        @NotNull
        @Valid
        DadosEndereco endereco) {
}
