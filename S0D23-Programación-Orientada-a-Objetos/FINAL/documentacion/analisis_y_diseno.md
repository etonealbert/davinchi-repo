# Análisis y Diseño del Sistema de Gestión de Garaje

**Autor:** Albert Lukmanov  
**Email:** albert.lukmanov@davinci.edu.ar  
**Curso:** Programación Orientada a Objetos

---

## 1. Descripción del Dominio del Problema

El sistema modela un **garaje** que ofrece servicios de cambio de ruedas para vehículos. El garaje debe gestionar dos tipos de vehículos: **automóviles** y **motocicletas**.

### Operaciones principales del sistema:

- **Apertura del garaje:** Al iniciar operaciones, el garaje establece un precio fijo por cada rueda cambiada y define una capacidad máxima de vehículos que puede almacenar simultáneamente.

- **Ingreso de vehículos:** Los clientes pueden registrar sus vehículos en el garaje para el servicio de cambio de ruedas. El sistema debe verificar que haya espacio disponible antes de aceptar un nuevo vehículo.

- **Retiro de vehículos:** Una vez completado el servicio, los vehículos pueden ser retirados del garaje, liberando espacio para otros clientes.

- **Consultas del sistema:**
  - Cantidad total de vehículos actualmente en el garaje
  - Costo total del cambio de ruedas para todos los vehículos
  - Kilometraje medio de todos los vehículos registrados

### Características de los vehículos:

- **Automóviles:** tienen 4 ruedas, además de marca, número de puertas y kilometraje.
- **Motocicletas:** tienen 2 ruedas, además de marca, cilindrada y kilometraje.

---

## 2. Identificación de Objetos y Clases

### Clase `Vehiculo` (Abstracta)

**Responsabilidades:**
- Almacenar información común a todos los vehículos (marca, kilometraje)
- Definir el contrato para obtener el número de ruedas (método abstracto)
- Proporcionar métodos de acceso a los atributos comunes
- Generar una representación textual del vehículo

**Atributos:**
- `marca` (String): marca del vehículo
- `kilometraje` (double): kilometraje acumulado del vehículo

**Métodos:**
- `getMarca()`: retorna la marca
- `getKilometraje()`: retorna el kilometraje
- `obtenerNumeroRuedas()`: método abstracto que deben implementar las subclases
- `toString()`: representación textual del vehículo

### Clase `Auto`

**Responsabilidades:**
- Representar un automóvil con sus características específicas
- Implementar el número de ruedas (4 para autos)
- Gestionar información sobre el número de puertas

**Atributos:**
- Hereda `marca` y `kilometraje` de `Vehiculo`
- `numeroPuertas` (int): cantidad de puertas del automóvil

**Métodos:**
- Constructor para inicializar marca, kilometraje y número de puertas
- `obtenerNumeroRuedas()`: retorna 4
- `getNumeroPuertas()`: retorna el número de puertas
- `toString()`: información completa del auto

### Clase `Moto`

**Responsabilidades:**
- Representar una motocicleta con sus características específicas
- Implementar el número de ruedas (2 para motos)
- Gestionar información sobre la cilindrada del motor

**Atributos:**
- Hereda `marca` y `kilometraje` de `Vehiculo`
- `cilindrada` (int): cilindrada del motor en cc

**Métodos:**
- Constructor para inicializar marca, kilometraje y cilindrada
- `obtenerNumeroRuedas()`: retorna 2
- `getCilindrada()`: retorna la cilindrada
- `toString()`: información completa de la moto

### Clase `Garaje`

**Responsabilidades:**
- Gestionar la colección de vehículos registrados
- Controlar la capacidad máxima del garaje
- Calcular costos totales de servicio
- Calcular estadísticas de los vehículos (kilometraje medio)
- Proporcionar operaciones de ingreso y retiro de vehículos

**Atributos:**
- `precioPorRueda` (double): precio por cambiar una rueda
- `capacidadMaxima` (int): número máximo de vehículos que puede almacenar
- `vehiculos` (List<Vehiculo>): colección de vehículos actualmente en el garaje

**Métodos:**
- Constructor para establecer precio por rueda y capacidad máxima
- `ingresarVehiculo(Vehiculo)`: intenta agregar un vehículo, retorna booleano indicando éxito
- `retirarVehiculo(String marca)`: retira un vehículo por su marca
- `obtenerCantidadVehiculos()`: retorna el número de vehículos actuales
- `calcularCostoTotalCambioRuedas()`: calcula el costo total sumando precio × ruedas de cada vehículo
- `calcularKilometrajeMedio()`: calcula el promedio de kilometraje de todos los vehículos
- `estaLleno()`: verifica si el garaje alcanzó su capacidad máxima
- `obtenerVehiculos()`: retorna la lista de vehículos (para consultas)

### Clase `GarajeTest`

