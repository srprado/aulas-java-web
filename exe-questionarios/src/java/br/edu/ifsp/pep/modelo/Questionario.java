
package br.edu.ifsp.pep.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "questionario")
@NamedQuery(name = "Questionario.findByName", query = "FROM Questionario q WHERE q.titulo = :titulo")

public class Questionario implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_questionario")
    private Integer idQuestionario;
    
    @Column(name = "titulo", length = 50, nullable = false)
    private String titulo;
    
    @Lob
    @Column(name = "descricao", nullable = false)
    private String descricao;
    
    @Column(name = "data_abertura", nullable = false)
    private LocalDateTime dataAbertura;
    
    @Column(name = "data_fechamento", nullable = false)
    private LocalDateTime dataFechamento;
            
    @OneToMany(mappedBy = "fk_questionario_token", cascade = CascadeType.ALL)
    private List<Token> token;
    
    @OneToMany(mappedBy = "questionario", cascade = CascadeType.ALL)
    private List<Pergunta> perguntas;
       
    public Questionario() {
    }

    public Questionario(Integer idQuestionario) {
        this.idQuestionario = idQuestionario;
    }

    public Questionario(Integer idQuestionario, String tituto, String descricao, LocalDateTime dataAbertura, LocalDateTime dataFechamento) {
        this.idQuestionario = idQuestionario;
        this.titulo = tituto;
        this.descricao = descricao;
        this.dataAbertura = dataAbertura;
        this.dataFechamento = dataFechamento;
    }
    
    public Integer getIdQuestionario() {
        return idQuestionario;
    }

    public void setIdQuestionario(Integer idQuestionario) {
        this.idQuestionario = idQuestionario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDateTime getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(LocalDateTime dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public List<Pergunta> getPerguntas() {
        return perguntas;
    }

    public void setPerguntas(List<Pergunta> perguntas) {
        this.perguntas = perguntas;
    }

    public List<Token> getToken() {
        return token;
    }

    public void setToken(List<Token> token) {
        this.token = token;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.idQuestionario);
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
        final Questionario other = (Questionario) obj;
        return Objects.equals(this.idQuestionario, other.idQuestionario);
    }
}
