/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import modelos.Producto;
import modelos.Proveedor;
import modelosEJB.ProductoFacadeLocal;

/**
 *
 * @author nico
 */
@ManagedBean
@ViewScoped
public class beanProducto implements Serializable{

    /**
     * Creates a new instance of beanProducto
     */
    public beanProducto() {
    }
    
    @EJB
    private ProductoFacadeLocal productoEJB;
    private Producto producto;
    private List<Producto> productoLista=null;

    @PostConstruct
    public void init() {
        producto = new Producto();
    }
    
    public void crearProducto() {
        this.productoEJB.create(this.producto);
    }
    
    public void eliminar(){
        productoEJB.remove(producto);
    }
    
    public ProductoFacadeLocal getProductoEJB() {
        return productoEJB;
    }

    public void setProductoEJB(ProductoFacadeLocal productoEJB) {
        this.productoEJB = productoEJB;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Producto> getProductoLista() {
        return productoLista;
    }

    public void setProductoLista(List<Producto> productoLista) {
        this.productoLista = productoLista;
    }
    
    public List<Producto> getProductos() {
        productoLista = productoEJB.findAll();
        return productoLista;
    }
    
        public List<Producto> getProductosProveedor(int id) {
        productoLista = productoEJB.findAll();
        for (int i = 0; i < productoLista.size(); i++) {
            if(productoLista.get(i).getProveedorId().getId() != id){
                productoLista.remove(i);
            }
	}
        return productoLista;
    }
    
}
