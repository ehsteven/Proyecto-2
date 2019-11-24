import com.csvreader.CsvWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Pelicula extends AudioVisual {


    public Pelicula(String nombre, String genero, String anno, String clasificacion, String fechaSalida, String duracion, String director,
                    String escritor, String actor, String trama, String idioma, String pais, String poster, String calificacion) {
        super(nombre, genero, anno, clasificacion, fechaSalida, duracion, director, escritor, actor, trama, idioma, pais, poster, calificacion);
    }

    @Override
    public void guardarHistorialCSV(ArrayList<AudioVisual> listaPeliculas) {
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
            for (AudioVisual a : listaPeliculas ){
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

    public void agregarUsuarioNuevo(String Usuario, String pass){

    }

    @Override
    public String toString() {
        return super.toString();
    }


}
