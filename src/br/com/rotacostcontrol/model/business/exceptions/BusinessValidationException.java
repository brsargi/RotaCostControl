package br.com.rotacostcontrol.model.business.exceptions;

import javax.ejb.ApplicationException;

/**
 * 
 * @author bruno
 *
 */
@ApplicationException(inherited=true, rollback=true)
public class BusinessValidationException extends Exception{

	private static final long serialVersionUID = -7450444579121914576L;

	public BusinessValidationException(String message){
		
		super(message);
	}
}
