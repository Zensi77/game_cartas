package juego_cartas.src;
public class CartaAlemana extends carta {
    public CartaAlemana(int valor, String palo) {
        super(palo, valor);
    }
    
    public String toString() {
        return "CartaAlemana{" +
                "palo='" + palo + '\'' +
                ", valor=" + valor +
                '}';
    }

    

    
}
