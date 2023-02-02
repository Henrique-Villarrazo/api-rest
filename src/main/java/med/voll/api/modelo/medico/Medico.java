package med.voll.api.modelo.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.modelo.endereco.Endereco;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;

    private String telefone;

    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Medico(DadosCadastroMedico dadosMedico) {
        this.ativo = true;
        this.nome = dadosMedico.nome();
        this.email = dadosMedico.email();
        this.telefone = dadosMedico.telefone();
        this.crm = dadosMedico.crm();
        this.especialidade = dadosMedico.especialidade();
        this.endereco = new Endereco(dadosMedico.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoMedico dadosMedico) {
        if (dadosMedico.nome() != null) {
            this.nome = dadosMedico.nome();
        }
        if (dadosMedico.telefone() != null) {
            this.telefone = dadosMedico.telefone();
        }
        if (dadosMedico.endereco() != null) {
            this.endereco.atualizarInformacoes(dadosMedico.endereco());
        }

    }

    public void excluir() {
        this.ativo = false;
    }
}
