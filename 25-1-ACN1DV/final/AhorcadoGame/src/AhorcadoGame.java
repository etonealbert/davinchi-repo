import java.util.Scanner;
import java.util.Random;

/**
 * Juego del Ahorcado - Proyecto Final
 * Autor: Albert Lukmanov
 * 
 * Este programa implementa el clásico juego del Ahorcado utilizando
 * únicamente estructuras de programación básicas de Java.
 * 
 * Requisitos técnicos implementados:
 * - Tres estructuras de repetición diferentes (for, while, do-while)
 * - Arrays y matrices para almacenar datos
 * - Control de selección múltiple (switch, if-else)
 * - Declaraciones condicionales con operadores lógicos
 * - Simulación de imágenes con arte ASCII
 */
public class AhorcadoGame {
    
    public static void main(String[] args) {
        // Scanner para leer entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        // Array de palabras para el juego (cumple requisito de array)
        String[] palabrasPosibles = {
            "JAVA", "PROGRAMACION", "COMPUTADORA", "UNIVERSIDAD", "ESTUDIANTE",
            "DESARROLLO", "ALGORITMO", "CODIGO", "VARIABLE", "FUNCION",
            "BUCLE", "CONDICION", "ARRAY", "MATRIZ", "TERMINAL"
        };
        
        // Variables del juego
        Random random = new Random();
        boolean jugarDeNuevo = true;
        int partidasGanadas = 0;
        int partidasPerdidas = 0;
        
        // Mostrar mensaje de bienvenida
        mostrarBienvenida();
        
        // Bucle principal del juego (while - primera estructura de repetición)
        while (jugarDeNuevo) {
            // Seleccionar palabra aleatoria
            String palabraSecreta = palabrasPosibles[random.nextInt(palabrasPosibles.length)];
            
            // Inicializar variables de la partida
            char[] palabraMostrada = new char[palabraSecreta.length()];
            boolean[] letrasAdivinadas = new boolean[26]; // Para las 26 letras del alfabeto
            int intentosRestantes = 6;
            boolean palabraCompleta = false;
            
            // Inicializar palabra mostrada con guiones (for - segunda estructura de repetición)
            for (int i = 0; i < palabraSecreta.length(); i++) {
                palabraMostrada[i] = '_';
            }
            
            System.out.println("\n¡Nueva partida comenzada!");
            System.out.println("Palabra a adivinar: " + new String(palabraMostrada));
            System.out.println("Intentos restantes: " + intentosRestantes);
            
            // Bucle de la partida actual
            while (intentosRestantes > 0 && !palabraCompleta) {
                // Mostrar estado actual del juego
                mostrarEstadoJuego(palabraMostrada, intentosRestantes, letrasAdivinadas);
                
                // Leer letra del usuario con validación (do-while - tercera estructura de repetición)
                char letraElegida;
                boolean entradaValida;
                do {
                    System.out.print("\nIngresa una letra (A-Z): ");
                    String entrada = scanner.nextLine().trim().toUpperCase();
                    
                    // Validar entrada usando operadores lógicos (&&, ||)
                    if (entrada.length() == 1 && entrada.charAt(0) >= 'A' && entrada.charAt(0) <= 'Z') {
                        letraElegida = entrada.charAt(0);
                        
                        // Verificar si la letra ya fue adivinada
                        if (letrasAdivinadas[letraElegida - 'A']) {
                            System.out.println("¡Ya has intentado esa letra! Prueba con otra.");
                            entradaValida = false;
                        } else {
                            entradaValida = true;
                        }
                    } else {
                        System.out.println("¡Entrada inválida! Por favor ingresa una sola letra.");
                        letraElegida = ' ';
                        entradaValida = false;
                    }
                } while (!entradaValida);
                
                // Marcar letra como adivinada
                letrasAdivinadas[letraElegida - 'A'] = true;
                
                // Verificar si la letra está en la palabra
                boolean letraEncontrada = false;
                for (int i = 0; i < palabraSecreta.length(); i++) {
                    if (palabraSecreta.charAt(i) == letraElegida) {
                        palabraMostrada[i] = letraElegida;
                        letraEncontrada = true;
                    }
                }
                
                // Procesar resultado usando control de selección múltiple (if-else)
                if (letraEncontrada) {
                    System.out.println("¡Excelente! La letra '" + letraElegida + "' está en la palabra.");
                    
                    // Verificar si la palabra está completa
                    palabraCompleta = true;
                    for (int i = 0; i < palabraMostrada.length; i++) {
                        if (palabraMostrada[i] == '_') {
                            palabraCompleta = false;
                            break;
                        }
                    }
                } else {
                    intentosRestantes--;
                    System.out.println("¡Ups! La letra '" + letraElegida + "' no está en la palabra.");
                    mostrarAhorcado(6 - intentosRestantes);
                }
            }
            
            // Mostrar resultado de la partida usando switch (control de selección múltiple)
            int resultado; // 1 = ganó, 2 = perdió
            if (palabraCompleta && intentosRestantes > 0) {
                resultado = 1;
                partidasGanadas++;
            } else {
                resultado = 2;
                partidasPerdidas++;
            }
            
            switch (resultado) {
                case 1:
                    System.out.println("\n🎉 ¡FELICITACIONES! ¡Has ganado!");
                    System.out.println("La palabra era: " + palabraSecreta);
                    System.out.println("Te sobraron " + intentosRestantes + " intentos.");
                    break;
                case 2:
                    System.out.println("\n💀 ¡Game Over! Has perdido.");
                    System.out.println("La palabra era: " + palabraSecreta);
                    mostrarAhorcado(6); // Mostrar ahorcado completo
                    break;
                default:
                    System.out.println("Error inesperado en el juego.");
                    break;
            }
            
            // Mostrar estadísticas
            mostrarEstadisticas(partidasGanadas, partidasPerdidas);
            
            // Preguntar si quiere jugar de nuevo
            jugarDeNuevo = preguntarJugarDeNuevo(scanner);
        }
        
        // Mensaje de despedida
        System.out.println("\n¡Gracias por jugar al Ahorcado!");
        System.out.println("Estadísticas finales:");
        mostrarEstadisticas(partidasGanadas, partidasPerdidas);
        
        scanner.close();
    }
    
