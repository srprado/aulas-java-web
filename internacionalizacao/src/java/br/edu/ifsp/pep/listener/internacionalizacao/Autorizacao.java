package br.edu.ifsp.pep.listener.internacionalizacao;

import br.edu.ifsp.pep.localeController.LocaleControlller;
import jakarta.faces.event.PhaseEvent;
import jakarta.faces.event.PhaseId;
import jakarta.faces.event.PhaseListener;
import jakarta.inject.Inject;

public class Autorizacao implements PhaseListener {

    @Inject
    private LocaleControlller localeController;

    @Override
    public void afterPhase(PhaseEvent event) {}

    @Override
    public void beforePhase(PhaseEvent event) {
        System.out.println("antes da fase: " + event.getPhaseId());
//para que o view no template funcione, não precisa ter essa parte
//        if (event.getFacesContext().getViewRoot() != null) {
//            event.getFacesContext().getViewRoot()
//                    .setLocale(localeController.getLocale());
//        }
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }

}
