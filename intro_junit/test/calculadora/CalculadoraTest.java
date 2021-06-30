package calculadora;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import calculadora.Calculadora;


@DisplayName("Teste calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Teste Soma")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(10, 5);		
		Assertions.assertEquals(15, soma);		
	}
	
	@DisplayName("Teste Subtração")
	@Test
	public void testSubtraiDoisNumeros() {
		int subtracao = calc.subtracao(10,5);
		Assertions.assertEquals(5, subtracao);
	}
	
	@DisplayName("Teste Subtração Resultado Negativo")
	@Test
	public void testSubtraiDoisNumerosNegativo() {
		int subtracao = calc.subtracao(5,10);
		Assertions.assertEquals(-5, subtracao);
	}
	
	@DisplayName("Teste Multiplicacao")
	@Test
	public void testMultiplicacaoDoisNumeros() {
		int multiplicacao = calc.multiplicacao(5,10);
		Assertions.assertEquals(50, multiplicacao);
	}
	
	@DisplayName("Teste Multiplicacao por Zero")
	@Test
	public void testMultiplicacaoPorZero() {
		int multiplicacao = calc.multiplicacao(5,0);
		Assertions.assertEquals(0, multiplicacao);
	}

	@DisplayName("Teste Multiplicacao 1 Negativo")
	@Test
	public void testMultiplicacaoUmNegativo() {
		int multiplicacao = calc.multiplicacao(5,-10);
		Assertions.assertEquals(-50, multiplicacao);
	}
	
	@DisplayName("Teste Multiplicacao 2 Negativos")
	@Test
	public void testMultiplicacaoDoisNegativo() {
		int multiplicacao = calc.multiplicacao(-5,-10);
		Assertions.assertEquals(50, multiplicacao);
	}
	
	@DisplayName("Teste divisao")
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}
	
	@DisplayName("Teste divisao por Zero")
	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Exceção não lançada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@DisplayName("Teste divisao Exception")
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}
	
	@DisplayName("Teste Somatorio")
	@Test
	public void testSomatorio() {
		int somatorio = calc.somatorio(5);
		Assertions.assertEquals(15, somatorio);
	}

	@DisplayName("Teste ehPositivo")
	@Test
	public void testPositivo() {
		boolean positivo = calc.ehPositivo(5);
		Assertions.assertTrue(positivo);
	}
	
	@DisplayName("Teste nao ehPositivo")
	@Test
	public void testNotPositivo() {
		boolean positivo = calc.ehPositivo(-5);
		Assertions.assertTrue(!positivo);
	}
	
	@DisplayName("Teste Compara Igual")
	@Test
	public void testCompara() {
		int compara = calc.compara(10, 10);
		Assertions.assertEquals(0, compara);
	}
	
	@DisplayName("Teste Compara Menor")
	@Test
	public void testComparaMenor() {
		int compara = calc.compara(10, 11);
		Assertions.assertEquals(-1, compara);
	}
	
	@DisplayName("Teste Compara Maior")
	@Test
	public void testComparaMaior() {
		int compara = calc.compara(11, 10);
		Assertions.assertEquals(1, compara);
	}
}
