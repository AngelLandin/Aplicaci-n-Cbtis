package cbtis.app.aplicacionCbtis.ui.comunidad.controlador.adapterClubs;

public class ListaElementosClubs {
    private String imageClub;
    private String club;
    private String descripcionClub;

    public void ListaElementosClubs(){

    }

    public void ListaElementosClubs(String imageClub, String club, String descripcionClub) {
        this.imageClub = imageClub;
        this.club = club;
        this.descripcionClub = descripcionClub;
    }

    public String getImageClub() {
        return imageClub;
    }

    public void setImageClub(String imageClub) {
        this.imageClub = imageClub;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getDescripcionClub() {
        return descripcionClub;
    }

    public void setDescripcionClub(String descripcionClub) {
        this.descripcionClub = descripcionClub;
    }
}
