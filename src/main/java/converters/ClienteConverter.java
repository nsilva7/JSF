/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelos.Cliente;
/**
 *
 * @author nico
 */
@FacesConverter("clienteConverter")
public class ClienteConverter implements Converter{
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        String[] strArr = value.split("-");
		if (strArr.length >= 2) {
			Cliente cliente = new Cliente();
			cliente.setId(Integer.parseInt(strArr[0]));
			cliente.setNombre(strArr[1]);
			cliente.setCi(strArr[2]);
			return cliente;
		}
		return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null ){
			Cliente cliente = (Cliente)value;
			StringBuffer strBuff = new StringBuffer(cliente.getId().toString()).append("-");
			strBuff.append(cliente.getNombre()).append("-");
                        strBuff.append(cliente.getCi());
			String proveedorStr = strBuff.toString();
			return proveedorStr;
		}
		return null;
    }
}
