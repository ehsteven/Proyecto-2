import java.util.ArrayList;

public abstract class AudioVisual {
    private String nombre;
    private String genero;
    private String anno;
    private String clasificacion;
    private String fechaSalida;
    private String duracion;
    private String director;
    private String escritor;
    private String actor;
    private String trama;
    private String idioma;
    private String pais;
    private String poster;
    private String calificacion;
    private ArrayList<AudioVisual> lista = new ArrayList<>();

    public abstract void guardarHistorialCSV(AudioVisual audioVisual, String nombre);
    public abstract ArrayList cargarHistorial(String nombre);
    public abstract void eliminarFav(AudioVisual pelicula, String user);

    public AudioVisual(String nombre, String genero, String anno, String clasificacion, String fechaSalida, String duracion, String director, String escritor, String actor, String trama, String idioma, String pais, String poster, String calificacion) {
        this.nombre = nombre;
        this.genero = genero;
        this.anno = anno;
        this.clasificacion = clasificacion;
        this.fechaSalida = fechaSalida;
        this.duracion = duracion;
        this.director = director;
        this.escritor = escritor;
        this.actor = actor;
        this.trama = trama;
        this.idioma = idioma;
        this.pais = pais;
        this.poster = poster;
        this.calificacion = calificacion;
    }

    public AudioVisual() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAnno() {
        return anno;
    }

    public void setAnno(String anno) {
        this.anno = anno;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getEscritor() {
        return escritor;
    }

    public void setEscritor(String escritor) {
        this.escritor = escritor;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getTrama() {
        return trama;
    }

    public void setTrama(String trama) {
        this.trama = trama;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public ArrayList<AudioVisual> getLista() {
        return lista;
    }

    public void setLista(ArrayList<AudioVisual> lista) {
        this.lista = lista;
    }

    @Override
    public String toString() {
        return "nombre='" + nombre + '\'' +
                ", genero='" + genero + '\'' +
                ", anno='" + anno + '\'' +
                ", clasificacion='" + clasificacion + '\'' +
                ", fechaSalida='" + fechaSalida + '\'' +
                ", duracion='" + duracion + '\'' +
                ", escritor='" + escritor + '\'' +
                ", actor='" + actor + '\'' +
                ", trama='" + trama + '\'' +
                ", idioma='" + idioma + '\'' +
                ", pais='" + pais + '\'' +
                ", poster='" + poster + '\'' +
                ", calificacion='" + calificacion + '\'' +
                '}';
    }
}
