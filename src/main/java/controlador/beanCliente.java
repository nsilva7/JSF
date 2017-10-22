/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import modelos.Cliente;
import modelosEJB.ClienteFacadeLocal;

/**
 *
 * @author root
 */
@Named(value = "beanCliente")
@ViewScoped
public class beanCliente {

    /**
     * Creates a new instance of beanCliente
     */
    public beanCliente() {
    }
    @EJB
    private ClienteFacadeLocal clienteEJB;
    private Cliente cliente;
    private List<Cliente> listaCliente = null; 

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
}
