package application;

import java.util.ArrayList;
import javafx.fxml.Initializable;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import principal. *;

public class Controlador implements Initializable {
	
	
	//------------------------------LOGIN-------------------------------------------------------------------------
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
	

	private void alertaErroLogin() {
        
        Alert alerta = new Alert(AlertType.ERROR);
        alerta.setTitle("Erro");
      
        alerta.setContentText("Usuário e/ou senha incorretos\nVerifique se suas credenciais foram digitadas corretamente.");
        
        alerta.showAndWait();
    }

	public void botaoPaginaInicial(ActionEvent evento) {
		Main.mudarPagina(1);
	}

	
	public void enviarParaVerificacao(ActionEvent event) {
		Main.mudarPagina(1);
//		String nome = retornaUserLogin();
//		String senha = retornaSenhaLogin();
//		boolean existente = ManipulacaoDados.verificaLoginESenha(nome,senha);
//		if(existente) Main.mudarPagina(1);
//		else alertaErroLogin();		
	}
	

	
	public String retornaUserLogin() {
		return userLogin.getText();
	}
	public String retornaSenhaLogin() {
		return senhaLogin.getText();
	}
	
	public String retornaEmailRegistro() {
		return emailRegistro.getText();
	}
	public String retornaUserRegistro() {
		return userRegistro.getText();
	}
	public String retornaSenhaRegistro() {
		return senhaRegistro.getText();
	}
	
	
	
	
	//------------------------------PAGINA INICIAL-------------------------------------------------------------------------

	@FXML
	private Text textoFilmeCarrossel,textoGeneroCarrossel;
	
	@FXML
	private ImageView capaFilmeCarrossel,filme1Lista1,filme2Lista1,filme3Lista1,filme4Lista1,filme1Lista2,filme2Lista2,filme3Lista2,filme4Lista2,filme1Lista3,filme2Lista3,filme3Lista3,filme4Lista3,filme1Lista4,filme2Lista4,filme3Lista4,filme4Lista4;
	
	@FXML
	private Image imagem;
	
	@FXML
	private RadioButton filme1Carrossel,filme2Carrossel,filme3Carrossel,filme4Carrossel,filme5Carrossel;
	
	@FXML
	private Button botaoPassaCarrosselImagens,botaoVoltaCarrosselImagens,botaoProximaPagina,botaoPaginaAnterior;
	
	@FXML
	private ChoiceBox<String> opcoesNavegacaoPagInicial, opcoesNavegacaoAddFilme, opcoesNavegacaoAddLista;
	//tem que ser do tipo não primitivo String pois o método para add os itens só pode adicionar uma collection
	private String[] palavrasOpcoesNavegacaoPagIni = {"PERFIL","ADICIONAR FILME","ADICIONAR LISTA"};
	private String[] palavrasOpcoesNavegacaoAddFilme = {"PERFIL","ADICIONAR LISTA"};
	private String[] palavrasOpcoesNavegacaoAddLista = {"PERFIL","ADICIONAR FILME"};
	
	
	private int numeroDaPaginaAtual=0;
	public void passaListasDaPaginaInicial(ActionEvent event) {
		
	}
	public void voltaListasDaPaginaInicial(ActionEvent event) {
		
	}
	
	public void selecaoNavegacaoPagIni(ActionEvent event) {
		String escolha = opcoesNavegacaoPagInicial.getValue();
		switch(escolha) {
			case "PERFIL":
				Main.mudarPagina(0);
				break;
			case "ADICIONAR FILME":
				Main.mudarPagina(4);
				break;
			case "ADICIONAR LISTA":
				Main.mudarPagina(5);
				break;
			default: 
				Main.mudarPagina(1);
				break;
		}
	}
	public void selecaoNavegacaoAddFilme(ActionEvent event) {
		String escolha = opcoesNavegacaoAddFilme.getValue();
		switch(escolha) {
			case "PERFIL":
				Main.mudarPagina(0);
				break;
			case "ADICIONAR LISTA":
				Main.mudarPagina(5);
				break;
			default: 
				Main.mudarPagina(1);
				break;
		}
	}
	public void selecaoNavegacaoAddLista(ActionEvent event) {
		String escolha = opcoesNavegacaoAddLista.getValue();
		switch(escolha) {
			case "PERFIL":
				Main.mudarPagina(0);
				break;
			case "ADICIONAR FILME":
				Main.mudarPagina(4);
				break;
			default: 
				Main.mudarPagina(1);
				break;
		}
	}
	
