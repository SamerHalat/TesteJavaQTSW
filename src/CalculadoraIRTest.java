import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraIRTest {

    CalculadoraIR calc = new CalculadoraIR();

    // Caminho 1: Salário Inválido (Negativo)
    @Test
    public void testSalarioInvalido() {
        double desconto = calc.calcularDesconto(-100.00);
        // Considerando que o algoritmo retorna -1.0 para sinalizar erro
        assertEquals(-1.0, desconto, "Deve retornar -1.0 para salário negativo");
    }

    // Caminho 2: Faixa 1 (Isenção total)
    @Test
    public void testIsento() {
        double desconto = calc.calcularDesconto(4500.00);
        assertEquals(0.0, desconto, "Deve retornar 0.0 de desconto (Isento)");
    }

    // Caminho 3: Faixa 2 (Desconto de 75%)
    @Test
    public void testDesconto75Porcento() {
        double desconto = calc.calcularDesconto(5200.00);
        assertEquals(75.0, desconto, "Deve retornar 75.0 de desconto");
    }

    // Caminho 4: Faixa 3 (Desconto de 50%)
    @Test
    public void testDesconto50Porcento() {
        double desconto = calc.calcularDesconto(5800.00);
        assertEquals(50.0, desconto, "Deve retornar 50.0 de desconto");
    }

    // Caminho 5: Faixa 4 (Desconto de 25%)
    @Test
    public void testDesconto25Porcento() {
        double desconto = calc.calcularDesconto(6200.00);
        assertEquals(25.0, desconto, "Deve retornar 25.0 de desconto");
    }

    // Caminho 6: Faixa 5 (Desconto de 10%)
    @Test
    public void testDesconto10Porcento() {
        double desconto = calc.calcularDesconto(7000.00);
        assertEquals(10.0, desconto, "Deve retornar 10.0 de desconto");
    }

    // Caminho 7: Faixa 6 (Alíquota de 27,5%)
    @Test
    public void testAliquota27EMeioPorcento() {
        double desconto = calc.calcularDesconto(10000.00);
        assertEquals(27.5, desconto, "Deve aplicar alíquota de 27.5");
    }
}