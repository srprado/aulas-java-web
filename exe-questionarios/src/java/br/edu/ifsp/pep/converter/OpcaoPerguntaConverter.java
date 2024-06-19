
package br.edu.ifsp.pep.converter;

import br.edu.ifsp.pep.dao.OpcaoPerguntaDao;
import br.edu.ifsp.pep.modelo.OpcaoPergunta;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

//@FacesConverter(forClass = OpcaoPergunta.class)
@FacesConverter(value = "opcaoPerguntaConverter")
public class OpcaoPerguntaConverter implements Converter<OpcaoPergunta>{

    @Override
    public OpcaoPergunta getAsObject(FacesContext fc, UIComponent uic, String value) {
        System.out.println(value);
        
        if(value == null){
            return null;
        }
        OpcaoPerguntaDao opcaoPerguntaDao = CDI.current().select(OpcaoPerguntaDao.class).get();
        return opcaoPerguntaDao.findById(Integer.parseInt(value));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, OpcaoPergunta opcaoPergunta) {
        System.out.println(opcaoPergunta);
        if(opcaoPergunta == null){
            return null;
        }
         return String.valueOf(opcaoPergunta.getCodigo());
        
    }
    
    
}
