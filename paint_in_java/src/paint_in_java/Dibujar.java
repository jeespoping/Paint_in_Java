package paint_in_java;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class Dibujar {
    
    //puntos
    int X;
    int Y;
    //Color
    Color color = new Color(0,0,0);
    
    public Dibujar(){
    }
    
    //funcion que actuara como click cuando le de en cualquier lugar
    public void leerCoordenadas(MouseEvent ev){
        
        if(!ev.isMetaDown()){ // si no es click derecho
            //obtenemos el punto
            X = ev.getX();
            Y = ev.getY();
        }
    }
    
    public void pintar(MouseEvent ev,int grosor){
        if(!ev.isAltDown()){
            Graphics2D g = (Graphics2D) ((JPanel)ev.getSource()).getGraphics();
            g.setStroke(new BasicStroke(grosor));
            g.setColor(color);
            //punto final de la linea
            int x = ev.getX();
            int y = ev.getY();
            g.drawLine(X, Y, x, y);
            //liberamos recursos
            g.dispose();
            X =x;
            Y = y;
        }
        else{
            Graphics2D g = (Graphics2D) ((JPanel)ev.getSource()).getGraphics();
            g.setStroke(new BasicStroke(grosor));
            g.setColor(Color.white);
            int x = ev.getX();
            int y = ev.getY();
            g.drawLine(X, Y, x, y);
            //liberamos recursos
            g.dispose();
            X =x;
            Y = y;
        }
    }
}
