# 🎮 Juego del Ahorcado - Proyecto Final

## 📋 Descripción del Proyecto

Este proyecto implementa el clásico juego del **Ahorcado** utilizando únicamente estructuras de programación básicas de Java, sin programación orientada a objetos.

El jugador debe adivinar una palabra secreta letra por letra, con un máximo de 6 intentos fallidos antes de que el juego termine.

## ✅ Requisitos Técnicos Implementados

### 1. Tres Estructuras de Repetición Diferentes
- **`while`**: Bucle principal del juego (líneas 41-139)
- **`for`**: Inicialización de la palabra mostrada y búsqueda de letras (líneas 49-51, 87-92)
- **`do-while`**: Validación de entrada del usuario (líneas 66-85)

### 2. Arrays y Matrices
- **Array de palabras**: `String[] palabrasPosibles` (líneas 27-31)
- **Array de caracteres**: `char[] palabraMostrada` para mostrar el progreso
- **Array booleano**: `boolean[] letrasAdivinadas` para tracking de letras usadas
- **Matriz de strings**: `String[][] dibujoAhorcado` para arte ASCII del ahorcado (líneas 190-204)

### 3. Control de Selección Múltiple
- **`switch`**: Procesamiento del resultado de la partida (líneas 105-118)
- **`if-else` encadenados**: Validación de entrada y mensajes del ahorcado (líneas 208-218)

### 4. Declaraciones Condicionales
- Múltiples declaraciones `if` para control de flujo del juego
- Validación de entrada válida
- Verificación de fin de juego

### 5. Operadores Lógicos
- **`&&`**: Validación de entrada (`entrada.length() == 1 && entrada.charAt(0) >= 'A'`)
- **`||`**: Validación de respuestas (`respuesta.equals("S") || respuesta.equals("SI")`)
- **`!`**: Negación en condiciones de bucle

### 6. Simulación de Imágenes
- Arte ASCII para representar el ahorcado en diferentes estados
- Dibujos progresivos según el número de errores cometidos

## 🚀 Cómo Ejecutar el Juego

### Prerrequisitos
- Java Development Kit (JDK) 8 o superior
- Terminal o línea de comandos

### Instrucciones de Compilación y Ejecución

1. **Navegar a la carpeta del proyecto:**
   ```bash
   cd AhorcadoGame/src
   ```

2. **Compilar el programa:**
   ```bash
   javac AhorcadoGame.java
   ```

3. **Ejecutar el juego:**
   ```bash
   java AhorcadoGame
   ```

## 🎯 Cómo Jugar

1. **Inicio del Juego**: Se muestra un mensaje de bienvenida
2. **Palabra Secreta**: El programa selecciona aleatoriamente una palabra
3. **Adivinanza**: Ingresa letras una por una para adivinar la palabra
4. **Intentos**: Tienes 6 intentos fallidos máximo
5. **Victoria**: Adivina toda la palabra antes de agotar los intentos
6. **Derrota**: Se agotan los 6 intentos sin completar la palabra
7. **Estadísticas**: Al final se muestran las estadísticas de partidas

## 📁 Estructura del Proyecto

```
AhorcadoGame/
│
├── /src/                    → Archivos Java (.java)
│   └── AhorcadoGame.java   → Programa principal
├── /resources/img/          → Carpeta para imágenes (si se usaran)
├── /diagram/               → Diagrama de flujo del programa
├── README.md               → Este archivo de instrucciones
└── AhorcadoGame.zip        → Archivo comprimido final
```

## 🔧 Características del Código

### Variables y Estructuras de Datos
- **Array de palabras**: 15 palabras relacionadas con programación
- **Control de letras**: Sistema para evitar repetir letras ya utilizadas
- **Estadísticas**: Seguimiento de partidas ganadas y perdidas
- **Validación**: Control exhaustivo de entradas del usuario

### Funciones Implementadas
- `mostrarBienvenida()`: Interfaz de inicio del juego
- `mostrarEstadoJuego()`: Muestra el estado actual de la partida
- `mostrarAhorcado()`: Dibuja el ahorcado según errores cometidos
- `mostrarEstadisticas()`: Presenta estadísticas del jugador
- `preguntarJugarDeNuevo()`: Maneja la repetición del juego

## 🎨 Características Visuales

- **Arte ASCII**: Representación visual del ahorcado
- **Interfaz de texto**: Mensajes claros y organizados
- **Emojis**: Para hacer la experiencia más atractiva
- **Bordes y separadores**: Para organizar la información

## 📊 Palabras Incluidas

El juego incluye 15 palabras relacionadas con programación:
- JAVA, PROGRAMACION, COMPUTADORA, UNIVERSIDAD, ESTUDIANTE
- DESARROLLO, ALGORITMO, CODIGO, VARIABLE, FUNCION
- BUCLE, CONDICION, ARRAY, MATRIZ, TERMINAL

## 👨‍💻 Autor

**Nombre**: [Tu Nombre]  
**Proyecto**: Juego del Ahorcado - Programación Básica  
**Fecha**: [Fecha Actual]

## 📝 Notas de Desarrollo

- **Sin POO**: El código utiliza únicamente programación estructurada
- **Comentarios**: Todo el código está comentado en español
- **Validación**: Entrada robusta con validación de errores
- **Escalabilidad**: Fácil agregar nuevas palabras al array 