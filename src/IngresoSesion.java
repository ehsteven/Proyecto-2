import javax.swing.*;
import javax.swing.text.Position;
import java.awt.*;

public class IngresoSesion extends JFrame{
    private JPanel root;
    private JTextField campoUsuario;
    private JPasswordField campoPass;
    private JButton ingresarButton;
    private JButton crearCuentaButton;
    private JButton salirButton;

    public IngresoSesion() {
        add(root);
        setTitle("Inicio Sesión");
        setLocationRelativeTo(null);
        setSize(300, 300);

    }
}
