
package br.edu.ifsp.converter;

import br.edu.ifsp.dao.CarroDAO;
import br.edu.ifsp.modelo.Carro;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.FacesConverter;
import jakarta.faces.convert.Converter;


@FacesConverter(forClass = Carro.class)
public class CarroConverter implements Converter<Carro>{

    @Override
    public Carro getAsObject(FacesContext fc, UIComponent uic, String value) {
        System.out.println(value);     
        
        if(value == null){
            return null;
        }
        CarroDAO carroDao = CDI.current().select(CarroDAO.class).get();
        return carroDao.findByPlaca(value);        
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Carro carro) {
        System.out.println(carro);
        if(carro == null){
            return null;
        }
        //retornar chave primária
        return carro.getPlaca(); 
    }
    
    
    
}
