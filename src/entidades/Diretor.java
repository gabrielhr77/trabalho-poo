package entidades;

public class Diretor {
	private String nomeDiretor;
	private int anoNascimentoDiretor;
	private String[] filmesDirigidos;
	
//	métodos getters
	public String getNomeDiretor() {
		return nomeDiretor;
	}
	public int getAnoNascimentoDiretor() {
		return anoNascimentoDiretor;
	}
	public String[] getFilmesDirigidos() {
		return filmesDirigidos;
	}
	
//	métodos setters
	public void setNomeDiretor(String nomeDiretor) {
		this.nomeDiretor=nomeDiretor;
	}
	public void setAnoNascimentoDiretor(int anoNascimentoDiretor) {
		this.anoNascimentoDiretor=anoNascimentoDiretor;
	}
	
	public void setFilmesDirigidos(String[] filmesDirigidos) {
		this.filmesDirigidos=filmesDirigidos;
	}
	

}
