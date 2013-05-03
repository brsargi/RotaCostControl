package br.com.rotacostcontrol.model.business;

import javax.ejb.Asynchronous;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 * 
 * @author bruno
 *
 */
@Stateless
@LocalBean
public class EmailBS {

    public EmailBS() {
        
    }

    @Asynchronous
    public void sendEmailConfirmation(String destinatario, String token) throws EmailException {
    	 
		 HtmlEmail email = new HtmlEmail();
		 email.setHostName("smtp.gmail.com");
		 
		 // e-mail
		 email.addTo(destinatario); //destinatário
		 email.setFrom("contato.meudinheiro@gmail.com", "Meu Dinheiro");
		 email.setSubject("Meu Dinheiro - Confirmação de cadastro");
		 email.setMsg("Acesse a URL abaixo para confirmar o seu cadastro no Meu Email");
		 
		 StringBuilder conteudoEmail = new StringBuilder();
		 conteudoEmail.append("<html>");
		 conteudoEmail.append("<body>");
		 conteudoEmail.append("Olá, ").append(destinatario).append("<br/><br/>");
		 conteudoEmail.append("Clique na url abaixo para confirmar seu cadastro.<br/><br/>");
		 conteudoEmail.append("<a href='http://brunorota.com.br:8085/RotaCostControl/confirmacaocadastro?token="+token+"'>Clique aqui</a><br/><br/>");
		 conteudoEmail.append("Obrigado");
		 conteudoEmail.append("</body>");
		 conteudoEmail.append("</html>");
		 
		 email.setHtmlMsg(conteudoEmail.toString());
		 
		 email.setAuthentication("contato.meudinheiro@gmail.com","meudinheiro9192");
		 email.setSmtpPort(465);
		 email.setSSL(true);
		 email.setTLS(true);
		 email.send();
	}
}
