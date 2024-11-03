package application;

public class Controlador {
	
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
