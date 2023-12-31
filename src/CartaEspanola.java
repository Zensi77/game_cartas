public class CartaEspanola extends carta {

    //hazme el constructor y el tostring
    public CartaEspanola(String palo, int valor) {
        super(palo, valor);
    }
    //tostring
    public String toString() {
        return "CartaEspanola{" +
                "palo='" + palo + '\'' +
                ", numero=" + valor +
                '}';
    }
    
}
