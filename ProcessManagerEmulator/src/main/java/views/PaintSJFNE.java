/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import logic.ProcesoN;

/**
 *
 * @author Jordan Villalobos
 */
public class PaintSJFNE extends JPanel {

    private int[][] matriz; // La matriz con los valores de los rectángulos  ok la matriz con los valores de ejemplo
    private int tamañoRectanguloAncho; // Ancho del rectángulo en píxeles
    private int tamañoRectanguloAlto; // Alto del rectángulo en píxeles
    private int espaciadoHorizontal; // Espaciado horizontal entre rectángulos en píxeles
    private int espaciadoVertical; // Espaciado vertical entre rectángulos en píxeles
    private int currentIndex; // Índice del rectángulo actual
    private Timer timer; // Temporizador para la animación
    private List<ProcesoN> procesos;

    public PaintSJFNE(int[][] matriz, int tamañoRectanguloAncho, int tamañoRectanguloAlto,
            int espaciadoHorizontal, int espaciadoVertical, List<ProcesoN> pp) {

        this.matriz = matriz;
        this.tamañoRectanguloAncho = tamañoRectanguloAncho;
        this.tamañoRectanguloAlto = tamañoRectanguloAlto;
        this.espaciadoHorizontal = espaciadoHorizontal;
        this.espaciadoVertical = espaciadoVertical;
        this.currentIndex = 0;
        this.procesos = new ArrayList<>(pp);

        timer = new Timer(300, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint(); // Volver a dibujar el componente en cada evento del temporizador
                setCurrentIndex(getCurrentIndex() + 1); // Incrementar el índice para pasar al siguiente rectángulo

                if (getCurrentIndex() >= matriz.length * matriz[0].length) {
                    // Si se alcanza el final de la matriz, detener el temporizador
                    getTimer().stop();
                }
            }
        });

        timer.start(); // Iniciar el temporizador

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int startX = espaciadoHorizontal;
        int startY = 101;

        Font font = new Font("Arial", Font.BOLD, 18);

        g.setFont(font);

        int rows = matriz.length;
        int cols = matriz[0].length;

// Calcular el índice de fila y columna actual
        int currentRow = currentIndex / cols;
        int currentCol = currentIndex % cols;

        g.drawString(
                "Diagrama de GANTT ALGORITMO SJF NO EXPULSIVO", 350, 55);
        Graphics2D g2d = (Graphics2D) g;
        float grosorLinea = 5.0f; // Puedes ajustar el valor según el grosor deseado

        int tamañoTotalAncho = cols * tamañoRectanguloAncho + (cols - 1) * espaciadoHorizontal;
        int x1 = 0;
        int y1 = 100;
        int x2 = startX + cols * tamañoRectanguloAncho + (cols - 1) * espaciadoHorizontal;
        int y2 = 100;

        int valorr = 0;
        int prevX = 0; // Posición x del rectángulo anterior
        int contador = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matriz[i][j] == 1) { // Si el valor es 1, dibujar el rectángulo rojo
                    int x;
                    int y = startY;//+ i * tamañoRectanguloAlto;

                    if (j == 0) {
                        // Es la primera iteración, establecer x en 0
                        x = 0;
                    } else {
                        x = prevX;
                    }

                    if (i < currentRow || (i == currentRow && j <= currentCol)) {
                        g.setColor(Color.BLACK);
                        g.setColor(Color.RED);

                        if (i < procesos.size()) {
                            ProcesoN proceso = procesos.get(i);
                            proceso.setTiempoEspera(valorr);
                            if (contador == 0) {
                                String cc = String.valueOf(proceso.getArrivalTime());
                                g2d.drawString(cc, 18, 98);
                                valorr += proceso.getArrivalTime() + proceso.getDurationTime();
                                procesos.get(i).setCt(valorr);
                                contador++;
                            } else {
                                valorr += proceso.getDurationTime();
                                contador++;
                                procesos.get(i).setCt(valorr);
                            }

                            String c = String.valueOf(valorr);
                            g2d.setColor(Color.BLACK);
                            g.setColor(Color.RED);
                            g.fillRect(x, y, tamañoRectanguloAncho * proceso.getDurationTime() / 3, tamañoRectanguloAlto);
                            g.setColor(Color.BLACK);
                            g.drawRect(x, y, tamañoRectanguloAncho * proceso.getDurationTime() / 3, tamañoRectanguloAlto);
                            g.setColor(Color.WHITE);
                            g.drawString(proceso.getProcessName(), x + tamañoRectanguloAncho * proceso.getDurationTime() / 6 - 10, y + tamañoRectanguloAlto / 2 + 5);
                            g.setColor(Color.BLACK);
                            prevX = x + tamañoRectanguloAncho * proceso.getDurationTime() / 3;
                            g2d.drawString(c, prevX - 10, 98);

                            if (contador == procesos.size()) {
                                int ii = 0;
                                int counter2 = 0;
                                int counter3 = 1;
                                for (ProcesoN pp : procesos) {
                                    String pname = pp.getProcessName();
                                    int pTiempoEspero = (pp.getCt() - pp.getArrivalTime()) - pp.getDurationTime();
                                    counter2 += pTiempoEspero;
                                    g.drawString(pname + " TIEMPO DE ESPERA: " + pTiempoEspero, 400, startY + 200 + ii);
                                    ii += 30;
                                    counter3++;
                                }

                                double media = counter2 / (double) contador +1;

                                g.drawString("TIEMPO DE ESPERA MEDIO: " + media, 400, startY + 200 + ii);
                                g.setColor(Color.BLACK);
                                g.setColor(Color.BLACK);
                                g.drawString("TIEMPO DE ESPERA MEDIO: " + media, 400, startY + 200 + ii);
                                g.setColor(Color.BLACK);
                                g.drawString("El algoritmo SJF NO EXPULSIVO ha terminado, diagrama completo", 400, startY + 250 + ii);
                                JButton button = new JButton("Salir");
                                button.setBounds(600, startY + 260 + ii, 100, 30);
                                button.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(button);
                                        frame.dispose(); // Cerrar la ventana
                                    }
                                });
                                add(button);
                            }
                        }
                    }
                }
            }

// Iterar sobre la matriz y dibujar los rectángulos 
        }
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }

    public int getTamañoRectanguloAncho() {
        return tamañoRectanguloAncho;
    }

    public void setTamañoRectanguloAncho(int tamañoRectanguloAncho) {
        this.tamañoRectanguloAncho = tamañoRectanguloAncho;
    }

    public int getTamañoRectanguloAlto() {
        return tamañoRectanguloAlto;
    }

    public void setTamañoRectanguloAlto(int tamañoRectanguloAlto) {
        this.tamañoRectanguloAlto = tamañoRectanguloAlto;
    }

    public int getEspaciadoHorizontal() {
        return espaciadoHorizontal;
    }

    public void setEspaciadoHorizontal(int espaciadoHorizontal) {
        this.espaciadoHorizontal = espaciadoHorizontal;
    }

    public int getEspaciadoVertical() {
        return espaciadoVertical;
    }

    public void setEspaciadoVertical(int espaciadoVertical) {
        this.espaciadoVertical = espaciadoVertical;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

}