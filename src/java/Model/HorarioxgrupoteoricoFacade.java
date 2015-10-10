/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.Horarioxgrupoteorico;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Admin
 */
@Stateless
public class HorarioxgrupoteoricoFacade extends AbstractFacade<Horarioxgrupoteorico> {
    @PersistenceContext(unitName = "ExpedientePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HorarioxgrupoteoricoFacade() {
        super(Horarioxgrupoteorico.class);
    }
    
}
