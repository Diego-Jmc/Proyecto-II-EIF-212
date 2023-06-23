/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.SJFNEController;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import logic.ProcesoN;
import model.SFJNEModel;
import painters.SJFNoExpulsivoPainter;

/**
 *
 * @author diego
 */
public class SJFNEXView extends javax.swing.JFrame implements Observer{

    private SFJNEModel model;
    private SJFNEController controller;
    SJFNoExpulsivoPainter painter;

    public SFJNEModel getModel() {
        return model;
    }

    public void setModel(SFJNEModel model) {
        this.model = model;
        model.addObserver(this);
    }

    public SJFNEController getController() {
        return controller;
    }

    public void setController(SJFNEController controller) {
        this.controller = controller;
    }
     
   
    public SJFNEXView() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        arrivalTxt = new javax.swing.JTextField();
        cpuTimeTxt = new javax.swing.JTextField();
        Rafaga = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

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

        jLabel1.setText("Llegada");

        jButton1.setText("Comenzar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        arrivalTxt.setPreferredSize(new java.awt.Dimension(100, 22));

        cpuTimeTxt.setPreferredSize(new java.awt.Dimension(100, 22));

        Rafaga.setText("Rafaga");

        jButton2.setBackground(new java.awt.Color(204, 255, 204));
        jButton2.setText("Agregar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("SJFE (NO EXPUSLIVO)");

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
                        .addGap(63, 63, 63)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton1)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(arrivalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(146, 146, 146)
                                .addComponent(Rafaga)
                                .addGap(18, 18, 18)
                                .addComponent(cpuTimeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jButton2))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jButton3)))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(arrivalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cpuTimeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Rafaga)
                    .addComponent(jButton2))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton1)
                .addContainerGap())
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
             int arrivalInt = Integer.valueOf(arrival);
             int cpuTimeInt = Integer.valueOf(cpu);
             
             if(processExists(arrivalInt))
                 throw new Exception();
             
             ProcesoN process = new ProcesoN(getProcessName(),arrivalInt ,cpuTimeInt);
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

    
     private List<ProcesoN> ordenarProcesosSJ2F() {

        List<ProcesoN> procesosFinal  = new ArrayList();
        List<ProcesoN> procesos = model.getProcessesList();
        int tiempo = 0;

        while(!procesos.isEmpty()){

            List<ProcesoN> procesosLlegados = new ArrayList<>();

            for(ProcesoN proceso : procesos){

                if(proceso.getArrivalTime() <= tiempo){
                    procesosLlegados.add(proceso);
                }
            }

            procesosLlegados.sort(Comparator.comparingInt(ProcesoN::getDurationTime));

            if(!procesosLlegados.isEmpty()){
                ProcesoN pp = procesosLlegados.get(0);
                int nuevoEjecuccion = pp.getDurationTime();

                procesosFinal.add(pp);
                tiempo += nuevoEjecuccion;

                procesos.remove(pp);
            }
            else{
                tiempo++;
            }
        }
        return procesosFinal;
    }
    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int cant = model.getProcessesList().size();
        int total = 0;
        int maxArrivalTime = 0;

// Calcular la suma total de los tiempos de duración y encontrar el mayor tiempo de llegada
        for (int i = 0; i < model.getProcessesList().size(); i++) {
            total += model.getProcessesList().get(i).getDurationTime();
            maxArrivalTime = Math.max(maxArrivalTime, model.getProcessesList().get(i).getArrivalTime());
        }
        
       List<ProcesoN> sortedList =  ordenarProcesosSJ2F();
        int[][] matrizEjemplo = new int[cant][total + maxArrivalTime];
               
        for (int i = 0; i < sortedList.size(); i++) {
            ProcesoN p = sortedList.get(i);
            matrizEjemplo[i][p.getArrivalTime()] = 1;
        }

        int tamañoRectanguloAncho = 120; // Ancho del rectángulo en píxeles
        int tamañoRectanguloAlto = 60; // Alto del rectángulo en píxeles
        int espaciadoHorizontal = 25; // Espaciado horizontal entre rectángulos en píxeles
        int espaciadoVertical = 25; // Espaciado vertical entre rectángulos en píxeles

        SwingUtilities.invokeLater(() -> {

            // Crear el marco principal y agregar el componente personalizado
            JFrame frame = new JFrame("Resolucion del algoritmo");
            frame.setSize(1200, 600);

            painter = new SJFNoExpulsivoPainter(matrizEjemplo, tamañoRectanguloAncho, tamañoRectanguloAlto,
                    espaciadoHorizontal, espaciadoVertical, sortedList);
            
            frame.add(painter);

            frame.setVisible(true);

         
           
        });
                


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
           controller.returnToMainMenu();
    }//GEN-LAST:event_jButton3ActionPerformed

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Rafaga;
    private javax.swing.JTextField arrivalTxt;
    private javax.swing.JTextField cpuTimeTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {     
        table.setModel(model.getProcessTable());  
    }
}
