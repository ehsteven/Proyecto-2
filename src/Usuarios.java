import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Usuarios {
    private String nombreUsuario;
    private String contrasenna;
    private ArrayList<Usuarios> listaUsuariosIngresados = new ArrayList<>();

    public Usuarios() {
    }

    public Usuarios(String nombreUsuario, String contrasenna) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenna = contrasenna;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    public ArrayList<Usuarios> getListaUsuariosIngresados() {
        return listaUsuariosIngresados;
    }

    public void setListaUsuariosIngresados(ArrayList<Usuarios> listaUsuarios) {
        this.listaUsuariosIngresados = listaUsuariosIngresados;
    }

    public void registrarUsuario(Usuarios usuarioNuevo){  //registrarUsuario(new Usuario(name , pass))
        listaUsuariosIngresados = cargarUsuarios();
        boolean state = true;
        for (Usuarios a : listaUsuariosIngresados){
            if (a.getNombreUsuario().equals(usuarioNuevo.nombreUsuario)){
                JOptionPane.showMessageDialog(null, "Nombre de usuario ya usado");
                state = false; break;}
                if(usuarioNuevo.getContrasenna().length() < 8)
                    JOptionPane.showMessageDialog(null, "La contraseña es muy corta!");
            }
        if(state){
            listaUsuariosIngresados.add(usuarioNuevo);
            guardarUsuariosCSV(listaUsuariosIngresados);
            JOptionPane.showMessageDialog(null, "Usuario creado con éxito!");
        }
    }

    public void guardarUsuariosCSV(ArrayList<Usuarios> lista){
        String salidaArchivo = "src\\CSV\\Usuarios.csv";
        boolean exite = new File(salidaArchivo).exists();
        String [] datos = {"Usuario", "Contrasena"};
        if (exite){
            File archivoUsuarios = new File(salidaArchivo);
            archivoUsuarios.delete();
        }
        try{
            CsvWriter salidaCsv = new CsvWriter(new FileWriter(salidaArchivo, true), ';');
            salidaCsv.writeRecord(datos);
            for (Usuarios a : lista ){
                salidaCsv.writeRecord(new String[] {a.getNombreUsuario(), a.getContrasenna()});
            }
            salidaCsv.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList cargarUsuarios(){
        ArrayList<Usuarios> usuarios = new ArrayList<>();
        try{
            CsvReader leeUsuario = new CsvReader("src\\CSV\\Usuarios.csv");
            String[] next;
            leeUsuario.readHeaders();
            while(leeUsuario.readRecord()){
                String[] datos = leeUsuario.getValues()[0].split(";");
                String nombre = datos[0];
                String pass = datos[1];
                usuarios.add(new Usuarios(nombre, pass));
            }
            leeUsuario.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public boolean validarIngreso(String nombreUsuario, String pass){
        listaUsuariosIngresados = cargarUsuarios();
        boolean state = true;
        for(Usuarios a : listaUsuariosIngresados){
            if (a.getNombreUsuario().equals(nombreUsuario) & a.getContrasenna().equals(pass))
                state = true;
            else
                JOptionPane.showMessageDialog(null, "Datos ingresados incorrectos!");
                state = false;
        }
        return state;
    }

}
