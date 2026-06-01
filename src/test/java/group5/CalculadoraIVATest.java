package group5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
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
}