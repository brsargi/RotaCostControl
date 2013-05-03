package br.com.rotacostcontrol.utils;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 * 
 * @author bruno
 *
 */
public class EmailUtil {
	public EmailUtil() {
		super();
	}

	public static void sendEmail(String destinatario) throws EmailException {
 
		 HtmlEmail email = new HtmlEmail();
		 email.setHostName("smtp.gmail.com"); // o servidor SMTP para envio do
		 
		 // e-mail
		 email.addTo(destinatario); //destinatário
		 email.setFrom("email@gmail.com", "Meu Dinheiro"); //remetente
		 email.setSubject("Meu Dinheiro - Confirmação de cadastro"); //assunto do e-mail
		 email.setMsg("Acesse a URL abaixo para confirmar o seu cadastro no Meu Email"); //conteudo do e-mail
		 
		 StringBuilder conteudoEmail = new StringBuilder();
		 conteudoEmail.append("<html>");
		 conteudoEmail.append("<body>");
		 conteudoEmail.append("Clique na url abaixo para confirmar seu cadastro.");
		 conteudoEmail.append("</body>");
		 conteudoEmail.append("</html>");
		 
		 //email.setMsg("Conteudo em texto");
		 email.setHtmlMsg(conteudoEmail.toString());
		 
		 email.setAuthentication("email@gmail.com","senha");
		 email.setSmtpPort(465);
		 email.setSSL(true);
		 email.setTLS(true);
		 email.send();
	}
}
