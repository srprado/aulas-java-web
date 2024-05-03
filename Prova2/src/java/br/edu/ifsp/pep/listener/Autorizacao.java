package br.edu.ifsp.pep.listener;

import br.edu.ifsp.pep.controller.PessoaController;
import br.edu.ifsp.pep.dao.PaginaAcessoDAO;
import br.edu.ifsp.pep.model.Pessoa;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.PhaseEvent;
import jakarta.faces.event.PhaseId;
import jakarta.faces.event.PhaseListener;
import jakarta.inject.Inject;
import java.io.IOException;

public class Autorizacao implements PhaseListener {

    @Inject
    private PessoaController pessoaController;

    @Inject
    private PaginaAcessoDAO paginaAcessoDao;

    @Override
    public void afterPhase(PhaseEvent event) {
        System.out.println("Após a fase: " + event.getPhaseId());

        FacesContext ctx = event.getFacesContext();
        String pagina = ctx.getViewRoot().getViewId();
        System.out.println(pagina);

        //Validacao
        Pessoa pessoaLogada = pessoaController.getPessoaLogada();

        if (pessoaLogada == null && !pagina.startsWith("/login.xhtml")) {
            redirecionar(ctx, "/login.xhtml");
        } else if (pessoaLogada != null 
                && !pagina.startsWith("acesso-negado.xhtml")
                && !paginaAcessoDao.podeAcessar(pessoaLogada.getNivelAcesso(), pagina)) {
            redirecionar(ctx, "/acesso-negado.xhtml");
        }

        //FORMA ESTÀTICA
//        else if (pessoaLogada != null) {            
//            if (!pessoaLogada.getNivelAcesso()
//                    .equals(NivelAcesso.Administrador)
//                    && pagina.startsWith("/financeiro/create.xhtml")) {
//                redirecionar(ctx, "/acesso-negado.xhtml");
//            } else if (pessoaLogada.getNivelAcesso()
//                    .equals(NivelAcesso.Administrativo)
//                    && pagina.startsWith("/financeiro/list.xhtml")) {
//                redirecionar(ctx, "/acesso-negado.xhtml");
//            }
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        System.out.println("antes da fase: " + event.getPhaseId());
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }

    private void redirecionar(FacesContext ctx, String pagina) {
        try {
            //Nome do projeto
            String projeto = ctx.getExternalContext()
                    .getRequestContextPath();

            //Encaminhar/Redirecionar
            ctx.getExternalContext().redirect(projeto + pagina);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
