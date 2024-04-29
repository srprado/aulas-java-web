
package br.edu.ifsp.pep.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "pessoa")
public class Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;
    
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    
    @Column(name = "login", length = 20, nullable = false)
    private String login;
    
    @NotBlank//Verifica se tem espaços em branco. Tem q ter algum caracter
    @Size(min = 5)
    @Column(name = "senha", length = 20, nullable = false)
    private String senha;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "nivel_acesso", length = 15, nullable = false)
    private NivelAcesso nivel_acesso;

    public Pessoa() {
    }

    public Pessoa(String nome, String login, String senha, NivelAcesso nivel_acesso) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.nivel_acesso = nivel_acesso;
    }   

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public NivelAcesso getNivel_acesso() {
        return nivel_acesso;
    }

    public void setNivel_acesso(NivelAcesso nivel_acesso) {
        this.nivel_acesso = nivel_acesso;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.codigo;
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
    
    
    
    
}
