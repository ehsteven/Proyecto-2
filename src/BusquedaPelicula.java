import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.io.*;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import com.csvreader.*;

public class BusquedaPelicula {
    private CrearJson c = new CrearJson();
    private GuardarHistorialCSV historial = new GuardarHistorialCSV();

    public BusquedaPelicula() {
    }

    public void jsonPrueba(String nombre, String anno) throws IOException {
        nombre = nombre.replace(" ", "+");
        String stringUrl;
        if (anno.equals("")){
            stringUrl = "http://www.omdbapi.com/?t="+nombre+"&plot=full&apikey=1a7095ce";
        }else{
            stringUrl = "http://www.omdbapi.com/?t="+nombre+"&y="+anno+"&plot=full&apikey=1a7095ce";
        }
        URL url = new URL(stringUrl);
        //URL url = new URL("http://www.omdbapi.com/?t=Shrek+10&y=2004&plot=full&apikey=1a7095ce&");  prueba de url funcional
        try{
            HttpURLConnection con =  (HttpURLConnection) url.openConnection();
            System.out.println("\nEnviando 'GET' request to URL: "+ url);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null ){
                response.append(inputLine);
            }
            in.close();
            c.crearJson(response);
            leerJson();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "No hay conexion al internet");
            e.printStackTrace();
        }
    }

    public AudioVisual leerJson() throws MalformedURLException {
        JSONParser parser = new JSONParser();
        try {
            Object obj =  parser.parse(new FileReader("Json.json"));
            JSONObject jsonObject  =  (JSONObject) obj;
            String response = (String) jsonObject.get("Response");
            if (response.equals("False")){
                System.out.println("No se encontró la pelicula");
            }else {
                String title = (String) jsonObject.get("Title");
                String year = (String) jsonObject.get("Year");
                String rated = (String) jsonObject.get("Rated");
                String released = (String) jsonObject.get("Released");
                String runtime = (String) jsonObject.get("Runtime");
                String genre = (String) jsonObject.get("Genre");
                String director = (String) jsonObject.get("Director");
                String writer = (String) jsonObject.get("Writer");
                String actors = (String) jsonObject.get("Actors");
                String plot = (String) jsonObject.get("Plot");
                String language = (String) jsonObject.get("Language");
                String country = (String) jsonObject.get("Country");
                String poster = (String) jsonObject.get("Poster");
                String tipo = (String) jsonObject.get("Type");
                String rating = (String) jsonObject.get("imdbRating");
                //Usuarios user  = new Usuarios("Fernandez", "password");
                if (!poster.equals("N/A"))
                    guardarPoster(poster, title);
                if (tipo.equals("series")) {
                    String temporadas = (String) jsonObject.get("totalSeasons");
                    Serie serie = new Serie(title, genre, year, rated, released, runtime, director, writer, actors,
                            plot, language, country, poster, rating, temporadas);
                    historial.agregarALista(serie);
                    return serie;
                }else if (tipo.equals("movie")) {
                    Pelicula pelicula = new Pelicula(title, genre, year, rated, released, runtime, director, writer, actors,
                            plot, language, country, poster, rating);
                    historial.agregarALista(pelicula);
                    //historial.agregarFavorito(pelicula, user);
                    return pelicula;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch (ParseException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void guardarPoster(String poster, String nombre) throws IOException  {
        URL urlposter = new URL(poster);
        InputStream is = urlposter.openStream();
        String name = "src\\Imagenes\\"+nombre+".jpg";
        OutputStream os = new FileOutputStream(name);
        byte[] b = new byte[2048];
        int len;
        while ((len = is.read(b)) != -1){

            os.write(b,0,len);
        }
        is.close();
        os.close();
    }
}