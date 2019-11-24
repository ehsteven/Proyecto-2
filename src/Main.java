import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Usuarios u = new Usuarios("Esteven11", "m");
        boolean a = u.validarIngreso(u.getNombreUsuario(), u.getContrasenna());
        System.out.println(a);
//        u.registrarUsuario(u);

//        Prueba p = new Prueba();
//        while (true) {
//            Scanner sn = new Scanner(System.in);
//            System.out.print("Nombre: ");
//            String nombre = sn.nextLine();
//            System.out.print("Año: ");
//            String anno = sn.nextLine();
//            p.jsonPrueba(nombre, anno);
//        }
    }
}
