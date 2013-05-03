package br.com.rotacostcontrol.model.dao;

import java.util.Calendar;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;

import br.com.rotacostcontrol.model.entities.Entry;

/**
 * EntryDAO
 * @author bruno
 *
 */
@Stateless
@LocalBean
public class EntryDAO {

	@PersistenceContext
	private EntityManager em;
	
    public EntryDAO() {
    }
    
    public Entry save(Entry entry){
    	
    	em.persist(entry);
    	
    	return entry;
    }
    
    public Entry update(Entry entry){
    	
    	em.merge(entry);
    	
    	return entry;
    }
    
    public void delete(Entry entry){
    	
    	em.remove(entry);
    }
    
    public List<Entry> listEntriesByEmailUser(String email, Calendar initDate, Calendar endDate){
    	
    	return em.createNamedQuery("Entry.listEntriesByEmailUser")
    			.setParameter("initDate", initDate, TemporalType.DATE)
    			.setParameter("endDate", endDate, TemporalType.DATE)
    			.setParameter("email", email).getResultList();
    }
    
    public Entry findEntryByIdAndEmailUser(Integer id, String email){
    	
    	return (Entry)em.createNamedQuery("Entry.findEntryByIdAndEmailUser")
    			.setParameter("id", id)
    			.setParameter("email", email).getSingleResult();
    }
    
    public List<Entry> listEntriesByIdCategoryAndEmailUser(Integer id, String email, Calendar initDate, Calendar endDate){
    	
    	return em.createNamedQuery("Entry.listEntriesByIdCategoryAndEmailUser")
    			.setParameter("id", id)
    			.setParameter("email",email)
    			.setParameter("initDate", initDate, TemporalType.DATE)
    			.setParameter("endDate", endDate, TemporalType.DATE)
    			.getResultList();
    }

}
