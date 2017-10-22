package modelos;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelos.Producto;
import modelos.Proveedor;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-22T13:25:26")
@StaticMetamodel(Compra.class)
public class Compra_ { 

    public static volatile SingularAttribute<Compra, Date> fecha;
    public static volatile SingularAttribute<Compra, Proveedor> proveedorId;
    public static volatile SingularAttribute<Compra, Producto> productoId;
    public static volatile SingularAttribute<Compra, Integer> id;
    public static volatile SingularAttribute<Compra, Integer> cantidad;

}