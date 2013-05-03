package br.com.rotacostcontrol.services.rest;

import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.rotacostcontrol.model.business.EntryBS;
import br.com.rotacostcontrol.model.business.exceptions.BusinessValidationException;
import br.com.rotacostcontrol.model.entities.Entry;
import br.com.rotacostcontrol.services.json.EntryJSON;
import br.com.rotacostcontrol.services.json.EntryJSONResult;
import br.com.rotacostcontrol.utils.Constants;
import br.com.rotacostcontrol.utils.JSONUtils;

/**
 * 
 * @author bruno
 *
 */
@Path(value="/entry")
@Stateless
@LocalBean
public class EntryResource {
	
	@EJB
	private EntryBS entryBS;

	@Resource
	private SessionContext ctx;
	
    public EntryResource() {
        
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes(MediaType.APPLICATION_JSON)
    public EntryJSONResult saveEntry(EntryJSON entryJSON){
    	
    	EntryJSONResult result = new EntryJSONResult();
    	
    	Entry entry = null;
    	
		try {
			
			entry = JSONUtils.convertEntryJSONForEntry(entryJSON);
			
			entry = entryBS.saveEntryWithCategory(entry, entryJSON.getCategoryName(), ctx.getCallerPrincipal().getName());
			
			entryJSON = JSONUtils.convertEntryForEntryJSON(entry);
			
			entryJSON.setDate(convertStringDateForTwoDigits(entryJSON.getDate()));
			result.setEntry(entryJSON);
			result.setMessage("Entry saved with success!");
			result.setMethod(Constants.POST);
			result.setStatus(Constants.SUCCESS);
			
		} catch (BusinessValidationException e) {

			result.setMessage("Error when save Entry: " + entry.getName());
			result.setMethod(Constants.POST);
			result.setStatus(Constants.FAILURE);
			
			e.printStackTrace();
		}catch(ParseException e){
			

			result.setMessage("Data inválida");
			result.setMethod(Constants.POST);
			result.setStatus(Constants.FAILURE);
			
			e.printStackTrace();
		}
    	
    	return result;
    }
    
    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes(MediaType.APPLICATION_JSON)
    public EntryJSONResult updateEntry(EntryJSON entryJSON){
    	
    	EntryJSONResult result = new EntryJSONResult();
    	
    	Entry entry = null;
    	
		try {
			
			entry = JSONUtils.convertEntryJSONForEntry(entryJSON);
			
			entryBS.saveEntryWithCategory(entry, entryJSON.getCategoryName(), ctx.getCallerPrincipal().getName());
			
			entryJSON.setDate(convertStringDateForTwoDigits(entryJSON.getDate()));
			result.setEntry(entryJSON);
			result.setMessage("Entry saved with success!");
			result.setMethod(Constants.POST);
			result.setStatus(Constants.SUCCESS);
			
		} catch (BusinessValidationException e) {

			result.setMessage("Error when save Entry: " + entry.getName());
			result.setMethod(Constants.POST);
			result.setStatus(Constants.FAILURE);
			
			e.printStackTrace();
		}catch(ParseException e){
			

			result.setMessage("Data inválida");
			result.setMethod(Constants.POST);
			result.setStatus(Constants.FAILURE);
			
			e.printStackTrace();
		}
    	
    	return result;
    }
    
    @Path("delete/{id}")
    @DELETE()
    @Produces({MediaType.APPLICATION_JSON})
    public EntryJSONResult deleteEntry(@PathParam("id")Integer id){
    	
    	EntryJSONResult result = new EntryJSONResult();
    	
    	try {
		
    		result.setMessage("Entry removed with sucess!");
    		result.setMethod(Constants.DELETE);
    		result.setStatus(Constants.SUCCESS);
    		
    		entryBS.removeEntryByIdAndEmailUser(id, ctx.getCallerPrincipal().getName());
		
    	} catch (BusinessValidationException e) {

    		result.setMessage("Failure in remove entry!");
    		result.setMethod(Constants.DELETE);
    		result.setStatus(Constants.FAILURE);
    		
			e.printStackTrace();
		}
    	
    	return result;
    }
    
    @Path("listAll")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public EntryJSONResult getListAllEntries(){
    	
    	EntryJSONResult result = new EntryJSONResult();
    	
    	return result;
    }
    
    @Path("list/{date}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public EntryJSONResult getEntriesByDate(@PathParam("date")String date){
    	
    	EntryJSONResult result = new EntryJSONResult();
    	
    	Calendar initDate = getCalendarByString(date);
    	
    	Calendar endDate = getCalendarByString(date);
    	endDate.add(Calendar.MONTH, 1);
    	
    	List<EntryJSON> entriesJSON = null;
    	
    	try {
			
    		entriesJSON = JSONUtils.convertListEntryForListEntryJSON(
    				entryBS.listEntriesByEmailUser(ctx.getCallerPrincipal().getName(), initDate, endDate));
    		
    		result.setEntries(entriesJSON);
    		result.setMessage("List entries json");
    		result.setMethod(Constants.GET);
    		result.setStatus(Constants.SUCCESS);
		
    	} catch (BusinessValidationException e) {

    		result.setMessage("Failure in list entriesJSON");
    		result.setMethod(Constants.GET);
    		result.setStatus(Constants.FAILURE);
    		
    		e.printStackTrace();
		}
    	
    	return result;
    }
    
    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public EntryJSONResult getEntryById(@PathParam("id")Integer id){
    	
    	EntryJSONResult result = new EntryJSONResult();
    	
    	try {
	    		
    		result.setEntry(JSONUtils.convertEntryForEntryJSON(entryBS.findEntryByIdAndEmailUser(id, ctx.getCallerPrincipal().getName())));
    		result.setMessage("List entries json");
    		result.setMethod(Constants.GET);
    		result.setStatus(Constants.SUCCESS);
		
    	} catch (BusinessValidationException e) {

    		result.setMessage("Failure in list entriesJSON");
    		result.setMethod(Constants.GET);
    		result.setStatus(Constants.FAILURE);
    		
    		e.printStackTrace();
		}
    	
    	return result;
    }
    
    private Calendar getCalendarByString(String date){
    			
    	String[] dateSplit = date.split("-");
    	
    	int month = Integer.parseInt(dateSplit[0]);
    	int year = Integer.parseInt(dateSplit[1]);
    	
    	Calendar calendar = Calendar.getInstance();
    	calendar.set(Calendar.DATE, 1);
    	calendar.set(Calendar.MONTH, month-1);
    	calendar.set(Calendar.YEAR, year);
    	
    	return calendar;
    }
    
    private String convertStringDateForTwoDigits(String date){
    	
    	String[] arrayDate = date.split("/");
    	
    	if(arrayDate[0].length() < 2){
    		
    		arrayDate[0] = "0"+arrayDate[0];
    	}
    	
    	if(arrayDate[1].length() < 2){
    		
    		arrayDate[1] = "0"+arrayDate[1];
    	}
    	
    	return arrayDate[0]+"/"+arrayDate[1]+"/"+arrayDate[2];
    }
}
