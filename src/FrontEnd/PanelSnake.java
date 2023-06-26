package FrontEnd;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelSnake extends JPanel {

//    Color ColorSnake = Color.MAGENTA;
//    Color ColorComida = Color.GREEN;
    int tamanoMax, tamano, cantidad, residuo;
    List<int[]> snake = new ArrayList<>();
    int[] comida = new int[2];
    String direccionActual = "Izquierda";
    String direccionProxima = "Izquierda";

    private Image imagenComida;
    private Image imagenCabeza;
    private Image imagenCuerpo;
    private Image imagenInvertirCabeza;

    Thread hilo;
    Caminante camino;

    public PanelSnake(int tamanoMax, int cantidad) {
        this.tamanoMax = tamanoMax;
        this.cantidad = cantidad;
        this.tamano = tamanoMax / cantidad;
        this.residuo = tamanoMax % cantidad;
        int[] a = {cantidad / 2 - 1, cantidad / 2 - 1};
        int[] b = {cantidad / 2, cantidad / 2 - 1};
        snake.add(a);
        snake.add(b);
        generarComida();

        imagenComida = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/IMG/Manzanas.png"));
        imagenCabeza = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/IMG/Cabeza.gif"));
        imagenInvertirCabeza = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/IMG/InvertirCabeza.gif"));
        imagenCuerpo = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/IMG/HuevoYoshi.png"));

        camino = new Caminante(this);
        hilo = new Thread(camino);
        hilo.start();
    }

    @Override
    public void paint(Graphics pintor) {
        super.paint(pintor);
//        pintor.setColor(ColorSnake);

        //Recorrer Serpiente
        if (direccionActual == "Derecha" || direccionActual == "Abajo") {
            pintor.drawImage(imagenCabeza, residuo / 2 + snake.get(0)[0] * tamano, residuo / 2 + snake.get(0)[1] * tamano, tamano, tamano, this);
        } else if (direccionActual == "Izquierda" || direccionActual == "Arriba") {
            pintor.drawImage(imagenInvertirCabeza, residuo / 2 + snake.get(0)[0] * tamano, residuo / 2 + snake.get(0)[1] * tamano, tamano, tamano, this);
        }
//        for (int[] par : snake) {
        for (int i = 1; i < snake.size(); i++) {
            pintor.drawImage(imagenCuerpo, residuo / 2 + snake.get(i)[0] * tamano, residuo / 2 + snake.get(i)[1] * tamano, tamano, tamano, this);
//            pintor.fillRect(residuo / 2 + par[0] * tamano, residuo / 2 + par[1] * tamano, tamano - 1, tamano - 1);
        }

        //Pintar casillas de comida
        pintor.drawImage(imagenComida, residuo / 2 + comida[0] * tamano, residuo / 2 + comida[1] * tamano, tamano - 1, tamano - 1, this);
//        pintor.setColor(ColorComida);
//        pintor.fillRect(residuo / 2 + comida[0] * tamano, residuo / 2 + comida[1] * tamano, tamano - 1, tamano - 1);
    }

    public void avanzar() {
        igualarDireccion();
        int[] primeraCasilla = snake.get(0); // Obtener la primera casilla (cabeza)
        int agregarX = 0;
        int agregarY = 0;

        switch (direccionActual) {
            case "Derecha":
                agregarX = 1;
                break;
            case "Izquierda":
                agregarX = -1;
                break;
            case "Arriba":
                agregarY = -1;
                break;
            case "Abajo":
                agregarY = 1;
                break;
        }

        int[] nuevo = {Math.floorMod(primeraCasilla[0] + agregarX, cantidad),
            Math.floorMod(primeraCasilla[1] + agregarY, cantidad)};

        boolean existe = false;
        for (int i = 0; i < snake.size(); i++) {
            if (nuevo[0] == snake.get(i)[0] && nuevo[1] == snake.get(i)[1]) {
                existe = true;
                break;
            }
        }
        if (existe) {
            JOptionPane.showMessageDialog(this, "Has perdido");
        } else {
            if (nuevo[0] == comida[0] && nuevo[1] == comida[1]) {
                snake.add(0, nuevo); // Agregar el nuevo segmento al principio de la lista
                generarComida();
            } else {
                snake.add(0, nuevo); // Agregar el nuevo segmento al principio de la lista
                snake.remove(snake.size() - 1); // Eliminar el último segmento (cola) de la serpiente
            }
        }
    }

    public void generarComida() {
        boolean existe = false;
        int a = (int) (Math.random() * cantidad);
        int b = (int) (Math.random() * cantidad);

        for (int[] par : snake) {
            if (par[0] == a && par[1] == b) {
                existe = true;
                generarComida();
                break;
            }
        }
        if (!existe) {
            this.comida[0] = a;
            this.comida[1] = b;
        }
    }

    public void cambiarDireccion(String dir) {
        if ((this.direccionActual.equals("Derecha") || this.direccionActual.equals("Izquierda")) && (dir.equals("Arriba") || dir.equals("Abajo"))) {
            this.direccionProxima = dir;
        }
        if ((this.direccionActual.equals("Arriba") || this.direccionActual.equals("Abajo")) && (dir.equals("Izquierda") || dir.equals("Derecha"))) {
            this.direccionProxima = dir;
        }
    }

    public void igualarDireccion() {
        this.direccionActual = this.direccionProxima;
    }
}
