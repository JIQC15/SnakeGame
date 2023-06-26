
package FrontEnd;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

public class PanelFondo extends JPanel {
    Color ColorFondo = new Color(39, 135, 39);
    int tamanoMax, tamano, cantidad, residuo;
    
    private Image imagenFondo;
    
    public PanelFondo(int tamanoMax, int cantidad){
        this.tamanoMax = tamanoMax;
        this.cantidad = cantidad;
        this.tamano = tamanoMax / cantidad;
        this.residuo = tamanoMax%cantidad;
        
        imagenFondo = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/IMG/desierto.png"));

    }

    @Override
    public void paint(Graphics pintor){
        super.paint(pintor);
        pintor.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
        pintor.setColor(ColorFondo);
        for (int i = 0; i < cantidad; i++) {
            for (int j = 0; j < cantidad; j++) {
                pintor.fillRect(residuo/2+i*tamano, residuo/2+j*tamano, tamano-1, tamano-1);
            }
        }
    }
}
