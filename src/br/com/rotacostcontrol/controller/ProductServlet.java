package br.com.rotacostcontrol.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.mail.EmailException;
import org.jboss.crypto.CryptoUtil;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rotacostcontrol.model.business.EmailBS;
import br.com.rotacostcontrol.model.business.UserBS;
import br.com.rotacostcontrol.model.dao.ProductDAO;
import br.com.rotacostcontrol.model.entities.Role;
import br.com.rotacostcontrol.model.entities.User;
import br.com.rotacostcontrol.utils.EmailUtil;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private ProductDAO productDAO;
	
	@EJB
	private UserBS userBS;
	

    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("teste");
		
		System.out.println(userBS == null);
		
		/*Role r1 = new Role();
		r1.setId(1);
		r1.setName("user");
		
		productDAO.save(r1);
		
		//Role r1 = productDAO.find(1);
		
		User user = new User();
		user.setEmail("brunorota1989@gmail.com");
		user.setPassword(CryptoUtil.createPasswordHash("MD5", CryptoUtil.BASE64_ENCODING, null, null, "teste123"));
		//user.setRoles(new HashSet<Role>());
		
		//user.getRoles().add(r1);
		
		
		productDAO.save(user);
		
		
		Role r2 = productDAO.find(1);
		
		User u2 = productDAO.findUser(user.getId());
		
		u2.setRoles(new HashSet<Role>());
		u2.getRoles().add(r2);
		
		productDAO.merge(u2);
		
		//System.out.println(productDAO.getUserLoged());*/
		
		/*try {
			emailBS.sendEmailConfirmation("bruno_sargi1989@hotmail.com", null);
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
