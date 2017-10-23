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
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import modelos.Compra;
import modelos.Detallecompra;
import modelos.Producto;
import modelosEJB.CompraFacadeLocal;
import modelosEJB.DetallecompraFacadeLocal;
import modelosEJB.ProductoFacadeLocal;

/**
 *
 * @author nico
 */
@ManagedBean
@ViewScoped
public class beanCompra implements Serializable {

    /**
     * Creates a new instance of beanCompra
     */
    public beanCompra() {
    }
    
    
    @EJB
    private CompraFacadeLocal compraEJB;
    @EJB
    private DetallecompraFacadeLocal detalleEJB;
    @EJB
    private ProductoFacadeLocal productoEJB;
    private Compra compra;
    private Detallecompra detail;
    private Producto producto;
    private int cantidad;
    private List<Compra> compraLista=null;
    private static List<Detallecompra> detalleLista= new ArrayList<>();
    private List<Producto> productos = new ArrayList<>();
    
    public Detallecompra getDetail() {
        return detail;
    }

    public void setDetail(Detallecompra detail) {
        this.detail = detail;
    }
    
    
    
    @PostConstruct
    public void init() {
        compra = new Compra();
        detail = new Detallecompra();
        
        
    }
    
    public void agregar() {
        for (int i = 0; i < detalleLista.size(); i++) {
           detail =  detalleLista.get(i);
           Producto pro = detail.getProductoId();
           Producto pro2 = productoEJB.find(pro.getId());
           pro2.setStock(pro2.getStock()+detail.getCantidad());
           productoEJB.edit(pro2);
           detalleEJB.create(detail);
	}
        this.compra.setDetallecompraList(detalleLista);
        this.compraEJB.create(this.compra);
        detalleLista.removeAll(detalleLista);
        
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public List<Detallecompra> getDetalleLista() {
        return detalleLista;
    }

    public void setDetalleLista(List<Detallecompra> detalleLista) {
        this.detalleLista = detalleLista;
    }
    
    public void agregarDetalle(){
        beanCompra.detalleLista.add(detail);
    }
    
    public List<Detallecompra> getDetalles() {
        return beanCompra.detalleLista;
    }

    public CompraFacadeLocal getCompraEJB() {
        return compraEJB;
    }

    public void setCompraEJB(CompraFacadeLocal compraEJB) {
        this.compraEJB = compraEJB;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public List<Compra> getCompraLista() {
        return compraLista;
    }

    public void setCompraLista(List<Compra> compraLista) {
        this.compraLista = compraLista;
    }
    
    public void onProveedorChange() {
        if(compra.getProveedorId() !=null && !compra.getProveedorId().equals("")){
            List<Producto> productos2 = productoEJB.findAll();
            productos.removeAll(productos);
            for (int i = 0; i < productos2.size(); i++) {
            if(productos2.get(i).getProveedorId().equals(compra.getProveedorId())){
                productos.add(productos2.get(i));
            }
	}
        }
            
    }

    public DetallecompraFacadeLocal getDetalleEJB() {
        return detalleEJB;
    }

    public void setDetalleEJB(DetallecompraFacadeLocal detalleEJB) {
        this.detalleEJB = detalleEJB;
    }

    public ProductoFacadeLocal getProductoEJB() {
        return productoEJB;
    }

    public void setProductoEJB(ProductoFacadeLocal productoEJB) {
        this.productoEJB = productoEJB;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    

    
}
