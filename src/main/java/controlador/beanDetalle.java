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
import modelos.Detallecompra;
import modelos.Producto;
import modelosEJB.DetallecompraFacadeLocal;
import modelosEJB.ProductoFacadeLocal;

/**
 *
 * @author nico
 */
@ManagedBean
@ViewScoped
public class beanDetalle implements Serializable{

    /**
     * Creates a new instance of beanDetalle
     */
    public beanDetalle() {
    }
    @EJB
    private DetallecompraFacadeLocal detalleEJB;
    private Detallecompra detalle;
    private List<Detallecompra> detalleLista=null;

    @PostConstruct
    public void init() {
        detalle = new Detallecompra();
    }
    
    public Detallecompra agregar() {
        this.detalleEJB.create(this.detalle);
        return this.detalle;
    }

    public DetallecompraFacadeLocal getDetalleEJB() {
        return detalleEJB;
    }

    public void setDetalleEJB(DetallecompraFacadeLocal detalleEJB) {
        this.detalleEJB = detalleEJB;
    }

    public Detallecompra getDetalle() {
        return detalle;
    }

    public void setDetalle(Detallecompra detalle) {
        this.detalle = detalle;
    }

    public List<Detallecompra> getDetalleLista() {
        return detalleLista;
    }

    public void setDetalleLista(List<Detallecompra> detalleLista) {
        this.detalleLista = detalleLista;
    }
    
    
}
