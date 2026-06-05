# EjerciciosTDD — Grupo 5

Proyecto de práctica de **TDD (Test-Driven Development)** aplicando el ciclo **PDCA (Plan-Do-Check-Act)**, desarrollado en Java con Maven y JUnit 5.

## Contexto de la actividad

El objetivo fue implementar una funcionalidad de software completa siguiendo TDD, donde cada integrante del grupo ejecutó al menos un ciclo completo RED → GREEN → REFACTOR, mapeado al ciclo de calidad PDCA.

**Funcionalidad elegida:** Calculadora de IVA al 15% (`CalculadoraIVA.java`)

---

## Integrantes y ciclos implementados

| Ciclo | Método implementado     | Responsable |
|-------|-------------------------|-------------|
| 1     | `calcularIVA`           | Andres      |
| 2     | `calcularTotalConIVA`   | Paul        |
| 3     | `calcularMontoSinIVA`   | Pablo       |
| 4     | `estaExento`            | Galo        |
| 5     | `calcularIVALote`       | Roberto     |

---

## Estructura del proyecto

```
EjerciciosTDD-G5/
├── pom.xml
└── src/
    ├── main/java/group5/
    │   └── CalculadoraIVA.java       # Implementación
    └── test/java/group5/
        └── CalculadoraIVATest.java   # Pruebas unitarias (JUnit 5)
```

---

## Funcionalidades implementadas

Todas las operaciones aplican una tasa fija de **IVA = 15%**.

| Método | Descripción |
|---|---|
| `calcularIVA(double monto)` | Retorna el monto del IVA (`monto × 0.15`) |
| `calcularTotalConIVA(double monto)` | Retorna el total con IVA incluido (`monto × 1.15`) |
| `calcularMontoSinIVA(double total)` | Extrae el monto base de un total con IVA (`total / 1.15`) |
| `estaExento(String categoria)` | Indica si una categoría está exenta de IVA (ALIMENTOS, MEDICAMENTOS, EDUCACION) |
| `calcularIVALote(List<Double> montos)` | Calcula la suma total de IVA para una lista de montos |

Todos los métodos lanzan `IllegalArgumentException` ante entradas inválidas (valores negativos, nulos).

---

## Metodología: PDCA + TDD

Cada ciclo siguió los cuatro pasos del ciclo PDCA, mapeados directamente a las fases de TDD:

### Plan — Definir el objetivo y escribir la prueba (RED)

Se identificó el comportamiento esperado del método y se redactó la prueba unitaria **antes** de escribir código de producción. Al ejecutar las pruebas en este punto, todas fallan porque la implementación aún no existe.

**Ejemplo — Ciclo 1 (Andres):**
```java
@Test
void calcularIVA_montoValido_retornaIVACorrecto() {
    assertEquals(15.0, calculadora.calcularIVA(100.0), 0.001);
}
```
*Commit:* `RED: test calcularIVA - ciclo 1 Andres`

---

### Do — Escribir el código mínimo para pasar la prueba (GREEN)

Se implementó únicamente el código necesario para que la prueba pase, sin sobre-ingeniería.

**Ejemplo — Ciclo 1:**
```java
public double calcularIVA(double monto) {
    if (monto < 0) throw new IllegalArgumentException("Monto invalido");
    return monto * TASA_IVA;
}
```
*Commit:* `GREEN: implementa calcularIVA - ciclo 1 Andres`

---

### Check — Verificar que la prueba pase correctamente

Se ejecutó la suite de pruebas con `mvn test` para confirmar que el nuevo test y todos los anteriores pasan sin errores.

---

### Act — Refactorizar y expandir casos de prueba

Se agregaron pruebas para casos borde (monto cero, monto negativo, lista vacía, categoría nula) y se refactorizó cuando fue necesario para mantener claridad y consistencia en el código.

**Ejemplo — Ciclo 5 (Roberto), expansión de casos:**
```java
@Test
void calcularIVALote_listaVacia_retornaCero() {
    assertEquals(0.0, calculadora.calcularIVALote(List.of()), 0.001);
}

@Test
void calcularIVALote_listaNula_lanzaExcepcion() {
    assertThrows(IllegalArgumentException.class,
            () -> calculadora.calcularIVALote(null));
}
```

---

## Pruebas unitarias implementadas

| Test | Caso verificado |
|---|---|
| `calcularIVA_montoValido_retornaIVACorrecto` | IVA correcto para monto positivo |
| `calcularIVA_cero_retornaCero` | IVA de 0 es 0 |
| `calcularIVA_montoNegativo_lanzaExcepcion` | Excepción con monto negativo |
| `calcularTotalConIVA_montoValido_retornaTotalCorrecto` | Total = monto + IVA |
| `calcularTotalConIVA_cero_retornaCero` | Total de 0 es 0 |
| `calcularTotalConIVA_montoNegativo_lanzaExcepcion` | Excepción con monto negativo |
| `calcularMontoSinIVA_totalValido_retornaMontoOriginal` | Extracción correcta del monto base |
| `calcularMontoSinIVA_cero_retornaCero` | Base de 0 es 0 |
| `calcularMontoSinIVA_totalNegativo_lanzaExcepcion` | Excepción con total negativo |
| `estaExento_categoriaExenta_retornaTrue` | ALIMENTOS → exento |
| `estaExento_categoriaNoExenta_retornaFalse` | ELECTRONICA → no exento |
| `estaExento_categoriaNula_lanzaExcepcion` | Excepción con null |
| `calcularIVALote_listaValida_retornaSumaIVA` | Suma de IVA para lista de montos |
| `calcularIVALote_listaVacia_retornaCero` | Lista vacía → IVA = 0 |
| `calcularIVALote_listaNula_lanzaExcepcion` | Excepción con lista nula |
---

![alt text](https://file%2B.vscode-resource.vscode-cdn.net/Users/thedamnandres/Documents/Calidad/EjercicioTDD/EjerciciosTDD-G5/docs/Captura%20de%20pantalla%202026-06-05%20a%20la%28s%29%2010.27.32.png?version%3D1780673362195)

---

## Tecnologías

- **Java 17**
- **Maven 3**
- **JUnit Jupiter 5.10.0**

---

## Cómo ejecutar las pruebas

```bash
mvn test
```

Para compilar sin ejecutar pruebas:

```bash
mvn compile
```
