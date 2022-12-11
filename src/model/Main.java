package model;

public class Main {

	public static void main(String[] args) {
		
		Album a1 = new Album();
		a1.setNome("Copa do Mundo");
		a1.setAno(2022);
		a1.setQtd_figurinha_total(10);
		
		CopaDoMundoQatar f1 = new CopaDoMundoQatar("Neymar Jr.", "Ultra rara", 1.75, "05/02/1992", "Brasil", 68);
		CopaDoMundoQatar f2 = new CopaDoMundoQatar("Messi", "Ultra rara", 1.69, "24/06/1987", "Argentina", 67);
		CopaDoMundoQatar f3 = new CopaDoMundoQatar("Cristiano Ronaldo", "Ultra Rara", 1.87, "05/02/1985", "Portugal", 85);
		
		a1.addFigurinha(f1);
		a1.addFigurinha(f2);
		a1.addFigurinha(f3);
		
		System.out.println(a1.getFigurinha(0) + "\n");
		
		System.out.println("Quantidade de figurinha: " + a1.getQtd_figurinha());
		System.out.println(a1.listarFigurinhas() + "\n");
		System.out.println(a1.toString() + "\n");
		
		Album a2 = new Album();
		a2.setNome("Pokemon");
		a2.setQtd_figurinha_total(5);
		
		Pokemon f4 = new Pokemon("Articuno", "Lendário", "Gelo/Voador");
		
		a2.addFigurinha(f4);
		
		System.out.println(a2.getFigurinha(0) + "\n");
		System.out.println(a2.listarFigurinhas() + "\n");
		
		Album a3 = new Album();
		a3.setNome("Yu-Gi-Oh!");
		a3.setQtd_figurinha_total(5);
		
		Yugioh f5 = new Yugioh("Stardust Dragon", "Ultra Rara", "Synchro", 2500, 2000, 8);
		
		a3.addFigurinha(f5);
		
		System.out.println(a3.getFigurinha(0));
		System.out.println(a3.listarFigurinhas() + "\n");
		
		ControleAlbumFigurinha controle = new ControleAlbumFigurinha();
		
		controle.addAlbum(a1);
		controle.addAlbum(a2);
		controle.addAlbum(a3);
		
		System.out.println(controle.listarAlbuns());
		
	}

}
