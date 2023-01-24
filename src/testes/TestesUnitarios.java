package testes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import model.*;
import controllers.ControleAlbumFigurinha;

class TestesUnitarios {
	
	/*
	 * O seguinte teste confere se a funcao para retornar o nome das figurinhas
	 * presentes em determinado album esta funcionando. Foi criado um album e uma
	 * figurinha de teste para conferir.
	 */
	
	@Test
	 void checkListaFigurinha() {
		ControleAlbumFigurinha controle = new ControleAlbumFigurinha();
		Album a1 = new Album();
		a1.setNome("Test");
		a1.setTipo("pokemon");
		a1.setAno(2022);
		a1.setQtd_figurinha_total(199);
		a1.setQtd_figurinha(0);
		
		String fig = controle.listarFigurinhas(a1, 0);
		
		assertEquals("Test", fig);
	}
	
	/*
	 * O seguinte teste confere se a funcao de adicionar figurinha esta funcionando
	 * da forma como deveria.
	 */
	
	@Test
	void checkAddFigurinha() {
		ControleAlbumFigurinha controle = new ControleAlbumFigurinha();
		Album a1 = new Album();
		a1.setNome("Test");
		a1.setTipo("pokemon");
		a1.setAno(2022);
		a1.setQtd_figurinha_total(199);
		
		Pokemon fig = new Pokemon();
		fig.setNome("Test2");
		fig.setRaridade("Test");
		fig.setTipo("Test");
		
		assertTrue(controle.addFigurinha(a1, fig));
	}
	
	/*
	 * O seguinte teste confere se a funcao de deletar figurinha esta funcionando 
	 * da forma como deveria
	 */
	
	@Test
	void checkDeletarFigurinha() {
		ControleAlbumFigurinha controle = new ControleAlbumFigurinha();
		Album a1 = new Album();
		a1.setNome("Test");
		a1.setTipo("pokemon");
		a1.setAno(2022);
		a1.setQtd_figurinha_total(199);
		
		Pokemon figPresente = new Pokemon();
		figPresente.setNome("Test2");
		figPresente.setRaridade("Test");
		figPresente.setTipo("Test");
		
		Pokemon figNaoPresente = new Pokemon();
		figNaoPresente.setNome("Test3");
		figNaoPresente.setRaridade("Test");
		figNaoPresente.setTipo("Test");
		
		assertTrue(controle.deletarFigurinha(a1, figPresente));
		assertFalse(controle.deletarFigurinha(a1, figNaoPresente));
	}
}