	public void botaoPerfil(ActionEvent event) {
		Main.mudarPagina(0);
	}
	public void botaoFilme(ActionEvent event) {
		Main.mudarPagina(4);
	}
	public void botaoLista(ActionEvent event) {
		Main.mudarPagina(5);
	}
	
	
	//criando um arraylist com as imagens do carrossel
	private ArrayList<Image> imagens = new ArrayList<>();
	private int indiceCarrossel = 0;
	
	//precisa ter esse nome pois é uma função da interface INITIALIZABLE, a qual nos obriga a ter essa função "initialize"
	//PQ USAR INITIALIZABLE? pq ela permite que, quando o FXML é executado, automaticamente o que a gente quiser de métodos
	//será iniciado em primeiro lugar, evitando os erros que eu tava enfrentando para iniciar o carrossel
//	public void initialize(URL location, ResourceBundle resources) {
//        iniciaCarrossel(); // Inicia o carrossel ao carregar a interface
//        atualizaCarrossel(); // Exibe a primeira imagem e texto do carrossel
//    }
//	
	
	
//	public void initialize(URL location, ResourceBundle resources) {
//	    if (capaFilmeCarrossel != null) {
//	        iniciaCarrossel(); // Inicia o carrossel ao carregar a interface
//	        atualizaCarrossel(); // Exibe a primeira imagem e texto do carrossel
//	        opcoesNavegacaoPagInicial.getItems().addAll(palavrasOpcoesNavegacaoPagIni);
//	        opcoesNavegacaoPagInicial.setOnAction(this::selecaoNavegacaoPagIni);
//	        opcoesNavegacaoAddFilme.getItems().addAll(palavrasOpcoesNavegacaoAddFilme);
//	        opcoesNavegacaoAddFilme.setOnAction(this::selecaoNavegacaoAddFilme);
//	        opcoesNavegacaoAddLista.getItems().addAll(palavrasOpcoesNavegacaoAddLista);
//	        opcoesNavegacaoAddLista.setOnAction(this::selecaoNavegacaoAddLista);
//	    }
//	}
	public void initialize(URL location, ResourceBundle resources) {
	    if (capaFilmeCarrossel != null) {
	        iniciaCarrossel(); // Inicia o carrossel ao carregar a interface
	        atualizaCarrossel(); // Exibe a primeira imagem e texto do carrossel
	    }

	    if (opcoesNavegacaoPagInicial != null) {
	        opcoesNavegacaoPagInicial.getItems().addAll(palavrasOpcoesNavegacaoPagIni);
	        opcoesNavegacaoPagInicial.setOnAction(this::selecaoNavegacaoPagIni);
	    }

	    if (opcoesNavegacaoAddFilme != null) {
	        opcoesNavegacaoAddFilme.getItems().addAll(palavrasOpcoesNavegacaoAddFilme);
	        opcoesNavegacaoAddFilme.setOnAction(this::selecaoNavegacaoAddFilme);
	    }

	    if (opcoesNavegacaoAddLista != null) {
	        opcoesNavegacaoAddLista.getItems().addAll(palavrasOpcoesNavegacaoAddLista);
	        opcoesNavegacaoAddLista.setOnAction(this::selecaoNavegacaoAddLista);
	    }
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
	

	
	
	//------------------------------ADICIONA FILME OU LISTA-------------------------------------------------------------------------
	
	
	
	
	
	
	
	
	public static void selecionaArquivo() {
		FileChooser arqSelecionado = new FileChooser();
		
		arqSelecionado.setTitle("Selecione uma imagem");
		arqSelecionado.getExtensionFilters().add(new FileChooser.ExtensionFilter("Arquivos JPG", "*.jpg"));
		arqSelecionado.getExtensionFilters().add(new FileChooser.ExtensionFilter("Arquivos PNG", "*.png"));
		
		java.io.File arquivoCerto = arqSelecionado.showOpenDialog(Main.retornaStage());
		
		if(arquivoCerto!=null) {
			System.out.println("Arquivo selecionado: " + arquivoCerto.getAbsolutePath());
		}
		
	}
	
	

}
