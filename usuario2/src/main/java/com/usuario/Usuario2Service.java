package com.usuario;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.usuario.utils.EmailUtils;

public class Usuario2Service {

	@Autowired
	private Usuario2Repository rep;
	
	@Autowired
	private EmailUtils emailUtils;

	public void findEmailByNomeAndSenha(String nome, String senha) {

		String email= rep.findEmailByNomeAndSenha(nome, senha);
		
		
		try {
			emailUtils.enviaEmail(montaCorpo(nome), email, "dmattamachado@gmail.com", "Bem Vindo", "Ao sistema da Daniela");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	private String montaCorpo(String nome) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		
		// Registra data/hora login
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date dataHoraAtual = Calendar.getInstance().getTime();
		String dataLogin = df.format(dataHoraAtual);

		StringBuilder corpo = new StringBuilder();
		corpo.append("<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.0 Transitional//EN'>");
		corpo.append("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
		corpo.append("<head>");
		corpo.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
		corpo.append("<title>Teste</title>");
		corpo.append("</head>");
		corpo.append("<body style=\"background-color: #A4D1FF;\">");
		corpo.append("<p>Olá" + nome + "</p>");
		corpo.append("<p>Horário de acesso:" + dataLogin + "</p>");
		corpo.append("</body></html>");

		return corpo.toString();
}
	
	
	
}
