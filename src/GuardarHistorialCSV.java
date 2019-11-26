import com.csvreader.*;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class GuardarHistorialCSV {
    private ArrayList<String> listaHistorial  = new ArrayList<>();
    private ArrayList<AudioVisual> listaBusqueda= new ArrayList<>();

    public ArrayList<AudioVisual> getListaBusqueda() {
        return listaBusqueda ;
    }
    public void setListaBusqueda(ArrayList<AudioVisual> listaHistorial) {
        this.listaBusqueda  = listaHistorial;
    }
    public ArrayList<String> getListaHistorial() {
        return listaHistorial;
    }
    public void setListaHistorial(ArrayList<String> listaPeliculas) {
        this.listaHistorial = listaPeliculas;
    }

    public String agregarALista(AudioVisual audioVisual) throws IOException {
        try{
            listaHistorial = cargarHistorial();
            for(String a: listaHistorial){
                String[] datos = a.split(",");
                if (datos[0].equals(audioVisual.getNombre())){
                    return "Ya fue ingresada";
                }
            }
            incluirAlHistorial(audioVisual.getNombre(), audioVisual.getAnno());
        }catch (IOException e){
            e.printStackTrace();
        }
        return "listo";
    }
    //agarra datos del txt
    public ArrayList<String> cargarHistorial() throws IOException {
        ArrayList<String> historial =new ArrayList<>();
        String ruta = "src\\Historial.txt";
        File historialN = new File (ruta);
        BufferedWriter bw;
        try{
            if(!historialN.exists()){
                bw = new BufferedWriter(new FileWriter(historialN));
            }
            FileReader fr = new FileReader (historialN);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while((linea=br.readLine())!=null){
                historial.add(linea);
            }
            fr.close();

        }catch (IOException e){
            e.printStackTrace();
        }
        return historial;
    }

    //Mete datos al txt
    public void incluirAlHistorial(String nombre, String anno) throws IOException {
        ArrayList<String> datos = cargarHistorial();
        try{
            FileWriter fichero = null;
            PrintWriter pw = null;
            fichero = new FileWriter("src\\Historial.txt");
            pw = new PrintWriter(fichero);
                for(String a: datos){
                    String[] datos_1 = a.split(",");
                    String nombre1 = datos_1[0];
                    String anno1 = datos_1[1];
                    pw.println(nombre1+","+anno1);
                }
                pw.println(nombre+","+anno);
                pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<AudioVisual> agregarListaPelis(AudioVisual audioVisual){
        listaBusqueda.add(audioVisual);
        return listaBusqueda;
    }

    public void agregarFavorito(AudioVisual pelicula, Usuarios user) throws IOException {
        if(pelicula!= null)
            pelicula.guardarHistorialCSV(pelicula, user.getNombreUsuario());
        else
            System.out.println("hubo un error");
    }
    public void eliminarFavorito(AudioVisual pelicula, Usuarios user){
        pelicula.eliminarFav(pelicula, user.getNombreUsuario());
    }
}
