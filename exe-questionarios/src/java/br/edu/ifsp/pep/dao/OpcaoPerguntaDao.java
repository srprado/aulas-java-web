
package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.modelo.OpcaoPergunta;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class OpcaoPerguntaDao {
    
    @PersistenceContext(unitName = "conexaoPU")
    private EntityManager em;
    
    public void cadastrar(OpcaoPergunta opPergunta){
        em.persist(opPergunta);
    }
    
}
