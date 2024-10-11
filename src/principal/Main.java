package principal;
import entidades.Filme;
import entidades.FilmeCSV;
import entidades.Pessoa;
import entidades.Diretor;
import entidades.Ator;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		LocalDate dateAtor1 = LocalDate.of(1971,6,5);
		Ator ator1 = new Ator(60001,"Mark Wahlberg",dateAtor1);
		LocalDate dateAtor2 = LocalDate.of(1982,1,7);
		Ator ator2 = new Ator(60002,"Lauren Cohan",dateAtor2);
		LocalDate dateAtor3 = LocalDate.of(1983,2,12);
		Ator ator3 = new Ator(60003,"Iko Uwais",dateAtor3);
//		 Filme(int, String, String, String, int, Ator, Ator, Ator) is undefined
		LocalDate dateDiretor1 = LocalDate.of(1964,3,11);
		Diretor Peter_Berg = new Diretor(50001,"Peter Berg", dateDiretor1);
		Filme filme1 = new Filme(20001,"22 milhas","acao",Peter_Berg ,2021, ator1, ator2, ator3);
		FilmeCSV filmeCSV = new FilmeCSV(); 
		filmeCSV.adicionaFilme(filme1);
		System.out.println(filme1.getIDFilme());
		System.out.println(filme1.getNomeFilme());
		System.out.println(filme1.getGeneroFilme());
		System.out.println(filme1.getDiretor().getNomeDiretor());
		System.out.println(filme1.getAnoLancamento());
		System.out.println(filme1.getAtor1().getNomeAtor()+", "+filme1.getAtor1().getDataNascimentoAtor());
		System.out.println(filme1.getAtor2().getNomeAtor()+", "+filme1.getAtor2().getDataNascimentoAtor());
		System.out.println(filme1.getAtor3().getNomeAtor()+", "+filme1.getAtor3().getDataNascimentoAtor());
	
	
	
	}

	
	
	public static void show(String a) {
		System.out.println(a);
	}
}