**Responsabilidades:**
- Servir como punto de entrada del programa (método main)
- Demostrar el funcionamiento del sistema
- Crear instancias de prueba del garaje y varios vehículos
- Mostrar información por consola sobre las operaciones realizadas

---

## 3. Relaciones entre Clases

### Herencia (Generalización/Especialización)

- **`Vehiculo`** es la clase base abstracta
- **`Auto`** extiende `Vehiculo`: especializa el concepto de vehículo para automóviles
- **`Moto`** extiende `Vehiculo`: especializa el concepto de vehículo para motocicletas

Esta jerarquía permite aprovechar el **polimorfismo**: el garaje puede trabajar con referencias de tipo `Vehiculo` sin necesidad de saber si es un auto o una moto, delegando comportamientos específicos (como el número de ruedas) a cada subclase.

### Composición/Agregación

- **`Garaje`** contiene una colección de **`Vehiculo`** (agregación)
- El garaje no es responsable del ciclo de vida completo de los vehículos (pueden existir antes de ingresar y después de retirarse)
- Relación de cardinalidad: 1 Garaje contiene 0..* Vehículos (limitado por capacidadMaxima)

---

## 4. Decisiones de Diseño Importantes

### 4.1. Clase Abstracta `Vehiculo`

Se decidió hacer `Vehiculo` una clase abstracta (en lugar de una interfaz o clase concreta) porque:
- Hay comportamiento y estado común que se puede compartir (marca, kilometraje)
- El método `obtenerNumeroRuedas()` debe ser implementado por cada tipo específico
- Se establece un contrato claro para todas las subclases

### 4.2. Control de Capacidad

El control de capacidad se implementa mediante:
- Atributo `capacidadMaxima` en el `Garaje`
- Método `ingresarVehiculo()` que verifica el espacio disponible antes de agregar
- Retorno de un valor booleano (`true` si se agregó, `false` si el garaje está lleno)
- Esto permite al código cliente manejar el caso de rechazo y mostrar un mensaje apropiado

### 4.3. Cálculo del Costo Total

El costo total se calcula mediante:
```
CostoTotal = Σ (precioPorRueda × numeroRuedasDelVehiculo)
```

Gracias al polimorfismo, el método `calcularCostoTotalCambioRuedas()` del garaje itera sobre la lista de vehículos y llama a `obtenerNumeroRuedas()` en cada uno, sin necesidad de verificar el tipo específico. Cada subclase proporciona el número correcto de ruedas.

### 4.4. Cálculo del Kilometraje Medio

El kilometraje medio se obtiene sumando el kilometraje de todos los vehículos y dividiendo por la cantidad total. Se maneja el caso especial de garaje vacío retornando 0.0 para evitar división por cero.

### 4.5. Uso de ArrayList

Se utiliza `ArrayList<Vehiculo>` para almacenar los vehículos porque:
- Permite tamaño dinámico (aunque controlado por capacidadMaxima)
- Proporciona acceso eficiente a los elementos
- Facilita operaciones de agregar y eliminar

### 4.6. Método de Retiro por Marca

Para simplificar la demostración, el método `retirarVehiculo()` busca por marca. En un sistema real, se usaría un identificador único (matrícula, ID, etc.), pero para este proyecto académico, la marca es suficiente para identificar vehículos.

---

## 5. Justificación del Uso de Orientación a Objetos

### Encapsulación
- Los atributos son privados y se acceden mediante getters
- La lógica interna del garaje está oculta al exterior
- Cada clase tiene responsabilidades bien definidas

### Herencia
- `Auto` y `Moto` heredan comportamiento común de `Vehiculo`
- Se evita duplicación de código
- Se establece una jerarquía conceptual clara

### Polimorfismo
- El garaje trabaja con referencias de tipo `Vehiculo`
- Cada subclase implementa `obtenerNumeroRuedas()` de manera específica
- El código del garaje no necesita distinguir entre tipos de vehículos

### Abstracción
- `Vehiculo` define el contrato que deben cumplir todos los vehículos
- Se modelan solo los aspectos relevantes del problema
- Se ocultan detalles de implementación innecesarios

---

## 6. Extensibilidad del Sistema

El diseño permite extensiones futuras fácilmente:
- **Nuevos tipos de vehículos:** se pueden agregar (camiones, bicicletas) simplemente extendiendo `Vehiculo`
- **Nuevos servicios:** se pueden agregar métodos al `Garaje` para otros servicios
- **Identificación mejorada:** se puede agregar un atributo ID o matrícula a `Vehiculo`
- **Historial:** se puede mantener un registro de vehículos que han pasado por el garaje

---

**Conclusión:** El sistema aprovecha los principios de la programación orientada a objetos para crear una solución flexible, mantenible y fácil de entender, cumpliendo con todos los requisitos del proyecto final.

