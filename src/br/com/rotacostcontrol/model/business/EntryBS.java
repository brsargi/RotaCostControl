package br.com.rotacostcontrol.model.business;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

import br.com.rotacostcontrol.model.business.exceptions.BusinessValidationException;
import br.com.rotacostcontrol.model.dao.EntryDAO;
import br.com.rotacostcontrol.model.entities.Category;
import br.com.rotacostcontrol.model.entities.Entry;
import br.com.rotacostcontrol.utils.StringUtils;

/**
 * 
 * @author bruno
 *
 */
@Stateless
@LocalBean
public class EntryBS {

	@EJB
	private EntryDAO entryDAO;
	
	@EJB
	private CategoryBS categoryBS;
	
    public EntryBS() {
        
    }
    
    public Entry saveEntryWithCategory(Entry entry, String categoryName, String email) throws BusinessValidationException{
    	
    	Category category = categoryBS.findCategoryByNameAndEmailUser(categoryName, email);
    	
    	if(category == null){
    		
    		category = new Category();
    		category.setName(categoryName);
    		category.setEntries(new ArrayList<Entry>());
    		
    		categoryBS.saveCategoryWithUser(category, email);
    	}
    	
    	if(entry != null){

    		entry.setCategory(category);
    		
    		if(entry.getId() != null){

    			return entryDAO.update(entry);
    		}else{
    			
    			return entryDAO.save(entry);
    		}
    	}else{
    		
    		throw new BusinessValidationException("O entry nao pode ser nulo");
    	}
    }
    
    public void removeEntryByIdAndEmailUser(Integer id, String email) throws BusinessValidationException{
    	
    	if(id != null && !StringUtils.isNull(email)){
    		
    		try{
    		
    			Entry entry = entryDAO.findEntryByIdAndEmailUser(id, email);
        		
    			entryDAO.delete(entry);
    			
    		}catch(NoResultException e){
    			
    			throw new BusinessValidationException("A entry não existe para o usuário: " + email);
    		}
    		
    	}else{
    		
    		throw new BusinessValidationException("O email não pode ser nulo");
    	}
    }
    
    public Entry findEntryByIdAndEmailUser(Integer id, String email) throws BusinessValidationException{
    	
    	if(id != null && !StringUtils.isNull(email)){
    		
    		try{
    		
    			Entry entry = entryDAO.findEntryByIdAndEmailUser(id, email);
        		
    			return entry;
    			
    		}catch(NoResultException e){
    			
    			throw new BusinessValidationException("A entry não existe para o usuário: " + email);
    		}
    		
    	}else{
    		
    		throw new BusinessValidationException("O email não pode ser nulo");
    	}
    }
    
    public List<Entry> listEntriesByEmailUser(String email, Calendar initDate, Calendar endDate) throws BusinessValidationException{
    	
    	if(!StringUtils.isNull(email) && initDate != null && endDate != null){
    		
    		return entryDAO.listEntriesByEmailUser(email, initDate, endDate);
    	
    	}else{
    		
    		throw new BusinessValidationException("O email, initDate e endDate não pode ser nulo");
    	}
    }
    
    public List<Entry> listEntriesByIdCategoryAndEmailUser(Integer id, String email, Calendar initDate, Calendar endDate) throws BusinessValidationException{
    	
    	if(id != null && email != null && !email.isEmpty() && initDate != null && endDate != null){
    		
    		return entryDAO.listEntriesByIdCategoryAndEmailUser(id, email, initDate, endDate);
    	}else{
    		
    		throw new BusinessValidationException("O email, idCategory, initDate e endDate não pode ser nulo");
    	}
    }
}
