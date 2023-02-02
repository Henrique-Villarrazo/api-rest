package med.voll.api.modelo.paciente;

public record DadosListagemPaciente(Long id, String nome, String email, String cpf, Necessidade necessidade) {

    public DadosListagemPaciente(Paciente paciente) {
        this(
                paciente.getId(),
                paciente.getNome(),
                paciente.getEmail(),
                paciente.getCpf(),
                paciente.getNecessidade());
    }

}