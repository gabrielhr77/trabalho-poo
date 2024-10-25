package entidades;

import java.util.ArrayList;
import java.time.LocalDate;

public class Diretor {
	private int _IDDiretor;
	private String nomeDiretor;
	private LocalDate dataNascimentoDiretor;
	private ArrayList<Filme> filmesDirigidos;
	
	public Diretor(int _IDDiretor, String nomeDiretor, LocalDate dataNascimentoDiretor){
		this._IDDiretor=_IDDiretor;
		this.nomeDiretor=nomeDiretor;
		this.dataNascimentoDiretor=dataNascimentoDiretor;
		this.filmesDirigidos = new ArrayList<>();
	}
	
	
	
	
//	métodos getters
	public int getIDDiretor() {
		return _IDDiretor;
	}
	public String getNomeDiretor() {
		return nomeDiretor;
	}
	public LocalDate getDataNascimentoDiretor() {
		return dataNascimentoDiretor;
	}
	public ArrayList<Filme> getFilmesDirigidos() {
		return filmesDirigidos;
	}
	
//	métodos setters
	public void setIDDiretor(int _IDDiretor) {
		this._IDDiretor=_IDDiretor;
	}
	public void setNomeDiretor(String nomeDiretor) {
		this.nomeDiretor=nomeDiretor;
	}
	public void setdataNascimentoDiretor(LocalDate dataNascimentoDiretor) {
		this.dataNascimentoDiretor=dataNascimentoDiretor;
	}
	public void adicionarFilmeDirigido(ArrayList<Filme> todosFilmes, Filme filmeADD) {
		filmesDirigidos.add(filmeADD);
	}
	private int buscarFilmeDoDiretor(String nomeFilme) {//RETORNA A POSICAO DO FILME NO ARRAY DOS FILMES DO DIRETOR		
		for (int i=0;i<filmesDirigidos.size();i++) {
            if (filmesDirigidos.get(i).getNomeFilme() == nomeFilme) {
                return i;
            }
        }
        System.out.println("Nome de filme inválido!"); // Retorna -1 se o aluno não for encontrado
        return -1;
        }
    }
	


