package entidades;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class FilmeCSV {
	private String caminhoArquivo = "./dados/Filmes.csv";

	
	
	
	
	
	public void adicionaFilme(Filme filme) {
		try {
			//Verifica se o arquivo existe depois de declarar um File
			File arquivo = new File(caminhoArquivo);
			boolean existe = arquivo.exists();
			
			//Abrir o escritor --> esse charset permite escrever com caracteres do português
			FileWriter escritor = new FileWriter(caminhoArquivo, StandardCharsets.ISO_8859_1, existe);
			if(!existe) {
				escritor.write("ID_FILME;NOME;GENERO;DIRETOR;ANO_LANCAMENTO;ATOR1;ATOR2;ATOR3\n");
			}
			
			//Escrevendo os dados do filme 
			escritor.write(filme.getNomeFilme()+";"+filme.getGeneroFilme()+";"+filme.getDiretor()+";"+filme.getAnoLancamento()+";"+filme.getAtor1()+";"+filme.getAtor2()+";"+filme.getAtor3()+"\n");
			
			//Escrever todos os dados do buffer do arquivo
			escritor.flush();
			
			//Fecha o escritor
			escritor.close();
			
		
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void removeFilme(int _IDFilme, ArrayList<Filme> array) {
		
	}





	private Object File(String caminhoArquivo2) {
		// TODO Auto-generated method stub
		return null;
	}


}
