package br.com.rotacostcontrol.model.business;

import java.util.HashSet;
import java.util.UUID;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.apache.commons.mail.EmailException;
import org.jboss.crypto.CryptoUtil;

import br.com.rotacostcontrol.model.business.exceptions.BusinessValidationException;
import br.com.rotacostcontrol.model.business.exceptions.UserExistException;
import br.com.rotacostcontrol.model.dao.RoleDAO;
import br.com.rotacostcontrol.model.dao.UserDAO;
import br.com.rotacostcontrol.model.entities.Role;
import br.com.rotacostcontrol.model.entities.User;
import br.com.rotacostcontrol.utils.StringUtils;

/**
 * 
 * @author bruno
 *
 */
@Stateless
@LocalBean
public class UserBS {

	@EJB
	private UserDAO userDAO;
	
	@EJB
	private RoleDAO roleDAO;
	
	@EJB
	private EmailBS emailBS;
	
    public UserBS() {
    }

    public void saveUserWithRole(String email, String password, Integer roleId) throws BusinessValidationException, UserExistException, EmailException{
    	
    	if(StringUtils.isNull(email) && StringUtils.isNull(password)){
    		
    		throw new BusinessValidationException("Usuário nulo");
    	}
    	
    	User userExist = userDAO.findByEmail(email);
    	
    	if(userExist != null){
    		
    		throw new UserExistException("Usuário existente");
    	}
    	
    	Role role = roleDAO.find(roleId);
    	
    	if(role == null){
    		
    		throw new BusinessValidationException("Role não existente");
    	}
    	
    	User user = createNewUser(email, password);
    	
    	if(user.getRoles() == null){
    		
    		user.setRoles(new HashSet<Role>());
    	}
    	
    	user.getRoles().add(role);
    	
    	userDAO.save(user);
    	
    	emailBS.sendEmailConfirmation(user.getEmail(), user.getToken());
    }
    
    private User createNewUser(String email, String password){
    	
    	User user = new User();
    	user.setEmail(email);
    	user.setPassword(CryptoUtil.createPasswordHash("MD5", CryptoUtil.BASE64_ENCODING, null, null, password));
    	user.setActive(Boolean.FALSE);
    	user.setToken(generateToken());
    	
    	return user;
    }
    
    public User findByEmail(String email) throws BusinessValidationException{
    	
    	if(!StringUtils.isNull(email)){
    		
        	return userDAO.findByEmail(email);
    	}else{
    		
    		throw new BusinessValidationException("O email não pode ser nulo nem vazio");
    	}
    }
    
    public User findByToken(String token) throws BusinessValidationException{
    	
    	if(!StringUtils.isNull(token)){
    		
        	return userDAO.findByToken(token);
    	}else{
    		
    		throw new BusinessValidationException("O email não pode ser nulo nem vazio");
    	}
    }
    
    public void update(User user) throws BusinessValidationException{
    	
    	if(user != null){
    		
        	userDAO.update(user);
    	}else{
    		
    		throw new BusinessValidationException("O user não pode ser nulo");
    	}
    	
    }
    
    private String generateToken(){
    	
    	return UUID.randomUUID().toString();
    }
}
