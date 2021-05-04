package guerraespacial;

public abstract class Guerrero {

    protected boolean vivo = true;

    protected int blanco;

    protected String raza;

    public Guerrero(String raza) {
        this.blanco = generaBlanco();
        this.raza = raza;
    }

    public Guerrero() {
    }

    public boolean isVivo() {
        return vivo;
    }

    public int getBlanco() {
        return blanco;
    }

    public String getRaza() {
        return raza;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public void setBlanco(int blanco) {
        this.blanco = blanco;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int dispara() {
        /*Un método denominado dispara que simule un disparo mediante la generación de un número aleatorio
        del 0 al 9.*/
        int disparo = -1;

        if (vivo) {
            disparo = (int) (Math.random() * 10);
            System.out.print("\n  Guerrero " + raza + " ha disparado un " + disparo);
        }
        return disparo;

    }

    public abstract void recibeDisparo(int disparo);

    /*Otro método que se denominará recibeDisparo que recibirá como parámetro el "disparo numérico" 
        de un oponente, en caso de que ese número coincida con el identificador del mismo, el guerrero 
        muere, se decrementa el número de guerreros disponibles de esa clase y se muestra un mensaje 
        indicando tal circunstancia.*/
    private static int generaBlanco() {
        /*Otro método que se denominará generaBlanco, que dará un valor aleatorio, entre 0 y 9, al 
        identificador del mismo.*/

        int identificador = (int) (Math.random() * 10);

        return identificador;

    }

    @Override
    public String toString() {

        String cadena;

        if (!vivo) {
            cadena = " X";
        } else {
            cadena = " " + blanco;
        }

        return cadena;

    }

}
