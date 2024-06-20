
package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.modelo.Pessoa;
import br.edu.ifsp.pep.modelo.Questionario;
import br.edu.ifsp.pep.modelo.Token;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class TokenDao {
    
    @PersistenceContext(unitName = "conexaoPU")
    private EntityManager em;
    
    public void cadastrar(Token token){
        em.persist(token);
    }
    
    public List<Token> findToken(Pessoa pessoa, Questionario questionario){
        TypedQuery<Token> query = em.createQuery(
            "SELECT t FROM Token t WHERE t.fk_pessoa_token = :pessoa AND t.fk_questionario_token = :questionario", Token.class);
        query.setParameter("pessoa", pessoa);
        query.setParameter("questionario", questionario);
        try {
            return query.getResultList();
        } catch (NoResultException nre) {
            return null;
        }                
    }
       
}
