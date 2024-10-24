package entidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class FilmeCSV {
	private static String caminhoArquivo = "./dados/Filmes.csv";

	
	public void adicionaFilme(Filme filme) {
		try {
			//Verifica se o arquivo existe depois de declarar um File
			File arquivo = new File(caminhoArquivo);
			boolean existe = arquivo.exists();
			
			//Abrir o escritor --> esse charset permite escrever com caracteres do português
			FileWriter escritor = new FileWriter(caminhoArquivo, StandardCharsets.ISO_8859_1, existe);
			if(!existe) {
				escritor.write("FILME_ID;NOME;GENERO;DIRETOR;ANO_LANCAMENTO;ATOR1;ATOR2;ATOR3\n");
			}
			
			//Escrevendo os dados do filme 
			escritor.write(filme.getIDFilme()+";"+filme.getNomeFilme()+";"+filme.getGeneroFilme()+";"+filme.getDiretor().getNomeDiretor()+";"+filme.getAnoLancamento()+";"+filme.getAtor1().getNomeAtor()+";"+filme.getAtor2().getNomeAtor()+";"+filme.getAtor3().getNomeAtor()+"\n");
			
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

	//metodo para ler e imprimir algo dentro do arquivo CSV
	public void  imprimirFilme(int IDFilme){
		int colunaDoIDDoFilme = 0;
		
		try {
			//Abrindo o LEITOR
			BufferedReader leitor = new BufferedReader(new FileReader(caminhoArquivo));
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
				if(Integer.parseInt(partesDaLinha[colunaDoIDDoFilme])==IDFilme) {//torna o string IDFilme no CSV um inteiro para poder comparar com o id de parâmetro
					String nomeFilme = partesDaLinha[1];
					String genero = partesDaLinha[2];
					String nomeDiretor = partesDaLinha[3];
					int anoLancamento = Integer.parseInt(partesDaLinha[4]);
					String nomeAtor1 = partesDaLinha[5];
					String nomeAtor2 = partesDaLinha[6];
					String nomeAtor3 = partesDaLinha[7];
					
					//print do filme em questão
					System.out.println("Filme: "+nomeFilme+" -- Genero: "+genero+" -- Diretor: "+nomeDiretor+" -- Ano de lancamento: "+anoLancamento+" -- Atores principais: "+nomeAtor1+", "+nomeAtor2+" e "+nomeAtor3);
					break;
				}
			   
			}
			leitor.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}

