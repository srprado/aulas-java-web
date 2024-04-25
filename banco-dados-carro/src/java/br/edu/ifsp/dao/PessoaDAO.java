
package br.edu.ifsp.dao;

import br.edu.ifsp.modelo.Pessoa;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Stateless //EJB - transações
public class PessoaDAO {
    
    @PersistenceContext(unitName = "conexaoPU")
    private EntityManager em;
    
    
    public void cadastrar(Pessoa pessoa) {
        em.persist(pessoa);
    }
    
    public Pessoa findUser (String login, String senha) {
        TypedQuery<Pessoa> query = em.createQuery(
                "Select p FROM Pessoa p WHERE p.login = :login AND p.senha = :senha",
                Pessoa.class);
        query.setParameter("login", login);
        query.setParameter("senha", senha);
        try {
            return query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
      
    
    
}
