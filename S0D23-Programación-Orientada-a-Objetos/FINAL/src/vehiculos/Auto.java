package vehiculos;

/**
 * Clase que representa un automóvil.
 * Autor: Albert Lukmanov (albert.lukmanov@davinci.edu.ar)
 */
public class Auto extends Vehiculo {
    private int numeroPuertas;
    
    public Auto(String marca, double kilometraje, int numeroPuertas) {
        super(marca, kilometraje);
        this.numeroPuertas = numeroPuertas;
    }
    
    @Override
    public int obtenerNumeroRuedas() {
        return 4;
    }
    
    public int getNumeroPuertas() {
        return numeroPuertas;
    }
    
    @Override
    public String toString() {
        return "Auto - " + super.toString() + ", Puertas: " + numeroPuertas + ", Ruedas: " + obtenerNumeroRuedas();
    }
}

