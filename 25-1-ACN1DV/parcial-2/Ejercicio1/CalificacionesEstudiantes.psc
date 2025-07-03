Proceso Principal_CalificacionesEstudiantes
    // Constantes del programa
    Definir CANTIDAD_ESTUDIANTES Como Entero;
    CANTIDAD_ESTUDIANTES <- 10;
    Definir NOTA_MINIMA_APROBADO Como Real;
    NOTA_MINIMA_APROBADO <- 4.0;
    Definir NOTA_MINIMA_PROMOVIDO Como Real;
    NOTA_MINIMA_PROMOVIDO <- 7.0;
    Definir NOTA_MINIMA Como Real;
    NOTA_MINIMA <- 1.0;
    Definir NOTA_MAXIMA Como Real;
    NOTA_MAXIMA <- 10.0;

    // Declaración de arreglos paralelos
    Dimension nombresEstudiantes[CANTIDAD_ESTUDIANTES];
    Dimension calificacionesEstudiantes[CANTIDAD_ESTUDIANTES];

    Escribir "=== SISTEMA DE CALIFICACIONES DE ESTUDIANTES ===";
    Escribir "";

    // Entrada manual de nombres de estudiantes
    ingresarNombresEstudiantes(nombresEstudiantes, CANTIDAD_ESTUDIANTES);

    // Generación aleatoria de calificaciones
    generarCalificacionesAleatorias(calificacionesEstudiantes, CANTIDAD_ESTUDIANTES, NOTA_MINIMA, NOTA_MAXIMA);

    // Mostrar información de todos los estudiantes
    mostrarInformacionEstudiantes(nombresEstudiantes, calificacionesEstudiantes, CANTIDAD_ESTUDIANTES);

    // Calcular y mostrar estadísticas
    calcularYMostrarEstadisticas(nombresEstudiantes, calificacionesEstudiantes, CANTIDAD_ESTUDIANTES, NOTA_MINIMA_APROBADO, NOTA_MINIMA_PROMOVIDO);
FinProceso

SubProceso ingresarNombresEstudiantes(nombres Por Referencia, cantidad)
    Definir i Como Entero;
    Escribir "--- INGRESO DE NOMBRES DE ESTUDIANTES ---";
    Para i <- 0 Hasta cantidad - 1 Hacer
        Escribir "Ingrese el nombre del estudiante ", i + 1, ": ";
        Leer nombres[i];
    FinPara
    Escribir "";
FinSubProceso

SubProceso generarCalificacionesAleatorias(calificaciones Por Referencia, cantidad, minNota, maxNota)
    Definir i Como Entero;
    Escribir "--- GENERANDO CALIFICACIONES ALEATORIAS ---";
    Para i <- 0 Hasta cantidad - 1 Hacer
        // Generar calificación aleatoria entre minNota y maxNota
        calificaciones[i] <- Azar(maxNota * 100 - minNota * 100 + 1) / 100 + minNota;
        // PSeInt no tiene una función para redondear a 2 decimales directamente, la fórmula anterior aproxima
    FinPara
    Escribir "Calificaciones generadas exitosamente.";
    Escribir "";
FinSubProceso

SubProceso mostrarInformacionEstudiantes(nombres Por Referencia, calificaciones Por Referencia, cantidad)
    Definir i Como Entero;
    Definir estado Como Caracter;
    Escribir "--- INFORMACIÓN DE ESTUDIANTES ---";
    Escribir "Nombre                Calificación  Estado";
    Escribir "------------------------------------------------";
    
    Para i <- 0 Hasta cantidad - 1 Hacer
        estado <- determinarEstadoEstudiante(calificaciones[i]);
        Escribir Sin Saltar, nombres[i];
        // Simulación de printf para formato
        Definir espacios, j Como Entero;
        espacios <- 22 - Longitud(nombres[i]);
        Para j <- 1 Hasta espacios Hacer
            Escribir Sin Saltar " ";
        FinPara
        Escribir calificaciones[i], "      ", estado;
    FinPara
    Escribir "";
FinSubProceso

