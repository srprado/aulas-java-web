package br.edu.ifsp.pep.model;

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

/**
 *
 * @author aluno
 */
@Entity
@Table(name = "carro")
@NamedQueries({
    @NamedQuery(name = "Carro.buscarTodos", query = "FROM Carro c"),
    @NamedQuery(name = "Carro.buscarPelaPlaca", query = "FROM Carro c WHERE c.placa = :placa"),
    @NamedQuery(name = "Carro.buscarPelaPlacaParcial", query = "FROM Carro c WHERE c.placa LIKE :placa")
})
public class Carro implements Serializable {

    @Id
    @Column(name = "placa", length = 8)
    private String placa;

    @Column(name = "nome", length = 50)
    private String nome;

    @OneToMany(mappedBy = "carro")
    private List<Servico> servicos;

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

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.placa);
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
    
    

    @Override
    public String toString() {
        return "Carro{" + "placa=" + placa + ", nome=" + nome + '}';
    }
    

}
