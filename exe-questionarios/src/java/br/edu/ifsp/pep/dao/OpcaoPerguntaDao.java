
package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.modelo.OpcaoPergunta;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class OpcaoPerguntaDao {
    
    @PersistenceContext(unitName = "conexaoPU")
    private EntityManager em;
    
    public void cadastrar(OpcaoPergunta opPergunta){
        em.persist(opPergunta);
    }
    
    public OpcaoPergunta findById(int codigo) {
        try {
            return em.createNamedQuery("OpcaoPergunta.findById", OpcaoPergunta.class)
                    .setParameter("codigo", codigo)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getCause().getMessage());
        }
        return null;
    }
    
    public List<OpcaoPergunta> findOpcoesByPergunta(Integer idPergunta) {
        TypedQuery<OpcaoPergunta> query = em.createQuery("SELECT op FROM OpcaoPergunta op WHERE op.pergunta.idPergunta = :idPergunta", OpcaoPergunta.class);
        query.setParameter("idPergunta", idPergunta);
        return query.getResultList();
    }
    
    
    
}
