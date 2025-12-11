package vehiculos;

/**
 * Clase abstracta que representa un vehículo genérico.
 * Autor: Albert Lukmanov (albert.lukmanov@davinci.edu.ar)
 */
public abstract class Vehiculo {
    private String marca;
    private double kilometraje;
    
    public Vehiculo(String marca, double kilometraje) {
        this.marca = marca;
        this.kilometraje = kilometraje;
    }
    
    public String getMarca() {
        return marca;
    }
    
    public double getKilometraje() {
        return kilometraje;
    }
    
    public abstract int obtenerNumeroRuedas();
    
    @Override
    public String toString() {
        return "Marca: " + marca + ", Kilometraje: " + kilometraje + " km";
    }
}

