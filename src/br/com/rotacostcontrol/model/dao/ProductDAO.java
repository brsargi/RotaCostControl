package br.com.rotacostcontrol.model.dao;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.rotacostcontrol.model.entities.Product;
import br.com.rotacostcontrol.model.entities.Role;
import br.com.rotacostcontrol.model.entities.User;

/**
 * 
 * @author bruno
 *
 */
@Stateless
@LocalBean
public class ProductDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Resource
	private SessionContext ctx;
	
    public ProductDAO() {
        
    }

    public void save(Product product){
    	
    	em.persist(product);
    }
    
    public void save(Role role){
    	
    	System.out.println("ROLE ID: " + role.getId());
    	
    	em.persist(role);
    	
    	System.out.println("ROLE ID: " + role.getId());
    }
    
    public void merge(User user){
    	
    	em.merge(user);
    }
    
    
    
    public void save(User user){
    	
    	System.out.println(user.getId());
    	
    	em.persist(user);
    	
    	System.out.println(user.getId());
    }
    
    public Role find(Integer id){
    	
    	return em.find(Role.class, id);
    }
    
    public User findUser(Integer id){
    	
    	return em.find(User.class, id);
    }
    
    public String getUserLoged(){
    	
    	return ctx.getCallerPrincipal().getName();
    }
    
}
