
package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.modelo.Pergunta;
import br.edu.ifsp.pep.modelo.Questionario;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

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
    
    public Pergunta findById(Integer id) {
        try {
            return em.createNamedQuery("Pergunta.findById", Pergunta.class)
                    .setParameter("idPergunta", id)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getCause().getMessage());
        }
        return null;
    }
    
    //achar as perguntas de um respectivo Questionário
    public List<Pergunta> findPerguntasById(Integer idQuestionario) {
        TypedQuery<Pergunta> query = em.createQuery("SELECT p FROM Pergunta p Where p.questionario.idQuestionario = :questionario", Pergunta.class);
        query.setParameter("questionario", idQuestionario);
        try {
            return query.getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }
    
    public List<String> findTitulosPerguntasByQuestionario(Questionario questionario) {
        TypedQuery<String> query = em.createQuery("SELECT p.tituloPergunta FROM Pergunta p WHERE p.questionario = :questionario", String.class);
        query.setParameter("questionario", questionario);
        return query.getResultList();
    }
    
    
    
//    public List<Object[]> findPerguntasAndOpcaoById(Integer idQuestionario) {
//    TypedQuery<Object[]> query = em.createQuery(
//        "SELECT p.tituloPergunta, op.opcao " +
//        "FROM Pergunta p JOIN p.opcoes op " +
//        "WHERE p.questionario.id = :questionario", 
//        Object[].class
//    );
//    query.setParameter("questionario", idQuestionario);
//    try {
//        return query.getResultList();
//    } catch (NoResultException nre) {
//        return null;
//    }
//    
//    }
}
