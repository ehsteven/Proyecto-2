import com.csvreader.CsvWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Serie extends AudioVisual{
    private String temporada;

    public Serie(String nombre, String genero, String anno, String clasificacion, String fechaSalida, String duracion, String director, String escritor,
                 String actor, String trama, String idioma, String pais, String poster, String calificacion, String temporada) {
        super(nombre, genero, anno, clasificacion, fechaSalida, duracion, director, escritor, actor, trama, idioma, pais, poster, calificacion);
        this.temporada = temporada;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    @Override
    public void guardarHistorialCSV(ArrayList<AudioVisual> listaSeries) {
        String salidaArchivo = "src\\Peliculas.csv";
        boolean exite = new File(salidaArchivo).exists();
        String [] datos = {"Nombre", "Genero", "Year", "Clasificacion", "Fecha de salida", "Duracion",
                "Directores", "Escritores", "Actores", "Trama", "Idioma", "Pais", "Poster", "Calificacion"};
        if (exite){
            File archivoPelicula = new File(salidaArchivo);
            archivoPelicula.delete();
        }
        try{
            CsvWriter salidaCsv = new CsvWriter(new FileWriter(salidaArchivo, true), ';');
            salidaCsv.writeRecord(datos);
            for (AudioVisual a : listaSeries ){
                String[] peliculaArray = crearArreglo(a);
                salidaCsv.writeRecord(peliculaArray);
            }
            salidaCsv.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[] crearArreglo(AudioVisual a){
        String[] arreglo = {a.getNombre(), a.getGenero(), a.getAnno(), a.getClasificacion(), a.getFechaSalida(), a.getDuracion(),
                a.getDirector(),a.getEscritor(), a.getActor(), a.getTrama(), a.getIdioma(), a.getPais(), a.getPoster()};
        return arreglo;
    }

    @Override
    public void cargarHistorial() {

    }
}
