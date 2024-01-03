import java.util.Scanner;

public class interfaz {
    static String entrar = "a", tipoMazo = "";
    static int score1 = 0, score2 = 0;
    static boolean barajada = false, creada = false;
    static Scanner sc = new Scanner(System.in);
    static carta player1 = new carta();
    static carta player2 = new carta();
    static baraja miBaraja;
    static carta [] CartasRestantes;

    public static void main(String[] args) {
        int opcion = -1;
        // Mensaje de bienvenida al juego
        System.out.println("Bienvenido al juego de baraja");
        System.out.println("Presione enter para iniciar el juego");
        do {
            entrar = sc.nextLine();
        } while (!entrar.equals(""));

        // Menu
        while (opcion != 0) {
        System.out.println("****************************************");
        System.out.println("Elige una de las siguientes opciones: ");
        System.out.println("1. Elegir tipo de mazo");
        System.out.println("2. Barajar");
        System.out.println("3. Siguiente ronda");
        System.out.println("4. Numero de cartas restantes");
        System.out.println("5. Ver cartas que quedan en la baraja");
        System.out.println("6. Reiniciar");
        System.out.println("0. Salir");
        System.out.println("****************************************");

        // leer opcion
            System.out.println("Opcion: ");
            do {
                opcion = sc.nextInt();
                sc.nextLine();
                if(opcion != 1 && !creada){
                    System.out.println("Primero, has de crear el Mazo");
                    opcion = 1;
                } 
            if (opcion != 2 && !barajada && creada) {
                    System.out.println("Para empezar a jugar, has de barajar el mazo, dejalo, ya lo hago yo...");
                    opcion = 2;
                }
            } while (opcion < 0 || opcion > 6);
            
            
            // switch de cada opcion
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            switch (opcion) {
                case 1:
                    crearMazo();
                    creada = true;
                    break;
                case 2:
                    Barajar();
                    barajada = true;
                    break;
                case 3:
                    NextRound();
                    break;
                case 4:
                    System.out.println("Numero de cartas restantes: " + miBaraja.numCartas());
                    break;
                case 5:
                    cartasRest();
                    break;
                    case 6:
                    Reiniciar();
                    break;
                case 0:
                    break;
            
            }
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        //Validador de que no haya acabado la partida
        if(creada && barajada && miBaraja.numCartas() == 0){
            System.out.println("NO QUEDAN MAS CARTAS!!");
            if(score1 > score2){
                System.out.println("EL PRIMER JUGADOR HA GANADO!!");
            } else if(score1 < score2){
                System.out.println("EL SEGUNDO JUGADOR HA GANADO!!");
            } else {
                System.out.println("EMPATE!!");
            }
            System.out.println("SIGUIENTE PARTIDA!!");
            Reiniciar();
        }

        }
    }

    public static void crearMazo() {
        System.out.println("Ingrese el tipo de baraja: ");
        do {
            tipoMazo = sc.nextLine();
        } while (!tipoMazo.equalsIgnoreCase("poker") && !tipoMazo.equalsIgnoreCase("espanola")
                && !tipoMazo.equalsIgnoreCase("alemana"));
        miBaraja = new baraja(tipoMazo);
    }

    public static void Barajar() {
        miBaraja.barajar();
    }

