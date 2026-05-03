import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraIRTest {

    CalculadoraIR calc = new CalculadoraIR();

    // Partição de Classes de Equivalência (CE1 a CE7)    

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


    // Análise de Valor Limite (VL01 a VL12)   
 
    // VL01: -0.01 (limite superior do salário inválido)
    @Test
    public void testLimiteSalarioInvalido() {
        double desconto = calc.calcularDesconto(-0.01);
        assertEquals(-1.0, desconto, "Valor imediatamente abaixo de 0 deve ser inválido");
    }

    // VL02: 0.00 (limite inferior da Faixa 1 - Isenção)
    @Test
    public void testLimiteInferiorIsencao() {
        double desconto = calc.calcularDesconto(0.00);
        assertEquals(0.0, desconto, "Salário 0.00 deve ser isento");
    }

    // VL03: 5000.00 (limite superior da Faixa 1 - Isenção)
    @Test
    public void testLimiteSuperiorIsencao() {
        double desconto = calc.calcularDesconto(5000.00);
        assertEquals(0.0, desconto, "Salário 5000.00 deve ser isento");
    }

    // VL04: 5000.01 (limite inferior da Faixa 2 - 75%)
    @Test
    public void testLimiteInferiorDesconto75() {
        double desconto = calc.calcularDesconto(5000.01);
        assertEquals(75.0, desconto, "Salário 5000.01 deve receber 75% de desconto");
    }

    // VL05: 5500.00 (limite superior da Faixa 2 - 75%)
    @Test
    public void testLimiteSuperiorDesconto75() {
        double desconto = calc.calcularDesconto(5500.00);
        assertEquals(75.0, desconto, "Salário 5500.00 deve receber 75% de desconto");
    }

    // VL06: 5500.01 (limite inferior da Faixa 3 - 50%)
    @Test
    public void testLimiteInferiorDesconto50() {
        double desconto = calc.calcularDesconto(5500.01);
        assertEquals(50.0, desconto, "Salário 5500.01 deve receber 50% de desconto");
    }

    // VL07: 6000.00 (limite superior da Faixa 3 - 50%)
    @Test
    public void testLimiteSuperiorDesconto50() {
        double desconto = calc.calcularDesconto(6000.00);
        assertEquals(50.0, desconto, "Salário 6000.00 deve receber 50% de desconto");
    }

    // VL08: 6000.01 (limite inferior da Faixa 4 - 25%)
    @Test
    public void testLimiteInferiorDesconto25() {
        double desconto = calc.calcularDesconto(6000.01);
        assertEquals(25.0, desconto, "Salário 6000.01 deve receber 25% de desconto");
    }

    // VL09: 6500.00 (limite superior da Faixa 4 - 25%)
    @Test
    public void testLimiteSuperiorDesconto25() {
        double desconto = calc.calcularDesconto(6500.00);
        assertEquals(25.0, desconto, "Salário 6500.00 deve receber 25% de desconto");
    }

    // VL10: 6500.01 (limite inferior da Faixa 5 - 10%)
    @Test
    public void testLimiteInferiorDesconto10() {
        double desconto = calc.calcularDesconto(6500.01);
        assertEquals(10.0, desconto, "Salário 6500.01 deve receber 10% de desconto");
    }

    // VL11: 7350.00 (limite superior da Faixa 5 - 10%)
    @Test
    public void testLimiteSuperiorDesconto10() {
        double desconto = calc.calcularDesconto(7350.00);
        assertEquals(10.0, desconto, "Salário 7350.00 deve receber 10% de desconto");
    }

    // VL12: 7350.01 (limite inferior da Faixa 6 - 27,5%)
    @Test
    public void testLimiteInferiorAliquota27EMeio() {
        double desconto = calc.calcularDesconto(7350.01);
        assertEquals(27.5, desconto, "Salário 7350.01 deve aplicar alíquota de 27,5%");
    }
}
