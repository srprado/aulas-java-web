
package br.edu.ifsp.pep.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "token")
public class Token implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;
    
    @Column(name = "chave", length = 10, nullable = false)
    private String chave;
    //atribuir valor false ao gerar os token
    @Column(name = "status", nullable = false)
    private boolean status;    
    //o nome do mappedBy é o msm do atributo em Java;
    @ManyToOne
    @JoinColumn(name = "fk_pessoa_token", nullable = true)
    private Pessoa fk_pessoa_token;
    
    @ManyToOne
    @JoinColumn(name = "fk_questionario_token", nullable = true)
    private Questionario fk_questionario_token;

    public Token() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }
    
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Pessoa getFk_pessoa_token() {
        return fk_pessoa_token;
    }

    public void setFk_pessoa_token(Pessoa fk_pessoa_token) {
        this.fk_pessoa_token = fk_pessoa_token;
    }

    public Questionario getFk_questionario_token() {
        return fk_questionario_token;
    }

    public void setFk_questionario_token(Questionario fk_questionario_token) {
        this.fk_questionario_token = fk_questionario_token;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.codigo;
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
        final Token other = (Token) obj;
        return this.codigo == other.codigo;
    }

}
