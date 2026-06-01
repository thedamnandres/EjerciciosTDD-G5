package group5;

import java.util.List;
import java.util.Set;

/**
 * CalculadoraIVA
 * Ciclo 1 (calcularIVA)          - Andres
 * Ciclo 2 (calcularTotalConIVA)  - Galo
 * Ciclo 3 (calcularMontoSinIVA)  - Pablo
 * Ciclo 4 (estaExento)           - Paul
 * Ciclo 5 (calcularIVALote)      - Roberto
 */
public class CalculadoraIVA {

    private static final double TASA_IVA = 0.15;

    // Ciclo 1 - Andres
    public double calcularIVA(double monto) {
        if (monto < 0)
            throw new IllegalArgumentException("Monto invalido");
        return monto * TASA_IVA;
    }
}