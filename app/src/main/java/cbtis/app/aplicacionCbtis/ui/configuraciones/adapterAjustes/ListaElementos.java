package cbtis.app.aplicacionCbtis.ui.configuraciones.adapterAjustes;

public class ListaElementos {
    private int image;
    private String seccion;

    public ListaElementos(int image, String seccion) {
        this.image = image;
        this.seccion = seccion;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }
}
