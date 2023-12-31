package juego_cartas.src;

public class baraja {
    private int ncartas, proxima = 0;
    private carta[] Mazo;
    private carta[] Mazobarajado;
    private carta[] CartasRestantes;

    public baraja(String baraja) {
        //Creamos los diferentes tipos de barajas, rellenando los mazos por orden
        if (baraja.equalsIgnoreCase("poker")) {
            ncartas = 52;
            Mazo = new carta[ncartas];
            for (int i = 0; i < Mazo.length; i++) {
                if (i <= 12) Mazo[i] = new CartaPoker("Picas", i + 1);
                
                if (i > 12 && i <= 25) Mazo[i] = new CartaPoker("Corazones", i - 12);

                if (i > 25 && i <= 38) Mazo[i] = new CartaPoker("Diamantes", i - 25);
                
                if (i > 38 && i <= 51) Mazo[i] = new CartaPoker("Treboles", i - 38);

            }
        }
        if (baraja.equalsIgnoreCase("española")) {
            ncartas = 48;
            Mazo = new carta[ncartas];
            for (int i = 0; i < 48; i++) {
                if (i <= 11) {
                    if(i != 8 && i != 9) new CartaEspanola("Oros", i + 1);
                }
                if (i > 11 && i <= 23) {
                    if(i - 11 != 8 && i - 11 != 9) Mazo[i] = new CartaPoker("Bastos", i - 11);
                }
                if (i > 23 && i <= 35) {
                    if(i - 23 != 8 && i - 23 != 9) Mazo[i] = new CartaPoker("Espadas", i - 23);
                }
                if (i > 35 && i <= 47) {
                    if(i - 35 != 8 && i - 35 != 9) Mazo[i] = new CartaPoker("Copas", i - 35);
                }
            }
        }
        if (baraja.equalsIgnoreCase("alemana")) {
            ncartas = 36;
            Mazo = new carta[ncartas];
            for(int i = 0; i < 4; i++) {
                for(int j = 6; j <= 14; j++) {
                    if (i == 0) Mazo[ncartas - 1] = new CartaAlemana("Campanas", j);
                    if (i == 1) Mazo[ncartas] = new CartaAlemana("Pastos", j);
                    if (i == 2) Mazo[ncartas] = new CartaAlemana("Corazones", j);
                    if (i == 3) Mazo[ncartas] = new CartaAlemana("Bellotas", j);
                    ncartas--;
                }
            }
            ncartas = 36;
        }
    }

    public void barajar() {
        Mazobarajado = new carta[ncartas];

        for (int i = 0; i < Mazobarajado.length; i++) {
            int random = Math.random() * ncartas;
            if( Mazo[random] != null) {
                Mazobarajado[i] = Mazo[random]; 
                Mazo[random] = null;
            }
        }
    }

    public carta Siguiente() {
        carta siguiente = Mazobarajado[proxima];
        Mazobarajado[proxima] = null;
        proxima++;
        return siguiente;
    }

    public void reiniciar() {
        //Segun mi concepto, regenero el array de cartas, PERO SIN BARAJARLAS
        //Lo voy a hacer poniendo el Array barajado a null, comprobando en la interfaz si este esta a null, como condicion para empezar la partida
        for(int i = 0; i < Mazobarajado.length; i++) Mazobarajado[i] = null;
    }

    public int numCartas() {
        int contadorCartas = 0;
        for(int i = 0; i < Mazobarajado.length; i++) if(Mazobarajado[i] != null) contadorCartas++;
        return contadorCartas;
    }

    public carta[] getBaraja() {
        CartasRestantes = new carta[ncartas];
        for(int i = 0; i < Mazobarajado.length; i++) 
            if (Mazobarajado[i] != null) CartasRestantes[i] = Mazobarajado[i];
        return CartasRestantes;
    }

    public String toString() {
        return CartasRestantes.toString();
    }

}
