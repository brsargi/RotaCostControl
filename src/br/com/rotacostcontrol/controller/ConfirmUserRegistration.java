package br.com.rotacostcontrol.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rotacostcontrol.model.business.UserBS;
import br.com.rotacostcontrol.model.business.exceptions.BusinessValidationException;
import br.com.rotacostcontrol.model.entities.User;

@WebServlet("/confirmacaocadastro")
public class ConfirmUserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private UserBS userBS;
	
    public ConfirmUserRegistration() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
						
		RequestDispatcher requestDispatcher = null; 
		
		String token = request.getParameter("token");
		
		try {
			
			User user = userBS.findByToken(token);
			
			user.setActive(Boolean.TRUE);
			
			userBS.update(user);
			
			requestDispatcher = request.getRequestDispatcher("/pages/create-account-success.jsp" ) ; 

			
		} catch (BusinessValidationException e) {
			
			e.printStackTrace();
			
			requestDispatcher = request.getRequestDispatcher("/pages/create-account-error.jsp" ) ; 
		}
		
		requestDispatcher.forward( request, response ) ;
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
