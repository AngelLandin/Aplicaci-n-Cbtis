package cbtis.app.aplicacionCbtis.ui.home.adapterAvisos;

public class ListaElementos {
    private String descripcion;
    private String image;
    private String urlAviso;
    private String fecha;

    public ListaElementos() {
    }

    public ListaElementos(String descripcion, String image, String urlAviso, String fecha) {
        this.descripcion = descripcion;
        this.image = image;
        this.urlAviso = urlAviso;
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUrlAviso() {
        return urlAviso;
    }

    public void setUrlAviso(String urlAviso) {
        this.urlAviso = urlAviso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
