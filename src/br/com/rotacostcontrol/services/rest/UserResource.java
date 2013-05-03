package br.com.rotacostcontrol.services.rest;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.mail.EmailException;

import br.com.rotacostcontrol.model.business.UserBS;
import br.com.rotacostcontrol.model.business.exceptions.BusinessValidationException;
import br.com.rotacostcontrol.model.business.exceptions.UserExistException;
import br.com.rotacostcontrol.services.json.UserJSONResult;
import br.com.rotacostcontrol.utils.Constants;

/**
 * 
 * @author bruno
 *
 */
@Path("user")
@Stateless
@LocalBean
public class UserResource {

	@EJB
	private UserBS userBS;
	
    public UserResource() {
    }
    
    @POST
    @Consumes("application/x-www-form-urlencoded")
    @Produces({MediaType.APPLICATION_JSON})
    public UserJSONResult createUser(@FormParam("email")String email, 
    								 @FormParam("password")String password){
    	   	
    	System.out.println("CreateUser");
    	
    	UserJSONResult userResult = new UserJSONResult();
		userResult.setMethod(Constants.POST);
    	
    	
    	try {
			userBS.saveUserWithRole(email,password, 1);
			
			userResult.setMessage("User saved with success!");
			userResult.setStatus(Constants.SUCCESS);
			
		} catch (BusinessValidationException e) {
			
			userResult.setMessage("validation");
			userResult.setStatus(Constants.FAILURE);
			
			e.printStackTrace();
		} catch (UserExistException e) {
			
			userResult.setMessage("exist");
			userResult.setStatus(Constants.FAILURE);
			
			e.printStackTrace();
		} catch(EmailException e){
		
			userResult.setMessage("email");
			userResult.setStatus(Constants.FAILURE);
			
			e.printStackTrace();
		}
    	
    	System.out.println(userResult.getStatus());
    	
    	return userResult;
    }

}
