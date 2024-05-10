
package br.edu.ifsp.pep.localeController;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Locale;

@Named
@SessionScoped
public class LocaleControlller implements Serializable{
    
    private Locale locale;
    
    public void setLocaleUS(){
        System.out.println("US...");
        //Alterar o lacale da aplicação
//        FacesContext
//                .getCurrentInstance()
//                .getViewRoot()
//                .setLocale(Locale.US);
        this.locale = Locale.US;
    }
    
    public void setLocaleBR(){
        System.out.println("US...");
        //Alterar o lacale da aplicação
//        FacesContext
//                .getCurrentInstance()
//                .getViewRoot()
//                .setLocale(new Locale("pt", "BR"));      
//        //guarda o lacale atual
        this.locale = new Locale("pt", "BR");
    }  

    public Locale getLocale() {
        return locale;
    }
}
