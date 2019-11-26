import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import java.io.File;
import java.io.FileNotFoundException;
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

    public Serie(String nombre, String anno) {
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    @Override
    public void guardarHistorialCSV(AudioVisual audioVisual, String nombre) {
        ArrayList<AudioVisual> listaPeliculas = cargarHistorial(nombre);
        if (listaPeliculas != null) {
            String salidaArchivo = "src\\historial_" + nombre + ".csv";
            boolean exite = new File(salidaArchivo).exists();
            String[] datos = {"Nombre", "Genero", "Year", "Clasificacion", "Fecha de salida", "Duracion",
                    "Directores", "Escritores", "Actores", "Trama", "Idioma", "Pais", "Poster", "Calificacion"};
            if (exite) {
                File archivoPelicula = new File(salidaArchivo);
                archivoPelicula.delete();
            }
            try {
                CsvWriter salidaCsv = new CsvWriter(new FileWriter(salidaArchivo, true), ';');
                salidaCsv.writeRecord(datos);
                for (AudioVisual a : listaPeliculas) {
                    if(!a.getNombre().equals(audioVisual.getNombre())){
                        String[] peliculaArray = crearArreglo(a);
                        salidaCsv.writeRecord(peliculaArray);
                    }
                }
                String[] pelicula = crearArreglo(audioVisual);
                salidaCsv.writeRecord(pelicula);
                salidaCsv.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            String salidaArchivo = "src\\historial_" + nombre + ".csv";
            boolean exite = new File(salidaArchivo).exists();
            String[] datos = {"Nombre", "Genero", "Year", "Clasificacion", "Fecha de salida", "Duracion",
                    "Directores", "Escritores", "Actores", "Trama", "Idioma", "Pais", "Poster", "Calificacion"};
            if (exite) {
                File archivoPelicula = new File(salidaArchivo);
                archivoPelicula.delete();
            }
            try {
                CsvWriter salidaCsv = new CsvWriter(new FileWriter(salidaArchivo, true), ';');
                salidaCsv.writeRecord(datos);
                String[] pelicula = crearArreglo(audioVisual);
                salidaCsv.writeRecord(pelicula);
                salidaCsv.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public String[] crearArreglo(AudioVisual a) {
        String[] arreglo = {a.getNombre(), a.getGenero(), a.getAnno(), a.getClasificacion(), a.getFechaSalida(), a.getDuracion(),
                a.getDirector(), a.getEscritor(), a.getActor(), a.getTrama(), a.getIdioma(), a.getPais(), a.getPoster()};
        return arreglo;
    }

    @Override
    public ArrayList cargarHistorial(String nombreArc) {
        ArrayList<AudioVisual> historial = new ArrayList<>();
        try {
            CsvReader leePeliculaSerie = new CsvReader("src\\historial_" + nombreArc + ".csv");
            leePeliculaSerie.setDelimiter(';');
            leePeliculaSerie.readHeaders();
            while (leePeliculaSerie.readRecord()) {
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
                //String calificacion = datos[13];
                historial.add(new Serie(nombre, genero, anno, clasificacion, fechaSalida, duracion, directores, escritores,
                        actores, trama, idioma, pais, poster, null, null));
            }
            leePeliculaSerie.close();
            return historial;
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void eliminarFav(AudioVisual nombreFav, String nombreUser) {
        ArrayList<AudioVisual> historial = cargarHistorial(nombreUser);
        ArrayList<AudioVisual> historialNuevo = new ArrayList<>();
        for(AudioVisual a : historial){
            if(!nombreFav.getNombre().equals(a.getNombre()))
                historialNuevo.add(a);
        }
        if (historialNuevo != null) {
            String salidaArchivo = "src\\historial_" + nombreUser + ".csv";
            boolean exite = new File(salidaArchivo).exists();
            String[] datos = {"Nombre", "Genero", "Year", "Clasificacion", "Fecha de salida", "Duracion",
                    "Directores", "Escritores", "Actores", "Trama", "Idioma", "Pais", "Poster", "Calificacion"};
            if (exite) {
                File archivoPelicula = new File(salidaArchivo);
                archivoPelicula.delete();
            }
            try {
                CsvWriter salidaCsv = new CsvWriter(new FileWriter(salidaArchivo, true), ';');
                salidaCsv.writeRecord(datos);
                for (AudioVisual a : historialNuevo) {
                    String[] peliculaArray = crearArreglo(a);
                    salidaCsv.writeRecord(peliculaArray);
                }
                salidaCsv.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

/*
        BusquedaPelicula busca = new BusquedaPelicula();
        GuardarHistorialCSV guarda = new GuardarHistorialCSV();
        if(jCheckBox1.isSelected()){
            String info = jTextPaneInformacion.getText();
            String[] infoCompleta = info.split("\n");
            String[] n1 = infoCompleta[0].split(" ");
            String[] a1 = infoCompleta[2].split(" ");
            String nombre = n1[1];
            String anno = a1[1];

            try {
                busca.jsonPrueba(nombre, anno);
                AudioVisual visual = busca.leerJson();
                guarda.agregarFavorito(visual, new Usuarios(getUsuario(), getPass()));
            } catch (MalformedURLException ex) {
                Logger.getLogger(Buscador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Buscador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            //Accion de quitar de favoritos
            busca.jsonPrueba(nombre, anno);
            AudioVisual visual = busca.leerJson();
            guarda.eliminarFavorito(visual, new Usuarios(getUsuario(), getPass()));
        }
 */