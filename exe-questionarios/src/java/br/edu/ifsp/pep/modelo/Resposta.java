
package br.edu.ifsp.pep.modelo;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Objects;


@Entity
@Table(name = "resposta")
//Essa classe é a tabela intermediária do relacionamento N pra N entre Pessoa e Questionario
public class Resposta {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_resposta")
    private Integer idResposta;
    
    @Lob
    @Column(name = "resposta", length = 50, nullable = false)
    private String resposta;
    
    @ManyToOne
    @JoinColumn(name = "FK_id_pergunta", nullable = false)
    private Pergunta pergunta;
    
    @ManyToOne
    @JoinColumn(name = "FK_cpf", nullable = false)
    private Pessoa pessoa;
    
    @ManyToOne
    @JoinColumn(name = "FK_id_questionario", nullable = false)
    private Questionario questionarioRes;
            

    public Resposta() {
    }

    public Resposta(Integer idResposta) {
        this.idResposta = idResposta;
    }

    public Resposta(Integer idResposta, String resposta) {
        this.idResposta = idResposta;
        this.resposta = resposta;
    }

    public Integer getIdResposta() {
        return idResposta;
    }

    public void setIdResposta(Integer idResposta) {
        this.idResposta = idResposta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public Pergunta getPergunta() {
        return pergunta;
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Questionario getQuestionarioRes() {
        return questionarioRes;
    }

    public void setQuestionarioRes(Questionario questionarioRes) {
        this.questionarioRes = questionarioRes;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.idResposta);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Resposta other = (Resposta) obj;
        return Objects.equals(this.idResposta, other.idResposta);
    }
}
