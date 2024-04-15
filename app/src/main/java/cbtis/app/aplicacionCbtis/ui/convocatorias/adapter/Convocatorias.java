package cbtis.app.aplicacionCbtis.ui.convocatorias.adapter;

public class Convocatorias {
    //MODELO DE LA CLASE
    String urlConvocatoria;
    String tituloConvocatoria;
    String asociacionConvocatoria;
    String descripcionConvocatoria;

    public Convocatorias(){

    }

    public Convocatorias(String urlConvocatoria, String tituloConvocatoria, String asociacionConvocatoria, String descripcionConvocatoria){
        this.urlConvocatoria = urlConvocatoria;
        this.tituloConvocatoria = tituloConvocatoria;
        this.asociacionConvocatoria = asociacionConvocatoria;
        this.descripcionConvocatoria = descripcionConvocatoria;
    }

    public String getUrlConvocatoria() {
        return urlConvocatoria;
    }

    public void setUrlConvocatoria(String urlConvocatoria) {
        this.urlConvocatoria = urlConvocatoria;
    }

    public String getTituloConvocatoria() {
        return tituloConvocatoria;
    }

    public void setTituloConvocatoria(String tituloConvocatoria) {
        this.tituloConvocatoria = tituloConvocatoria;
    }

    public String getAsociacionConvocatoria() {
        return asociacionConvocatoria;
    }

    public void setAsociacionConvocatoria(String asociacionConvocatoria) {
        this.asociacionConvocatoria = asociacionConvocatoria;
    }

    public String getDescripcionConvocatoria() {
        return descripcionConvocatoria;
    }

    public void setDescripcionConvocatoria(String descripcionConvocatoria) {
        this.descripcionConvocatoria = descripcionConvocatoria;
    }
}
