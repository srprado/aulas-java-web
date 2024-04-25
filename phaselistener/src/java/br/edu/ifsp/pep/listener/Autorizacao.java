
package br.edu.ifsp.pep.listener;

import br.edu.ifsp.pep.controller.PessoaController;
import br.edu.ifsp.pep.model.NivelAcesso;
import br.edu.ifsp.pep.model.Pessoa;
import jakarta.faces.application.NavigationHandler;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.PhaseEvent;
import jakarta.faces.event.PhaseId;
import jakarta.faces.event.PhaseListener;
import jakarta.inject.Inject;
import java.io.IOException;

public class Autorizacao implements PhaseListener{
    
    @Inject
    private PessoaController pessoaController;
    
//    @Override
//    public void afterPhase(PhaseEvent event) {
//        System.out.println("Após a fase: " + event.getPhaseId());
//
//        FacesContext ctx = event.getFacesContext();
//
//        String pagina = ctx.getViewRoot().getViewId();
//        System.out.println(pagina);
//
//        //validação
//        Pessoa pessoaLogada = pessoaController.getPessoaLogada();
//        
//        //Encaminhar/Redirecionar
//        if (pagina.startsWith("/login.xhtml") && pessoaLogada.getLogin()!=null && pessoaLogada.getSenha()!=null) {
//            try {
//                ctx.getExternalContext()
//                        .redirect("/phaselistener/index.xhtml");
//                //dentro do redirect é o /nomedoprojeto/página
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        }
//    }
    
    @Override
    public void afterPhase(PhaseEvent event) {
        System.out.println("After: " + event.getPhaseId());
       
        FacesContext ctx = event.getFacesContext();
        String pagina = ctx.getViewRoot().getViewId();
        System.out.println(pagina);
        //Validação
        Pessoa pessoaAutenticada = pessoaController.getPessoaLogada();
        //login público
        if (pagina.startsWith("/index") && (pessoaAutenticada==null ||
                                            pessoaAutenticada.getNivelAcesso().equals(NivelAcesso.Financeiro) ||
                                            pessoaAutenticada.getNivelAcesso().equals(NivelAcesso.Administrativo) ||
                                            pessoaAutenticada.getNivelAcesso().equals(NivelAcesso.Administrador)))
        {
            redirecionar(ctx, "/login.xhtml");
        }
        
        if (pagina.startsWith("/index") && pessoaAutenticada != null) {
            redirecionar(ctx, "/index.xhtml");
        }
        
        if (!pagina.startsWith("/login") && pessoaAutenticada == null) {
            redirecionar(ctx, "/login.xhtml");
        }
        
        if (pagina.startsWith("/financeiro") && (pessoaAutenticada == null || !pessoaAutenticada.getNivelAcesso().equals(NivelAcesso.Financeiro))) {
            redirecionar(ctx, "/acesso-negado.xhtml");
        }
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        //monitorar algo antes da fase
        System.out.println("Antes da fase: "+event.getPhaseId());
    }

    //Aqui indica qual a fase que vai ser monitorada
    @Override
    public PhaseId getPhaseId() {
        //monitorando todas as fases...
        return PhaseId.ANY_PHASE;
    }
    
    private void redirecionar(FacesContext ctx, String pagina){
        try {
            String projeto = ctx.getExternalContext().getRequestContextPath();
            
            //Encaminhar, redirecionar
            ctx.getExternalContext().redirect(projeto + pagina);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    
}
