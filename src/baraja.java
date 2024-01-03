public class baraja {
    private int ncartas, proxima = 0, random, index;
    private carta[] Mazo;
    private carta[] Mazobarajado;
    private carta[] CartasRestantes;

    public baraja(String baraja) {
        System.out.println("Creando Mazo!!..");
        // Variable clave para recorrer los mazos, ya que recorrelos con ncartas no
        // funciona bien
        index = 0;
        // Creamos los diferentes tipos de barajas, rellenando los mazos por orden
        if (baraja.equalsIgnoreCase("poker")) {
            ncartas = 52;
            Mazo = new carta[ncartas];
            /*
             * Forma matematica que funciona, pero mas fácil todavia
             * for (int i = 0; i < Mazo.length; i++) {
             * if (i <= 12)
             * Mazo[i] = new CartaPoker("Picas", i);
             * 
             * else if (i <= 25)
             * Mazo[i] = new CartaPoker("Corazones", i - 12);
             * 
             * else if (i <= 38)
             * Mazo[i] = new CartaPoker("Diamantes", i - 25);
             * 
             * else if (i <= 51)
             * Mazo[i] = new CartaPoker("Treboles", i - 38);
             * 
             * }
             */
            for (int palo = 0; palo < 4; palo++) {
                for (int valor = 1; valor <= 13; valor++) {
                    switch (palo) {
                        case 0:
                            Mazo[index] = new CartaPoker("Picas", valor);
                            break;
                        case 1:
                            Mazo[index] = new CartaPoker("Treboles", valor);
                            break;
                        case 2:
                            Mazo[index] = new CartaPoker("Rombos", valor);
                            break;
                        case 3:
                            Mazo[index] = new CartaPoker("Corazones", valor);
                            break;
                    }
                    index++;
                }
            }
        }
        if (baraja.equalsIgnoreCase("espanola")) {
            ncartas = 40;
            Mazo = new carta[ncartas];
            for (int palo = 0; palo < 4; palo++) {
                for (int valor = 1; valor <= 12; valor++) {
                    if (valor != 8 && valor != 9) {

                        switch (palo) {
                            case 0:
                                Mazo[index] = new CartaEspanola("Oros", valor);
                                break;
                            case 1:
                                Mazo[index] = new CartaEspanola("Copas", valor);
                                break;
                            case 2:
                                Mazo[index] = new CartaEspanola("Espadas", valor);
                                break;
                            case 3:
                                Mazo[index] = new CartaEspanola("Bastos", valor);
                                break;
                        }
                        index++;
                        ;
                    }
                }
            }
            ncartas = 40;
        }
        if (baraja.equalsIgnoreCase("alemana")) {
            ncartas = 36;
            Mazo = new carta[ncartas];
            for (int palo = 0; palo < 4; palo++) {
                for (int valor = 6; valor <= 14; valor++) {
                    switch (palo) {
                        case 0:
                            Mazo[index] = new CartaAlemana("Campanas", valor);     
                            break;
                        case 1:
                            Mazo[index] = new CartaAlemana("Pastos", valor);
                            break;
                        case 2:
                            Mazo[index] = new CartaAlemana("Corazones", valor);
                            break;
                        case 3:
                            Mazo[index] = new CartaAlemana("Bellotas", valor);
                            break;
                    }
                    index++;
                }
            }
        }
        /* enseña el mazo creado
        for (int i = 0; i < Mazo.length; i++)
            System.out.println(Mazo[i]);
        */
    }

    public void barajar() {
        System.out.println("Barajando!!...");
        Mazobarajado = new carta[ncartas];

        for (int i = 0; i < Mazobarajado.length; i++) {
            do {
                random = (int) (Math.random() * ncartas);
            } while (Mazo[random] == null);
            Mazobarajado[i] = Mazo[random];
            Mazo[random] = null;
        }
    }

    public carta Siguiente() {
        carta siguiente = Mazobarajado[proxima];
        Mazobarajado[proxima] = null;
        proxima++;
        return siguiente;
    }

    public void reiniciar() {
        /* Segun mi concepto, regenero el array de cartas, PERO SIN BARAJARLAS
        Lo voy a hacer poniendo el Array barajado a null, comprobando en la interfaz
        si este esta a null, como condicion para empezar la partida
        */
        for (int i = 0; i < Mazobarajado.length; i++)
            Mazobarajado[i] = null;
    }

    public int numCartas() {
        int contadorCartas = 0;
        for (int i = 0; i < ncartas; i++)
            if (Mazobarajado[i] != null)
                contadorCartas++;
        return contadorCartas;
    }

    public carta[] getBaraja() {
        CartasRestantes = new carta[ncartas];
        for (int i = 0; i < Mazobarajado.length; i++)
            if (Mazobarajado[i] != null)
                CartasRestantes[i] = Mazobarajado[i];
        return CartasRestantes;
    }

    public String toString() {
        return CartasRestantes.toString();
    }

}
