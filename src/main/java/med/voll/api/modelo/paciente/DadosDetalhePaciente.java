package med.voll.api.modelo.paciente;

import med.voll.api.modelo.endereco.Endereco;

public record DadosDetalhePaciente(Long id, String nome, String email, String cpf,
                                 String telefone , Necessidade necessidade, Endereco endereco) {

public DadosDetalhePaciente(Paciente paciente) {
        this(paciente.getId(),
        paciente.getNome(),
        paciente.getEmail(),
        paciente.getCpf(),
        paciente.getTelefone(),
        paciente.getNecessidade(),
        paciente.getEndereco());
        }
}
