package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.PaginaAcessoDAO;
import br.edu.ifsp.pep.model.NivelAcesso;
import br.edu.ifsp.pep.model.PaginaAcesso;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class PaginaAcessoController implements Serializable {

    @Inject
    private PaginaAcessoDAO paginaDao;

    private PaginaAcesso pagina;

    public List<PaginaAcesso> paginasAdministrador(){
        return paginaDao.buscarPorPagina(NivelAcesso.Administrador);
    }
    
    public List<PaginaAcesso> paginasAdministrativo(){
        return paginaDao.buscarPorPagina(NivelAcesso.Administrativo);
    }
    
    public List<PaginaAcesso> paginasFinanceiro(){
        return paginaDao.buscarPorPagina(NivelAcesso.Financeiro);
    }

    public PaginaAcesso getPagina() {
        return pagina;
    }

    public void setPagina(PaginaAcesso pagina) {
        this.pagina = pagina;
    }

}
