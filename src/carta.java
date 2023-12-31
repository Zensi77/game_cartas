public class carta {

    public String palo;
    public int valor;

    public carta(String palo, int valor){
        this.palo = palo;
        this.valor = valor;
    }

    public void setPalo(String palo) {
        this.palo = palo;
    }

    public String getPalo() {
        return palo;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public carta clone() {
        carta nueva = new carta(this.palo, this.valor);
        return nueva;
    }

    public boolean compararNumero(carta a) {
        if (a.getValor() == this.valor) {
            return true;
        } else return false;
    }

    public boolean compararPalo(carta a) {
        if (a.getPalo().equals(this.palo)) {
            return true;
        } else return false;
    }

    public boolean mayorQue(carta a) {
        if (this.valor > a.getValor()) {
            return true;
        } else return false;
        //No se cpnsidera q seean iguales, en ese caso sera false
    }

    public boolean equals(carta a) {
        if (a.getPalo().equals(this.palo) && a.getValor() == this.valor) {
            return true;
        }
        else return false;
    }
}