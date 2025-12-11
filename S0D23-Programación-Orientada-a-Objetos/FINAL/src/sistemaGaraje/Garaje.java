package sistemaGaraje;

import vehiculos.Vehiculo;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un garaje que realiza cambios de ruedas.
 * Autor: Albert Lukmanov (albert.lukmanov@davinci.edu.ar)
 */
public class Garaje {
    private double precioPorRueda;
    private int capacidadMaxima;
    private List<Vehiculo> vehiculos;
    
    public Garaje(double precioPorRueda, int capacidadMaxima) {
        this.precioPorRueda = precioPorRueda;
        this.capacidadMaxima = capacidadMaxima;
        this.vehiculos = new ArrayList<>();
    }
    
    public boolean ingresarVehiculo(Vehiculo vehiculo) {
        if (estaLleno()) {
            return false;
        }
        vehiculos.add(vehiculo);
        return true;
    }
    
    public boolean retirarVehiculo(String marca) {
        for (int i = 0; i < vehiculos.size(); i++) {
            if (vehiculos.get(i).getMarca().equalsIgnoreCase(marca)) {
                vehiculos.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public int obtenerCantidadVehiculos() {
        return vehiculos.size();
    }
    
    public double calcularCostoTotalCambioRuedas() {
        double costoTotal = 0.0;
        for (Vehiculo vehiculo : vehiculos) {
            costoTotal += precioPorRueda * vehiculo.obtenerNumeroRuedas();
        }
        return costoTotal;
    }
    
    public double calcularKilometrajeMedio() {
        if (vehiculos.isEmpty()) {
            return 0.0;
        }
        double sumaKilometraje = 0.0;
        for (Vehiculo vehiculo : vehiculos) {
            sumaKilometraje += vehiculo.getKilometraje();
        }
        return sumaKilometraje / vehiculos.size();
    }
    
    public boolean estaLleno() {
        return vehiculos.size() >= capacidadMaxima;
    }
    
    public List<Vehiculo> obtenerVehiculos() {
        return new ArrayList<>(vehiculos);
    }
    
    public double getPrecioPorRueda() {
        return precioPorRueda;
    }
    
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }
}

