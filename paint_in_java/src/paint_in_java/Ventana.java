
package paint_in_java;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EtchedBorder;

public class Ventana extends JFrame{
    //Objeto de tipo dibujar
    Dibujar objdibujar = new Dibujar();
    
    public Ventana(){
        
     super("Paint versiona 1.0");
        setVisible(true); //visibilidad
        setSize(650,600);
        setLocationRelativeTo(null);
        setResizable(false); //no se puede redimencionar
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Cerrar ventana
        initComponents();
    }
    
    public void initComponents(){
        getContentPane().setLayout(null);
        color.setBounds(10, 80, 150, 25);
        grosorTrazo.setBounds(265, 40, 100, 25);
        grosorTrazo.setFont(f1);
        grosor.setMaximum(10);
        grosor.setBounds(230, 80, 150, 25);
        clean.setBounds(450, 80, 150, 25);
        clean.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                //se vuelve a dibujar el panel cuande se de click en el boton apint
                panelDibujo.repaint();
            }
        });
        panelDibujo.setBounds(10,150,600,420);
        panelDibujo.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        panelDibujo.setBackground(Color.white);
        panelDibujo.addMouseListener(new MouseAdapter() {
            
            public void mousePressed(MouseEvent e) {
                objdibujar.leerCoordenadas(e);
            }
        });
        panelDibujo.addMouseMotionListener(new MouseAdapter() {
            
            public void mouseDragged(MouseEvent e){
                //actua hasta que se suelte el click del mouse
                objdibujar.pintar(e, grosor.getValue());
            }
            
        });
        getContentPane().add(color);
        getContentPane().add(grosorTrazo);
        getContentPane().add(grosor);
        getContentPane().add(clean);
        getContentPane().add(panelDibujo);
    }
    
    //Controles
    Font f1 = new Font("segoe UI",Font.PLAIN,15); //Fuente
    
    JButton color = new JButton("Elejir color");
    JButton clean = new JButton("Limpiar");
    JLabel grosorTrazo = new JLabel("Grosor Trazo");
    JSlider grosor = new JSlider();
    JPanel panelDibujo = new JPanel();
}
