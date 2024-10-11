package entidades;

public class AtoresPrincipais {
	
	private String nomeAtor, nacionalidadeAtor;
	private int anoNascimento;
	
	
	public AtoresPrincipais(String nomeAtor, int anoNascimento, String nacionalidadeAtor) {
		this.nomeAtor=nomeAtor;
		this.anoNascimento=anoNascimento;
		this.nacionalidadeAtor=nacionalidadeAtor;
		
	}
	
	
	// métodos getters
		public String getNomeAtor() {
			return nomeAtor;
		}
		public String getNacionalidadeAtor() {
			return nacionalidadeAtor;
		}
		public int getAnoNascimento() {
			return anoNascimento;
		}
		
		// métodos setters
		
		public void setNomeAtor(String nomeAtor) {
			this.nomeAtor=nomeAtor;
		}
		public void setNacionalidadeAtor(String nacionalidadeAtor) {
			this.nacionalidadeAtor=nacionalidadeAtor;
		}
		public void setAnoNascimento(int anoNascimento) {
			this.anoNascimento=anoNascimento;
		}
	
}
