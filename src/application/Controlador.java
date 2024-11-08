package application;

import java.util.ArrayList;
import javafx.fxml.Initializable;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class Controlador/* implements Initializable*/ {
	//LOGIN
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
	
	
	/*
	
	//PAGINA INICIAL
	@FXML
	private Text textoFilmeCarrossel,textoGeneroCarrossel;
	
	@FXML
	private ImageView capaFilmeCarrossel;
	
	@FXML
	private Image imagem;
	
	@FXML
	private RadioButton filme1Carrossel,filme2Carrossel,filme3Carrossel,filme4Carrossel,filme5Carrossel;
	
	@FXML
	private Button botaoPassaCarrosselImagens, botaoVoltaCarrosselImagens;	
	
	
	//criando um arraylist com as imagens do carrossel
	private ArrayList<Image> imagens = new ArrayList<>();
	private int indiceCarrossel = 0;
	
	//precisa ter esse nome pois é uma função da interface INITIALIZABLE, a qual nos obriga a ter essa função "initialize"
	//PQ USAR INITIALIZABLE? pq ela permite que, quando o FXML é executado, automaticamente o que a gente quiser de métodos
	//será iniciado em primeiro lugar, evitando os erros que eu tava enfrentando para iniciar o carrossel
	public void initialize(URL location, ResourceBundle resources) {
        iniciaCarrossel(); // Inicia o carrossel ao carregar a interface
        atualizaCarrossel(); // Exibe a primeira imagem e texto do carrossel
    }
	
	public void iniciaCarrossel() {

		InputStream inputStream1 = getClass().getResourceAsStream("/application/imagens/posterInterestelar.jpg");
		if (inputStream1 == null) {
		    System.out.println("Erro: o arquivo 1 de imagem não foi encontrado!");
		} else {
		    imagens.add(new Image(inputStream1));
		}
		InputStream inputStream2 = getClass().getResourceAsStream("/application/imagens/posterAlienRomulus.jpg");
		if (inputStream2 == null) {
		    System.out.println("Erro: o arquivo 2 de imagem não foi encontrado!");
		} else {
		    imagens.add(new Image(inputStream2));
		}
		InputStream inputStream3 = getClass().getResourceAsStream("/application/imagens/posterMIAcertoContas.jpg");
		if (inputStream3 == null) {
		    System.out.println("Erro: o arquivo 3 de imagem não foi encontrado!");
		} else {
		    imagens.add(new Image(inputStream3));
		}
		InputStream inputStream4 = getClass().getResourceAsStream("/application/imagens/posterItACoisa.jpg");
		if (inputStream4 == null) {
		    System.out.println("Erro: o arquivo 3 de imagem não foi encontrado!");
		} else {
		    imagens.add(new Image(inputStream4));
		}
		InputStream inputStream5 = getClass().getResourceAsStream("/application/imagens/posterSilencioDosInocentes.jpg");
		if (inputStream5 == null) {
		    System.out.println("Erro: o arquivo 3 de imagem não foi encontrado!");
		} else {
		    imagens.add(new Image(inputStream5));
		}
		
	}

	public void filmeRelativoAoRadioButton(ActionEvent event) {
		if(filme1Carrossel.isSelected()) {
			indiceCarrossel=0;
			atualizaCarrossel();
		}else if(filme2Carrossel.isSelected()) {
			indiceCarrossel=1;
			atualizaCarrossel();
		}else if(filme3Carrossel.isSelected()) {
			indiceCarrossel=2;
			atualizaCarrossel();
		}else if(filme4Carrossel.isSelected()) {
			indiceCarrossel=3;
			atualizaCarrossel();
		}else if(filme5Carrossel.isSelected()) {
			indiceCarrossel=4;
			atualizaCarrossel();
		}
	}
	
	public void passaFilmeCarrossel(ActionEvent envent) {
		indiceCarrossel = (indiceCarrossel+1)%imagens.size();
		atualizaCarrossel();
	}
	
	public void voltaFilmeCarrossel(ActionEvent envent) {
		indiceCarrossel = (indiceCarrossel-1);
		if(indiceCarrossel==-1) indiceCarrossel = imagens.size()-1;
		atualizaCarrossel();
	}
	
	public void atualizaCarrossel() {
		switch(indiceCarrossel) {
			case 0:
				capaFilmeCarrossel.setImage(imagens.get(0));
				textoFilmeCarrossel.setText("Interestelar");
				textoGeneroCarrossel.setText("FICÇÃO CIENTÍFICA - DRAMA");
				filme1Carrossel.setSelected(true);
				filme2Carrossel.setSelected(false);
				filme3Carrossel.setSelected(false);
				filme4Carrossel.setSelected(false);
				filme5Carrossel.setSelected(false);
				break;
			case 1:
				capaFilmeCarrossel.setImage(imagens.get(1));
				textoFilmeCarrossel.setText("Alien Romulus");
				textoGeneroCarrossel.setText("TERROR - FICÇÃO CIENTÍFICA");
				filme1Carrossel.setSelected(false);
				filme2Carrossel.setSelected(true);
				filme3Carrossel.setSelected(false);
				filme4Carrossel.setSelected(false);
				filme5Carrossel.setSelected(false);
				break;
			case 2:
				capaFilmeCarrossel.setImage(imagens.get(2));
				textoFilmeCarrossel.setText("Missão: Impossível 7");
				textoGeneroCarrossel.setText("AÇÃO - ESPIONAGEM");
				filme1Carrossel.setSelected(false);
				filme2Carrossel.setSelected(false);
				filme3Carrossel.setSelected(true);
				filme4Carrossel.setSelected(false);
				filme5Carrossel.setSelected(false);
				break;
			case 3:
				capaFilmeCarrossel.setImage(imagens.get(3));
				textoFilmeCarrossel.setText("It: A Coisa");
				textoGeneroCarrossel.setText("SUSPENSE - RETRÔ");
				filme1Carrossel.setSelected(false);
				filme2Carrossel.setSelected(false);
				filme3Carrossel.setSelected(false);
				filme4Carrossel.setSelected(true);
				filme5Carrossel.setSelected(false);
				break;
			case 4:
				capaFilmeCarrossel.setImage(imagens.get(4));
				textoFilmeCarrossel.setText("O silêncio dos inocentes");
				textoGeneroCarrossel.setText("SUSPENSE - TERROR");
				filme1Carrossel.setSelected(false);
				filme2Carrossel.setSelected(false);
				filme3Carrossel.setSelected(false);
				filme4Carrossel.setSelected(false);
				filme5Carrossel.setSelected(true);
				break;
		}
	}
	

	
	
	
	*/
	
	
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
