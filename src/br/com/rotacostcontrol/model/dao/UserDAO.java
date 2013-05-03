package br.com.rotacostcontrol.model.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.rotacostcontrol.model.entities.User;

/**
 * 
 * @author bruno
 *
 */
@Stateless
@LocalBean
public class UserDAO {

	@PersistenceContext
	private EntityManager em;
	
    public UserDAO() {

    }

    public void update(User user){
    	
    	em.merge(user);
    }
    
    public void save(User user){
    	
    	em.persist(user);
    }
    
    public User findByEmail(String email){
    	
    	List<User> users = em.createNamedQuery("User.findByEmail")
    	    	.setParameter("email", email).getResultList();
    	
    	if(users != null && !users.isEmpty()){
    		
    		return users.get(0);
    		
    	}else{
    		
    		return null;
    	}
    }

    public User findByToken(String token){
    	
    	List<User> users = em.createNamedQuery("User.findByToken")
    	    	.setParameter("token", token).getResultList();
    	
    	if(users != null && !users.isEmpty()){
    		
    		return users.get(0);
    		
    	}else{
    		
    		return null;
    	}
    }
}
