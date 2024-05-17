package br.edu.ifsp.dao;

import br.edu.ifsp.modelo.Vendas;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless //EJB - responsável pelas transações
public class VendasDAO {

    @PersistenceContext(unitName = "conexaoPU")
    private EntityManager em;

    public void cadastrar(Vendas vendas) {
        em.persist(vendas);
    }

    public List<Vendas> findAll() {
        return em.createNamedQuery("Vendas.findAll", Vendas.class)
                .getResultList();
    }

    public List<Object[]> findByMonth() {
        return em.createQuery("Select SQL('EXTRACT(MONTH FROM ?)', v.data) as mes,"
                + "SUM(v.valor) from Vendas v GROUP BY mes")
                .getResultList();
    }

    public List<VendaDTO> findByMonthDTO(int ano) {
        return em.createQuery("SELECT NEW br.edu.ifsp.dao.VendaDTO("
                        + "FUNCTION('MONTH', v.data), SUM(v.valor)) "
                        + "from Vendas v WHERE FUNCTION('YEAR', v.data) = :ano "
                        + "GROUP BY FUNCTION('MONTH', v.data) "
                        + "ORDER BY 1",
                        VendaDTO.class)
                .setParameter("ano", ano)
                .getResultList();

    }

//    public void excluir(Servico servico){
//        em.remove(em.merge(servico));
//    }
//    public Pessoa findUser (String login, String senha) {
//        TypedQuery<Pessoa> query = em.createQuery(
//                "Select p FROM Pessoa p WHERE p.login = :login AND p.senha = :senha",
//                Pessoa.class);
//        query.setParameter("login", login);
//        query.setParameter("senha", senha);
//        try {
//            return query.getSingleResult();
//        } catch (NoResultException nre) {
//            return null;
}
