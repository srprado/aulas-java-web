
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
    
    public void cadastrar(Vendas vendas){
        em.persist(vendas);
    }
    
    public List<Vendas> findAll() {
        return em.createNamedQuery("Carro.findAll", Vendas.class)
                .getResultList();
    }
    
    public List<Vendas> findByAno(Integer ano) {
        return em.createNamedQuery("Vendas.findByAno", Vendas.class)
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
