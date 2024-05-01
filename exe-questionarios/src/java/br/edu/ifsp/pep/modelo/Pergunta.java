
package br.edu.ifsp.pep.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "pergunta")
public class Pergunta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pergunta")
    private Integer idPergunta;
    
    @Column(name = "titulo_pergunta", length = 50, nullable = false)
    private String tituloPergunta;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_pergunta", length = 20, nullable = false)
    private TipoPergunta tipoPergunta;
    
    @ManyToOne
    @JoinColumn(name = "FK_id_questionario", nullable = false)
    private Questionario questionario;
    
    @OneToMany(mappedBy = "pergunta", cascade = CascadeType.ALL)
    private List<Resposta> respostas;
   
    public Pergunta() {
    }

    public Pergunta(Integer idPergunta) {
        this.idPergunta = idPergunta;
    }

    public Pergunta(Integer idPergunta, String tituloPergunta, TipoPergunta tipoPergunta) {
        this.idPergunta = idPergunta;
        this.tituloPergunta = tituloPergunta;
        this.tipoPergunta = tipoPergunta;
    }
    
    public Integer getIdPergunta() {
        return idPergunta;
    }

    public void setIdPergunta(Integer idPergunta) {
        this.idPergunta = idPergunta;
    }

    public String getTituloPergunta() {
        return tituloPergunta;
    }

    public void setTituloPergunta(String tituloPergunta) {
        this.tituloPergunta = tituloPergunta;
    }

    public TipoPergunta getTipoPergunta() {
        return tipoPergunta;
    }

    public void setTipoPergunta(TipoPergunta tipoPergunta) {
        this.tipoPergunta = tipoPergunta;
    }

    public Questionario getQuestionario() {
        return questionario;
    }

    public void setQuestionario(Questionario questionario) {
        this.questionario = questionario;
    }

    public List<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<Resposta> respostas) {
        this.respostas = respostas;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.idPergunta);
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
        final Pergunta other = (Pergunta) obj;
        return Objects.equals(this.idPergunta, other.idPergunta);
    }   
}