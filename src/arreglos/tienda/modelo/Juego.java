package arreglos.tienda.modelo;

public class Juego {
    private String nombre;
    private String categoria;
    private int memoria;
    private double precio;
    private int licenciasDisponibles;
    private int licenciasVendidas;

    public Juego(String nombre, String categoria, int memoria, double precio, int licenciasDisponibles){
        this.nombre = nombre;
        this.categoria = categoria;
        this.memoria = memoria;
        this.precio = precio;
        this.licenciasDisponibles = licenciasDisponibles;
        licenciasVendidas = 0;
    }

    //Getters

    public String getCategoria() {
        return categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public int getMemoria() {
        return memoria;
    }

    public double getPrecio() {
        return precio;
    }

    public int getLicenciasVendidas() {
        return licenciasVendidas;
    }

    public int getLicenciasDisponibles() {
        return licenciasDisponibles;
    }

    //Setters

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCategoria(String categoria) {
        if (categoria != null && !categoria.trim().isEmpty())
            this.categoria = categoria;
    }

    public void setMemoria(int memoria){
        if (memoria > 0)
            this.memoria = memoria;
    }

    public boolean comprar(int cantidad){
        if (cantidad > 0){
            licenciasDisponibles += cantidad;
            return true;
        }
        return false;
    }

    public boolean vender(int cantidad){
        if (cantidad > 0 && cantidad <= licenciasDisponibles){
            licenciasDisponibles -= cantidad;
            licenciasVendidas += cantidad;
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        return "Juego{" +
                "nombre='" + nombre + '\'' +
                ", categoria='" + categoria + '\'' +
                ", memoria=" + memoria +
                ", precio=" + precio +
                ", licenciasDisponibles=" + licenciasDisponibles +
                ", licenciasVendidas=" + licenciasVendidas +
                '}';
    }

    public void setPrecio(double precio) {
        if (precio > 0)
            this.precio = precio;
    }
}
