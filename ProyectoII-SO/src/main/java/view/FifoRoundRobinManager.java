/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import painters.PaintRoundRobin;
import controller.RoundRobinFifoController;
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
import painters.RoundRobinPainter;

public class FifoRoundRobinManager extends javax.swing.JFrame implements Observer{

    private RoundRobinModel model;
    private RoundRobinFifoController controller;
    private RoundRobinPainter painter;
    
    public RoundRobinModel getModel() {
        return model;
    }
    
    public void paintDiagram(int quantum){
        int cant = model.getProcessesList().size();
        int total = 0;
        int maxArrivalTime = 0;

        for (int i = 0; i < model.getProcessesList().size(); i++) {
            total += model.getProcessesList().get(i).getCpuTime();
            maxArrivalTime = Math.max(maxArrivalTime, model.getProcessesList().get(i).getCpuTime());
        }


        List<ProgramProcess> sortedList = roundRobinFifo(quantum); 
         JFrame frame = new JFrame("Round Robin FIFO");
         frame.setSize(1400, 800);
         painter = new RoundRobinPainter(sortedList);
         frame.add(painter);
         frame.setVisible(true);
         painter.startAnimation();
    }
    

    public void setModel(RoundRobinModel model) {
        this.model = model;
        model.addObserver(this);
    }

    public RoundRobinFifoController getController() {
        return controller;
    }

    public void setController(RoundRobinFifoController controller) {
        this.controller = controller;
    }
    
 
    public FifoRoundRobinManager() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        scrollPane1 = new java.awt.ScrollPane();
        jTextField4 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        cuantumTxt = new javax.swing.JTextField();
        startRrFifoBtn = new javax.swing.JButton();
        addProcessRrFifoBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        processTableFifo = new javax.swing.JTable();
        arrivalTimeTxt = new javax.swing.JTextField();
        cpuTimeTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jTextField2.setText("jTextField2");

        jTextField4.setText("jTextField4");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cuantum");

        cuantumTxt.setToolTipText("");
        cuantumTxt.setPreferredSize(new java.awt.Dimension(100, 22));

        startRrFifoBtn.setText("Comenzar");
        startRrFifoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startRrFifoBtnActionPerformed(evt);
            }
        });

        addProcessRrFifoBtn.setBackground(new java.awt.Color(204, 255, 204));
        addProcessRrFifoBtn.setText("Add");
        addProcessRrFifoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProcessRrFifoBtnActionPerformed(evt);
            }
        });

        jLabel2.setText("Llegada");

        jLabel3.setText("Rafaga");

        processTableFifo.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(processTableFifo);

        arrivalTimeTxt.setPreferredSize(new java.awt.Dimension(100, 22));
        arrivalTimeTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arrivalTimeTxtActionPerformed(evt);
            }
        });

        cpuTimeTxt.setPreferredSize(new java.awt.Dimension(100, 22));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("ALGORITMO ROUND ROBIN (FIFO)");

        jButton1.setText("Atras");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(121, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(59, 59, 59)
                                .addComponent(arrivalTimeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel3)
                                .addGap(87, 87, 87)
                                .addComponent(cpuTimeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)
                                .addComponent(addProcessRrFifoBtn))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cuantumTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(38, 38, 38)
                                    .addComponent(startRrFifoBtn))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 414, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jButton1)
                .addGap(8, 8, 8)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addProcessRrFifoBtn)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(arrivalTimeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cpuTimeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cuantumTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startRrFifoBtn))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private String getProcessName(){
        return "P" + (model.getProcessesList().size());
    }
    
    private boolean processExists(int arrival){
        return model.getProcessesList().stream().anyMatch(e-> e.getArrivalTime() == arrival);
    }

    
    public  List<ProgramProcess> roundRobinFifo(int quantum) {
        
        Queue<ProgramProcess> colaProcesos = new ArrayDeque<>(model.getProcessesList());
        Queue<ProgramProcess> colaTemporal = new ArrayDeque<>(colaProcesos);
        List<ProgramProcess> sortedList = new ArrayList<>();
        
        int tiempoTotal = 0;

        while (!colaTemporal.isEmpty()) {
            ProgramProcess procesoActual = colaTemporal.poll();
            int rafagaActual = procesoActual.getCpuTime();

            if (rafagaActual > quantum) {
                rafagaActual -= quantum;
                tiempoTotal += quantum;
                procesoActual.setCpuTime(rafagaActual);
                colaTemporal.offer(procesoActual);
            } else {
                tiempoTotal += rafagaActual;
                procesoActual.setDurationTime(tiempoTotal);
                sortedList.add(procesoActual);
                System.out.println("Proceso " + procesoActual.getName() + " finalizado en tiempo: " + tiempoTotal);
            }
        }
        
        
        return sortedList;
    }
  
    
    
    private void addProcessRrFifoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProcessRrFifoBtnActionPerformed
        
     String arrival = arrivalTimeTxt.getText();
     String cpu = cpuTimeTxt.getText();

     if(!arrival.isBlank() && !cpu.isBlank()){
                        
         try{
             int arrivalInt = Integer.valueOf(arrival);
             int cpuTimeInt = Integer.valueOf(cpu);
             
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
     
     
     
        
    }//GEN-LAST:event_addProcessRrFifoBtnActionPerformed

    private void arrivalTimeTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arrivalTimeTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_arrivalTimeTxtActionPerformed

    private void startRrFifoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startRrFifoBtnActionPerformed
        
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
    }//GEN-LAST:event_startRrFifoBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
           controller.returnToMainMenu();
    }//GEN-LAST:event_jButton1ActionPerformed

    @Override
    public void update(Observable o, Object arg) {
     processTableFifo.setModel(model.getProcessTable());
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addProcessRrFifoBtn;
    private javax.swing.JTextField arrivalTimeTxt;
    private javax.swing.JTextField cpuTimeTxt;
    private javax.swing.JTextField cuantumTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTable processTableFifo;
    private java.awt.ScrollPane scrollPane1;
    private javax.swing.JButton startRrFifoBtn;
    // End of variables declaration//GEN-END:variables
}
