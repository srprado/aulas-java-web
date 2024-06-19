
package br.edu.ifsp.pep.modelo;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name = "resposta")
//Essa classe é a tabela intermediária do relacionamento N pra N entre Pessoa e Questionario
public class Resposta implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_resposta")
    private Integer idResposta;
    
//    @Lob
//    @Column(name = "resposta", length = 50, nullable = false)
//    private String resposta;
    @ManyToOne
    @JoinColumn(name = "fk_opcao_resposta", nullable = false)
    private OpcaoPergunta respostaOp;
    
    @ManyToOne
    @JoinColumn(name = "fk_pergunta_resposta", nullable = false)
    private Pergunta fk_pergunta_resposta;
    
    @ManyToOne
    @JoinColumn(name = "fk_pessoa_resposta", nullable = false)
    private Pessoa fk_pessoa_resposta;

    public Resposta() {
    }

    public Resposta(Integer idResposta) {
        this.idResposta = idResposta;
    }

    public Resposta(Integer idResposta, OpcaoPergunta respostaOp) {
        this.idResposta = idResposta;
        this.respostaOp = respostaOp;
    }

    public Integer getIdResposta() {
        return idResposta;
    }

    public void setIdResposta(Integer idResposta) {
        this.idResposta = idResposta;
    }

    public OpcaoPergunta getRespostaOp() {
        return respostaOp;
    }

    public void setRespostaOp(OpcaoPergunta respostaOp) {
        this.respostaOp = respostaOp;
    }

    public Pergunta getFk_pergunta_resposta() {
        return fk_pergunta_resposta;
    }

    public void setFk_pergunta_resposta(Pergunta fk_pergunta_resposta) {
        this.fk_pergunta_resposta = fk_pergunta_resposta;
    }

    public Pessoa getFk_pessoa_resposta() {
        return fk_pessoa_resposta;
    }

    public void setFk_pessoa_resposta(Pessoa fk_pessoa_resposta) {
        this.fk_pessoa_resposta = fk_pessoa_resposta;
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
