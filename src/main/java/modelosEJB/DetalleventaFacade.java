/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelosEJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelos.Detalleventa;

/**
 *
 * @author nico
 */
@Stateless
public class DetalleventaFacade extends AbstractFacade<Detalleventa> implements DetalleventaFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_JSF_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleventaFacade() {
        super(Detalleventa.class);
    }
    
}
