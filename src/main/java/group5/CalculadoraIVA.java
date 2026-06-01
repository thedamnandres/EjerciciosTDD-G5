package group5;

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

    // Ciclo 2 - Paul
    public double calcularTotalConIVA(double monto) {
        if (monto < 0)
            throw new IllegalArgumentException("Monto invalido");
        return monto + calcularIVA(monto);
    }

    // Ciclo 3 - Pablo
    public double calcularMontoSinIVA(double total) {
        if (total < 0)
            throw new IllegalArgumentException("Monto invalido");
        return total / (1 + TASA_IVA);
    }

    // Ciclo 4 - Paul
    public boolean estaExento(String categoria) {
        if (categoria == null)
            throw new IllegalArgumentException("Categoria invalida");
        return Set.of("ALIMENTOS", "MEDICAMENTOS", "EDUCACION")
                .contains(categoria.toUpperCase());
    }
}