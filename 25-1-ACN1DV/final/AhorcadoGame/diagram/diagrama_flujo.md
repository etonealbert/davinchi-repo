# Diagrama de Flujo - Juego del Ahorcado

Este diagrama muestra la lógica completa del juego del Ahorcado implementado en Java.

## Descripción del Flujo

1. **Inicio**: El programa comienza inicializando variables y mostrando el mensaje de bienvenida
2. **Selección de Palabra**: Se selecciona aleatoriamente una palabra del array predefinido
3. **Bucle Principal**: Se ejecuta mientras el jugador tenga intentos y la palabra esté incompleta
4. **Validación de Entrada**: Se valida que la letra ingresada sea correcta y no haya sido usada
5. **Procesamiento**: Se verifica si la letra está en la palabra secreta
6. **Actualización**: Se actualiza el estado del juego según el resultado
7. **Finalización**: Se muestra el resultado y se pregunta si quiere jugar otra vez

## Estructuras de Programación Implementadas

- **while**: Bucle principal del juego
- **for**: Inicialización y búsqueda de letras
- **do-while**: Validación de entrada del usuario
- **switch**: Procesamiento del resultado de la partida
- **if-else**: Múltiples decisiones condicionales
- **Arrays**: Almacenamiento de palabras y estado del juego
- **Matrices**: Representación del dibujo del ahorcado

```mermaid
flowchart TD
    A[Inicio del Programa] --> B[Inicializar Variables]
    B --> C[Mostrar Mensaje de Bienvenida]
    C --> D[Seleccionar Palabra Aleatoria]
    D --> E[Inicializar Array palabraMostrada con guiones]
    E --> F{¿Intentos > 0 AND Palabra Incompleta?}
    
    F -->|Sí| G[Mostrar Estado del Juego]
    G --> H[Solicitar Letra del Usuario]
    H --> I{¿Entrada Válida?}
    
    I -->|No| J[Mostrar Error de Validación]
    J --> H
    
    I -->|Sí| K{¿Letra ya Utilizada?}
    K -->|Sí| L[Mostrar Mensaje: Letra ya Usada]
    L --> H
    
    K -->|No| M[Marcar Letra como Utilizada]
    M --> N[Buscar Letra en Palabra Secreta - FOR LOOP]
    N --> O{¿Letra Encontrada?}
    
    O -->|Sí| P[Actualizar palabraMostrada]
    P --> Q{¿Palabra Completa?}
    Q -->|Sí| R[Mostrar Victoria - SWITCH]
    Q -->|No| F
    
    O -->|No| S[Reducir Intentos]
    S --> T[Mostrar Dibujo del Ahorcado - IF-ELSE]
    T --> F
    
    F -->|No| U{¿Palabra Completa?}
    U -->|Sí| R
    U -->|No| V[Mostrar Derrota - SWITCH]
    
    R --> W[Actualizar Estadísticas]
    V --> W
    W --> X[Mostrar Estadísticas]
    X --> Y{¿Jugar Otra Vez? - DO-WHILE}
    
    Y -->|Sí| D
    Y -->|No| Z[Mostrar Estadísticas Finales]
    Z --> AA[Fin del Programa]
    
    style A fill:#90EE90
    style AA fill:#FFB6C1
    style R fill:#98FB98
    style V fill:#FFA07A
    style F fill:#87CEEB
    style U fill:#87CEEB
    style Y fill:#DDA0DD
```

## Leyenda de Colores

- 🟢 **Verde**: Inicio del programa
- 🔵 **Azul**: Puntos de decisión importantes
- 🟢 **Verde claro**: Victoria del jugador
- 🟠 **Naranja**: Derrota del jugador
- 🟣 **Púrpura**: Decisión de continuar jugando
- 🔴 **Rosa**: Fin del programa

## Requisitos Técnicos Destacados

### Tres Estructuras de Repetición
1. **WHILE**: Bucle principal (nodo F)
2. **FOR**: Búsqueda de letras (nodo N)
3. **DO-WHILE**: Validación de entrada (nodo Y)

### Control de Selección Múltiple
1. **SWITCH**: Procesamiento de resultados (nodos R y V)
2. **IF-ELSE**: Validación y mensajes (nodos I, K, T)

### Arrays y Matrices
- Array de palabras posibles
- Array para mostrar palabra actual
- Array booleano para letras utilizadas
- Matriz para dibujos ASCII del ahorcado 