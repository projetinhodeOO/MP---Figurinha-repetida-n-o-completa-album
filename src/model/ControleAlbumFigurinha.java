package model;

public class ControleAlbumFigurinha {
	private Album[] albuns;
	private int qtd_albuns;
	
	public ControleAlbumFigurinha() {
		qtd_albuns = 0;
		
		albuns = new Album[10];
	}
	
	public boolean addAlbum(Album a) {
		if(qtd_albuns < 10) {	
			albuns[qtd_albuns] = a;
			qtd_albuns++;
			return true;
		} else {
			return false;
		}
	}
	
	public void apagarAlbum(String nome) {
		int confere = 0;
		
		for(int i = 0; i < qtd_albuns; i++) {
			if(albuns[i].getNome() == nome) {
				confere = 1;
			}
			if(confere == 1 && i != qtd_albuns-1) {
				albuns[i] = albuns[i+1];
			}
		}
		qtd_albuns--;
	}
	
	public String listarAlbuns() {
		if(qtd_albuns == 0) {
			return "Não há Albuns cadastradas nesse album";
		} else {
			String lista = albuns[0].getNome();
			for(int i = 1; i < qtd_albuns; i++) {
				lista = lista + "\n" + albuns[i].getNome();
			}
		
			return "Albuns:\n" + lista;
		}
	}
}
