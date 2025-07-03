import java.util.Random;

/**
 * Simulador de Ascensor para un edificio de 6 pisos
 * 
 * Funcionalidades:
 * - Genera personas esperando aleatoriamente en cada piso (0-4 personas)
 * - Simula el movimiento del ascensor desde el piso 0 hasta el último piso
 * - Maneja la capacidad máxima del ascensor (8 personas)
 * - Muestra el estado inicial y final del sistema
 * 
 * @author Desarrollador Java
 * @version 1.0
 */
public class SimuladorAscensor {
    
    // Constantes del sistema
    private static final int NUMERO_PISOS = 6;
    private static final int CAPACIDAD_MAXIMA_ASCENSOR = 8;
    private static final int MIN_PERSONAS_POR_PISO = 0;
    private static final int MAX_PERSONAS_POR_PISO = 4;
    
    public static void main(String[] args) {
        
        System.out.println("=== SIMULADOR DE ASCENSOR ===");
        System.out.println("Edificio de " + NUMERO_PISOS + " pisos");
        System.out.println("Capacidad máxima del ascensor: " + CAPACIDAD_MAXIMA_ASCENSOR + " personas");
        System.out.println();
        
        // Generar arreglo con personas esperando en cada piso
        int[] personasEsperandoPorPiso = generarPersonasEsperando();
        
        // Mostrar estado inicial
        mostrarEstadoInicial(personasEsperandoPorPiso);
        
        // Simular el movimiento del ascensor
        int[] estadoFinalPisos = simularMovimientoAscensor(personasEsperandoPorPiso);
        
        // Mostrar estado final
        mostrarEstadoFinal(personasEsperandoPorPiso, estadoFinalPisos);
        
        // Mostrar estadísticas de la simulación
        mostrarEstadisticasSimulacion(personasEsperandoPorPiso, estadoFinalPisos);
    }
    
    /**
     * Genera un arreglo con cantidad aleatoria de personas esperando en cada piso
     * @return arreglo con personas esperando por piso (índices 0-5 representan pisos 0-5)
     */
    private static int[] generarPersonasEsperando() {
        Random random = new Random();
        int[] personasPorPiso = new int[NUMERO_PISOS];
        
        System.out.println("--- GENERANDO PERSONAS ESPERANDO EN CADA PISO ---");
        
        for (int piso = 0; piso < NUMERO_PISOS; piso++) {
            // Generar número aleatorio de personas entre 0 y 4
            personasPorPiso[piso] = random.nextInt(MAX_PERSONAS_POR_PISO + 1);
            System.out.println("Piso " + piso + ": " + personasPorPiso[piso] + " personas esperando");
        }
        
        System.out.println();
        return personasPorPiso;
    }
    
    /**
     * Muestra el estado inicial del sistema antes de la simulación
     * @param personasEsperando arreglo con personas esperando en cada piso
     */
    private static void mostrarEstadoInicial(int[] personasEsperando) {
        System.out.println("--- ESTADO INICIAL DEL SISTEMA ---");
        System.out.println("🏢 Edificio de " + NUMERO_PISOS + " pisos:");
        
        // Mostrar el edificio de arriba hacia abajo (piso 5 al 0)
        for (int piso = NUMERO_PISOS - 1; piso >= 0; piso--) {
            String indicadorPiso = (piso == 0) ? "🚪" : "  ";
            String personasVisuales = generarRepresentacionVisualPersonas(personasEsperando[piso]);
            
            System.out.printf("Piso %d %s │ %s (%d personas)%n", 
                piso, indicadorPiso, personasVisuales, personasEsperando[piso]);
        }
        
        System.out.println("        └─────────────────────");
        System.out.println("🛗 Ascensor: VACÍO (0/" + CAPACIDAD_MAXIMA_ASCENSOR + " personas)");
        
        // Calcular total de personas esperando
        int totalPersonas = 0;
        for (int personas : personasEsperando) {
            totalPersonas += personas;
        }
        System.out.println("👥 Total de personas esperando: " + totalPersonas);
        System.out.println();
    }
    
