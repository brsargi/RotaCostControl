package br.com.rotacostcontrol.services.rest;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.rotacostcontrol.model.business.CategoryBS;
import br.com.rotacostcontrol.model.business.exceptions.BusinessValidationException;
import br.com.rotacostcontrol.services.json.CategoryJSON;
import br.com.rotacostcontrol.services.json.CategoryJSONResult;
import br.com.rotacostcontrol.utils.Constants;
import br.com.rotacostcontrol.utils.JSONUtils;

/**
 * 
 * @author bruno
 *
 */
@Path("category")
@Stateless
@LocalBean
public class CategoryResource {

	@EJB
	private CategoryBS categoryBS;
	
	@Resource
	private SessionContext ctx;
	
    public CategoryResource() {
    }

    @Path("list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public CategoryJSONResult listAllCategories(){
        	
    	CategoryJSONResult result = new CategoryJSONResult();
    	
    	try {
    		
    		result.setCategories(JSONUtils.convertListCategoryForListCategoryJSON(
    				categoryBS.listCategoryByEmailUser(ctx.getCallerPrincipal().getName())));
		
    		result.setMessage("List of categories json");
    		result.setMethod(Constants.GET);
    		result.setStatus(Constants.SUCCESS);
    		
    	} catch (BusinessValidationException e) {

    		result.setMessage("Failure in get list category json");
    		result.setMethod(Constants.GET);
    		result.setStatus(Constants.FAILURE);
    		
			e.printStackTrace();
		}
    	
    	return result;
    }
}
