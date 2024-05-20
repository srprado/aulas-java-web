
package br.edu.ifsp.pep.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {
    
    @Id
    @Column(name = "cpf", length = 14, nullable = false)
    private String cpf;
    
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
    
    @OneToMany(mappedBy = "fk_pessoa_resposta", cascade = CascadeType.ALL)
    private List<Resposta> respostas;
    
    @OneToMany(mappedBy = "fk_pessoa_token", cascade = CascadeType.ALL)
    private List<Token> token;
    
    public Pessoa() {
    }

    public Pessoa(String cpf) {
        this.cpf = cpf;
    }

    public Pessoa(String cpf, String nome, String login, String senha, NivelAcesso nivel_acesso) {
        this.cpf = cpf;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.nivel_acesso = nivel_acesso;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public List<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<Resposta> respostas) {
        this.respostas = respostas;
    }

    public List<Token> getToken() {
        return token;
    }

    public void setToken(List<Token> token) {
        this.token = token;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.cpf);
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
        return Objects.equals(this.cpf, other.cpf);
    }     
}
