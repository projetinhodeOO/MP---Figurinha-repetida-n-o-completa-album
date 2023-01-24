package model;

/**
 * Classe abstrata do tipo Figurinha. Possui tres classes filhas: CopaDoMundoQatar,
 * Pokemon e Yugioh.
 * @see CopaDoMundoQatar
 * @see Pokemon
 * @See Yugioh
 * @author Vinicius Eduardo Muniz da Silva
 * @since 2023
 */
public abstract class Figurinha {
	protected String nome;
	protected String raridade;
	
	public Figurinha(String nome, String raridade) {
		this.nome = nome;
		this.raridade = raridade;
	}

	public Figurinha() {

	}
	
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
