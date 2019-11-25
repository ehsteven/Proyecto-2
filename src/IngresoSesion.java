import javax.swing.*;
import javax.swing.text.Position;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IngresoSesion extends JFrame{
    Usuarios u = new Usuarios();
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

        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = campoUsuario.getText();
                String pass = String.valueOf(campoPass.getPassword());
                boolean state = u.validarIngreso(user, pass);
                if (state){
                    //VentanaPeliculas ventanaPeliculas = new VentanaPeliculas(user)
                    //ventanaPeliculas.setVisible(true)
                    //
                }else{

                }

            }
        });
    }
}
