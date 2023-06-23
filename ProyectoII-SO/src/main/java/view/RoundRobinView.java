/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.RoundRobinController;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Queue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import logic.FifoProcess;
import logic.ProgramProcess;
import model.RoundRobinModel;
import painters.PaintRoundRobin;
import painters.RoundRobinPainter;

public class RoundRobinView extends javax.swing.JFrame implements Observer {
    
        private RoundRobinModel model;
        private RoundRobinController controller;
        private RoundRobinPainter painter;
     
     public void paintDiagram(int quantum){
        int cant = model.getProcessesList().size();
        int total = 0;
        int maxArrivalTime = 0;

        for (int i = 0; i < model.getProcessesList().size(); i++) {
            total += model.getProcessesList().get(i).getCpuTime();
            maxArrivalTime = Math.max(maxArrivalTime, model.getProcessesList().get(i).getCpuTime());
        }


        List<ProgramProcess> sortedList = roundRobin(quantum); 
         JFrame frame = new JFrame("Round Robin FIFO");
         frame.setSize(1400, 800);
         painter = new RoundRobinPainter(sortedList);
         frame.add(painter);
         frame.setVisible(true);
         painter.startAnimation();
 
     }
      
    public RoundRobinModel getModel() {
        return model;
    }

    public void setModel(RoundRobinModel model) {
        this.model = model;
        model.addObserver(this);
    }

    public RoundRobinController getController() {
        return controller;
    }

    public void setController(RoundRobinController controller) {
        this.controller = controller;
    }
    
    
    
    public  List<ProgramProcess> roundRobin(int quantum) {

        int tiempoTotal = 0;
        Queue<ProgramProcess> colaProcesos = new ArrayDeque<ProgramProcess>(model.getProcessesList()); 
        List<ProgramProcess> sortedList = new ArrayList<ProgramProcess>();
        
        while (!colaProcesos.isEmpty()) {
            ProgramProcess procesoActual = colaProcesos.poll();
            int rafagaActual = procesoActual.getCpuTime();

            if (rafagaActual <= quantum) {
                // El proceso se ejecuta completamente
                tiempoTotal += rafagaActual;
                 procesoActual.setDurationTime(tiempoTotal);
                                 System.out.println("Proceso " + procesoActual.getName() + " finalizado en tiempo: " + tiempoTotal);

                sortedList.add(procesoActual);
            } else {
                // Se ejecuta una porción del proceso y se vuelve a encolar
                tiempoTotal += quantum;
                procesoActual.setCpuTime(rafagaActual - quantum);
                colaProcesos.add(procesoActual);
                procesoActual.setDurationTime(tiempoTotal);
                System.out.println("Proceso " + procesoActual.getName() + " finalizado en tiempo: " + tiempoTotal);
                sortedList.add(procesoActual);
            }
        }
        return sortedList;
    }
  
    public RoundRobinView() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        processesTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        arrivalTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cpuTimeTxt = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        Iniciar = new javax.swing.JButton();
        cuantumTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        processesTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(processesTable);

        jLabel1.setText("Llegada");

        arrivalTxt.setPreferredSize(new java.awt.Dimension(100, 22));

        jLabel2.setText("Rafaga");

        cpuTimeTxt.setPreferredSize(new java.awt.Dimension(100, 22));

        jButton1.setBackground(new java.awt.Color(204, 255, 204));
        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Iniciar.setText("Iniciar");
        Iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniciarActionPerformed(evt);
            }
        });

        cuantumTxt.setPreferredSize(new java.awt.Dimension(100, 22));

        jLabel3.setText("Cuantum");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("ALGORITMO ROUND ROBIN");

        jButton2.setText("Atras");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(cuantumTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(81, 81, 81)
                                    .addComponent(Iniciar))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addComponent(arrivalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(47, 47, 47)
                                    .addComponent(jLabel2)
                                    .addGap(26, 26, 26)
                                    .addComponent(cpuTimeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(54, 54, 54)
                                    .addComponent(jButton1)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jButton2)
                .addGap(7, 7, 7)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(arrivalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cpuTimeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Iniciar)
                    .addComponent(cuantumTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     private String getProcessName(){
        return "P" + (model.getProcessesList().size());
    }
    
    private boolean processExists(int arrival){
        return model.getProcessesList().stream().anyMatch(e-> e.getArrivalTime() == arrival);
    }
    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

     String arrival = arrivalTxt.getText();
     String cpu = cpuTimeTxt.getText();
        
    if(!arrival.isBlank() && !cpu.isBlank()){
            try{
             int arrivalInt = Integer.parseInt(arrival);
             int cpuTimeInt = Integer.parseInt(cpu);
             
             if(processExists(arrivalInt))
                 throw new Exception();
             
             FifoProcess process = new FifoProcess(getProcessName(),arrivalInt ,cpuTimeInt);
             model.addProcess(process);
             
         }catch(java.lang.NumberFormatException e){
                     JOptionPane.showMessageDialog(null, "Debe escribir un numero!");
         } catch (Exception ex) {
                 JOptionPane.showMessageDialog(null, "Tiempo de llegada ocupado");

         }
        
    }else{
              JOptionPane.showMessageDialog(null, "No puede dejar espacios en blanco!");
     }

        

    }//GEN-LAST:event_jButton1ActionPerformed

    
    
    
    private void IniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarActionPerformed


         String cuantum = cuantumTxt.getText();
     
        if(model.getProcessesList().isEmpty()){
           JOptionPane.showMessageDialog(null, "No hay procesos");
        }
        
        if(cuantum.isBlank()){
          JOptionPane.showMessageDialog(null, "Debe escribir el cuantum");
        }
        
        try{
            
        paintDiagram(Integer.parseInt(cuantum));    

        }catch(java.lang.NumberFormatException e){
          JOptionPane.showMessageDialog(null, "El cuantum debe ser un numero!");
        }



    }//GEN-LAST:event_IniciarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
           controller.returnToMainMenu();
    }//GEN-LAST:event_jButton2ActionPerformed

    @Override
    public void update(Observable o, Object arg) {
        processesTable.setModel(model.getProcessTable());
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Iniciar;
    private javax.swing.JTextField arrivalTxt;
    private javax.swing.JTextField cpuTimeTxt;
    private javax.swing.JTextField cuantumTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable processesTable;
    // End of variables declaration//GEN-END:variables
}
