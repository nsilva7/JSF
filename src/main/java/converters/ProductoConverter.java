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
import modelos.Producto;
import modelos.Proveedor;

/**
 *
 * @author nico
 */
@FacesConverter("productoConverter")
public class ProductoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        String[] strArr = value.split("-");
		if (strArr.length >= 2) {
			Producto producto = new Producto();
			producto.setId(Integer.parseInt(strArr[0]));
			producto.setNombre(strArr[1]);
			return producto;
		}
		return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null ){
			Producto producto = (Producto)value;
			StringBuffer strBuff = new StringBuffer(producto.getId().toString()).append("-");
			strBuff.append(producto.getNombre());
			String productoStr = strBuff.toString();
			return productoStr;
		}
		return null;
    }
    
}
