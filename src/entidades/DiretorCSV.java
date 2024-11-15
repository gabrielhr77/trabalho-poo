package entidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

public class DiretorCSV {
	private String caminhoArquivo = "./dados/Diretores.csv";

	
	
	
	
	
	public void adicionaDiretor(Diretor diretor) {
		try {
			//Verifica se o arquivo existe depois de declarar um File
			File arquivo = new File(caminhoArquivo);
			boolean existe = arquivo.exists();
			
			//Abrir o escritor --> esse charset permite escrever com caracteres do português
			FileWriter escritor = new FileWriter(caminhoArquivo, StandardCharsets.ISO_8859_1, existe);
			if(!existe) {
				escritor.write("DIRETOR_ID;NOME_DIRETOR;DATA_NASCIMENTO;ONJETO_DIRETOR\n");
			}
			
			//Escrevendo os dados do diretor 
			escritor.write(diretor.getIDDiretor()+";"+diretor.getNomeDiretor()+";"+diretor.getDataNascimentoDiretor()+";"+diretor.getFilmesDirigidos()+";"+diretor+"\n");//esse ultimo é o proprio objeto diretor
			
			//Escrever todos os dados do buffer do arquivo
			escritor.flush();
			
			//Fecha o escritor
			escritor.close();
					
		} catch(IOException e) {
			e.printStackTrace();
		}
	}


//	private Object File(String caminhoArquivo2) {
//		// TODO Auto-generated method stub
//		return null;
//	}


	public static Diretor retornaDiretor(String nomeDiretor) {
		try {
			BufferedReader leitor = new BufferedReader(new FileReader("./dados/Diretores.csv"));
			String linha;
			boolean primeiraLinha = true;
			
			while( (linha = leitor.readLine()) != null ) {
				//ignoramos o cabecalho
				if(primeiraLinha) {
					primeiraLinha = false;
					continue;
				}
				
				String[] partesDaLinha = linha.split(";");
				if (partesDaLinha[1] == nomeDiretor) {
                    // Converte os dados de volta para os tipos adequados
					int IDDiretor = Integer.parseInt(partesDaLinha[0]);
                    LocalDate dataNascimento = LocalDate.parse(partesDaLinha[2]);
                    
                    //VAI RETORNAR UM NOVO OBJETO DIRETOR COM AS CARACTERÍSTICAS EXATAS DO DIRETOR COM TAL ID PASSADO POR PARÂMETRO
                    return new Diretor(IDDiretor, nomeDiretor, dataNascimento);
                }
			}
			leitor.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		return null;//precisa retornar algo senao o método não funcionará
	}



}

