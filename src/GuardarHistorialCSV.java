import com.csvreader.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class GuardarHistorialCSV {
    private ArrayList<AudioVisual> listaBusqueda = new ArrayList<>();

    public ArrayList<AudioVisual> getListaBusqueda() {
        return listaBusqueda;
    }

    public void setListaBusqueda(ArrayList<AudioVisual> listaPeliculas) {
        this.listaBusqueda = listaPeliculas;
    }

    public String agregarALista(AudioVisual audioVisual){
        for(AudioVisual a: listaBusqueda){
            if (a.getNombre().equals(audioVisual.getNombre())){
                return "Ya fue ingresada";
            }
        }listaBusqueda.add(audioVisual);
        return "Listo";
    }

}
