package principal;

import principal.Main;
import entidades.Ator;
import entidades.Diretor;
import entidades.Filme;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Catalogo {

	ArrayList<Filme> todosOsFilmes = new ArrayList<>();
	ArrayList<Ator> todosOsAtores = new ArrayList<>();
	ArrayList<Diretor> todosOsDiretores = new ArrayList<>();
	
	String caminhoArquivoFilmes = Main.retornaCaminhoArquivo("filme");
	String caminhoArquivoAtor = Main.retornaCaminhoArquivo("ator");
	String caminhoArquivoDiretor = Main.retornaCaminhoArquivo("diretor");
	
	BufferedReader leitor = new BufferedReader(new FileReader(caminhoArquivoFilmes));
	String linha;
	boolean primeiraLinha = true;
	
	while( (linha = leitor.readLine()) != null ) {
		//ignoramos o cabecalho
		if(primeiraLinha) {
			primeiraLinha = false;
			continue;
		}
		//agora pego o ; para separar as frases da linha para achar qual a linha do filme em questão
		String[] partesDaLinha = linha.split(";");
	//pego o arquivo aberto, pego as infos e crio as instancias para colocar nos arrays, tudo isso dentro de um método
	
	public void copiaInfosFilmesParaArray()
	
	
}
