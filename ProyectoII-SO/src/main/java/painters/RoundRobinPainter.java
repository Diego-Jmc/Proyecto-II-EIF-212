/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package painters;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Timer;
import logic.ProgramProcess;
import logic.RoundRobinProcess;

/**
 *
 * @author diego
 */
public class RoundRobinPainter extends javax.swing.JPanel {
    
   private static final int RECTANGLE_HEIGHT = 50;
    private static final int MARGIN = 50; // Margen a los lados
    private static final Color RECTANGLE_COLOR = Color.RED;
    private static final Color BORDER_COLOR = Color.BLACK;
    private static final int DELAY = 1000; // Retraso de 1 segundo entre iteraciones

    private List<ProgramProcess> procesos;
    private int currentIndex;
    private Timer timer;
  
    
    
    public RoundRobinPainter(List<ProgramProcess> procesos) {
        this.procesos = procesos;
        setPreferredSize(new Dimension(1200, 600));
        currentIndex = 0;

        ActionListener timerAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                repaint(); // Vuelve a pintar el componente en cada iteración del timer
                currentIndex++;
                if (currentIndex >= procesos.size()) {
                    timer.stop();
                }
            }
        };

        timer = new Timer(DELAY, timerAction);
        timer.setInitialDelay(0); // Sin retardo inicial
        initComponents();
    }
  @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        FontMetrics fontMetrics = g.getFontMetrics();

        int totalDuration = 0;
        for (ProgramProcess proceso : procesos) {
            totalDuration += proceso.getDurationTime();
        }

        int startX = MARGIN; // Starting X-coordinate

        int x = startX; // X-coordinate of the rectangle
        int y = getHeight() / 2 - RECTANGLE_HEIGHT / 2; // Y-coordinate of the rectangle

        int currentDuration = 0;

        String title = "ALGORITMO ROUND ROBIN";
        g.setFont(g.getFont().deriveFont(Font.BOLD, 20)); // Increase the font size and set it to bold
        int titleWidth = fontMetrics.stringWidth(title);
        int titleX = getWidth() / 2 - titleWidth / 2;
        int titleY = MARGIN / 2;
        g.drawString(title, titleX, titleY);

        for (int i = 0; i < currentIndex; i++) {
            ProgramProcess proceso = procesos.get(i);
            int duration = proceso.getDurationTime();
            int rectangleWidth = (int) ((double) duration / totalDuration * (getWidth() - 2 * MARGIN)); // Width adjusted for margin

            currentDuration += duration;

            String procesoName = proceso.getName();
            if (procesoName.equals(procesos.get(0).getName())) {
                g.setFont(g.getFont().deriveFont(Font.BOLD, 18)); // Increase the font size and set it to bold
                g.drawString("0", x + 5, y - 5); //
            }
            g.drawString(procesoName, x + rectangleWidth / 2 - fontMetrics.stringWidth(procesoName) / 2, y + RECTANGLE_HEIGHT / 2 + fontMetrics.getAscent() / 2);

            g.setColor(RECTANGLE_COLOR);
            g.fillRect(x, y, rectangleWidth, RECTANGLE_HEIGHT);
            g.setColor(BORDER_COLOR);
            g.drawRect(x, y, rectangleWidth, RECTANGLE_HEIGHT);
            g.setColor(Color.BLACK);
            g.setFont(g.getFont().deriveFont(Font.BOLD, 16)); // Increase the font size
            g.drawString(proceso.getName(), x + 5, y + RECTANGLE_HEIGHT / 2 + fontMetrics.getAscent() / 2);

            Font originalFont = g.getFont();
            Font boldFont = new Font(originalFont.getFontName(), Font.BOLD, originalFont.getSize() + 2); // Increase the font size
            g.setFont(boldFont);
            String durationText = String.valueOf(currentDuration);
            int durationTextWidth = fontMetrics.stringWidth(durationText);
            g.drawString(durationText, x + rectangleWidth - durationTextWidth, y - 5);
            g.setFont(originalFont);

            x += rectangleWidth;
        }
    }
    
    
    
    public void startAnimation() {
        timer.start();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
