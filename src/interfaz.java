import java.util.Scanner;

public class interfaz {
    static String tipoMazo;
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Ingrese el tipo de baraja: ");
        do{
            tipoMazo = sc.nextLine();
        } while(!tipoMazo.equalsIgnoreCase("poker") && !tipoMazo.equalsIgnoreCase("española") && !tipoMazo.equalsIgnoreCase("alemana"));
        baraja baraja = new baraja(tipoMazo);

        //Vamos a contruir la baraja en cuestion
        baraja.barajar();
        carta [] CartasBaraja;
        CartasBaraja = baraja.getBaraja();
        //Muestra el array de objetos carta de CartasBaraja
        for(int i = 0; i < CartasBaraja.length; i++){
            System.out.println(CartasBaraja[i]);
        }
        System.out.println(baraja.numCartas());
        
    }

}
