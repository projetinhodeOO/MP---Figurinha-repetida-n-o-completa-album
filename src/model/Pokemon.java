package model;

public class Pokemon extends Figurinha {
	public String tipo;
	
	public Pokemon(String nome, String raridade, String tipo) {
		super(nome, raridade);
		this.tipo = tipo;
	}
	
	public Pokemon() {
		super();
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String toString() {
		return "Nome: " + nome + "\nRaridade: " + raridade + "\nTipo: " + tipo;
	}
}
