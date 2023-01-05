package cbtis.app.aplicacionCbtis.ui.cursos.adapterCursos;

public class ListElementCursos {
    private int image;
    private String tituloCurso;
    private String asociacion;
    private String descripcion;
    private String urlCurso;

    public ListElementCursos(int image, String tituloCurso, String asociacion, String descripcion, String urlCurso) {
        this.image = image;
        this.tituloCurso = tituloCurso;
        this.asociacion = asociacion;
        this.descripcion = descripcion;
        this.urlCurso = urlCurso;
    }

    public String getUrlCurso() {
        return urlCurso;
    }

    public void setUrlCurso(String urlCurso) {
        this.urlCurso = urlCurso;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTituloCurso() {
        return tituloCurso;
    }

    public void setTituloCurso(String tituloCurso) {
        this.tituloCurso = tituloCurso;
    }

    public String getAsociacion() {
        return asociacion;
    }

    public void setAsociacion(String asociacion) {
        this.asociacion = asociacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
