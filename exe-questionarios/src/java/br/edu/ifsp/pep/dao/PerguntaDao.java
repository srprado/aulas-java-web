
package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.modelo.Pergunta;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class PerguntaDao {
    
    @PersistenceContext(unitName = "conexaoPU")
    private EntityManager em;
    
    public void cadastrar(Pergunta pergunta){
        em.persist(pergunta);
    }
    
    public Pergunta findByName(String titulo){
        try {
            return em.createNamedQuery("Pergunta.findByName", Pergunta.class)
                .setParameter("titulo", titulo)
                .getSingleResult();            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getCause().getMessage());
        }
        return null;        
    }
    
}
