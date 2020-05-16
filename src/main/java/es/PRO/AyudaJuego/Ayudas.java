package es.PRO.AyudaJuego;

/**
 *
 * @author Jorge
 */
public class Ayudas {

    /**
     * Recibe el valor maximo del dado y devuelve un numero aleatorio entre el
     * maximo y 1
     *
     * @param dado
     * @return resultado
     */
    public static int tirarDado(int dado) {
        int resultado;
        resultado = (int) (Math.random() * dado);
        // En valor 0 corresponderá al valor maximo del dado
        if (resultado == 0) {
            resultado = dado;
        }
        return resultado;
    }

    /**
     * Devuelve un evento aletorio al que jugar
     *
     * @return evento
     */
    public static String jugarEvento() {
        String evento = "";
        int aleatorio = (int) (Math.random() * 6);
        String[] eventos = {"historia", "mision", "mazmorra", "combate", "aldea", "viaje"};
        evento = eventos[aleatorio];
        return evento;
    }

    /**
     * Devuelve una recompensa aleatoria
     *
     * @return recom
     */
    public static String ganarRecompensa() {
        String recom = "";
        int aleatorio = (int) (Math.random() * 6);
        String[] recoms = {"oro", "objeto magico", "arma", "armadura", "aliado", "nada"};
        recom = recoms[aleatorio];
        return recom;
    }
}