    public static void NextRound() {
        player1 = miBaraja.Siguiente();
        player2 = miBaraja.Siguiente();
        System.out.println("Carta del primer jugador: " + player1.toString());
        System.out.println("Carta del segundo jugador: " + player2.toString());
        if (player1.getValor() > player2.getValor()) {
            score1++;
            System.out.println("El primer jugador gana");
        } else if (player1.getValor() < player2.getValor()) {
            score2++;
            System.out.println("El segundo jugador gana");
        } else {
            switch (tipoMazo) {
                case "poker":
                    if (player1.getPalo().equals(player2.getPalo())) {
                        System.out.println("Empate");
                    } else if (player1.getPalo().equalsIgnoreCase("Corazones")) {
                        System.out.println("El primer jugador gana");
                        score1++;
                    } else if (player2.getPalo().equalsIgnoreCase("Corazones")) {
                        System.out.println("El segundo jugador gana");
                        score2++;
                    } else if (player1.getPalo().equalsIgnoreCase("Rombos")) {
                        System.out.println("El primer jugador gana");
                        score1++;
                    } else if (player2.getPalo().equalsIgnoreCase("Rombos")) {
                        System.out.println("El segundo jugador gana");
                        score2++;
                    } else if (player1.getPalo().equalsIgnoreCase("Treboles")) {
                        System.out.println("El primer jugador gana");
                        score1++;
                    } else if (player2.getPalo().equalsIgnoreCase("Treboles")) {
                        System.out.println("El segundo jugador gana");
                        score2++;
                    } else if (player1.getPalo().equalsIgnoreCase("Corazones")) {
                        System.out.println("El primer jugador gana");
                        score1++;
                    } else if (player2.getPalo().equalsIgnoreCase("Corazones")) {
                        System.out.println("El segundo jugador gana");
                        score2++;
                    }
                    break;
                case "espanola":
                    if (player1.getPalo().equals(player2.getPalo())) {
                        System.out.println("Empate");
                    } else if (player1.getPalo().equalsIgnoreCase("Oros")) {
                        System.out.println("El primer jugador gana");
                        score1++;
                    } else if (player2.getPalo().equalsIgnoreCase("Oros")) {
                        System.out.println("El segundo jugador gana");
                        score2++;
                    } else if (player1.getPalo().equalsIgnoreCase("Copas")) {
                        System.out.println("El primer jugador gana");
                        score1++;
                    } else if (player2.getPalo().equalsIgnoreCase("Copas")) {
                        System.out.println("El segundo jugador gana");
                        score2++;
                    } else if (player1.getPalo().equalsIgnoreCase("Espadas")) {
                        System.out.println("El primer jugador gana");
                        score1++;
                    } else if (player2.getPalo().equalsIgnoreCase("Espadas")) {
                        System.out.println("El segundo jugador gana");
                        score2++;
                    } else if (player1.getPalo().equalsIgnoreCase("Bastos")) {
                        System.out.println("El primer jugador gana");
                        score1++;
                    } else if (player2.getPalo().equalsIgnoreCase("Bastos")) {
                        System.out.println("El segundo jugador gana");
                        score2++;
                    }

                    break;
                case "alemana":
                    if (player1.getPalo().equals(player2.getPalo())) {
                        System.out.println("Empate");
                    } else if (player1.getPalo().equalsIgnoreCase("Bellotas")) {
                        System.out.println("El primer jugador gana");
                        score1++;
                    } else if (player2.getPalo().equalsIgnoreCase("Bellotas")) {
                        System.out.println("El segundo jugador gana");
                        score2++;
                    } else if (player1.getPalo().equalsIgnoreCase("Campanas")) {
                        System.out.println("El primer jugador gana");
                        score1++;
                    } else if (player2.getPalo().equalsIgnoreCase("Campanas")) {
                        System.out.println("El segundo jugador gana");
                        score2++;
                    } else if (player1.getPalo().equalsIgnoreCase("Pastos")) {
                        System.out.println("El primer jugador gana");
                        score1++;
                    } else if (player2.getPalo().equalsIgnoreCase("Pastos")) {
                        System.out.println("El segundo jugador gana");
                        score2++;
                    } else if (player1.getPalo().equalsIgnoreCase("Corazones")) {
                        System.out.println("El primer jugador gana");
                        score1++;
                    } else if (player2.getPalo().equalsIgnoreCase("Corazones")) {
                        System.out.println("El segundo jugador gana");
                        score2++;
                    }
            }
        }
        System.out.println("El puntaje del primer jugador es: " + score1);
        System.out.println("El puntaje del segundo jugador es: " + score2);
    }

    public static void cartasRest() {
        CartasRestantes = miBaraja.getBaraja();
         //Muestra el array de objetos carta de CartasBaraja
         for(int i = 0; i < CartasRestantes.length; i++){
         System.out.println(CartasRestantes[i]);
         }
    }

    public static void Reiniciar() {
        miBaraja.reiniciar();
        creada = false;
        barajada = false;
        score1 = 0;
        score2 = 0;
    }

}
