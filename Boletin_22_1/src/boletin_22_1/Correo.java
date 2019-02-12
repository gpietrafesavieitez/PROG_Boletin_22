/**
 * Gabriel P.
 * CPR Daniel Castelao
 * <gpietrafesavieitez@danielcastelao.org>
 */

package boletin_22_1;

public class Correo {
    private String contenido;
    private boolean flagSinLeer;
    
    public Correo() {
    }

    public Correo(String contenido) {
        this.contenido = contenido;
    }

    public Correo(boolean flagSinLeer) {
        this.flagSinLeer = flagSinLeer;
    }
    
    public Correo(String contenido, boolean flagSinLeer) {
        this.contenido = contenido;
        this.flagSinLeer = flagSinLeer;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public boolean isflagSinLeer() {
        return flagSinLeer;
    }

    public void flagSinLeer(boolean flagSinLeer) {
        this.flagSinLeer = flagSinLeer;
    }

    @Override
    public String toString() {
        return "\t '" + contenido + "'";
    }
}