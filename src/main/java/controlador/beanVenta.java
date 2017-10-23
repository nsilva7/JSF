/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import modelos.Detallecompra;
import modelos.Detalleventa;
import modelos.Producto;
import modelos.Venta;
import modelosEJB.DetalleventaFacadeLocal;
import modelosEJB.ProductoFacadeLocal;
import modelosEJB.VentaFacadeLocal;

/**
 *
 * @author nico
 */
@ManagedBean
@Dependent
public class beanVenta implements Serializable{

    /**
     * Creates a new instance of beanVenta
     */
    public beanVenta() {
    }
    
    @EJB
    private VentaFacadeLocal ventaEJB;
    @EJB
    private DetalleventaFacadeLocal detalleEJB;
    @EJB
    private ProductoFacadeLocal productoEJB;
    private Venta venta;
    private Detalleventa detail;
    private Producto producto;
    private List<Venta> ventaLista=null;
    private static List<Detalleventa> detalleLista= new ArrayList<>();
    private List<Producto> productos = new ArrayList<>();
    
     @PostConstruct
    public void init() {
        venta= new Venta();
        detail = new Detalleventa();
        productos = productoEJB.findAll();
        
        
    }
    
    public void agregar() {
        for (int i = 0; i < detalleLista.size(); i++) {
           detail =  detalleLista.get(i);
           Producto pro = detail.getProductoId();
           Producto pro2 = productoEJB.find(pro.getId());
           pro2.setStock(pro2.getStock()-detail.getCantidad());
           productoEJB.edit(pro2);
           detalleEJB.create(detail);
	}
        this.venta.setDetalleventaList(detalleLista);
        this.ventaEJB.create(this.venta);
        detalleLista.removeAll(detalleLista);
        
    }
    
    public VentaFacadeLocal getVentaEJB() {
        return ventaEJB;
    }

    public void setVentaEJB(VentaFacadeLocal ventaEJB) {
        this.ventaEJB = ventaEJB;
    }

    public DetalleventaFacadeLocal getDetalleEJB() {
        return detalleEJB;
    }

    public void setDetalleEJB(DetalleventaFacadeLocal detalleEJB) {
        this.detalleEJB = detalleEJB;
    }

    public void agregarDetalle(){
        beanVenta.detalleLista.add(detail);
    }
    
    public List<Detalleventa> getDetalles() {
        return beanVenta.detalleLista;
    }
    
    public ProductoFacadeLocal getProductoEJB() {
        return productoEJB;
    }

    public void setProductoEJB(ProductoFacadeLocal productoEJB) {
        this.productoEJB = productoEJB;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Detalleventa getDetail() {
        return detail;
    }

    public void setDetail(Detalleventa detail) {
        this.detail = detail;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Venta> getVentaLista() {
        return ventaLista;
    }

    public void setVentaLista(List<Venta> ventaLista) {
        this.ventaLista = ventaLista;
    }

    public static List<Detalleventa> getDetalleLista() {
        return detalleLista;
    }

    public static void setDetalleLista(List<Detalleventa> detalleLista) {
        beanVenta.detalleLista = detalleLista;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    
}
