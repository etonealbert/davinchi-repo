Proceso SimuladorAscensor
    // Constantes del sistema
    Definir NUMERO_PISOS Como Entero;
    NUMERO_PISOS <- 6;
    Definir CAPACIDAD_MAXIMA_ASCENSOR Como Entero;
    CAPACIDAD_MAXIMA_ASCENSOR <- 8;
    Definir MIN_PERSONAS_POR_PISO Como Entero;
    MIN_PERSONAS_POR_PISO <- 0;
    Definir MAX_PERSONAS_POR_PISO Como Entero;
    MAX_PERSONAS_POR_PISO <- 4;

    Dimension personasEsperandoPorPiso[NUMERO_PISOS];
    Dimension estadoFinalPisos[NUMERO_PISOS];

    Escribir "=== SIMULADOR DE ASCENSOR ===";
    Escribir "Edificio de ", NUMERO_PISOS, " pisos";
    Escribir "Capacidad máxima del ascensor: ", CAPACIDAD_MAXIMA_ASCENSOR, " personas";
    Escribir "";

    // Generar arreglo con personas esperando en cada piso
    generarPersonasEsperando(personasEsperandoPorPiso, NUMERO_PISOS, MAX_PERSONAS_POR_PISO);

    // Mostrar estado inicial
    mostrarEstadoInicial(personasEsperandoPorPiso, NUMERO_PISOS, CAPACIDAD_MAXIMA_ASCENSOR);

    // Simular el movimiento del ascensor
    simularMovimientoAscensor(personasEsperandoPorPiso, estadoFinalPisos, NUMERO_PISOS, CAPACIDAD_MAXIMA_ASCENSOR);

    // Mostrar estado final
    mostrarEstadoFinal(personasEsperandoPorPiso, estadoFinalPisos, NUMERO_PISOS, CAPACIDAD_MAXIMA_ASCENSOR);

    // Mostrar estadísticas de la simulación
    mostrarEstadisticasSimulacion(personasEsperandoPorPiso, estadoFinalPisos, NUMERO_PISOS);
FinProceso

SubProceso generarPersonasEsperando(personasPorPiso Por Referencia, numPisos, maxPersonas)
    Definir piso Como Entero;
    Escribir "--- GENERANDO PERSONAS ESPERANDO EN CADA PISO ---";
    Para piso <- 0 Hasta numPisos - 1 Hacer
        personasPorPiso[piso] <- Azar(maxPersonas + 1);
        Escribir "Piso ", piso, ": ", personasPorPiso[piso], " personas esperando";
    FinPara
    Escribir "";
FinSubProceso

SubProceso mostrarEstadoInicial(personasEsperando Por Referencia, numPisos, capacidadAscensor)
    Definir piso, totalPersonas Como Entero;
    Definir indicadorPiso, personasVisuales Como Caracter;

    Escribir "--- ESTADO INICIAL DEL SISTEMA ---";
    Escribir "🏢 Edificio de ", numPisos, " pisos:";

    Para piso <- numPisos - 1 Hasta 0 Con Paso -1 Hacer
        Si piso == 0 Entonces
            indicadorPiso <- "🚪";
        Sino
            indicadorPiso <- "  ";
        FinSi
        personasVisuales <- generarRepresentacionVisualPersonas(personasEsperando[piso]);
        Escribir "Piso ", piso, " ", indicadorPiso, " │ ", personasVisuales, " (", personasEsperando[piso], " personas)";
    FinPara

    Escribir "        └─────────────────────";
    Escribir "🛗 Ascensor: VACÍO (0/", capacidadAscensor, " personas)";

    totalPersonas <- calcularTotalPersonas(personasEsperando, numPisos);
    Escribir "👥 Total de personas esperando: ", totalPersonas;
    Escribir "";
FinSubProceso

