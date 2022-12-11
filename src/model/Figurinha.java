package model;

public abstract class Figurinha {
	protected String nome;
	protected String raridade;
	
	public Figurinha(String nome, String raridade) {
		this.nome = nome;
		this.raridade = raridade;
	}

	public Figurinha() {

	}
	
	public abstract String toString();
	
	public String getNome() {
		return nome;
	}

	public String getRaridade() {
		return raridade;
	}

	public void setRaridade(String raridade) {
		this.raridade = raridade;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
