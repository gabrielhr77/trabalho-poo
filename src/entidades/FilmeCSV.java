package entidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;



//IMPORTANTE************************************************************************************

//LEMBRANDO QUE OS MÉTODOS DE LER O ARQUIVO NÃO TERÃO A PARTE DE ABRIR O ARQUIVO COM OS FILMES, MAS SIM USARÃO O ARQUIVO JÁ ABERTO NA INICIALIZAÇÃO DO PROGRAMA
//NAO NECESSARIAMENTE TEREMOS COMO PARAMETRO DOS METODOS DE ADD E REMOVER FILME O ID DELE, É SÓ UMA SIMPLIFICAÇÃO
//FAZER COM QUE O ARQUIVO CONTENHA O OBJETO EM SI COMO DADO NA AULA DE ARQUIVOS

//IMPORTANTE************************************************************************************


public class FilmeCSV {
	ArrayList<Filme> todosOsFilmes = new ArrayList<>();
	
	
	
	private static String caminhoArquivo = "./dados/Filmes.csv";

	
//	public void adicionaFilme(Filme filme) {
//		try {
//			//Verifica se o arquivo existe depois de declarar um File
//			File arquivo = new File(caminhoArquivo);
//			boolean existe = arquivo.exists();
//			
//			//Abrir o escritor --> esse charset permite escrever com caracteres do português
//			FileWriter escritor = new FileWriter(caminhoArquivo, StandardCharsets.ISO_8859_1, existe);
//			if(!existe) {
//				escritor.write("FILME_ID;FILME_NOME;GENERO;ANO_LANCAMENTO;DIRETOR_ID;DIRETOR_NOME;DIR_DATA_NASC;ATOR1_ID;ATOR1_NOME;ATOR1_DATA_NASC;ATOR2_ID;ATOR2_NOME;ATOR2_DATA_NASC;ATOR3_ID;ATOR3_NOME;ATOR3_DATA_NASC\n");
//			}
//			
//			//Escrevendo os dados do filme 
//			escritor.write(filme.getIDFilme()+";"+filme.getNomeFilme()+";"+filme.getGeneroFilme()+";"+filme.getAnoLancamento()+";"+filme.getDiretor().getIDDiretor()+";"+filme.getDiretor().getNomeDiretor()+";"+filme.getDiretor().getDataNascimentoDiretor()+";"+filme.getAtor1().getIDAtor()+";"+filme.getAtor1().getNomeAtor()+";"+filme.getAtor1().getDataNascimentoAtor()+";"+filme.getAtor2().getIDAtor()+";"+filme.getAtor2().getNomeAtor()+";"+filme.getAtor2().getDataNascimentoAtor()+";"+filme.getAtor3().getIDAtor()+";"+filme.getAtor3().getNomeAtor()+";"+filme.getAtor3().getDataNascimentoAtor()+"\n");
////			escritor.write(filme.getIDFilme()+";"+filme.getNomeFilme()+";"+filme.getGeneroFilme()+";"+filme.getAnoLancamento()+";"+filme.getDiretor().getNomeDiretor()+";"+filme.getAtor2().getNomeAtor()+";"+filme.getAtor3().getNomeAtor()+"\n");
//			//Escrever todos os dados do buffer do arquivo
//			escritor.flush();
//			
//			//Fecha o escritor
//			escritor.close();
//			
//		
//		} catch(IOException e) {
//			e.printStackTrace();
//		}
//	}
	
	
//	public void removeFilme(int _IDFilme) {
//		try {
//			File arquivo = new File(caminhoArquivo);
//			File arquivoTemporario = new File("./dados/FilmesTemp.csv");
//			boolean existe = arquivoTemporario.exists();
//			FileWriter escritor = new FileWriter(caminhoArquivo, StandardCharsets.ISO_8859_1, existe);
//			if(!existe) {
//				
//				
//				
//				
//			}
//			
//			
//			
//			
//		} catch(IOException e) {
//			e.printStackTrace();
//		}
//	}

	
	
	//metodo para imprimir algo de dentro do arquivo CSV
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
	
	/*
	
	//metodo para copiar algo dentro do arquivo CSV para outro arquivo CSV
	public void  copiaOFilme(int IDFilme, String caminhoArquivoOrigem, String caminhoArquivoDestino){
		int colunaDoIDDoFilme = 0;
		
		try {
			BufferedReader leitor = new BufferedReader(new FileReader(caminhoArquivoOrigem));
			boolean primeiraLinha = true;
			File arquivoCopia = new File(caminhoArquivoDestino);
			boolean existe = arquivoCopia.exists();
			String linha;
			
			FileWriter escritor = new FileWriter(caminhoArquivo, StandardCharsets.ISO_8859_1, existe);
			
			if(!existe) {
				escritor.write("FILME_ID;NOME;GENERO;DIRETOR;ANO_LANCAMENTO;ATOR1;ATOR2;ATOR3\n");
			}
			
			
			while( (linha = leitor.readLine()) != null ) {
				//ignoramos o cabecalho
				if(primeiraLinha) {
					primeiraLinha = false;
					continue;
				}
				
				String[] partesDaLinha = linha.split(";");
				//TENHO QUE PEGAR OS IDS DOS FILMES QUE DEVEM SER COPIADOS, OU SEJA, LISATAR TODOS MENOS AQUELE, OU MESMO FAZER UM CONJUNTO DE IDS DAQUELES QUE NAO DEVEM SER COPIADOS E COLOCAR (!partesDaLinha[colunaDoIDDoFilme])
				if(Integer.parseInt(partesDaLinha[colunaDoIDDoFilme])==IDFilme) {//torna o string IDFilme no CSV um inteiro para poder comparar com o id de parâmetro
					
					String nomeFilme = partesDaLinha[1];
					String genero = partesDaLinha[2];
					String nomeDiretor = partesDaLinha[3];
					int anoLancamento = Integer.parseInt(partesDaLinha[4]);
					String nomeAtor1 = partesDaLinha[5];
					String nomeAtor2 = partesDaLinha[6];
					String nomeAtor3 = partesDaLinha[7];
					
					Diretor diretor = DiretorCSV.retornaDiretor(nomeDiretor);
//					Diretor diretor = retornaDiretor(partesDaLinha[3]);

					//Escrevendo os dados do filme no arquivo cópia
					escritor.write(IDFilme+";"+nomeFilme+";"+genero+";"+diretor+";"+filme.getAnoLancamento()+";"+filme.getAtor1().getNomeAtor()+";"+filme.getAtor2().getNomeAtor()+";"+filme.getAtor3().getNomeAtor()+"\n");
					
					//Escrever todos os dados do buffer do arquivo
					escritor.flush();
					
					//Fecha o escritor
					escritor.close();
					
					//print do filme em questão
					System.out.println("Filme: "+nomeFilme+" -- Genero: "+genero+" -- Diretor: "+nomeDiretor+" -- Ano de lancamento: "+anoLancamento+" -- Atores principais: "+nomeAtor1+", "+nomeAtor2+" e "+nomeAtor3);
					break;
				}
			}
			leitor.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}*/

}



