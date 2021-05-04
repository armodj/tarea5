package guerraespacial;

public class Terrestre extends Guerrero {

    private static int total = 0;

    public Terrestre(String raza) {
        super(raza);
        total++;
    }

    public Terrestre() {
        total++;
    }

    public static int getTotal() {
        return total;
    }

    public static void setTotal(int total) {
        Terrestre.total = total;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public int getBlanco() {
        return blanco;
    }

    public void setBlanco(int blanco) {
        this.blanco = blanco;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    @Override
    public void recibeDisparo(int disparo) {

        if (blanco == disparo && vivo) {
            vivo = false;
            total--;
            System.out.print("\n     Guerrero " + raza + " nº " + blanco + " caido!!!!");
        }
    }

}
