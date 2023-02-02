package med.voll.api.modelo.medico;

import med.voll.api.modelo.endereco.Endereco;

public record DadosDetalheMedico(Long id, String nome, String email, String crm,
                                 String telefone , Especialidade especialidade, Endereco endereco) {

    public DadosDetalheMedico(Medico medico) {
        this(medico.getId(),
                medico.getNome(),
                medico.getEmail(),
                medico.getCrm(),
                medico.getTelefone(),
                medico.getEspecialidade(),
                medico.getEndereco());
    }
}
