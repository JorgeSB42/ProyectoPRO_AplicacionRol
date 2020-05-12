package es.PRO.modelo;

/**
 *
 * @author Jorge
 */
// Ficha de personaje
public class FichaPJ {

    private int codigo;
    private String nombrePJ;
    private String raza;
    private String clase;
    private int nivel;
    private int fue; // fuerza
    private int mag; // magia
    private int agi; // agilidad
    private int res; // resistencia

    public FichaPJ() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombrePJ() {
        return nombrePJ;
    }

    public void setNombrePJ(String nombrePJ) {
        this.nombrePJ = nombrePJ;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }  
    
    public int getFue() {
        return fue;
    }

    public void setFue(int fue) {
        this.fue = fue;
    }

    public int getMag() {
        return mag;
    }

    public void setMag(int mag) {
        this.mag = mag;
    }

    public int getAgi() {
        return agi;
    }

    public void setAgi(int agi) {
        this.agi = agi;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

}
