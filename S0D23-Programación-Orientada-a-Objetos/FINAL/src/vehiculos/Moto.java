package vehiculos;

/**
 * Clase que representa una motocicleta.
 * Autor: Albert Lukmanov (albert.lukmanov@davinci.edu.ar)
 */
public class Moto extends Vehiculo {
    private int cilindrada;
    
    public Moto(String marca, double kilometraje, int cilindrada) {
        super(marca, kilometraje);
        this.cilindrada = cilindrada;
    }
    
    @Override
    public int obtenerNumeroRuedas() {
        return 2;
    }
    
    public int getCilindrada() {
        return cilindrada;
    }
    
    @Override
    public String toString() {
        return "Moto - " + super.toString() + ", Cilindrada: " + cilindrada + " cc, Ruedas: " + obtenerNumeroRuedas();
    }
}

