package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class Controlador {
	@FXML
	private RadioButton loginRButton, registroRButton;
	@FXML
	private TextField userLogin,senhaLogin,emailRegistro,userRegistro,senhaRegistro;
	
	
	
	
	//métodos ACTIONEVENT, ou seja, não precisam ser chamados na "main", eles ocorrem quando há "ação" no app
	public String escolhaLoginRegistro(ActionEvent event) {
		if(loginRButton.isSelected()) {
			userLogin.setDisable(false);
			senhaLogin.setDisable(false);
			emailRegistro.setDisable(true);
			userRegistro.setDisable(true);
			senhaRegistro.setDisable(true);
			return "login";
		}else {
			userLogin.setDisable(true);
			senhaLogin.setDisable(true);
			emailRegistro.setDisable(false);
			userRegistro.setDisable(false);
			senhaRegistro.setDisable(false);
			return "registro";
		}
	}
	
//	public void permiteTextFields(String escolhaLoginRegistro) {
//		if()
//		
//	}
	
	public String retornaUserLogin(ActionEvent event) {
		return userLogin.getText();
	}
	public String retornaSenhaLogin(ActionEvent event) {
		return senhaLogin.getText();
	}
	
	public String retornaEmailRegistro(ActionEvent event) {
		return emailRegistro.getText();
	}
	public String retornaUserRegistro(ActionEvent event) {
		return userRegistro.getText();
	}
	public String retornaSenhaRegistro(ActionEvent event) {
		return senhaRegistro.getText();
	}
	
	
	
	
	
	
	
	
//
//    @FXML
//    private ToggleButton login;
//
//    @FXML
//    private ToggleGroup login_registro;
//
//    @FXML
//    private ToggleButton registro;
//
//    @FXML
//    private ToggleButton tor;
//    
//    @FXML
//    private Button botaoEnviar;
//
//    @FXML
//    void escolhaDaTelaInicial(ActionEvent event) {
//    	if(event.getSource()==login) {
//    		botaoEnviar.setText("LOGIN");
//    		if(event.getSource()==botaoEnviar) {
//    			//aqui garante que o usuario e a senha conferem com algum user do arquivo e retorna o boolean 'aprovado'
//    			geraAlerta("login",true);
//    		}
//    	}
//    	if(event.getSource()==registro) {
//    		botaoEnviar.setText("REGISTRAR-SE");
//    		if(event.getSource()==botaoEnviar) {
//    			//aqui garante que o usuario e a senha conferem com algum user do arquivo e retorna o boolean 'aprovado'
//    			geraAlerta("registro",true);
//    		}
//    	}
//    	
//    	
//    	
//    	
//    	
//    }
//    public void geraAlerta(String evento, boolean aprovado) {
//    	Alert alerta = new Alert(aprovado ? Alert.AlertType.INFORMATION : Alert.AlertType.ERROR);
//    	switch(evento){
//	    	case "login":
//	    		if(aprovado) {
//	    			//Alert alerta = new Alert(Alert.AlertType.INFORMATION);
//	    			alerta.setTitle("LOGIN");
//	    			alerta.setContentText("LOGIN permitido!\nSeja bem vindo!");
//	    			//alerta.show();
//	    			break;
//	    		}else {
//	    			//Alert alerta = new Alert(Alert.AlertType.ERROR);
//	    			alerta.setTitle("LOGIN");
//	    			alerta.setContentText("LOGIN negado!\nUsuário ou senha inválido(s)!");
//	    			//alerta.show();
//	    			break;
//	    		}
//	    	case "registro":
//	    		//Alert alerta = new Alert(Alert.AlertType.INFORMATION);
//    			alerta.setTitle("REGISTRO DE NOVO USUÁRIO");
//    			alerta.setContentText("REGISTRO concluído!\nSeja bem vindo!");
//    			//alerta.show();
//    			break;
//    	}
//    	alerta.show();
//
//    }
//	
//public static void main(String[] args) {
//	Application.launch(Controlador.class, args);
//}
}
