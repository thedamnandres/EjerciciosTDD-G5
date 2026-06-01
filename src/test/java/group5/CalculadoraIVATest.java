package group5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraIVATest {

    private CalculadoraIVA calculadora;

    @BeforeEach
    void setUp() {
        calculadora = new CalculadoraIVA();
    }

    // --- Ciclo 1: calcularIVA - Andres ---

    @Test
    void calcularIVA_montoValido_retornaIVACorrecto() {
        assertEquals(15.0, calculadora.calcularIVA(100.0), 0.001);
    }

    @Test
    void calcularIVA_cero_retornaCero() {
        assertEquals(0.0, calculadora.calcularIVA(0.0), 0.001);
    }

    @Test
    void calcularIVA_montoNegativo_lanzaExcepcion() {
        assertThrows(IllegalArgumentException.class,
                () -> calculadora.calcularIVA(-50.0));
    }

    // Ciclo 2: calcularTotalConIVA - Galo
    @Test
    void calcularTotalConIVA_montoValido_retornaTotalCorrecto() {
        assertEquals(115.0, calculadora.calcularTotalConIVA(100.0), 0.001);
    }

    @Test
    void calcularTotalConIVA_cero_retornaCero() {
        assertEquals(0.0, calculadora.calcularTotalConIVA(0.0), 0.001);
    }

    @Test
    void calcularTotalConIVA_montoNegativo_lanzaExcepcion() {
        assertThrows(IllegalArgumentException.class,
                () -> calculadora.calcularTotalConIVA(-10.0));
    }

    // Ciclo 3: calcularMontoSinIVA - Pablo
    @Test
    void calcularMontoSinIVA_totalValido_retornaMontoOriginal() {
        assertEquals(100.0, calculadora.calcularMontoSinIVA(115.0), 0.001);
    }

    @Test
    void calcularMontoSinIVA_cero_retornaCero() {
        assertEquals(0.0, calculadora.calcularMontoSinIVA(0.0), 0.001);
    }

    @Test
    void calcularMontoSinIVA_totalNegativo_lanzaExcepcion() {
        assertThrows(IllegalArgumentException.class,
                () -> calculadora.calcularMontoSinIVA(-115.0));
    }

    // Ciclo 4: estaExento - Paul
    @Test
    void estaExento_categoriaExenta_retornaTrue() {
        assertTrue(calculadora.estaExento("ALIMENTOS"));
    }

    @Test
    void estaExento_categoriaNoExenta_retornaFalse() {
        assertFalse(calculadora.estaExento("ELECTRONICA"));
    }

    @Test
    void estaExento_categoriaNula_lanzaExcepcion() {
        assertThrows(IllegalArgumentException.class,
                () -> calculadora.estaExento(null));
    }
}