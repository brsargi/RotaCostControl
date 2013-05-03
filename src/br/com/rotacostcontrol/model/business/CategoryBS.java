package br.com.rotacostcontrol.model.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.hibernate.validator.constraints.Email;

import br.com.rotacostcontrol.model.business.exceptions.BusinessValidationException;
import br.com.rotacostcontrol.model.dao.CategoryDAO;
import br.com.rotacostcontrol.model.dao.UserDAO;
import br.com.rotacostcontrol.model.entities.Category;
import br.com.rotacostcontrol.model.entities.User;
import br.com.rotacostcontrol.utils.StringUtils;

/**
 * 
 * @author bruno
 *
 */
@Stateless
@LocalBean
public class CategoryBS {
	
	@EJB
	private CategoryDAO categoryDAO;
	
	@EJB
	private UserBS userBS;
	
    public CategoryBS() {
        
    }
    
    public Category saveCategoryWithUser(Category category, String emailUser) throws BusinessValidationException{
    	
    	User user =  userBS.findByEmail(emailUser);
    	
    	if(category != null && !StringUtils.isNull(category.getName())){
    		
    		category.setUser(user);
    		
        	return categoryDAO.save(category);
    	}else{
    		
    		throw new BusinessValidationException("O nome da categoria não pode ser nulo ou vazio.");
    	}
    }
    
    public List<Category> listCategoryByEmailUser(String email) throws BusinessValidationException{
    	
    	if(!StringUtils.isNull(email)){

        	return categoryDAO.listCategoryByEmailUser(email);
    	}else{
    		
    		throw new BusinessValidationException("O email do usuário não pode ser vazio e nem nulo.");
    	}
    }
    
    public Category findCategoryByNameAndEmailUser(String name, String email) throws BusinessValidationException{

    	System.out.println("findCategoryByNameAndEmailUser: " + name);
    	
    	if(!StringUtils.isNull(name) && !StringUtils.isNull(email)){
    		
        	return categoryDAO.findCategoryByNameAndEmailUser(name, email);
    	}else{
    		
    		throw new BusinessValidationException("O email e o nome do usuário não pode ser vazio e nem nulo.");
    	}
    	
    }

}
