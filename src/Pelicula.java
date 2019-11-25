import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Pelicula extends AudioVisual {
    public Pelicula(String nombre, String genero, String anno, String clasificacion, String fechaSalida, String duracion, String director,
                    String escritor, String actor, String trama, String idioma, String pais, String poster, String calificacion) {
        super(nombre, genero, anno, clasificacion, fechaSalida, duracion, director, escritor, actor, trama, idioma, pais, poster, calificacion);
    }

    public Pelicula() {
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
    public ArrayList cargarHistorial() {
        ArrayList<AudioVisual> historial = new ArrayList<>();
        try{
            CsvReader leePeliculaSerie = new CsvReader("src\\Peliculas.csv");
            leePeliculaSerie.setDelimiter(';');
            String[] next;
            leePeliculaSerie.readHeaders();
            while(leePeliculaSerie.readRecord()){
                String[] datos = leePeliculaSerie.getValues();
                String nombre = datos[0];
                String genero = datos[1];
                String anno = datos[2];
                String clasificacion = datos[3];
                String fechaSalida = datos[4];
                String duracion = datos[5];
                String directores = datos[6];
                String escritores = datos[7];
                String actores = datos[8];
                String trama = datos[9];
                String idioma = datos[10];
                String pais = datos[11];
                String poster = datos[12];
                String calificacion = "calificacion";
                historial.add(new Pelicula(nombre, genero, anno, clasificacion, fechaSalida, duracion, directores, escritores,
                        actores, trama, idioma, pais, poster, calificacion));
            }
            leePeliculaSerie.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return historial;
    }

    public void agregarUsuarioNuevo(String Usuario, String pass){

    }

    @Override
    public String toString() {
        return super.toString();
    }


}
