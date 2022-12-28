package cbtis.app.aplicacionCbtis.adapter;

import android.widget.Button;

//Esta clase es la que tendra en lista los elementos que tendra nuestras CardView para la seccion de
//convocatorias
public class ListElement {
    String compania;
    String descripcion;

    public ListElement(String compania, String descripcion) {
        this.compania = compania;
        this.descripcion = descripcion;
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