SubProceso simularMovimientoAscensor(personasEsperando Por Referencia, estadoActualPisos Por Referencia, numPisos, capacidadAscensor)
    Definir espaciosDisponiblesAscensor, totalPersonasRecogidas, pisoActual, personasQueSuben Como Entero;
    Definir i Como Entero;
    
    Escribir "--- SIMULACIÓN DEL MOVIMIENTO DEL ASCENSOR ---";
    
    Para i <- 0 hasta numPisos-1 Hacer
        estadoActualPisos[i] <- personasEsperando[i];
    FinPara

    espaciosDisponiblesAscensor <- capacidadAscensor;
    totalPersonasRecogidas <- 0;

    Escribir "🛗 El ascensor inicia su recorrido desde el piso 0...";
    Escribir "";

    Para pisoActual <- 0 Hasta numPisos - 1 Hacer
        Escribir "📍 Ascensor llegando al piso ", pisoActual, ":";
        Escribir "   Personas esperando en este piso: ", estadoActualPisos[pisoActual];
        Escribir "   Espacios disponibles en ascensor: ", espaciosDisponiblesAscensor;

        Si estadoActualPisos[pisoActual] < espaciosDisponiblesAscensor Entonces
            personasQueSuben <- estadoActualPisos[pisoActual];
        Sino
            personasQueSuben <- espaciosDisponiblesAscensor;
        FinSi

        Si personasQueSuben > 0 Entonces
            estadoActualPisos[pisoActual] <- estadoActualPisos[pisoActual] - personasQueSuben;
            espaciosDisponiblesAscensor <- espaciosDisponiblesAscensor - personasQueSuben;
            totalPersonasRecogidas <- totalPersonasRecogidas + personasQueSuben;

            Escribir "   ✅ ", personasQueSuben, " personas suben al ascensor";
            Escribir "   🛗 Ascensor ahora tiene: ", (capacidadAscensor - espaciosDisponiblesAscensor), "/", capacidadAscensor, " personas";

            Si estadoActualPisos[pisoActual] > 0 Entonces
                Escribir "   ⚠️  ", estadoActualPisos[pisoActual], " personas quedan esperando (ascensor lleno)";
            FinSi
        Sino
            Si estadoActualPisos[pisoActual] > 0 Entonces
                Escribir "   ❌ No pueden subir personas (ascensor lleno)";
            Sino
                Escribir "   ℹ️  No hay personas esperando en este piso";
            FinSi
        FinSi
        Escribir "";

        Si espaciosDisponiblesAscensor == 0 Entonces
            Escribir "🚫 ¡ASCENSOR LLENO! No se pueden recoger más personas.";
            Escribir "";
        FinSi
    FinPara

    Escribir "🏁 El ascensor ha completado su recorrido hasta el último piso.";
    Escribir "📊 Total de personas recogidas: ", totalPersonasRecogidas, "/", calcularTotalPersonas(personasEsperando, numPisos);
    Escribir "";
FinSubProceso

SubProceso mostrarEstadoFinal(estadoInicial Por Referencia, estadoFinal Por Referencia, numPisos, capacidadAscensor)
    Definir piso, personasEnAscensor Como Entero;
    Definir indicadorPiso, personasInicialesVisuales, personasFinalesVisuales Como Caracter;

    Escribir "--- ESTADO FINAL DEL SISTEMA ---";
    Escribir "🏢 Comparación del edificio (Antes → Después):";

    Para piso <- numPisos - 1 Hasta 0 Con Paso -1 Hacer
        Si piso == 0 Entonces
            indicadorPiso <- "🚪";
        Sino
            indicadorPiso <- "  ";
        FinSi
        personasInicialesVisuales <- generarRepresentacionVisualPersonas(estadoInicial[piso]);
        personasFinalesVisuales <- generarRepresentacionVisualPersonas(estadoFinal[piso]);
        
        Escribir "Piso ", piso, " ", indicadorPiso, " │ ", personasInicialesVisuales, " (", estadoInicial[piso], ") → ", personasFinalesVisuales, " (", estadoFinal[piso], ")";
    FinPara

    Escribir "        └─────────────────────────────────";

    personasEnAscensor <- calcularTotalPersonas(estadoInicial, numPisos) - calcularTotalPersonas(estadoFinal, numPisos);

    Escribir "🛗 Ascensor final: ", personasEnAscensor, "/", capacidadAscensor, " personas ", generarRepresentacionVisualPersonas(personasEnAscensor);
    Escribir "";
