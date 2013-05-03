package br.com.rotacostcontrol.utils;

import java.util.Calendar;

/**
 * 
 * @author bruno
 *
 */
public class StringUtils {

	public static boolean isNull(String value){
		
		if(value != null && !value.isEmpty()){
			
			return false;
		}else{
			
			return true;
		}
	}
}
