package br.com.rotacostcontrol.model.business.exceptions;

import javax.ejb.ApplicationException;

/**
 * 
 * @author bruno
 *
 */
@ApplicationException(inherited=true, rollback=true)
public class UserExistException extends Exception{

	private static final long serialVersionUID = -8929976234474608515L;

	public UserExistException(String message){
		
		super(message);
	}
}
