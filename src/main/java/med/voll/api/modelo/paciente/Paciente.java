package med.voll.api.modelo.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.modelo.endereco.Endereco;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String telefone;

    private String cpf;

    @Enumerated(EnumType.STRING)
    private Necessidade necessidade;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Paciente(DadosCadatroPaciente dadosPaciente) {
        this.ativo = true;
        this.nome = dadosPaciente.nome();
        this.email = dadosPaciente.email();
        this.telefone = dadosPaciente.telefone();
        this.cpf = dadosPaciente.cpf();
        this.necessidade = dadosPaciente.necessidade();
        this.endereco = new Endereco(dadosPaciente.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoPaciente dadosPaciente) {
        if (dadosPaciente.nome() != null) {
            this.nome = dadosPaciente.nome();
        }
        if (dadosPaciente.telefone() != null) {
            this.telefone = dadosPaciente.telefone();
        }
        if (dadosPaciente.endereco() != null) {
            this.endereco.atualizarInformacoes(dadosPaciente.endereco());
        }

    }

    public void excluir() {
        this.ativo = false;
    }

}
