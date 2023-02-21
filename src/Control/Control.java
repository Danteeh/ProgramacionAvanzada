package Control;

import Modelo.Vino;
import Vista.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

public class Control implements ActionListener {

    private Vino modelo;
    private Vista vista;
    private ArrayList Vinos_lista;

    public Control() {

        this.modelo = new Vino();
        this.vista = new Vista();
        Vinos_lista = new ArrayList();
        this.vista.btn_buscar.addActionListener(this);
        this.vista.btn_insertar.addActionListener(this);
        this.vista.btn_limpiar.addActionListener(this);
        this.vista.btn_salir.addActionListener(this);

    }

    public void iniciar() {

        this.vista.setTitle("SIstema de vinos");
        this.vista.setVisible(true);
        this.vista.setLocationRelativeTo(null);

    }

    public boolean buscarVino (String id) {
        Iterator it = Vinos_lista.iterator();
        boolean existe = false;
        Vino aux;
        while (it.hasNext()) {
            aux = (Vino) it.next();
            if (aux.getIdentificacion().equals(id)) {
                existe = true;
            }
        }
        return existe;
    }

    public void crearVino(String id, String Color, String Edad, String Marca) {
        modelo = new Vino();
        modelo.setIdentificacion(id);
        modelo.setColor(Color);
        modelo.setEdad(Edad);
        modelo.setMarca(Marca);
        Vinos_lista.add(modelo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.btn_limpiar) {
            this.vista.blanquear_campos();
        }
        if (e.getSource() == this.vista.btn_salir) {
            this.vista.setVisible(false);
            this.vista.dispose();
        }

        if (e.getSource() == this.vista.btn_insertar) {

            if (this.vista.txtf_Identificacion1.getText().equals("") || this.vista.txtf_color.getText().equals("")
                    || this.vista.txtf_marca.getText().equals("") || this.vista.txtf_edad.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Algun campo se encuentra vacio por favor completarlo");
            } else if (Vinos_lista.isEmpty() || buscarVino(this.vista.txtf_Identificacion1.getText()) == false) {
                crearVino(this.vista.txtf_Identificacion1.getText(), this.vista.txtf_color.getText(), this.vista.txtf_edad.getText(), this.vista.txtf_marca.getText());
                JOptionPane.showMessageDialog(null, "Vino registrado con exito");
            } else {
                JOptionPane.showMessageDialog(null, "Este vino ya se encuentra registrado");

            }
            
        }
        if (e.getSource() == this.vista.btn_buscar){
            if (buscarVino(this.vista.txtf_Identificacion.getText()) == true){
                
                
            }
        }
    }

}
