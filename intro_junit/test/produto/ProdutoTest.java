package produto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProdutoTest {
	
	Produto livro;
	
	@BeforeEach
	public void inicializa() {
		livro = new Produto("Introdução ao Teste de Software", 100.00);
	}
	
	@DisplayName("Teste Criar Produto")
	@Test
	public void testCriaProduto() {
		Assertions.assertAll("livro",
				() -> assertEquals("Introdução ao Teste de Software", livro.getNome()),
				() -> assertTrue(100.00 == livro.getPreco())						
				);
	}
	
	@DisplayName("Teste Produtos Iguais")
	@Test
	public void testProdutosIguais() {
		Produto livro2 = new Produto("Introdução ao Teste de Software", 90.00);
		assertNotSame(livro, livro2);
	}
	
	@DisplayName("Teste Valida Preco")
	@Test
	public void validaPreco() {
		assertThat(livro.getPreco(), equalTo(100.00));
	}

	@DisplayName("Teste Valida Nome")
	@Test
	public void validaNome() {
		assertThat(livro.getNome(), notNullValue());
	}
	
	@DisplayName("Teste Valida Nome que Contem")
	@Test
	public void validaNomeContem() {
		assertThat(livro.getNome(), containsString("Teste"));
	}
	
	@DisplayName("Teste Valida Instancia")
	@Test
	public void validaInstancia() {
		assertThat(livro, instanceOf(Produto.class));
	}
}