    /**
     * Simula el movimiento del ascensor desde el piso 0 hasta el último piso
     * @param personasEsperando arreglo original con personas esperando
     * @return arreglo con el estado final de personas en cada piso
     */
    private static int[] simularMovimientoAscensor(int[] personasEsperando) {
        System.out.println("--- SIMULACIÓN DEL MOVIMIENTO DEL ASCENSOR ---");
        
        // Crear copia del arreglo original para modificar
        int[] estadoActualPisos = new int[NUMERO_PISOS];
        System.arraycopy(personasEsperando, 0, estadoActualPisos, 0, NUMERO_PISOS);
        
        int espaciosDisponiblesAscensor = CAPACIDAD_MAXIMA_ASCENSOR;
        int totalPersonasRecogidas = 0;
        
        System.out.println("🛗 El ascensor inicia su recorrido desde el piso 0...");
        System.out.println();
        
        // Simular el ascensor subiendo piso por piso
        for (int pisoActual = 0; pisoActual < NUMERO_PISOS; pisoActual++) {
            System.out.println("📍 Ascensor llegando al piso " + pisoActual + ":");
            System.out.println("   Personas esperando en este piso: " + estadoActualPisos[pisoActual]);
            System.out.println("   Espacios disponibles en ascensor: " + espaciosDisponiblesAscensor);
            
            // Calcular cuántas personas pueden subir
            int personasQueSuben = Math.min(estadoActualPisos[pisoActual], espaciosDisponiblesAscensor);
            
            if (personasQueSuben > 0) {
                // Personas suben al ascensor
                estadoActualPisos[pisoActual] -= personasQueSuben;
                espaciosDisponiblesAscensor -= personasQueSuben;
                totalPersonasRecogidas += personasQueSuben;
                
                System.out.println("   ✅ " + personasQueSuben + " personas suben al ascensor");
                System.out.println("   🛗 Ascensor ahora tiene: " + 
                    (CAPACIDAD_MAXIMA_ASCENSOR - espaciosDisponiblesAscensor) + "/" + 
                    CAPACIDAD_MAXIMA_ASCENSOR + " personas");
                
                if (estadoActualPisos[pisoActual] > 0) {
                    System.out.println("   ⚠️  " + estadoActualPisos[pisoActual] + 
                        " personas quedan esperando (ascensor lleno)");
                }
            } else {
                if (estadoActualPisos[pisoActual] > 0) {
                    System.out.println("   ❌ No pueden subir personas (ascensor lleno)");
                } else {
                    System.out.println("   ℹ️  No hay personas esperando en este piso");
                }
            }
            
            System.out.println();
            
            // Si el ascensor está lleno, informar
            if (espaciosDisponiblesAscensor == 0) {
                System.out.println("🚫 ¡ASCENSOR LLENO! No se pueden recoger más personas.");
                System.out.println();
            }
        }
        
        System.out.println("🏁 El ascensor ha completado su recorrido hasta el último piso.");
        System.out.println("📊 Total de personas recogidas: " + totalPersonasRecogidas + "/" + 
            calcularTotalPersonasIniciales(personasEsperando));
        System.out.println();
        
        return estadoActualPisos;
    }
    
    /**
     * Muestra el estado final del sistema después de la simulación
     * @param estadoInicial arreglo con el estado inicial
     * @param estadoFinal arreglo con el estado final
     */
    private static void mostrarEstadoFinal(int[] estadoInicial, int[] estadoFinal) {
        System.out.println("--- ESTADO FINAL DEL SISTEMA ---");
        System.out.println("🏢 Comparación del edificio (Antes → Después):");
        
        // Mostrar comparación piso por piso
        for (int piso = NUMERO_PISOS - 1; piso >= 0; piso--) {
            String indicadorPiso = (piso == 0) ? "🚪" : "  ";
            String personasInicialesVisuales = generarRepresentacionVisualPersonas(estadoInicial[piso]);
            String personasFinalesVisuales = generarRepresentacionVisualPersonas(estadoFinal[piso]);
            
            System.out.printf("Piso %d %s │ %s (%d) → %s (%d)%n", 
                piso, indicadorPiso, 
                personasInicialesVisuales, estadoInicial[piso],
                personasFinalesVisuales, estadoFinal[piso]);
        }
        
        System.out.println("        └─────────────────────────────────");
        
        // Calcular personas en el ascensor
        int personasEnAscensor = calcularTotalPersonasIniciales(estadoInicial) - 
                                calcularTotalPersonasIniciales(estadoFinal);
        
        System.out.println("🛗 Ascensor final: " + personasEnAscensor + "/" + 
            CAPACIDAD_MAXIMA_ASCENSOR + " personas " + 
            generarRepresentacionVisualPersonas(personasEnAscensor));
        System.out.println();
    }
    
