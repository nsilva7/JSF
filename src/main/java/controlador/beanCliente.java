/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import modelos.Cliente;
import modelosEJB.ClienteFacadeLocal;

/**
 *
 * @author root
 */
@ManagedBean
@ViewScoped
public class beanCliente implements Serializable{

    /**
     * Creates a new instance of beanCliente
     */
    public beanCliente() {
    }
    @EJB
    private ClienteFacadeLocal clienteEJB;
    private Cliente cliente;
    private List<Cliente> listaCliente = null; 

    @PostConstruct
    public void init() {
        cliente = new Cliente();
    }
    
    public ClienteFacadeLocal getClienteEJB() {
        return clienteEJB;
    }

    public void setClienteEJB(ClienteFacadeLocal clienteEJB) {
        this.clienteEJB = clienteEJB;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(List<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }
    
    public List<Cliente> listarClientes(){
        this.listaCliente = clienteEJB.findAll();
        return this.getListaCliente(); 
    }
    public void agregar() {
        clienteEJB.create(cliente);
    }
    public void eliminar(){
        clienteEJB.remove(cliente);
    }
}
