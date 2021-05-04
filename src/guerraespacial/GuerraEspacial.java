package guerraespacial;

/**
 *
 * @author Domingo J.
 */
public class GuerraEspacial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Crea una aplicación que cree dos naves, una terrestre y otra marciana. La batalla la comienza de forma aleatoria 
      una de las naves y termina cuando en una de las naves no queden tripulantes vivos. El programa mostrará cual de 
      las razas ha ganado la batalla.*/

        int victoria = 0;
        int derrota= 0;


        Nave nave1 = new Nave("Marciana");
        Nave nave2 = new Nave("Terrestre");

        System.out.print("\n\u001B[31mGUERRA ESPACIAL");
        System.out.print("\n\n        \u001B[31mESTADO INICIAL NAVES");
        imprimeNaves(nave1, nave2);

        System.out.println("\n\u001B[31m¡A las armas!");
        System.out.println("\u001B[31mQUE COMIENCE LA BATALLAAAA!!!\n");

        victoria = batallaNaves(nave1, nave2);

        System.out.println("\n\n\u001B[31mFIN DE LA BATALLA\u001B[0m");

        if (victoria == 1) {
            System.out.print("\n\u001B[37m\u001B[41mVICTORIA!!!! HAN GANADO LOS MARCIANOS\n\n\n");
        } else {
            System.out.print("\n\u001B[37m\u001B[44mVICTORIA!!!! HAN GANADO LOS TERRICOLAS\n\n\n");
        }
    }

    public static void imprimeNaves(Nave naveMarciana, Nave naveTerrestre) {

        System.out.print("\n\u001B[34m***********************************************");
        System.out.println(naveMarciana);
        System.out.println(naveTerrestre);
        System.out.println("\u001B[34m***********************************************\n");
    }

    public static int batallaNaves(Nave nave1, Nave nave2) {

        int comienza = -1;
        int ganador = 2;

        comienza = (int) (Math.random() * 2);

        do {
            if (comienza == 1) {
                //Empieza atacando la nave Terrestre
                for (int i = 0; i < 10; i++) {
                    /*Se llama el método generaDisparo en la nave de los Terricolas (1), cuyo disparo del tripulante i 
                    es recibido por la nave Marciana (2)*/
                    nave2.recibeDisparo(nave1.generaDisparo(i));
                }

                System.out.print("\n\n        \u001B[34mRECUENTO DE BAJAS");
                imprimeNaves(nave1, nave2);

                for (int j = 0; j < 10; j++) {
                    /*Cuando hayan disparado todos los guerreros terrícolas, disparan los marcianos j recibiendo 
                    los terrestres*/
                    nave1.recibeDisparo(nave2.generaDisparo(j));
                }

                System.out.print("\n\n        \u001B[34mRECUENTO DE BAJAS");
                imprimeNaves(nave1, nave2);

            } else {
                //Empieza atacando la nave Marciana
                for (int i = 0; i < 10; i++) {
                    nave1.recibeDisparo(nave2.generaDisparo(i));
                }

                System.out.print("\n\n        \u001B[34mRECUENTO DE BAJAS");
                imprimeNaves(nave1, nave2);

                for (int j = 0; j < 10; j++) {
                    nave2.recibeDisparo(nave1.generaDisparo(j));
                }

                System.out.print("\n\n        \u001B[34mRECUENTO DE BAJAS");
                imprimeNaves(nave1, nave2);

            }
        } while (nave1.quedanVivos() > 0 && nave2.quedanVivos() > 0);

        //Si quedan tripulantes vivos en la nave 1 ganaron ellos, en caso contrario gana la nave 2
        if (nave1.quedanVivos() > 0) {
            ganador = 1;
        }

        return ganador;
    }

}
