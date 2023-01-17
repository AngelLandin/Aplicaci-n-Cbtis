package cbtis.app.aplicacionCbtis.ui.cursos.adapterCuadernillos;

public class ListElementCuadernillos {
    private String semestreCuadernillos;
    private int imageCuadernillos;
    private String claseCuadernillos;

    public ListElementCuadernillos(String semestreCuadernillos, int imageCuadernillos, String claseCuadernillos) {
        this.semestreCuadernillos = semestreCuadernillos;
        this.imageCuadernillos = imageCuadernillos;
        this.claseCuadernillos = claseCuadernillos;
    }

    public String getClaseCuadernillos() {
        return claseCuadernillos;
    }

    public void setClaseCuadernillos(String claseCuadernillos) {
        this.claseCuadernillos = claseCuadernillos;
    }

    public String getSemestreCuadernillos() {
        return semestreCuadernillos;
    }

    public void setSemestreCuadernillos(String semestreCuadernillos) {
        this.semestreCuadernillos = semestreCuadernillos;
    }

    public int getImageCuadernillos() {
        return imageCuadernillos;
    }

    public void setImageCuadernillos(int imageCuadernillos) {
        this.imageCuadernillos = imageCuadernillos;
    }
}
