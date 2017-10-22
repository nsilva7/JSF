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
import modelosEJB.ProveedorFacadeLocal;

/**
 *
 * @author nico
 */
@ManagedBean
@ViewScoped
public class beanProveedor implements Serializable{

    /**
     * Creates a new instance of beanProveedor
     */
    public beanProveedor() {
    }
    
    @EJB
    private ProveedorFacadeLocal proveedorEJB;
    private Proveedor proveedor;
    private List<Proveedor> proveedorLista=null;

    @PostConstruct
    public void init() {
        proveedor = new Proveedor();
        
    }
    
    public void agregar() {
        this.proveedorEJB.create(proveedor);
    }
    
    public void eliminar(){
        proveedorEJB.remove(proveedor);
    }

    public ProveedorFacadeLocal getProveedorEJB() {
        return proveedorEJB;
    }

    public void setProveedorEJB(ProveedorFacadeLocal proveedorEJB) {
        this.proveedorEJB = proveedorEJB;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<Proveedor> getProveedorLista() {
        return proveedorLista;
    }

    public void setProveedorLista(List<Proveedor> proveedorLista) {
        this.proveedorLista = proveedorLista;
    }
    
    public List<Proveedor> getProveedores() {
        this.proveedorLista = proveedorEJB.findAll();
        return this.getProveedorLista();
    }
}
