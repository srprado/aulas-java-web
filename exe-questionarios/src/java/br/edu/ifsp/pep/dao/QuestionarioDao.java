
package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.modelo.Questionario;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class QuestionarioDao {
    
    @PersistenceContext(unitName = "conexaoPU")
    private EntityManager em;
    
    public void cadastrar(Questionario questionario){
        em.persist(questionario);
    }
    
    
    public Questionario findByName(String titulo){
        try {
            return em.createNamedQuery("Questionario.findByName", Questionario.class)
                .setParameter("titulo", titulo)
                .getSingleResult();            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getCause().getMessage());
        }
        return null;        
    }
    
}
