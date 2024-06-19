package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.modelo.Pergunta;
import br.edu.ifsp.pep.modelo.Resposta;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class RespostaDao {

    @PersistenceContext(unitName = "conexaoPU")
    private EntityManager em;

    public void cadastrar(Resposta resposta) {
        em.persist(resposta);
    }

    public List<Object[]> findRespostaCountByPergunta(Pergunta pergunta) {
        TypedQuery<Object[]> query = em.createQuery(
                "SELECT r.respostaOp.opcao, COUNT(r) "
                + "FROM Resposta r "
                + "WHERE r.fk_pergunta_resposta = :pergunta "
                + "GROUP BY r.respostaOp.opcao", Object[].class);
        query.setParameter("pergunta", pergunta);
        return query.getResultList();
    }

    public List<RespostaDTO> findCountByOpcaoAndPergunta(Integer idPergunta) {
        TypedQuery<RespostaDTO> query = em.createQuery(
                "SELECT NEW br.edu.ifsp.pep.dao.RespostaDTO(r.respostaOp.opcao, COUNT(r)) "
                + "FROM Resposta r "
                + "WHERE r.fk_pergunta_resposta.idPergunta = :idPergunta "
                + "GROUP BY r.respostaOp.opcao", RespostaDTO.class);
        query.setParameter("idPergunta", idPergunta);
        return query.getResultList();
    }
}
