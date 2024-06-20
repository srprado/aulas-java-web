package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.modelo.Questionario;
import br.edu.ifsp.pep.modelo.Token;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class QuestionarioDao {

    @PersistenceContext(unitName = "conexaoPU")
    private EntityManager em;

    public void cadastrar(Questionario questionario) {
        em.persist(questionario);
    }

    public List<Questionario> findAll() {
        return em.createNamedQuery("Questionario.findAll", Questionario.class)
                .getResultList();
    }
    
    public void excluir(Questionario questionario){
        em.remove(em.merge(questionario));
    }

    public Questionario findByName(String titulo) {
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
    
    public Questionario findById(Integer idQuestionario) {
        try {
            return em.createNamedQuery("Questionario.findById", Questionario.class)
                    .setParameter("idQuestionario", idQuestionario)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getCause().getMessage());
        }
        return null;
    }

    public List<Questionario> findPerguntas(Questionario questionario) {
        TypedQuery<Questionario> query = em.createQuery("SELECT q FROM Questionario q JOIN q.perguntas p WHERE p.questionario.idQuestionario = :idQuestionario", Questionario.class);
        query.setParameter("idQuestionario", questionario.getIdQuestionario());
        try {
            return query.getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }
    
    public List<Token> SeTokenEntaoResposta(Questionario questionario){
        TypedQuery<Token> query = em.createQuery(
            "SELECT t FROM Token t WHERE t.fk_questionario_token = :questionario", Token.class);
        query.setParameter("questionario", questionario);
        try {
            return query.getResultList();
        } catch (NoResultException nre) {
            return null;
        }                
    }

}
