package guerraespacial;

public class Nave {

    private String razaNave;

    private Guerrero[] tripulacion = new Guerrero[10];

    public Nave(String raza) {
        this.razaNave = raza;

        /*En el propio constructor se procede a inicializar las naves segun su raza*/
        for (int i = 0; i < 10; i++) {

            if (razaNave.equals("Marciana")) {
                tripulacion[i] = new Marciano("Marciano");
            } else {
                tripulacion[i] = new Terrestre("Terrestre");
            }
        }
    }

    public Guerrero[] getTripulacion() {
        return tripulacion;
    }

    public String getRaza() {
        return razaNave;
    }

    public void setTripulacion(Guerrero[] tripulacion) {
        this.tripulacion = tripulacion;
    }

    public void setRaza(String raza) {
        this.razaNave = raza;
    }

    public int generaDisparo(int posicion) {
        /*Un método que genere el disparo de uno de sus guerreros tripulantes, dada su posición del array de tripulantes, 
    y que denominaremos generaDisparo.*/
        int identificador;

        identificador = tripulacion[posicion].dispara();

        return identificador;
    }

    public void recibeDisparo(int identificador) {
        /*Otro método que reciba un disparo de su oponente y compruebe que el mismo mata o no a uno de sus ocupantes, 
    que denominaremos recibeDisparo.*/

        for (int i = 0; i < 10; i++) {
            tripulacion[i].recibeDisparo(identificador);
        }
    }

    public int quedanVivos() {
        /*Otro método que permita determinar cuantos guerreros de la tripulación quedan vivos*/
        int vivos;

        if (razaNave.equals("Marciana")) {
            vivos = Marciano.getTotal();
        } else {
            vivos = Terrestre.getTotal();
        }

        return vivos;
    }

    @Override
    public String toString() {
        String cadena;

        cadena = "\n  \u001B[35mNAVE " + razaNave.toUpperCase() + "\n";
        cadena += "    Tripulacion: (";
        for (int i = 0; i < 10; i++) {
            cadena += tripulacion[i].toString();
        }
        cadena += " )";

        return cadena;
    }

}
