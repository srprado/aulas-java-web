
package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.model.Carro;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author aluno
 */
@Stateless //EJB - transações
public class CarroDAO {
    
    @PersistenceContext(unitName = "conexaoPU")
    private EntityManager em;
    
    
    public void cadastrar(Carro carro) {
        em.persist(carro);
    }
    
    public List<Carro> buscarTodos() {
        return em.createNamedQuery("Carro.buscarTodos", Carro.class)
                .getResultList();
    }

    public Carro buscarPelaPlaca(String placa) {
        return em.createNamedQuery("Carro.buscarPelaPlaca", Carro.class)
                .setParameter("placa", placa)
                .getSingleResult();
    }
    
    public List<Carro> buscarPelaPlacaParcial(String placa) {
        return em.createNamedQuery("Carro.buscarPelaPlacaParcial", Carro.class)
                .setParameter("placa", "%"+placa+"%")
                .getResultList();
    }

}
