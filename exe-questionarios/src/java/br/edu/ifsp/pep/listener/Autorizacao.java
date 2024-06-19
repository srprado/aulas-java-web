package br.edu.ifsp.pep.listener;

import br.edu.ifsp.pep.controller.PessoaController;
import br.edu.ifsp.pep.modelo.NivelAcesso;
import br.edu.ifsp.pep.modelo.Pessoa;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.PhaseEvent;
import jakarta.faces.event.PhaseId;
import jakarta.faces.event.PhaseListener;
import jakarta.inject.Inject;
import java.io.IOException;

public class Autorizacao implements PhaseListener {

    @Inject
    private PessoaController pessoaController;

    @Override
    public void afterPhase(PhaseEvent event) {
//        System.out.println("After: " + event.getPhaseId());

        FacesContext ctx = event.getFacesContext();
        String pagina = ctx.getViewRoot().getViewId();
//        System.out.println(pagina);
        // Obtendo o bean gerenciado pelo CDI manualmente
        


        //Validação
        Pessoa pessoaAutenticada = pessoaController.getPessoaLogada();

        if (pagina.startsWith("/administrador") && (pessoaAutenticada == null
                || pessoaAutenticada.getNivel_acesso().equals(NivelAcesso.Comum))) {
            redirecionar(ctx, "/acesso-negado.xhtml");
        }
        if(pagina.startsWith("/questionarios") && (pessoaAutenticada==null)){
            redirecionar(ctx, "/acesso-negado.xhtml");
        }
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        //monitorar algo antes da fase
//        System.out.println("Antes da fase: " + event.getPhaseId());

    }

    @Override
    public PhaseId getPhaseId() {
        //monitorando todas as fases...
        return PhaseId.ANY_PHASE;
    }

    private void redirecionar(FacesContext ctx, String pagina) {
        try {
            String projeto = ctx.getExternalContext().getRequestContextPath();

            //Encaminhar, redirecionar
            ctx.getExternalContext().redirect(projeto + pagina);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
