package br.com.rotacostcontrol.model.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.rotacostcontrol.model.entities.Role;

/**
 * 
 * @author bruno
 *
 */
@Stateless
@LocalBean
public class RoleDAO {

	@PersistenceContext
	private EntityManager em;
	
    public RoleDAO() {
        
    }

    public Role find(Integer id){
    	
    	return em.find(Role.class, id);
    }
}
