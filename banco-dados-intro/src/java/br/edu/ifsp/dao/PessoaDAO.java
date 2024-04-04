
package br.edu.ifsp.dao;

import br.edu.ifsp.modelo.Pessoa;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless //EJB - responsável pelas transações
public class PessoaDAO {
   
    @PersistenceContext(unitName = "conexaoPU")
    private EntityManager em;
    
    public void cadastrar(Pessoa pessoa){
        em.persist(pessoa);
    }
    
    public List<Pessoa> findAll(){
        return em.createNamedQuery("Pessoa.findAll", Pessoa.class).getResultList();
    }
    
    
    
}
