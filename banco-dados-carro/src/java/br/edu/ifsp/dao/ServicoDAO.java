
package br.edu.ifsp.dao;

import br.edu.ifsp.modelo.Servico;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless //EJB - responsável pelas transações
public class ServicoDAO {
   
    @PersistenceContext(unitName = "conexaoPU")
    private EntityManager em;
    
    public void cadastrar(Servico servico){
        em.persist(servico);
    }

    public List<Servico> findAll() {
        return em.createNamedQuery("Servico.findAll", Servico.class)
                .getResultList();
    }
    
}