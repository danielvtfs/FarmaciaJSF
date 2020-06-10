package br.com.farmaciajsf.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class JSFUtil {

	public static void mensagemSucesso(String mensagem) {
		// FacesMessage para criar a mensagem que ser� exibida na tela
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem , mensagem);
		// FacesContext aponta o contexto da aplica��o. Registro, busca...
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, msg);
	}
	
	
	public static void mensagemErro(String mensagem) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem);
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, msg);
	}
	
}