    /**
     * Muestra estadísticas detalladas de la simulación
     * @param estadoInicial arreglo con el estado inicial
     * @param estadoFinal arreglo con el estado final
     */
    private static void mostrarEstadisticasSimulacion(int[] estadoInicial, int[] estadoFinal) {
        System.out.println("=== ESTADÍSTICAS DE LA SIMULACIÓN ===");
        
        int totalPersonasIniciales = calcularTotalPersonasIniciales(estadoInicial);
        int totalPersonasQueQuedan = calcularTotalPersonasIniciales(estadoFinal);
        int personasRecogidas = totalPersonasIniciales - totalPersonasQueQuedan;
        double porcentajeRecogidas = (totalPersonasIniciales > 0) ? 
            (double) personasRecogidas / totalPersonasIniciales * 100 : 0;
        
        System.out.println("📊 RESUMEN NUMÉRICO:");
        System.out.println("   • Total de personas iniciales: " + totalPersonasIniciales);
        System.out.println("   • Personas recogidas por el ascensor: " + personasRecogidas);
        System.out.println("   • Personas que quedaron esperando: " + totalPersonasQueQuedan);
        System.out.printf("   • Porcentaje de eficiencia: %.1f%%%n", porcentajeRecogidas);
        System.out.println();
        
        System.out.println("🎯 ANÁLISIS DE RENDIMIENTO:");
        if (porcentajeRecogidas == 100) {
            System.out.println("   • ✅ Excelente: Todas las personas fueron recogidas");
        } else if (porcentajeRecogidas >= 80) {
            System.out.println("   • 👍 Muy bueno: La mayoría de personas fueron recogidas");
        } else if (porcentajeRecogidas >= 60) {
            System.out.println("   • ⚠️  Aceptable: Se recogió más de la mitad de las personas");
        } else {
            System.out.println("   • ❌ Limitado: El ascensor no pudo recoger muchas personas");
        }
        
        // Análisis por piso
        System.out.println();
        System.out.println("📍 ANÁLISIS POR PISO:");
        for (int piso = 0; piso < NUMERO_PISOS; piso++) {
            int personasRecogidas_piso = estadoInicial[piso] - estadoFinal[piso];
            if (estadoInicial[piso] > 0) {
                double eficienciaPiso = (double) personasRecogidas_piso / estadoInicial[piso] * 100;
                System.out.printf("   • Piso %d: %d/%d personas recogidas (%.0f%%)%n", 
                    piso, personasRecogidas_piso, estadoInicial[piso], eficienciaPiso);
            } else {
                System.out.println("   • Piso " + piso + ": Sin personas esperando");
            }
        }
        
        System.out.println();
        System.out.println("💡 RECOMENDACIONES:");
        if (totalPersonasQueQuedan > 0) {
            System.out.println("   • Se recomienda realizar un segundo viaje del ascensor");
            System.out.println("   • Considerar aumentar la capacidad del ascensor para futuros casos");
        } else {
            System.out.println("   • ¡Operación perfecta! No se requieren viajes adicionales");
        }
    }
    
    /**
     * Genera una representación visual de las personas usando emojis
     * @param cantidad número de personas
     * @return cadena con representación visual
     */
    private static String generarRepresentacionVisualPersonas(int cantidad) {
        if (cantidad == 0) {
            return "     ";
        }
        
        StringBuilder visual = new StringBuilder();
        for (int i = 0; i < Math.min(cantidad, 5); i++) {
            visual.append("👤");
        }
        
        // Si hay más de 5 personas, agregar un indicador
        if (cantidad > 5) {
            visual.append("...");
        }
        
        return visual.toString();
    }
    
    /**
     * Calcula el total de personas en un arreglo
     * @param arreglo arreglo de enteros
     * @return suma total de elementos
     */
    private static int calcularTotalPersonasIniciales(int[] arreglo) {
        int total = 0;
        for (int valor : arreglo) {
            total += valor;
        }
        return total;
    }
} 