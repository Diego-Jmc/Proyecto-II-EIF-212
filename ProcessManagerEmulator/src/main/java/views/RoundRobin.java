/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import controllers.RoudRobinController;
import java.awt.Label;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import models.RoundRobinModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import logic.ProcesoN;


/**
 *
 * @author Jordan Villalobos
 */


public class RoundRobin extends javax.swing.JFrame implements Observer{
    
    
     private RoundRobinModel model;
     private RoudRobinController  controller;
     private int contador;
     List<ProcesoN> procesos = new ArrayList<>();
     PaintRR painter;

     int quantum = 2;
     
       public RoundRobinModel getModel(){
         
         return model;
     }
     
       public RoudRobinController getController() {
        return controller;
    }

    public void setController(RoudRobinController controller) {
        this.controller = controller;
    }
     public void setModel(RoundRobinModel  model){
         
         this.model = model;
         model.addObserver(this);

     }
     

    /**
     * Creates new form RoundRobin
     */
    public RoundRobin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        RafagaFD = new javax.swing.JTextField();
        agregarbt = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        llegada = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        label1.setName("title"); // NOI18N
        label1.setText("Algoritmo de planificacion Round Robin");

        jLabel1.setText("Agregar Proceso");

        jLabel2.setText("Rafaga");

        agregarbt.setText("Agregar");
        agregarbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarbtActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("LISTA DE PROCESOS");

        jLabel4.setText("Quantum");

        jButton2.setText("Iniciar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#Proceso", "Rafaga", "Tiempo Llegada"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jLabel5.setText("Llegada");

        llegada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                llegadaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(377, 377, 377)
                            .addComponent(jLabel4)
                            .addGap(26, 26, 26)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(11, 11, 11)
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(llegada, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(34, 34, 34)
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(RafagaFD, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(agregarbt)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(368, 368, 368)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(463, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(RafagaFD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agregarbt)
                    .addComponent(jLabel5)
                    .addComponent(llegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jButton2))
                .addContainerGap(240, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarbtActionPerformed
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        String proceso = "P" + contador;
        int rafaga = Integer.parseInt(RafagaFD.getText());
        int llegadaa = Integer.parseInt(llegada.getText());

        ProcesoN p = new ProcesoN(proceso, llegadaa, rafaga);
        //verificar que no se haya ya puesto un proceso en esa llegada
        int counter = 0;

        for (ProcesoN pp : procesos) {
            if (p.getArrivalTime() == pp.getArrivalTime()) {
                counter = 1;
            }
            System.out.println(pp.getProcessName());
        }

        if (counter == 0) {
            procesos.add(p);
            model.addRow(new Object[]{proceso, llegadaa, rafaga});

            this.contador++;
        } else {
            JOptionPane.showMessageDialog(null, "¡El tiempo de llegada ya ha sido ocupado por otro proceso!!!", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_agregarbtActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       int cant = procesos.size();
        int total = 0;
        int maxArrivalTime = 0;

// Calcular la suma total de los tiempos de duración y encontrar el mayor tiempo de llegada
        for (int i = 0; i < procesos.size(); i++) {
            total += procesos.get(i).getDurationTime();
            maxArrivalTime = Math.max(maxArrivalTime, procesos.get(i).getArrivalTime());
        }
        
        ordenarProcesosRR();
        int[][] matrizEjemplo = new int[cant][total + maxArrivalTime];
     
        for (int i = 0; i < procesos.size(); i++) {
            ProcesoN p = procesos.get(i);
            matrizEjemplo[i][p.getArrivalTime()] = 1;
        }

        int tamañoRectanguloAncho = 150; // Ancho del rectángulo en píxeles
        int tamañoRectanguloAlto = 90; // Alto del rectángulo en píxeles
        int espaciadoHorizontal = 25; // Espaciado horizontal entre rectángulos en píxeles
        int espaciadoVertical = 25; // Espaciado vertical entre rectángulos en píxeles

        SwingUtilities.invokeLater(() -> {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            // Crear el marco principal y agregar el componente personalizado
            JFrame frame = new JFrame("Resolucion del algoritmo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);

            painter = new PaintRR(matrizEjemplo, tamañoRectanguloAncho, tamañoRectanguloAlto,
                    espaciadoHorizontal, espaciadoVertical, procesos);
            frame.add(painter);

            frame.setVisible(true);

            for (int i = procesos.size() - 1; i >= 0; i--) {
                model.removeRow(i);
            }
            // Operación procesos.clear() dentro de invokeLater
            procesos.clear();
            contador = 0;
        });

    }//GEN-LAST:event_jButton2ActionPerformed

    private void llegadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_llegadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_llegadaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RoundRobin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RoundRobin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RoundRobin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RoundRobin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RoundRobin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField RafagaFD;
    private javax.swing.JButton agregarbt;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private java.awt.Label label1;
    private javax.swing.JTextField llegada;
    // End of variables declaration//GEN-END:variables

     private void ordenarProcesosRR() {
    List<ProcesoN> procesosFinal = new ArrayList<>();
    int tiempo = 0;

    while (!procesos.isEmpty()) {
        List<ProcesoN> procesosLlegados = new ArrayList<>();

        for (ProcesoN proceso : procesos) {
            if (proceso.getArrivalTime() <= tiempo) {
                procesosLlegados.add(proceso);
            }
        }

        if (!procesosLlegados.isEmpty()) {
            ProcesoN pp = procesosLlegados.get(0);
            int nuevoEjecucion = Math.min(pp.getDurationTime(), quantum);
            ProcesoN aux = new ProcesoN(pp.getProcessName(), pp.getArrivalTime(), nuevoEjecucion);

            pp.setDurationTime(pp.getDurationTime() - nuevoEjecucion);

            procesosFinal.add(aux);
            tiempo += nuevoEjecucion;

            if (pp.getDurationTime() <= 0) {
                procesos.remove(pp);
            }
        } else {
            tiempo++;
        }
    }
    procesos = procesosFinal;
}
    
    @Override
    public void update(Observable o, Object arg) {
      this.repaint();
    }

    public java.awt.Label getLabel1() {
        return label1;
    }

    public void setLabel1(java.awt.Label label1) {
        this.label1 = label1;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public javax.swing.JTextField getRafagaFD() {
        return RafagaFD;
    }

    public void setRafagaFD(javax.swing.JTextField RafagaFD) {
        this.RafagaFD = RafagaFD;
    }

    public javax.swing.JButton getAgregarbt() {
        return agregarbt;
    }

    public void setAgregarbt(javax.swing.JButton agregarbt) {
        this.agregarbt = agregarbt;
    }

    public javax.swing.JButton getjButton2() {
        return jButton2;
    }

    public void setjButton2(javax.swing.JButton jButton2) {
        this.jButton2 = jButton2;
    }

    public javax.swing.JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(javax.swing.JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public javax.swing.JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(javax.swing.JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public javax.swing.JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(javax.swing.JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public javax.swing.JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(javax.swing.JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public javax.swing.JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public void setjScrollPane2(javax.swing.JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public javax.swing.JTable getjTable1() {
        return jTable1;
    }

    public void setjTable1(javax.swing.JTable jTable1) {
        this.jTable1 = jTable1;
    }

    public javax.swing.JTextField getjTextField2() {
        return jTextField2;
    }

    public void setjTextField2(javax.swing.JTextField jTextField2) {
        this.jTextField2 = jTextField2;
    }
}
