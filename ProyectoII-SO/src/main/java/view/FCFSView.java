/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.FCFSController;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import logic.FifoProcess;
import logic.ProcesoFIFO;
import model.FCFSModel;
import painters.FCFSPainter;

/**
 *
 * @author diego
 */
public class FCFSView extends javax.swing.JFrame implements Observer{

   FCFSModel model;
   FCFSController controller;
   private int contador;
   FCFSPainter painter;
    
   
    private List<ProcesoFIFO> ordenarFCFS() {
       Comparator<ProcesoFIFO> comparador = Comparator.comparingInt(ProcesoFIFO::getArrivalTime);
       List<ProcesoFIFO> sortedList = new ArrayList<>(model.getProcessesList());
       Collections.sort(sortedList, comparador);
       return sortedList;
    }


    public FCFSModel getModel() {
        return model;
    }

    public void setModel(FCFSModel model) {
        this.model = model;
        model.addObserver(this);
    }

    public FCFSController getController() {
        return controller;
    }

    public void setController(FCFSController controller) {
        this.controller = controller;
    }
   
    
    
    public FCFSView() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        arrivalTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cpuTimeTxt = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table);

        jButton1.setText("Iniciar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Llegada");

        arrivalTxt.setPreferredSize(new java.awt.Dimension(100, 22));

        jLabel3.setText("Rafaga");

        cpuTimeTxt.setPreferredSize(new java.awt.Dimension(100, 22));

        jButton2.setBackground(new java.awt.Color(204, 255, 204));
        jButton2.setText("Agregar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("ALGORITMO FCFS");

        jButton3.setText("Atras");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(arrivalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(109, 109, 109)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(cpuTimeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton1)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jButton3)))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(arrivalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cpuTimeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     private String getProcessName(){
        return "P" + (model.getProcessesList().size());
    }
    
    private boolean processExists(int arrival){
        return model.getProcessesList().stream().anyMatch(e-> e.getArrivalTime() == arrival);
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed


     String arrival = arrivalTxt.getText();
     String cpu = cpuTimeTxt.getText();
        
    if(!arrival.isBlank() && !cpu.isBlank()){
            try{
             int arrivalInt = Integer.parseInt(arrival);
             int cpuTimeInt = Integer.parseInt(cpu);
             
             if(processExists(arrivalInt))
                 throw new Exception();
             
             ProcesoFIFO process = new ProcesoFIFO(getProcessName(),arrivalInt ,cpuTimeInt);
             model.addProcess(process);
             
         }catch(java.lang.NumberFormatException e){
                     JOptionPane.showMessageDialog(null, "Debe escribir un numero!");
         } catch (Exception ex) {
                 JOptionPane.showMessageDialog(null, "Tiempo de llegada ocupado");

         }
        
    }else{
              JOptionPane.showMessageDialog(null, "No puede dejar espacios en blanco!");
     }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int cant = model.getProcessesList().size();
        int total = 0;
        int maxArrivalTime = 0;

// Calcular la suma total de los tiempos de duración y encontrar el mayor tiempo de llegada
        for (int i = 0; i < model.getProcessesList().size(); i++) {
            total += model.getProcessesList().get(i).getDurationTime();
            maxArrivalTime = Math.max(maxArrivalTime, model.getProcessesList().get(i).getArrivalTime());
        }

        int[][] matrizEjemplo = new int[cant][total + maxArrivalTime];
        List<ProcesoFIFO> sortedList =  ordenarFCFS();

        for (int i = 0; i < model.getProcessesList().size(); i++) {
            ProcesoFIFO p = model.getProcessesList().get(i);
            matrizEjemplo[i][p.getArrivalTime()] = 1;
        }

        int tamañoRectanguloAncho = 120; // Ancho del rectángulo en píxeles
        int tamañoRectanguloAlto = 60; // Alto del rectángulo en píxeles
        int espaciadoHorizontal = 25; // Espaciado horizontal entre rectángulos en píxeles
        int espaciadoVertical = 25; // Espaciado vertical entre rectángulos en píxeles

        SwingUtilities.invokeLater(() -> {
            // Crear el marco principal y agregar el componente personalizado
            JFrame frame = new JFrame("Resolucion del algoritmo");
            frame.setSize(1200, 700);

            painter = new FCFSPainter(matrizEjemplo, tamañoRectanguloAncho, tamañoRectanguloAlto,
                    espaciadoHorizontal, espaciadoVertical, sortedList);
            frame.add(painter);

            frame.setVisible(true);

        });




    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
           controller.returnToMainMenu();
    }//GEN-LAST:event_jButton3ActionPerformed

    @Override
    public void update(Observable o, Object arg) {
        table.setModel(model.getProcessTable());   
    }

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField arrivalTxt;
    private javax.swing.JTextField cpuTimeTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
