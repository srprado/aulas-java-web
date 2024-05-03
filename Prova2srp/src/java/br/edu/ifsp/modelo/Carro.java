
package br.edu.ifsp.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "carro")
@NamedQueries({
    @NamedQuery(name = "Carro.findAll", query = "FROM Carro c"),
    @NamedQuery(name = "Carro.findByPlaca", query = "FROM Carro c WHERE c.placa = :placa")
})
public class Carro implements Serializable{

    @Id
    @Column(name = "placa",length = 8, unique = true)
    private String placa;
    
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;
    
    @Column(name = "cor", nullable = false, length = 50)
    private String cor;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carro")
    private List<Servico> servicos;

    public Carro() {
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.placa);
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
        final Carro other = (Carro) obj;
        return Objects.equals(this.placa, other.placa);
    }
           
}
