
package br.edu.ifsp.pep.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "pagina_acesso")
@NamedQueries(value={
    @NamedQuery(name = "PaginaAcesso.buscarTodos", query = "FROM PaginaAcesso pa"),
    @NamedQuery(name = "PaginaAcesso.buscarPorNivelePagina", query = "FROM PaginaAcesso pa WHERE pa.nivelAcesso = :nivelAcesso AND pa.caminhoPagina = :pagina")
})
//o nome que vem depois do igual na named query tem que ser igual ao nome do parâmetro que passa la na consulta do DAO, do setParameter
public class PaginaAcesso implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;

    @Column(name = "caminho_pagina", length = 50, nullable = false)
    private String caminhoPagina;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "nivelAcesso", length = 15, nullable = false)
    private NivelAcesso nivelAcesso;
    
    @ManyToOne
    @JoinColumn(name = "FK_codigo_pessoa", nullable = false)
    private Pessoa pessoaPagina;

    public PaginaAcesso() {
    }

    public PaginaAcesso(int codigo) {
        this.codigo = codigo;
    }

    public PaginaAcesso(int codigo, String caminhoPagina) {
        this.codigo = codigo;
        this.caminhoPagina = caminhoPagina;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCaminhoPagina() {
        return caminhoPagina;
    }

    public void setCaminhoPagina(String caminhoPagina) {
        this.caminhoPagina = caminhoPagina;
    }

    public Pessoa getPessoaPagina() {
        return pessoaPagina;
    }

    public void setPessoaPagina(Pessoa pessoaPagina) {
        this.pessoaPagina = pessoaPagina;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + this.codigo;
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
        final PaginaAcesso other = (PaginaAcesso) obj;
        return this.codigo == other.codigo;
    }
    
}
