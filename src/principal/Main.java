package principal;
import entidades.Filme;
import entidades.FilmeCSV;
import entidades.Pessoa;
import entidades.Diretor;
import entidades.AtoresPrincipais;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Filme filme1 = new Filme("22 milhas","acao","laura", 2021, "Mark Wahlberg", "Lauren Cohan", "Iko Uwais");
		FilmeCSV filmeCSV = new FilmeCSV(); 
		filmeCSV.adicionaFilme(filme1);
	
	
	
	
	
	}

	
	
	public static void show(String a) {
		System.out.println(a);
	}
}
