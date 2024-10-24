package entidades;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class AtoresCSV {
	private String caminhoArquivo = "./dados/AtoresPrincipais.csv";

	
	
	
	
	
	public void adicionaDiretor(Ator ator) {
		try {
			//Verifica se o arquivo existe depois de declarar um File
			File arquivo = new File(caminhoArquivo);
			boolean existe = arquivo.exists();
			
			//Abrir o escritor --> esse charset permite escrever com caracteres do português
			FileWriter escritor = new FileWriter(caminhoArquivo, StandardCharsets.ISO_8859_1, existe);
			if(!existe) {
				escritor.write("ID_ATOR;NOME_ATOR;DATA_NASCIMENTO\n");
			}
			
			//Escrevendo os dados do diretor 
			escritor.write(ator.getIDAtor()+";"+ator.getNomeAtor()+";"+ator.getDataNascimentoAtor()+"\n");
			
			//Escrever todos os dados do buffer do arquivo
			escritor.flush();
			
			//Fecha o escritor
			escritor.close();
			
			
			
			
			
			
			
		
		} catch(IOException e) {
			e.printStackTrace();
		}
	}






	private Object File(String caminhoArquivo2) {
		// TODO Auto-generated method stub
		return null;
	}






}
