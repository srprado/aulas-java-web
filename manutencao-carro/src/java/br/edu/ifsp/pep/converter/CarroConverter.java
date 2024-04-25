package br.edu.ifsp.pep.converter;

import br.edu.ifsp.pep.dao.CarroDAO;
import br.edu.ifsp.pep.model.Carro;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author aluno
 */
@FacesConverter(forClass = Carro.class)
public class CarroConverter implements Converter<Carro> {

    @Override
    public Carro getAsObject(FacesContext fc, UIComponent uic, String value) {
        System.out.println(value);
        if (value == null) {
            return null;
        }
        CarroDAO carroDAO = CDI.current().select(CarroDAO.class).get();
        return carroDAO.buscarPelaPlaca(value);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Carro carro) {
        System.out.println(carro);
        if (carro == null) {
            return null;
        }
        //retornar a chave primária
        return carro.getPlaca();
    }

}
