
package entidades;

import java.time.LocalDate;

public class Ator {
	
	private String nomeAtor;
	private int _IDAtor;
	private LocalDate dataNascimentoAtor;
//	private boolean copiado;
	
	
	public Ator(int _IDAtor, String nomeAtor, LocalDate dataNascimentoAtor) {
		this._IDAtor=_IDAtor;
		this.nomeAtor=nomeAtor;
		this.dataNascimentoAtor=dataNascimentoAtor;	
//		copiado = false;
	}
	
	
	// métodos getters
	public int getIDAtor() {
		return _IDAtor;
	}
	public String getNomeAtor() {
		return nomeAtor;
	}
	public LocalDate getDataNascimentoAtor() {
		return dataNascimentoAtor;
	}
//	public boolean getCopiado() {
//		return copiado;
//	}
	// métodos setters
	public void setIDAtor(int _IDAtor) {
		this._IDAtor=_IDAtor;
	}
	public void setNomeAtor(String nomeAtor) {
		this.nomeAtor=nomeAtor;
	}
	public void setDataNascimentoAtor(LocalDate dataNascimentoAtor) {
		this.dataNascimentoAtor=dataNascimentoAtor;
	}
//	public void setCopiado(boolean copiado) {
//		this.copiado=copiado;
//	}
}

