package br.com.rotacostcontrol.model.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;

import br.com.rotacostcontrol.model.entities.Category;

/**
 * 
 * @author bruno
 *
 */
@Stateless
@LocalBean
public class CategoryDAO {

	@PersistenceContext
	private EntityManager em;
	
    public CategoryDAO() {
    }

    public Category save(Category category){
    	
    	em.persist(category);
    	
    	return category;
    }
    
    public List<Category> listCategoryByEmailUser(String email){
    	
    	return em.createNamedQuery("Category.listCategoryByEmailUser")
    	.setParameter("email", email).getResultList();
    }
    
    public Category findCategoryByNameAndEmailUser(String name, String email){

    	List<Category> categories = em.createNamedQuery("Category.findCategoryByNameAndEmailUser")
    	.setParameter("name", name)
    	.setParameter("email", email).getResultList();
    	
    	if(categories != null && categories.size() > 0){
    		
    		return categories.get(0);
    	}else{
    		
    		return null;
    	}
    }
}
