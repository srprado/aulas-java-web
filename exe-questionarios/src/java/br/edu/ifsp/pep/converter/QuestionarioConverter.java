
package br.edu.ifsp.pep.converter;

import br.edu.ifsp.pep.dao.QuestionarioDao;
import br.edu.ifsp.pep.modelo.Questionario;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.FacesConverter;
import jakarta.faces.convert.Converter;


@FacesConverter(forClass = Questionario.class)
public class QuestionarioConverter implements Converter<Questionario>{

    @Override
    public Questionario getAsObject(FacesContext fc, UIComponent uic, String value) {
        System.out.println(value);     
        
        if(value == null){
            return null;
        }
        QuestionarioDao questionarioDao = CDI.current().select(QuestionarioDao.class).get();
        return questionarioDao.findById(Integer.parseInt(value));        
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Questionario questionario) {
        System.out.println(questionario);
        if(questionario == null){
            return null;
        }
        //retornar chave primária
        return questionario.getIdQuestionario().toString(); 
    }
    
    
    
}
