package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.model.NivelAcesso;
import br.edu.ifsp.pep.model.PaginaAcesso;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless //EJB - transações
public class PaginaAcessoDAO {

    @PersistenceContext(unitName = "conexaoPU")
    private EntityManager em;

    public void cadastrar(PaginaAcesso pagina) {
        em.persist(pagina);
    }

    public List<PaginaAcesso> buscarTodos() {
        return em.createNamedQuery("PaginaAcesso.buscarTodos", PaginaAcesso.class)
                .getResultList();
    }

    public List<PaginaAcesso> buscarPorPagina(NivelAcesso nivel) {
        try {
            return em.createNamedQuery("PaginaAcesso.buscarPorPagina", PaginaAcesso.class)
                    .setParameter("nivelAcesso", nivel)
                    .getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public boolean podeAcessar(NivelAcesso nivelAcesso, String pagina) {
        try {
            em.createNamedQuery("PaginaAcesso.buscarPorNivelePagina", PaginaAcesso.class)
                .setParameter("nivelAcesso", nivelAcesso)
                .setParameter("pagina", pagina)
                .getSingleResult();
            return true;
        } catch (NoResultException nre) {
            return false;
        }
        //usaria getSingleResult se os campos fossem unicos(nivel de acesso e pagina)
        
        //se for diferente de null retorna TRUE, cas contrário retorna FALSE
    }

}
