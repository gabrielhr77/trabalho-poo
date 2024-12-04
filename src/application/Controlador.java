package application;

import java.util.ArrayList;
import javafx.fxml.Initializable;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import entidadesFilmes.Filme;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import principal. *;
import entidadesUsuarios. *;

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
	private void alertaErroRegistro() {
        Alert alerta = new Alert(AlertType.ERROR);
        alerta.setTitle("Erro");
        alerta.setContentText("Usuário já está sendo utilizado.");
        alerta.showAndWait();
    }
	private void alertaUsuarioNaoExiste() {
        Alert alerta = new Alert(AlertType.ERROR);
        alerta.setTitle("Erro");
        alerta.setContentText("Usuário não existe.");
        alerta.showAndWait();
    }
	public void botaoPaginaInicial(ActionEvent evento) {
		Main.mudarPagina(1);
	}
	
	public void enviarParaVerificacao(ActionEvent event) {
//		Main.mudarPagina(1);
		if(loginRButton.isSelected()) {	
			String nome = retornaUserLogin();
			String senha = retornaSenhaLogin();
//			boolean existente = ManipulacaoDados.verificaLoginESenha(nome,senha);
			if(ManipulacaoDados.verificaLoginESenha(nome,senha)) Main.mudarPagina(1);
			else {
				alertaErroLogin();
//				for(int i=0;i<Main.retornaArrayListUsuarios().size();i++) {
//					System.out.println(Main.retornaArrayListUsuarios().get(i).getNome());
//				}
			}
		}else {
			String nome = retornaUserRegistro();
			String senha = retornaSenhaRegistro();
			boolean existente = ManipulacaoDados.verificaNomeExistente(nome);
			if(existente) alertaErroRegistro();
			else registraNovoUsuario(nome,senha);
			Main.mudarPagina(1);
		}
	}
	
	public void registraNovoUsuario(String nome, String senha) {
		if(ManipulacaoDados.verificaNomeExistente(retornaUserRegistro())) {
			alertaErroRegistro();
		}else {
			Usuario novoUsuario = new Usuario(retornaUserRegistro(),Main.retornaArrayListUsuarios().size()+100,retornaSenhaRegistro(),1);
			Main.retornaArrayListUsuarios().add(novoUsuario);
		}
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
	private Text textoFilmeCarrossel,textoGeneroCarrossel,nomeLista1,nomeLista2,nomeLista3,nomeLista4,nomeL1Filme1,nomeL1Filme2,nomeL1Filme3,nomeL1Filme4,nomeL2Filme1,nomeL2Filme2,nomeL2Filme3,nomeL2Filme4,nomeL3Filme1,nomeL3Filme2,nomeL3Filme3,nomeL3Filme4,nomeL4Filme1,nomeL4Filme2,nomeL4Filme3,nomeL4Filme4;
	
	@FXML
	private ImageView capaFilmeCarrossel,filme1Lista1,filme2Lista1,filme3Lista1,filme4Lista1,filme1Lista2,filme2Lista2,filme3Lista2,filme4Lista2,filme1Lista3,filme2Lista3,filme3Lista3,filme4Lista3,filme1Lista4,filme2Lista4,filme3Lista4,filme4Lista4;
	@FXML
	private ImageView estrela1F1L1,estrela2F1L1,estrela3F1L1,estrela4F1L1,estrela5F1L1,estrela1F2L1,estrela2F2L1,estrela3F2L1,estrela4F2L1,estrela5F2L1,estrela1F3L1,estrela2F3L1,estrela3F3L1,estrela4F3L1,estrela5F3L1,estrela1F4L1,estrela2F4L1,estrela3F4L1,estrela4F4L1,estrela5F4L1;
	@FXML
	private ImageView estrela1F1L2,estrela2F1L2,estrela3F1L2,estrela4F1L2,estrela5F1L2,estrela1F2L2,estrela2F2L2,estrela3F2L2,estrela4F2L2,estrela5F2L2,estrela1F3L2,estrela2F3L2,estrela3F3L2,estrela4F3L2,estrela5F3L2,estrela1F4L2,estrela2F4L2,estrela3F4L2,estrela4F4L2,estrela5F4L2;
	@FXML
	private ImageView estrela1F1L3,estrela2F1L3,estrela3F1L3,estrela4F1L3,estrela5F1L3,estrela1F2L3,estrela2F2L3,estrela3F2L3,estrela4F2L3,estrela5F2L3,estrela1F3L3,estrela2F3L3,estrela3F3L3,estrela4F3L3,estrela5F3L3,estrela1F4L3,estrela2F4L3,estrela3F4L3,estrela4F4L3,estrela5F4L3;
	@FXML
	private ImageView estrela1F1L4,estrela2F1L4,estrela3F1L4,estrela4F1L4,estrela5F1L4,estrela1F2L4,estrela2F2L4,estrela3F2L4,estrela4F2L4,estrela5F2L4,estrela1F3L4,estrela2F3L4,estrela3F3L4,estrela4F3L4,estrela5F3L4,estrela1F4L4,estrela2F4L4,estrela3F4L4,estrela4F4L4,estrela5F4L4;
	
	@FXML
	private Image imagem;
	
	@FXML
	private RadioButton filme1Carrossel,filme2Carrossel,filme3Carrossel,filme4Carrossel,filme5Carrossel;
	
	@FXML
	private Button botaoPassaCarrosselImagens,botaoVoltaCarrosselImagens,botaoProximaPagina,botaoPaginaAnterior,botaoFilme1,botaoFilme2,botaoFilme3,botaoFilme4,botaoFilme5,botaoFilme6,botaoFilme7,botaoFilme8,botaoFilme9,botaoFilme10,botaoFilme11,botaoFilme12,botaoFilme13,botaoFilme14,botaoFilme15,botaoFilme16;
	
	@FXML
	private ChoiceBox<String> opcoesNavegacaoPagInicial, opcoesNavegacaoPerfil, opcoesNavegacaoAddFilme, opcoesNavegacaoAddLista, opcoesNavegacaoRelatorio;
	
	
	
	
	
	
	//tem que ser do tipo não primitivo String pois o método para add os itens só pode adicionar uma collection
	private String[] palavrasOpcoesNavegacaoPagIni = {"PERFIL","ADICIONAR FILME","ADICIONAR LISTA","GERAR RELATÓRIO"};
	private String[] palavrasOpcoesNavegacaoAddFilme = {"PERFIL","ADICIONAR LISTA","GERAR RELATÓRIO"};
	private String[] palavrasOpcoesNavegacaoAddLista = {"PERFIL","ADICIONAR FILME","GERAR RELATÓRIO"};
	private String[] palavrasOpcoesNavegacaoRelatorio = {"ADICIONAR FILME","ADICIONAR LISTA"};
	private String[] palavrasOpcoesNavegacaoPerfil = {"ADICIONAR FILME","ADICIONAR LISTA"};
	
	private int numeroDaPaginaAtual=1;
	private ArrayList<Lista> listasPaginaAtual = Main.retorna4Listas(numeroDaPaginaAtual);
	
	
	
	public void clicouNoBotaoIrParaOFilme(ActionEvent event) {
		 Button botaoClicado = (Button) event.getSource();

	        // Obtém o ID do botão
	        String botaoId = botaoClicado.getId();

	        // Verifica o ID para decidir a ação
	        switch (botaoId) {
	            case "botaoFilme1":
	            	entraNoFilme(0);
	                break;
	            case "botaoFilme2":
	            	entraNoFilme(1); 
	                break;
	            case "botaoFilme3":
	            	entraNoFilme(2); 
	                break;
	            case "botaoFilme4":
	            	entraNoFilme(3); 
	                break;
	            case "botaoFilme5":
	            	entraNoFilme(4);
	                break;
	            case "botaoFilme6":
	            	entraNoFilme(5); 
	                break;
	            case "botaoFilme7":
	            	entraNoFilme(6); 
	                break;
	            case "botaoFilme8":
	            	entraNoFilme(7); 
	                break;
	            case "botaoFilme9":
	            	entraNoFilme(8);
	                break;
	            case "botaoFilme10":
	            	entraNoFilme(9); 
	                break;
	            case "botaoFilme11":
	            	entraNoFilme(10); 
	                break;
	            case "botaoFilme12":
	            	entraNoFilme(11); 
	                break;
	            case "botaoFilme13":
	            	entraNoFilme(12);
	                break;
	            case "botaoFilme14":
	            	entraNoFilme(13); 
	                break;
	            case "botaoFilme15":
	            	entraNoFilme(14); 
	                break;
	            case "botaoFilme16":
	            	entraNoFilme(15); 
	                break;
	            default:
	                System.err.println("Botão desconhecido: " + botaoId);
	        }
	}
	
	
	
	@FXML
	private Text nomeFilme,lancamentoFilme,diretorFilme,ator1Filme,ator2Filme,ator3Filme,horasFilme,minutosFilme,faixaEtariaFilme,sinopseFilme,criticaFilme;
	
	
	
	public void entraNoFilme(int filme) {
		if(filme<4) {	
			listasPaginaAtual.get(0).retornaFilmesDaLista().get(filme);
			Main.mudarPagina(2);
			
		}else if(filme>=4&&filme<8) {
			listasPaginaAtual.get(1).retornaFilmesDaLista().get(filme-4);
		}else if(filme>=8&&filme<12) {
			listasPaginaAtual.get(2).retornaFilmesDaLista().get(filme-8);
		}else if(filme>=12) {
			listasPaginaAtual.get(3).retornaFilmesDaLista().get(filme-12);
		}
	}
	
	public void passaListasDaPaginaInicial(ActionEvent event) {
		numeroDaPaginaAtual++;
		if(Main.retornaArrayListListas().size()%4==0) {
			if(numeroDaPaginaAtual>Main.retornaArrayListListas().size()/4){
				numeroDaPaginaAtual=1;
			}
		}else if(Main.retornaArrayListListas().size()%4!=0) {
			if(numeroDaPaginaAtual>(Main.retornaArrayListListas().size()/4)+1){
				numeroDaPaginaAtual=1;
			}
		}	
		listasPaginaAtual=Main.retorna4Listas(numeroDaPaginaAtual);
		atualizaPaginaPrincipal(listasPaginaAtual);
	}
	
	public void voltaListasDaPaginaInicial(ActionEvent event) {
		numeroDaPaginaAtual--;
		if(numeroDaPaginaAtual<1) {
			if(Main.retornaArrayListListas().size()%4==0) {
				numeroDaPaginaAtual=(Main.retornaArrayListListas().size()/4);
			}else {
				numeroDaPaginaAtual=(Main.retornaArrayListListas().size()/4)+1;
			}
		}
		listasPaginaAtual=Main.retorna4Listas(numeroDaPaginaAtual);
		atualizaPaginaPrincipal(listasPaginaAtual);
	}
	
//	public void entraNaLista
	
	public void atualizaPaginaPrincipal(ArrayList<Lista> arrayDeListas) {
		nomeLista1.setText(listasPaginaAtual.get(0).getNome());
		nomeLista2.setText(listasPaginaAtual.get(1).getNome());
		nomeLista3.setText(listasPaginaAtual.get(2).getNome());
		nomeLista4.setText(listasPaginaAtual.get(3).getNome());
		
		nomeL1Filme1.setText(listasPaginaAtual.get(0).retornaFilmesDaLista().get(0).getNomeFilme());
		nomeL1Filme2.setText(listasPaginaAtual.get(0).retornaFilmesDaLista().get(1).getNomeFilme());
		nomeL1Filme3.setText(listasPaginaAtual.get(0).retornaFilmesDaLista().get(2).getNomeFilme());
		nomeL1Filme4.setText(listasPaginaAtual.get(0).retornaFilmesDaLista().get(3).getNomeFilme());
		
		nomeL2Filme1.setText(listasPaginaAtual.get(1).retornaFilmesDaLista().get(0).getNomeFilme());
		nomeL2Filme2.setText(listasPaginaAtual.get(1).retornaFilmesDaLista().get(1).getNomeFilme());
		nomeL2Filme3.setText(listasPaginaAtual.get(1).retornaFilmesDaLista().get(2).getNomeFilme());
		nomeL2Filme4.setText(listasPaginaAtual.get(1).retornaFilmesDaLista().get(3).getNomeFilme());
		
		nomeL3Filme1.setText(listasPaginaAtual.get(2).retornaFilmesDaLista().get(0).getNomeFilme());
		nomeL3Filme2.setText(listasPaginaAtual.get(2).retornaFilmesDaLista().get(1).getNomeFilme());
		nomeL3Filme3.setText(listasPaginaAtual.get(2).retornaFilmesDaLista().get(2).getNomeFilme());
		nomeL3Filme4.setText(listasPaginaAtual.get(2).retornaFilmesDaLista().get(3).getNomeFilme());
		
		nomeL4Filme1.setText(listasPaginaAtual.get(3).retornaFilmesDaLista().get(0).getNomeFilme());
		nomeL4Filme2.setText(listasPaginaAtual.get(3).retornaFilmesDaLista().get(1).getNomeFilme());
		nomeL4Filme3.setText(listasPaginaAtual.get(3).retornaFilmesDaLista().get(2).getNomeFilme());
		nomeL4Filme4.setText(listasPaginaAtual.get(3).retornaFilmesDaLista().get(3).getNomeFilme());
		
		
	}
	
	public void selecaoNavegacaoPerfil(ActionEvent event) {
		String escolha = opcoesNavegacaoPerfil.getValue();
		switch(escolha) {
			case "PERFIL":
				Main.mudarPagina(3);
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
	
	public void selecaoNavegacaoPagIni(ActionEvent event) {
		String escolha = opcoesNavegacaoPagInicial.getValue();
		switch(escolha) {
			case "PERFIL":
				Main.mudarPagina(3);
				break;
			case "ADICIONAR FILME":
				Main.mudarPagina(4);
				break;
			case "ADICIONAR LISTA":
				Main.mudarPagina(5);
				break;
			case "GERAR RELATÓRIO":
				Main.mudarPagina(6);
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
				Main.mudarPagina(3);
				break;
			case "ADICIONAR LISTA":
				Main.mudarPagina(5);
				break;
			case "GERAR RELATÓRIO":
				Main.mudarPagina(6);
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
				Main.mudarPagina(3);
				break;
			case "ADICIONAR FILME":
				Main.mudarPagina(4);
				break;
			case "GERAR RELATÓRIO":
				Main.mudarPagina(6);
				break;
			default: 
				Main.mudarPagina(1);
				break;
		}
	}
	
	public void selecaoNavegacaoRelatorio(ActionEvent event) {
		String escolha = opcoesNavegacaoRelatorio.getValue();
		switch(escolha) {
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
	    
	    if (opcoesNavegacaoRelatorio != null) {
	        opcoesNavegacaoRelatorio.getItems().addAll(palavrasOpcoesNavegacaoRelatorio);
	        opcoesNavegacaoRelatorio.setOnAction(this::selecaoNavegacaoRelatorio);
	    }
	    
	    if (opcoesNavegacaoPerfil != null) {
	        opcoesNavegacaoPerfil.getItems().addAll(palavrasOpcoesNavegacaoPerfil);
	        opcoesNavegacaoPerfil.setOnAction(this::selecaoNavegacaoPerfil);
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
	

	
	public static void adicionaComentario(Usuario Usuario, Filme Filme, String conteudo, ArrayList<Comentario> comentarios) {
        int id = 2000000 + comentarios.size();
        Comentario comment = new Comentario(id, Usuario, Filme, conteudo);
        comentarios.add(comment);
    }
    
    public static void adicionaCritica(Usuario Usuario, Filme Filme, String titulo, String conteudo, float nota, ArrayList<Critica> criticas) {
        int id = 3000000 + criticas.size();
        Critica review = new Critica(id, Usuario, titulo, conteudo, Filme, nota);
        criticas.add(review);
    }
    
    public static void removeComentario(int id, ArrayList<Comentario> comentarios) {
        int i = buscaComentario(id, comentarios);
        comentarios.remove(i);
    }
    
    public static void removeCritica(int id, ArrayList<Critica> criticas) {
        int i = buscaCritica(id, criticas);
        criticas.remove(i);
    }
    
    public static int buscaComentario(int id, ArrayList<Comentario> comentarios) {
        for(int i=0;i<comentarios.size();i++) {
            if(comentarios.get(i).getID() == id){
                return i;
            }
        }
        return -1;
    }
    
    public static int buscaCritica(int id, ArrayList<Critica> criticas) {
        for(int i=0;i<criticas.size();i++) {
            if(criticas.get(i).getID() == id){
                return i;
            }
        }
        return -1;
    }
    
  //------------------------------PÁGINA DO FILME OU DA LISTA-------------------------------------------------------------------------
    
    
//função para buscar todos os comentários sobre um filme
    public static ArrayList<Comentario> buscaComentariosFilme(int idFilme, ArrayList<Comentario> comentarios){
        ArrayList<Comentario> lista = new ArrayList<>();
        for(int i=0; i<comentarios.size(); i++) {
            if(comentarios.get(i).getFilme().getIDFilme() == idFilme) {
                lista.add(comentarios.get(i));
            }
        }
        return lista;
    }
    
    //função para buscar todas as críticas sobre um filme
    public static ArrayList<Critica> buscaCriticasFilme(int idFilme, ArrayList<Critica> criticas){
        ArrayList<Critica> lista = new ArrayList<>();
        for(int i=0; i<criticas.size(); i++) {
            if(criticas.get(i).getFilme().getIDFilme() == idFilme) {
                lista.add(criticas.get(i));
            }
        }
        return lista;
    }
	//------------------------------ADICIONA FILME OU LISTA-------------------------------------------------------------------------
	
	public Image uploadDeImagem(Stage primaryStage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Selecione uma Imagem");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Imagens Suportadas", "*.png", "*.jpg", "*.jpeg"));

        File file = fileChooser.showOpenDialog(primaryStage);

        if (file != null) {
            try {
                // Retorna uma instância da imagem
                return new Image(file.toURI().toString());
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Erro ao carregar a imagem.");
            }
        }
        return null; // Retorna null se nenhum arquivo foi selecionado
    }
    
	
	
	@FXML
	private Button botaoAdicionarImagens; // Botão associado ao upload

	@FXML
	private ImageView imageView; // Componente para exibir a imagem
	
	@FXML
	private void adicionarImagens() {
		UploadDeImagens uploader = new UploadDeImagens(); // Instância do uploader
	    Stage stage = (Stage) botaoAdicionarImagens.getScene().getWindow(); // Obtém a janela principal

	    Image image = uploader.uploadImage(stage); // Chama o método de upload

	    if (image != null) {
	        imageView.setImage(image); // Define a imagem no ImageView
	    } else {
	        System.out.println("Nenhuma imagem foi selecionada.");
	    }
	}

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
	
	@FXML
	private TextField nomeNovoFilme,anoNovoFilme,diretorNovoFilme,ator1NovoFilme,ator2NovoFilme,ator3NovoFilme,horasNovoFilme,minutosNovoFilme,faixaEtariaNovoFilme;
	
	
	
	public String retornaNomeNovoFilme() {
		return nomeNovoFilme.getText();
	}
	public int retornaAnoNovoFilme() {
		return Integer.parseInt(anoNovoFilme.getText());
	}
	public String retornaAtor1NovoFilme() {
		return ator1NovoFilme.getText();
	}
	public String retornaAtor2NovoFilme() {
		return ator2NovoFilme.getText();
	}
	public String retornaAtor3NovoFilme() {
		return ator3NovoFilme.getText();
	}
	public String retornaDiretorNovoFilme() {
		return diretorNovoFilme.getText();
	}
	public String retornaHorasNovoFilme() {
		return horasNovoFilme.getText();
	}
	public String retornaMinutosNovoFilme() {
		return minutosNovoFilme.getText();
	}
	public int retornafaixaEtariaNovoFilme() {
		return Integer.parseInt(faixaEtariaNovoFilme.getText());
	}
	
	
	
	public void adicionarFilme(ActionEvent event) {
		Filme filme = new Filme(Main.retornaArrayListFilmes().size()+1000,retornaNomeNovoFilme(),retornaDiretorNovoFilme(),retornaAnoNovoFilme(),retornaAtor1NovoFilme(),retornaAtor2NovoFilme(),retornaAtor3NovoFilme(),retornaHorasNovoFilme(),retornaMinutosNovoFilme(),retornafaixaEtariaNovoFilme());
		ManipulacaoDados.adicionaFilme(filme,Main.retornaArrayListFilmes());
	}
	
	
	
	
	//------------------------------RELATÓRIO-------------------------------------------------------------------------

	
	@FXML
	private RadioButton radioUser, radioUsuarios, radioFilmes, radioComentClass;
	@FXML
	private Text pediuPraSerCritico,textoPesquisarUsuario,textoNomeDoUsuario,textoNomesDosFilmes,textoNomesDasListas,nomeUsuario,usuarioEstaSuspenso,ehCritico,quantidadeListas,quantidadeCriticas,quantidadeComentarios;
	@FXML
	private TextField nomeUsuarioPesquisado;
	@FXML
	private VBox listaDasListas,listaDosFilmes;
	
	public void declaraNomesDosFilmes(VBox vbox, ArrayList<Filme> listaDeFilmes) {
		if(listaDeFilmes.size()>0) {
			for(int i=0;i<listaDeFilmes.size();i++) {
				Text texto = (Text) vbox.getChildren().get(i);//força o tipo Node, que é o tipo dos filhos do vbox, para Text para que eu possa usat setText()
				texto.setText(listaDeFilmes.get(i).getNomeFilme());
			}
		}
	}
	public void declaraNomesDasListas(VBox vbox, ArrayList<Lista> listaDeListas) {
		if(listaDeListas.size()>0) {	
			for(int i=0;i<listaDeListas.size();i++) {
				Text texto = (Text) vbox.getChildren().get(i);
				texto.setText(listaDeListas.get(i).getNome());
			}
		}
	}
	public void declaraNomesDosUsuarios(VBox vbox, ArrayList<Usuario> listaDosUsuarios) {
		if(listaDosUsuarios.size()>0) {	
			for(int i=0;i<listaDosUsuarios.size();i++) {
				Text texto = (Text) vbox.getChildren().get(i);
				texto.setText(listaDosUsuarios.get(i).getNome());
			}
			for(int j=listaDosUsuarios.size();j<vbox.getChildren().size();j++) {
				Text texto = (Text) vbox.getChildren().get(j);
				texto.setText("");
			}
		}
	}
	
	//métodos ACTIONEVENT, ou seja, não precisam ser chamados na "main", eles ocorrem quando há "ação" no app
	public void escolhaRelatorio(ActionEvent event) {
		if(radioUsuarios.isSelected()) {
			nomeUsuarioPesquisado.setVisible(false);
			textoNomeDoUsuario.setVisible(false);
			textoPesquisarUsuario.setVisible(false);
			listaDasListas.setVisible(true);
			listaDosFilmes.setVisible(true);
			nomeUsuarioPesquisado.setVisible(false);
			textoNomeDoUsuario.setVisible(false);
			textoPesquisarUsuario.setVisible(false);
			nomeUsuario.setVisible(false);
			quantidadeComentarios.setVisible(false);
			quantidadeCriticas.setVisible(false);
			quantidadeListas.setVisible(false);
			usuarioEstaSuspenso.setVisible(false);
			ehCritico.setVisible(false);
			pediuPraSerCritico.setVisible(false);
			textoNomesDosFilmes.setVisible(true);
			textoNomesDasListas.setVisible(true);
			textoNomesDosFilmes.setText("Nomes dos usuários existentes");
			textoNomesDasListas.setText("Nomes dos usuários existentes");
			if(Main.retornaArrayListUsuarios().size()<70) {
				declaraNomesDosUsuarios(listaDosFilmes,Main.retornaArrayListUsuarios());
			}else {
				ArrayList<Usuario> lista1DosUsuarios = new ArrayList<>();
				ArrayList<Usuario> lista2DosUsuarios = new ArrayList<>();
				for(int j=0;j<70;j++) {
					lista1DosUsuarios.add(Main.retornaArrayListUsuarios().get(j));
				}
				for(int i=70;i<Main.retornaArrayListUsuarios().size();i++) {
					lista2DosUsuarios.add(Main.retornaArrayListUsuarios().get(i));
				}
				declaraNomesDosUsuarios(listaDosFilmes,lista1DosUsuarios);
				declaraNomesDosUsuarios(listaDasListas,lista2DosUsuarios);
			}
		}else if(radioFilmes.isSelected()) {
			nomeUsuarioPesquisado.setVisible(false);
			textoNomeDoUsuario.setVisible(false);
			textoPesquisarUsuario.setVisible(false);
			nomeUsuario.setVisible(false);
			quantidadeComentarios.setVisible(false);
			quantidadeCriticas.setVisible(false);
			quantidadeListas.setVisible(false);
			usuarioEstaSuspenso.setVisible(false);
			ehCritico.setVisible(false);
			pediuPraSerCritico.setVisible(false);
			listaDasListas.setVisible(true);
			listaDosFilmes.setVisible(true);
			textoNomesDosFilmes.setVisible(true);
			textoNomesDasListas.setVisible(true);
			textoNomesDosFilmes.setText("Nomes dos filmes existentes");
			textoNomesDasListas.setText("Nomes das listas existentes");
			declaraNomesDosFilmes(listaDosFilmes,Main.retornaArrayListFilmes());
			declaraNomesDasListas(listaDasListas,Main.retornaArrayListListas());
		}else if(radioComentClass.isSelected()) {
			nomeUsuarioPesquisado.setVisible(false);
			textoNomeDoUsuario.setVisible(false);
			textoPesquisarUsuario.setVisible(false);
			nomeUsuario.setVisible(false);
			quantidadeComentarios.setVisible(false);
			quantidadeCriticas.setVisible(false);
			quantidadeListas.setVisible(false);
			usuarioEstaSuspenso.setVisible(false);
			ehCritico.setVisible(false);
			pediuPraSerCritico.setVisible(false);
			textoNomesDosFilmes.setVisible(true);
			textoNomesDasListas.setVisible(true);
			listaDasListas.setVisible(false);
			listaDosFilmes.setVisible(false);
		}else if(radioUser.isSelected()) {
			nomeUsuarioPesquisado.setVisible(true);
			textoNomeDoUsuario.setVisible(true);
			textoPesquisarUsuario.setVisible(true);
			nomeUsuario.setVisible(true);
			quantidadeComentarios.setVisible(true);
			quantidadeCriticas.setVisible(true);
			quantidadeListas.setVisible(true);
			usuarioEstaSuspenso.setVisible(true);
			ehCritico.setVisible(true);
			pediuPraSerCritico.setVisible(true);
			textoNomesDosFilmes.setVisible(false);
			textoNomesDasListas.setVisible(false);
			listaDasListas.setVisible(false);
			listaDosFilmes.setVisible(false);
		}
	}
	
	public void geraRelatorioUsuarioEspecifico(ActionEvent event) {
		if(ManipulacaoDados.buscaUsuarioPorNome(nomeUsuarioPesquisado.getText())!=null) {	
			Usuario usuarioPesquisado = ManipulacaoDados.buscaUsuarioPorNome(nomeUsuarioPesquisado.getText());
			if(usuarioPesquisado.pediuParaSerCritico) pediuPraSerCritico.setText("SIM");
			else pediuPraSerCritico.setText("NÃO");
			nomeUsuario.setText(usuarioPesquisado.getNome());
			quantidadeComentarios.setText(String.valueOf(usuarioPesquisado.quantidadeComentarios));
			quantidadeCriticas.setText(String.valueOf(usuarioPesquisado.getQuantidadeCriticas()));
			quantidadeListas.setText(String.valueOf(usuarioPesquisado.getQuantidadeListas()));
			if(usuarioPesquisado.isSuspenso()) usuarioEstaSuspenso.setText("SIM");
			else usuarioEstaSuspenso.setText("NÃO");
			if(usuarioPesquisado.isCritico()) ehCritico.setText("SIM");
			else ehCritico.setText("NÃO");
			if(usuarioPesquisado.pediuParaSerCritico) pediuPraSerCritico.setText("SIM");
			else pediuPraSerCritico.setText("NÃO");
		}else alertaUsuarioNaoExiste();
	}

	public void deletarUsuario(ActionEvent event) {
		Main.retornaArrayListUsuarios().remove(ManipulacaoDados.buscaUsuarioPorNome(nomeUsuario.getText()));
	}
	
	public void tornarCritico(ActionEvent event) {
		ManipulacaoDados.buscaUsuarioPorNome(nomeUsuario.getText()).setCritico();
	}
	
	public void suspenderUsuario(ActionEvent event) {
		ManipulacaoDados.buscaUsuarioPorNome(nomeUsuario.getText()).suspender(true);
	}
	
	public void liberarUsuario(ActionEvent event) {
		ManipulacaoDados.buscaUsuarioPorNome(nomeUsuario.getText()).suspender(false);
	}
	
	
	
	
	
}
