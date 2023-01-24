package model;

/**
 * A classe Pokemon eh uma classe de figurinhas do tipo "pokemon". Ela herda da classe abstrata Figurinha
 * todos os seus metodos e atributos, ao mesmo tempo que possui os atributos proprios de um pokemon.
 * Os objetos dessa classe entao deverao ficar armazenados em um album do tipo "pokemon".
 * @author Vinicius Eduardo Muniz da Silva
 * @since 2023
 */
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
