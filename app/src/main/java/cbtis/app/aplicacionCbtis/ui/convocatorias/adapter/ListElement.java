package cbtis.app.aplicacionCbtis.ui.convocatorias.adapter;

//Esta clase es la que tendra en lista los elementos que tendra nuestras CardView para la seccion de
//convocatorias
public class ListElement {
    private String urlConvocatoria;
    private String tituloConvocatoria;
    private String compania;
    private String descripcion;

    public ListElement(String compania, String tituloConvocatoria, String descripcion, String urlConvocatoria) {
        this.compania = compania;
        this.descripcion = descripcion;
        this.urlConvocatoria = urlConvocatoria;
        this.tituloConvocatoria = tituloConvocatoria;
    }

    public String getTituloConvocatoria() {
        return tituloConvocatoria;
    }

    public void setTituloConvocatoria(String tituloConvocatoria) {
        this.tituloConvocatoria = tituloConvocatoria;
    }

    public String getUrlConvocatoria() {
        return urlConvocatoria;
    }

    public void setUrlConvocatoria(String urlConvocatoria) {
        this.urlConvocatoria = urlConvocatoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

}
