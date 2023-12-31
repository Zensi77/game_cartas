public class CartaPoker extends carta{
    //constructor
    public CartaPoker(String palo, int valor){
        super(palo, valor);
    }

    //tostring
    public String toString(){
        return "CartaPoker{" +
                "palo='" + palo + '\'' +
                ", valor=" + valor +
                '}';
    }
}
