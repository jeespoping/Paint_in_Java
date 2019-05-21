package paint_in_java;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;

public class EscogerColor extends JDialog implements ActionListener{
    JColorChooser jcolor = new JColorChooser(); //ventana para escoger color
    JButton btAceptar = new JButton("Aceptar");
    Dibujar d;
    
    EscogerColor(Dibujar dib){
        //Obtenemos el obnjeto dibujar para poder manipular la variable color
        d = dib;
        //El this es debido a que esta clase implementa actionlistener
        btAceptar.addActionListener(this);
        add(jcolor);
        add(btAceptar);
        setLayout(new FlowLayout());
        setSize(500,430);
        setTitle("Escoge el color...=");
        setVisible(true);
        setLocation(220,100);
        setResizable(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btAceptar){
            //modificamos el color
            d.color = jcolor.getColor();
        }
        dispose();
    }
    
}

