public class CalculadoraIR {

    public double calcularDesconto(double salario) {
        double taxa;

        /* B1 */ if (salario < 0) {
            /* B2 */     taxa = -1.0; // Representa valor inválido
        }
        /* B3 */ else if (salario <= 5000.00) {
            /* B4 */     taxa = 0.0; // Isento
        }
        /* B5 */ else if (salario <= 5500.00) {
            /* B6 */     taxa = 75.0; // Desconto de 75%
        }
        /* B7 */ else if (salario <= 6000.00) {
            /* B8 */     taxa = 50.0; // Desconto de 50%
        }
        /* B9 */ else if (salario <= 6500.00) {
            /* B10 */    taxa = 25.0; // Desconto de 25%
        }
        /* B11 */ else if (salario <= 7350.00) {
            /* B12 */    taxa = 10.0; // Desconto de 10%
        }
        else {
            /* B13 */    taxa = 27.5; // Alíquota de 27,5%
        }

        /* B14 */ return taxa;
    }
}
