
package br.edu.ifsp.pep.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "opcao_pergunta")
public class OpcaoPergunta implements Serializable{
    
    @Id
    @Column(name = "codigo",length = 8, unique = true)
    private int codigo;
    
    @Column(name = "opcao", nullable = false, length = 50)
    private String opcao;
    
    @ManyToOne
    @JoinColumn(name = "fk_pergunta")
    private Pergunta pergunta;

    public OpcaoPergunta() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getOpcao() {
        return opcao;
    }

    public void setOpcao(String opcao) {
        this.opcao = opcao;
    }

    public Pergunta getPergunta() {
        return pergunta;
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.codigo;
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
        final OpcaoPergunta other = (OpcaoPergunta) obj;
        return this.codigo == other.codigo;
    }
  
}
