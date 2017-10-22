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
import modelos.Proveedor;

/**
 *
 * @author nico
 */
@FacesConverter("proveedorConverter")
public class ProveedorConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        String[] strArr = value.split("-");
		if (strArr.length >= 2) {
			Proveedor proveedor = new Proveedor();
			proveedor.setId(Integer.parseInt(strArr[0]));
			proveedor.setNombre(strArr[1]);
			proveedor.setRuc(strArr[2]);
			return proveedor;
		}
		return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null ){
			Proveedor proveedor = (Proveedor)value;
			StringBuffer strBuff = new StringBuffer(proveedor.getId().toString()).append("-");
			strBuff.append(proveedor.getNombre()).append("-");
                        strBuff.append(proveedor.getRuc());
			String proveedorStr = strBuff.toString();
			return proveedorStr;
		}
		return null;
    }
    
}
