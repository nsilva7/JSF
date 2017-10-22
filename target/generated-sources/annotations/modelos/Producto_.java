package modelos;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelos.Compra;
import modelos.Proveedor;
import modelos.Venta;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-22T03:31:21")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, String> descripcion;
    public static volatile SingularAttribute<Producto, Integer> precio;
    public static volatile SingularAttribute<Producto, Proveedor> proveedorId;
    public static volatile ListAttribute<Producto, Venta> ventaList;
    public static volatile SingularAttribute<Producto, Integer> id;
    public static volatile SingularAttribute<Producto, Integer> stock;
    public static volatile ListAttribute<Producto, Compra> compraList;
    public static volatile SingularAttribute<Producto, String> nombre;

}