FinSubProceso

SubProceso mostrarEstadisticasSimulacion(estadoInicial Por Referencia, estadoFinal Por Referencia, numPisos)
    Definir totalPersonasIniciales, totalPersonasQueQuedan, personasRecogidas, piso, personasRecogidas_piso Como Entero;
    Definir porcentajeRecogidas, eficienciaPiso Como Real;

    Escribir "=== ESTADÍSTICAS DE LA SIMULACIÓN ===";
    
    totalPersonasIniciales <- calcularTotalPersonas(estadoInicial, numPisos);
    totalPersonasQueQuedan <- calcularTotalPersonas(estadoFinal, numPisos);
    personasRecogidas <- totalPersonasIniciales - totalPersonasQueQuedan;
    
    Si totalPersonasIniciales > 0 Entonces
        porcentajeRecogidas <- (personasRecogidas / totalPersonasIniciales) * 100;
    Sino
        porcentajeRecogidas <- 0;
    FinSi

    Escribir "📊 RESUMEN NUMÉRICO:";
    Escribir "   • Total de personas iniciales: ", totalPersonasIniciales;
    Escribir "   • Personas recogidas por el ascensor: ", personasRecogidas;
    Escribir "   • Personas que quedaron esperando: ", totalPersonasQueQuedan;
    Escribir "   • Porcentaje de eficiencia: ", porcentajeRecogidas, "%";
    Escribir "";

    Escribir "🎯 ANÁLISIS DE RENDIMIENTO:";
    Si porcentajeRecogidas == 100 Entonces
        Escribir "   • ✅ Excelente: Todas las personas fueron recogidas";
    Sino
        Si porcentajeRecogidas >= 80 Entonces
            Escribir "   • 👍 Muy bueno: La mayoría de personas fueron recogidas";
        Sino
            Si porcentajeRecogidas >= 60 Entonces
                Escribir "   • ⚠️  Aceptable: Se recogió más de la mitad de las personas";
            Sino
                Escribir "   • ❌ Limitado: El ascensor no pudo recoger muchas personas";
            FinSi
        FinSi
    FinSi
    
    Escribir "";
    Escribir "📍 ANÁLISIS POR PISO:";
    Para piso <- 0 Hasta numPisos - 1 Hacer
        personasRecogidas_piso <- estadoInicial[piso] - estadoFinal[piso];
        Si estadoInicial[piso] > 0 Entonces
            eficienciaPiso <- (personasRecogidas_piso / estadoInicial[piso]) * 100;
            Escribir "   • Piso ", piso, ": ", personasRecogidas_piso, "/", estadoInicial[piso], " personas recogidas (", trunc(eficienciaPiso), "%)";
        Sino
            Escribir "   • Piso ", piso, ": Sin personas esperando";
        FinSi
    FinPara

    Escribir "";
    Escribir "💡 RECOMENDACIONES:";
    Si totalPersonasQueQuedan > 0 Entonces
        Escribir "   • Se recomienda realizar un segundo viaje del ascensor";
        Escribir "   • Considerar aumentar la capacidad del ascensor para futuros casos";
    Sino
        Escribir "   • ¡Operación perfecta! No se requieren viajes adicionales";
    FinSi
FinSubProceso

SubProceso rep <- generarRepresentacionVisualPersonas(cantidad)
    Definir i Como Entero;
    Definir rep Como Caracter;
    rep <- "";
    Para i <- 1 hasta cantidad Hacer
        rep <- Concatenar(rep, "👤");
    FinPara
FinSubProceso

SubProceso total <- calcularTotalPersonas(arreglo Por Referencia, longitud)
    Definir i, suma Como Entero;
    suma <- 0;
    Para i <- 0 Hasta longitud - 1 Hacer
        suma <- suma + arreglo[i];
    FinPara
    total <- suma;
FinSubProceso 