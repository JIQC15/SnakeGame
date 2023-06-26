package FrontEnd;

import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

public class Vista extends javax.swing.JFrame{

    PanelSnake panel;

    public Vista() {
        initComponents();
        setTitle("Snake");
        this.setLocationRelativeTo(null);
        setResizable(false);

        panel = new PanelSnake(800, 9);
        this.add(panel);
        panel.setBounds(10, 10, 800, 800);
        panel.setOpaque(false);

        PanelFondo fondo = new PanelFondo(800, 9);
        this.add(fondo);
        fondo.setBounds(10, 10, 800, 800);
        
        this.requestFocus(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(231, 178, 71));
        setPreferredSize(null);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 820, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 820, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                panel.cambiarDireccion("Izquierda");
                break;
            case KeyEvent.VK_RIGHT:
                panel.cambiarDireccion("Derecha");
                break;
            case KeyEvent.VK_UP:
                panel.cambiarDireccion("Arriba");
                break;
            case KeyEvent.VK_DOWN:
                panel.cambiarDireccion("Abajo");
                break;
            default:
                break;
        }
        
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_A:
                panel.cambiarDireccion("Izquierda");
                break;
            case KeyEvent.VK_D:
                panel.cambiarDireccion("Derecha");
                break;
            case KeyEvent.VK_W:
                panel.cambiarDireccion("Arriba");
                break;
            case KeyEvent.VK_S:
                panel.cambiarDireccion("Abajo");
                break;
            default:
                break;
        }
    }//GEN-LAST:event_formKeyPressed

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
    
    }//GEN-LAST:event_formKeyTyped

    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
