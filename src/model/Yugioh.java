package model;

/**
 * A classe Yugioh eh uma classe de figurinhas do tipo "yugioh". Ela herda da classe abstrata Figurinha
 * todos os seus metodos e atributos, ao mesmo tempo que possui os atributos proprios de um monstro de
 * Yugioh. Os objetos dessa classe entao deverao ficar armazenados em um album do tipo "yugioh".
 * @author Vinicius Eduardo Muniz da Silva
 * @since 2023
 */
public class Yugioh extends Figurinha{
	private String tipo;
	private int atk;
	private int def;
	private int nivel;
	
	public Yugioh(String nome, String raridade, String tipo, int atk, int def, int nivel) {
		super(nome, raridade);
		this.tipo = tipo;
		this.atk = atk;
		this.def = def;
		this.nivel = nivel;	
	}
	
	public Yugioh() {
		super();
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String toString() {
		return "Nome: " + nome + "\nRaridade: " + raridade + "\nTipo: " + tipo + "\nATK: " + atk + "\nDEF: " + def + "\nNivel: " + nivel + "\n";
	}
}
