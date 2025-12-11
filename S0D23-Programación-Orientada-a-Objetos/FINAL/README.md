# Sistema de Gestión de Garaje

**Autor:** Albert Lukmanov  
**Email:** albert.lukmanov@davinci.edu.ar

## Descripción

Este proyecto implementa un sistema de gestión para un garaje que realiza cambios de ruedas para automóviles y motocicletas. El sistema permite registrar vehículos, retirarlos, calcular costos totales de cambio de ruedas y obtener estadísticas como el kilometraje medio de todos los vehículos.

## Características

- Registro y retiro de vehículos (autos y motos)
- Control de capacidad máxima del garaje
- Cálculo del costo total de cambio de ruedas
- Cálculo del kilometraje medio de todos los vehículos
- Gestión diferenciada por tipo de vehículo (4 ruedas para autos, 2 para motos)

## Compilación y Ejecución

### Compilar el proyecto

Desde el directorio `FINAL`:

```bash
javac -d bin src/vehiculos/*.java src/sistemaGaraje/*.java
```

### Ejecutar el programa

```bash
java -cp bin sistemaGaraje.GarajeTest
```

### Alternativa sin directorio bin

```bash
javac src/vehiculos/*.java src/sistemaGaraje/*.java
java -cp src sistemaGaraje.GarajeTest
```

## Estructura del Proyecto

- `src/vehiculos/` - Clases relacionadas con vehículos (Vehiculo, Auto, Moto)
- `src/sistemaGaraje/` - Clases del sistema de gestión (Garaje, GarajeTest)
- `documentacion/` - Análisis, diseño y diagramas UML del proyecto

## Tecnologías

- Java SE
- Programación Orientada a Objetos
- UML

