package modelos;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelos.Cliente;
import modelos.Producto;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-22T13:25:26")
@StaticMetamodel(Venta.class)
public class Venta_ { 

    public static volatile SingularAttribute<Venta, Date> fecha;
    public static volatile SingularAttribute<Venta, Cliente> clienteId;
    public static volatile SingularAttribute<Venta, Producto> productoId;
    public static volatile SingularAttribute<Venta, Integer> id;
    public static volatile SingularAttribute<Venta, Integer> cantidad;

}