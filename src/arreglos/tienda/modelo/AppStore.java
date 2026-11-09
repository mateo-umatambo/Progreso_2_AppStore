package arreglos.tienda.modelo;

public class AppStore {
    private static final int MAX =4;
    private Juego juegos[];
    private int cont;

    public AppStore(){
        juegos = new Juego[MAX];
        cont = -1;
        cargarDatos();
    }

    private void cargarDatos(){
        juegos[++cont] = new Juego("Fortnite", "Interactivo", 15, 45, 50);
        juegos[++cont] = new Juego("Valorant", "Todo Publico", 230, 1, 300);
    }

    public Juego[] getJuegos() {
        return juegos;
    }

    public void agregarJuegos(Juego j){ //en lugar del metodo SET
        if (j != null && cont < MAX -1){
            juegos[++cont] = j;
        }
    }

    public Juego buscarJuego(String nombre){
        for (int i = 0; i < cont; i ++){
            if (juegos[i].getNombre().equalsIgnoreCase(nombre)){
                return juegos[i];
            }
        }
        return null;
    }

    public boolean comprar(String nombre, int cantidad){
        Juego j1 = buscarJuego(nombre);
        if (j1 != null){
            return j1.comprar(cantidad);
        }
        return false;
    }

    public double vender(String nombre, int cantidad){
        Juego j1 = buscarJuego(nombre);
        if (j1 != null){
            if (j1.vender(cantidad)){
                return cantidad * j1.getPrecio();
            }
        }
        return 0;
    }
}