SubProceso estado <- determinarEstadoEstudiante(calificacion)
    Si calificacion >= 7.0 Entonces
        estado <- "Promovido";
    Sino
        Si calificacion >= 4.0 Entonces
            estado <- "Aprobado";
        Sino
            estado <- "Reprobado";
        FinSi
    FinSi
FinSubProceso

SubProceso calcularYMostrarEstadisticas(nombres Por Referencia, calificaciones Por Referencia, cantidad, notaAprobado, notaPromovido)
    Definir cantidadAprobados, cantidadPromovidos, cantidadReprobados, i Como Entero;
    Definir calificacionMasAlta, sumaCalificaciones, promedioGeneral, calificacion Como Real;
    Definir estudianteMejorNota Como Caracter;

    cantidadAprobados <- 0;
    cantidadPromovidos <- 0;
    cantidadReprobados <- 0;
    
    calificacionMasAlta <- calificaciones[0];
    estudianteMejorNota <- nombres[0];
    
    sumaCalificaciones <- 0.0;
    
    Para i <- 0 Hasta cantidad - 1 Hacer
        calificacion <- calificaciones[i];
        
        Si calificacion >= notaPromovido Entonces
            cantidadPromovidos <- cantidadPromovidos + 1;
            cantidadAprobados <- cantidadAprobados + 1;
        Sino
            Si calificacion >= notaAprobado Entonces
                cantidadAprobados <- cantidadAprobados + 1;
            Sino
                cantidadReprobados <- cantidadReprobados + 1;
            FinSi
        FinSi
        
        Si calificacion > calificacionMasAlta Entonces
            calificacionMasAlta <- calificacion;
            estudianteMejorNota <- nombres[i];
        FinSi
        
        sumaCalificaciones <- sumaCalificaciones + calificacion;
    FinPara
    
    promedioGeneral <- sumaCalificaciones / cantidad;
    
    mostrarEstadisticasFinales(cantidadAprobados, cantidadPromovidos, cantidadReprobados, calificacionMasAlta, estudianteMejorNota, promedioGeneral, cantidad, notaAprobado, notaPromovido);
FinSubProceso

SubProceso mostrarEstadisticasFinales(aprobados, promovidos, reprobados, mejorNota, mejorEstudiante, promedio, cantidadTotal, notaAprobado, notaPromovido)
    Definir porcentajeAprobados, porcentajePromovidos Como Real;

    Escribir "=== ESTADÍSTICAS FINALES ===";
    Escribir "";
    
    Escribir "📊 RESUMEN DE CALIFICACIONES:";
    Escribir "   • Estudiantes aprobados (nota >= ", notaAprobado, "): ", aprobados;
    Escribir "   • Estudiantes promovidos (nota >= ", notaPromovido, "): ", promovidos;
    Escribir "   • Estudiantes reprobados (nota < ", notaAprobado, "): ", reprobados;
    Escribir "";
    
    Escribir "🏆 MEJOR CALIFICACIÓN:";
    Escribir "   • Estudiante: ", mejorEstudiante;
    Escribir "   • Calificación: ", mejorNota;
    Escribir "";
    
    Escribir "📈 PROMEDIO GENERAL:";
    Escribir "   • Promedio de todas las calificaciones: ", promedio;
    Escribir "";
    
    porcentajeAprobados <- (aprobados / cantidadTotal) * 100;
    porcentajePromovidos <- (promovidos / cantidadTotal) * 100;
    
    Escribir "📋 ANÁLISIS DEL GRUPO:";
    Escribir "   • Porcentaje de aprobación: ", porcentajeAprobados, "%";
    Escribir "   • Porcentaje de promoción: ", porcentajePromovidos, "%";
    
    Si porcentajeAprobados >= 80 Entonces
        Escribir "   • ✅ Excelente rendimiento del grupo";
    Sino
        Si porcentajeAprobados >= 60 Entonces
            Escribir "   • ⚠️ Rendimiento aceptable del grupo";
        Sino
            Escribir "   • ❌ El grupo necesita apoyo adicional";
        FinSi
    FinSi
FinSubProceso
