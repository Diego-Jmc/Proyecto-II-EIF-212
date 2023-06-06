/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class PaintFifo extends JPanel {

    private int[][] matriz; // La matriz con los valores de los rectángulos  ok la matriz con los valores de ejemplo
    private int tamañoRectanguloAncho; // Ancho del rectángulo en píxeles
    private int tamañoRectanguloAlto; // Alto del rectángulo en píxeles
    private int espaciadoHorizontal; // Espaciado horizontal entre rectángulos en píxeles
    private int espaciadoVertical; // Espaciado vertical entre rectángulos en píxeles
    private int currentIndex; // Índice del rectángulo actual
    private Timer timer; // Temporizador para la animación

    public PaintFifo(int[][] matriz, int tamañoRectanguloAncho, int tamañoRectanguloAlto,
            int espaciadoHorizontal, int espaciadoVertical) {
        this.matriz = matriz;
        this.tamañoRectanguloAncho = tamañoRectanguloAncho;
        this.tamañoRectanguloAlto = tamañoRectanguloAlto;
        this.espaciadoHorizontal = espaciadoHorizontal;
        this.espaciadoVertical = espaciadoVertical;
        this.currentIndex = 0;

        // Configurar el temporizador para invocar el método actionPerformed cada 1000 milisegundos (1 segundo)
        timer = new Timer(950, new ActionListener() {
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
        int startY = espaciadoVertical;

        Font font = new Font("Arial", Font.BOLD, 18);
        g.setFont(font);

        int rows = matriz.length;
        int cols = matriz[0].length;

        // Calcular el índice de fila y columna actual
        int currentRow = currentIndex / cols;
        int currentCol = currentIndex % cols;

        // Iterar sobre la matriz y dibujar los rectángulos rojos
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matriz[i][j] == 1) { // Si el valor es 1, dibujar el rectángulo rojo
                    int x = startX + j * (tamañoRectanguloAncho + espaciadoHorizontal);
                    int y = startY + i * (tamañoRectanguloAlto + espaciadoVertical);

                    if (i < currentRow || (i == currentRow && j <= currentCol)) {

                        // Establecer el grosor de la línea
                         int x1 = 0;
        int y1 = getHeight() / 2;
        int x2 = getWidth() - 10;
        int y2 = getHeight() / 2;

        Graphics2D g2d = (Graphics2D) g;

        // Establecer el grosor de la línea
        float grosorLinea = 5.0f; // Puedes ajustar el valor según el grosor deseado
        g2d.setStroke(new BasicStroke(grosorLinea));

        // Dibujar la línea
        g2d.drawLine(x1, y1, x2, y2);

                        g.setColor(Color.BLACK);
                      
                        g.setColor(Color.RED);
                        g.fillRect(x, y, tamañoRectanguloAncho, tamañoRectanguloAlto);

                        // Pintar etiqueta en blanco
                        g.setColor(Color.WHITE);
                        g.drawString("P" + (i + 1), x + tamañoRectanguloAncho / 2 - 10, y + tamañoRectanguloAlto / 2 + 5);

                    }
                }
            }
        }
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

}
