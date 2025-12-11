package sistemaGaraje;

import vehiculos.Auto;
import vehiculos.Moto;
import vehiculos.Vehiculo;

/**
 * Clase de prueba para el sistema de gestión de garaje.
 * Autor: Albert Lukmanov (albert.lukmanov@davinci.edu.ar)
 */
public class GarajeTest {
    
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("  SISTEMA DE GESTIÓN DE GARAJE");
        System.out.println("  Autor: Albert Lukmanov");
        System.out.println("  Email: albert.lukmanov@davinci.edu.ar");
        System.out.println("=================================================\n");
        
        Garaje garaje = new Garaje(2500.0, 5);
        
        System.out.println(">>> CONFIGURACIÓN DEL GARAJE <<<");
        System.out.println("Precio por rueda: $" + garaje.getPrecioPorRueda());
        System.out.println("Capacidad máxima: " + garaje.getCapacidadMaxima() + " vehículos\n");
        
        Auto auto1 = new Auto("Toyota", 45000.0, 4);
        Auto auto2 = new Auto("Ford", 62000.0, 2);
        Auto auto3 = new Auto("Chevrolet", 38000.0, 5);
        
        Moto moto1 = new Moto("Honda", 15000.0, 250);
        Moto moto2 = new Moto("Yamaha", 8000.0, 150);
        Moto moto3 = new Moto("Kawasaki", 22000.0, 600);
        
        System.out.println(">>> INGRESO DE VEHÍCULOS <<<\n");
        
        ingresarVehiculoConMensaje(garaje, auto1);
        ingresarVehiculoConMensaje(garaje, auto2);
        ingresarVehiculoConMensaje(garaje, moto1);
        ingresarVehiculoConMensaje(garaje, moto2);
        ingresarVehiculoConMensaje(garaje, auto3);
        
        System.out.println("\n>>> INTENTO DE INGRESAR VEHÍCULO CON GARAJE LLENO <<<\n");
        ingresarVehiculoConMensaje(garaje, moto3);
        
        System.out.println("\n=================================================");
        System.out.println("  INFORMACIÓN DEL GARAJE");
        System.out.println("=================================================\n");
        
        System.out.println("Cantidad de vehículos en el garaje: " + garaje.obtenerCantidadVehiculos());
        System.out.println("Costo total del cambio de ruedas: $" + String.format("%.2f", garaje.calcularCostoTotalCambioRuedas()));
        System.out.println("Kilometraje medio de los vehículos: " + String.format("%.2f", garaje.calcularKilometrajeMedio()) + " km\n");
        
        System.out.println(">>> LISTA DE VEHÍCULOS EN EL GARAJE <<<\n");
        int contador = 1;
        for (Vehiculo vehiculo : garaje.obtenerVehiculos()) {
            System.out.println(contador + ". " + vehiculo);
            contador++;
        }
        
        System.out.println("\n>>> RETIRO DE VEHÍCULO <<<\n");
        String marcaARetirar = "Ford";
        if (garaje.retirarVehiculo(marcaARetirar)) {
            System.out.println("✓ Vehículo marca '" + marcaARetirar + "' retirado exitosamente.");
        } else {
            System.out.println("✗ No se encontró un vehículo marca '" + marcaARetirar + "'.");
        }
        
        System.out.println("\n>>> NUEVO INTENTO DE INGRESO <<<\n");
        ingresarVehiculoConMensaje(garaje, moto3);
        
        System.out.println("\n=================================================");
        System.out.println("  INFORMACIÓN FINAL DEL GARAJE");
        System.out.println("=================================================\n");
        
        System.out.println("Cantidad de vehículos en el garaje: " + garaje.obtenerCantidadVehiculos());
        System.out.println("Costo total del cambio de ruedas: $" + String.format("%.2f", garaje.calcularCostoTotalCambioRuedas()));
        System.out.println("Kilometraje medio de los vehículos: " + String.format("%.2f", garaje.calcularKilometrajeMedio()) + " km\n");
        
        System.out.println(">>> LISTA FINAL DE VEHÍCULOS <<<\n");
        contador = 1;
        for (Vehiculo vehiculo : garaje.obtenerVehiculos()) {
            System.out.println(contador + ". " + vehiculo);
            contador++;
        }
        
        System.out.println("\n=================================================");
        System.out.println("  FIN DE LA DEMOSTRACIÓN");
        System.out.println("=================================================");
    }
    
    private static void ingresarVehiculoConMensaje(Garaje garaje, Vehiculo vehiculo) {
        if (garaje.ingresarVehiculo(vehiculo)) {
            System.out.println("✓ Vehículo ingresado: " + vehiculo.getMarca() + 
                             " (" + vehiculo.obtenerNumeroRuedas() + " ruedas)");
        } else {
            System.out.println("✗ ADVERTENCIA: No se pudo ingresar el vehículo " + vehiculo.getMarca() + 
                             ". El garaje está lleno (capacidad máxima: " + garaje.getCapacidadMaxima() + " vehículos).");
        }
    }
}

