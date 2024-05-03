package br.edu.ifsp.pep.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "pessoa")
@NamedQueries({
    @NamedQuery(name = "Pessoa.buscarPorLoginESenha", query = "FROM Pessoa p WHERE p.login = :login AND p.senha = :senha")
})
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;

    @Column(name = "login", length = 20, nullable = false)
    private String login;

    @Column(name = "senha", length = 20, nullable = false)
    private String senha;

    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
        
    @Enumerated(EnumType.STRING)
    @Column(name = "nivel_acesso", length = 15, nullable = false)
    private NivelAcesso nivelAcesso;
    
    @OneToMany(mappedBy = "pessoaPagina", cascade = CascadeType.ALL)
    private List<PaginaAcesso> paginas;

    public Pessoa() {
    }

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public NivelAcesso getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(NivelAcesso nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.codigo;
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
        final Pessoa other = (Pessoa) obj;
        return this.codigo == other.codigo;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "codigo=" + codigo + ", login=" + login + ", senha=" + senha + ", nome=" + nome + '}';
    }

}