    /**
     * Muestra el mensaje de bienvenida del juego
     */
    public static void mostrarBienvenida() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║          🎮 JUEGO DEL AHORCADO 🎮       ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║                                        ║");
        System.out.println("║  Adivina la palabra letra por letra   ║");
        System.out.println("║  Tienes 6 intentos antes de perder    ║");
        System.out.println("║                                        ║");
        System.out.println("║  🎯 Objetivo: Descubrir la palabra     ║");
        System.out.println("║  ⚠️  Cuidado: Cada error cuenta        ║");
        System.out.println("║                                        ║");
        System.out.println("╚════════════════════════════════════════╝");
    }
    
    /**
     * Muestra el estado actual del juego
     */
    public static void mostrarEstadoJuego(char[] palabraMostrada, int intentosRestantes, boolean[] letrasAdivinadas) {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("Estado actual de la palabra: " + new String(palabraMostrada));
        System.out.println("Intentos restantes: " + intentosRestantes);
        
        // Mostrar letras ya utilizadas
        System.out.print("Letras utilizadas: ");
        boolean primeraLetra = true;
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            if (letrasAdivinadas[i]) {
                if (!primeraLetra) {
                    System.out.print(", ");
                }
                System.out.print((char)('A' + i));
                primeraLetra = false;
            }
        }
        if (primeraLetra) {
            System.out.print("Ninguna");
        }
        System.out.println();
        System.out.println("=".repeat(40));
    }
    
    /**
     * Muestra el dibujo del ahorcado según el número de errores
     * Simula el uso de imágenes con arte ASCII
     */
    public static void mostrarAhorcado(int errores) {
        System.out.println("\n" + "┌─────────────────┐");
        System.out.println("│  AHORCADO - " + errores + "/6  │");
        System.out.println("└─────────────────┘");
        
        // Matriz de strings para representar cada estado del ahorcado (uso de matriz)
        String[][] dibujoAhorcado = {
            // Estado 0 (sin errores)
            {"      ", "      ", "      ", "      ", "      ", "      "},
            // Estado 1 (1 error)
            {"  +---", "  |   ", "  |   ", "  |   ", "  |   ", "──┴───"},
            // Estado 2 (2 errores)  
            {"  +---", "  |  |", "  |   ", "  |   ", "  |   ", "──┴───"},
            // Estado 3 (3 errores)
            {"  +---", "  |  |", "  |  O", "  |   ", "  |   ", "──┴───"},
            // Estado 4 (4 errores)
            {"  +---", "  |  |", "  |  O", "  |  |", "  |   ", "──┴───"},
            // Estado 5 (5 errores)
            {"  +---", "  |  |", "  |  O", "  | /|", "  |   ", "──┴───"},
            // Estado 6 (6 errores - ahorcado completo)
            {"  +---", "  |  |", "  |  O", "  | /|\\", "  | / ", "──┴───"}
        };
        
        // Mostrar el dibujo correspondiente al número de errores
        if (errores >= 0 && errores <= 6) {
            for (int i = 0; i < dibujoAhorcado[errores].length; i++) {
                System.out.println(dibujoAhorcado[errores][i]);
            }
        }
        
        // Mensaje según el número de errores (if-else encadenados)
        if (errores == 1) {
            System.out.println("¡Primer error! Ten cuidado...");
        } else if (errores == 2) {
            System.out.println("¡Segundo error! La situación se complica...");
        } else if (errores == 3) {
            System.out.println("¡Tercer error! ¡Aparece la cabeza!");
        } else if (errores == 4) {
            System.out.println("¡Cuarto error! ¡Aparece el cuerpo!");
        } else if (errores == 5) {
            System.out.println("¡Quinto error! ¡Solo falta un brazo!");
        } else if (errores == 6) {
            System.out.println("¡Sexto error! ¡AHORCADO COMPLETO!");
        }
    }
    
    /**
     * Muestra las estadísticas del jugador
     */
    public static void mostrarEstadisticas(int ganadas, int perdidas) {
        int totalPartidas = ganadas + perdidas;
        System.out.println("\n📊 ESTADÍSTICAS:");
        System.out.println("Partidas ganadas: " + ganadas);
        System.out.println("Partidas perdidas: " + perdidas);
        System.out.println("Total de partidas: " + totalPartidas);
        
        if (totalPartidas > 0) {
            double porcentajeVictorias = (double) ganadas / totalPartidas * 100;
            System.out.printf("Porcentaje de victorias: %.1f%%\n", porcentajeVictorias);
        }
    }
    
    /**
     * Pregunta al usuario si quiere jugar de nuevo
     * Utiliza operadores lógicos para validar la respuesta
     */
    public static boolean preguntarJugarDeNuevo(Scanner scanner) {
        String respuesta;
        boolean entradaValida;
        
        // Bucle para validar entrada (uso de operadores lógicos)
        do {
            System.out.print("\n¿Quieres jugar otra partida? (S/N): ");
            respuesta = scanner.nextLine().trim().toUpperCase();
            
            // Validar usando operadores lógicos (|| y &&)
            entradaValida = (respuesta.equals("S") || respuesta.equals("SI") || 
                           respuesta.equals("N") || respuesta.equals("NO")) && 
                           respuesta.length() <= 2;
            
            if (!entradaValida) {
                System.out.println("¡Respuesta inválida! Por favor responde S (Sí) o N (No).");
            }
        } while (!entradaValida);
        
        // Retornar verdadero si quiere jugar de nuevo
        return respuesta.equals("S") || respuesta.equals("SI");
    }
} 