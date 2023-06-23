/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import controllers.SJFEController;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.PriorityQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import logic.ProcesoN;
import models.SJFEModel;

/**
 *
 * @author Jordan Villalobos
 */
public class SJFEView extends javax.swing.JFrame implements Observer {

    /**
     * Creates new form SJFEView
     */
    private SJFEModel model;
    private SJFEController controller;
    private int contador;
    PaintSJF painter;
    List<ProcesoN> procesos = new ArrayList<>();

    public SJFEModel getModel() {

        return model;
    }

    public SJFEController getController() {
        return controller;
    }

    public void setController(SJFEController controller) {
        this.controller = controller;
    }

    public void setModel(SJFEModel model) {

        this.model = model;
        model.addObserver(this);

    }

    public SJFEView() {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProcesos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        RafagaFD = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Llegada = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        label1.setFont(new java.awt.Font("Dialog", 2, 18)); // NOI18N
        label1.setText("Algoritmo de planificacion SJF Expulsivo");

        tablaProcesos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#Proceso", "Llegada", "Rafaga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaProcesos);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("LISTA DE PROCESOS");

        jButton1.setBackground(new java.awt.Color(204, 255, 204));
        jButton1.setForeground(new java.awt.Color(0, 51, 0));
        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Iniciar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Agregar proceso");

        jLabel3.setText("Rafaga");

        RafagaFD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RafagaFDActionPerformed(evt);
            }
        });

        jLabel4.setText("Llegada");

        Llegada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LlegadaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(28, 28, 28)
                                .addComponent(Llegada, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(RafagaFD, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(jLabel1)))
                .addContainerGap(162, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Llegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(RafagaFD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(14, 14, 14)))
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(255, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        DefaultTableModel model = (DefaultTableModel) tablaProcesos.getModel();
        String proceso = "P" + contador;
        int rafaga = Integer.parseInt(RafagaFD.getText());
        int llegada = Integer.parseInt(Llegada.getText());

        ProcesoN p = new ProcesoN(proceso, llegada, rafaga);
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
            model.addRow(new Object[]{proceso, llegada, rafaga});

            this.contador++;
        } else {
            JOptionPane.showMessageDialog(null, "¡El tiempo de llegada ya ha sido ocupado por otro proceso!!!", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        
        List<ProcesoN> originales = new ArrayList<>(procesos);
        
        List<ProcesoN> particiones = aplicarSJFExpulsivo(procesos);
        
        

        int cant = particiones.size();
        int total = 0;
        int maxArrivalTime = 0;

// Calcular la suma total de los tiempos de duración y encontrar el mayor tiempo de llegada
        for (int i = 0; i < particiones.size(); i++) {
            total += particiones.get(i).getDurationTime();
            maxArrivalTime = Math.max(maxArrivalTime, particiones.get(i).getArrivalTime());
        }

        int[][] matrizEjemplo = new int[cant][total + maxArrivalTime];
        //List<ProcesoN> particiones = aplicarSJFExpulsivo(procesos);

        for (int i = 0; i < particiones.size(); i++) {
            ProcesoN p = particiones.get(i);
            matrizEjemplo[i][p.getArrivalTime()] = 1;
        }

        int tamañoRectanguloAncho = 150; // Ancho del rectángulo en píxeles
        int tamañoRectanguloAlto = 90; // Alto del rectángulo en píxeles
        int espaciadoHorizontal = 25; // Espaciado horizontal entre rectángulos en píxeles
        int espaciadoVertical = 25; // Espaciado vertical entre rectángulos en píxeles
        List<ProcesoN> originales2 = getMedia(originales, particiones);
        SwingUtilities.invokeLater(() -> {
            DefaultTableModel model = (DefaultTableModel) tablaProcesos.getModel();
            // Crear el marco principal y agregar el componente personalizado
            JFrame frame = new JFrame("Resolucion del algoritmo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);

            painter = new PaintSJF(matrizEjemplo, tamañoRectanguloAncho, tamañoRectanguloAlto,
                    espaciadoHorizontal, espaciadoVertical, particiones, originales2);
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

    private void RafagaFDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RafagaFDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RafagaFDActionPerformed

    private void LlegadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LlegadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LlegadaActionPerformed
    public static List<ProcesoN> aplicarSJFExpulsivo(List<ProcesoN> procesos) {
        List<ProcesoN> particiones = new ArrayList<>();
        int tiempoActual = 0;
        List<ProcesoN> ppaux = new ArrayList<>();   //guardar aqui el pedazo de proceso restante.
        int cantAnterior = 0;
        int contaux = 0;
        List<ProcesoN> particionesAux = new ArrayList<>();

        ProcesoN procesoAnterior = new ProcesoN();

        if (procesos.size() == 1) {
            particionesAux.add(procesos.get(0));
        } else {
            while (!procesos.isEmpty()) {
                for (int i = 0; i < procesos.size(); i++) {
                    ProcesoN proceso = procesos.get(i);
                    if (proceso.getArrivalTime() == tiempoActual) {
                        if (contaux == 0) {
                            int next = procesos.get(i + 1).getArrivalTime();
                            ProcesoN nn = new ProcesoN(proceso.getProcessName(), proceso.getArrivalTime(), next);
                            ProcesoN auxiliar = new ProcesoN(proceso.getProcessName(), proceso.getArrivalTime(), proceso.getDurationTime() - next);
                            ppaux.add(auxiliar);
                            procesoAnterior = proceso;
                            cantAnterior = tiempoActual;
                            contaux++;
                            particionesAux.add(nn);
                        } else {
                            ProcesoN aux = particionesAux.get(particionesAux.size() - 1);
                            int arri = aux.getArrivalTime();
                            int ff = tiempoActual - arri;
                            if (proceso.getDurationTime() < ff) {
                                
                                ProcesoN nn = new ProcesoN(proceso.getProcessName(), proceso.getArrivalTime(), proceso.getDurationTime());
                               // particionesAux.add(nn);
                                int ppauxDurationaux = proceso.getDurationTime() - (ff-proceso.getDurationTime());
                                ProcesoN auxiliar = new ProcesoN(proceso.getProcessName(), proceso.getArrivalTime(), ppauxDurationaux);
                                
                                if(ppauxDurationaux < 0 ){
                                    ppaux.add(auxiliar);
                                }
                                
                                int xxcontador = 0;
                                for(int x=0; x<ppaux.size(); x++){
                                    if(ppaux.get(x).getDurationTime() < proceso.getDurationTime()){
                                        xxcontador ++;
                                    }
                                }
                                
                                if(xxcontador != 0){
                                    nn.setDurationTime(proceso.getDurationTime());
                                    ppaux.add(nn);
                                }
                                else{
                                      particionesAux.add(nn);
                                       //ProcesoN auxiliarr = new ProcesoN(proceso.getProcessName()+ "'", proceso.getArrivalTime(), ppauxDurationaux);
                                ppaux.add(auxiliar);
                                }
                                
                                
                            } else {
                                int sss = tiempoActual - arri;
                                
                                int xxcontador = 0;
                                for(int x=0; x<ppaux.size(); x++){
                                    if(ppaux.get(x).getDurationTime() < proceso.getDurationTime()){
                                        xxcontador ++;
                                    }
                                }
                                ProcesoN nn = new ProcesoN(proceso.getProcessName(), proceso.getArrivalTime(), sss);
                                //particionesAux.add(nn);
                                if(xxcontador != 0){
                                    nn.setDurationTime(proceso.getDurationTime());
                                    ppaux.add(nn);
                                }
                                else{
                                      particionesAux.add(nn);
                                      ProcesoN auxiliar = new ProcesoN(proceso.getProcessName(), proceso.getArrivalTime(), proceso.getDurationTime() - sss);
                                      
                                      int prueba = proceso.getDurationTime() - (proceso.getDurationTime()-sss);
                                      if(prueba != 0){
                                           ppaux.add(auxiliar);
                                      }
                                     
                                }
                                
                            }
                        }
                        procesos.remove(i);
                    }
                }
                tiempoActual++;
            }
           
            Collections.sort(ppaux, Comparator.comparingInt(ProcesoN::getDurationTime));
            
            
            while (!ppaux.isEmpty()) {

                for (int i = 0; i < ppaux.size(); i++) {
                    ProcesoN proceso = ppaux.get(i);
                    proceso.setArrivalTime(tiempoActual);
                    tiempoActual += proceso.getDurationTime();
                    
                    if(proceso.getDurationTime() > 0){
                         particionesAux.add(proceso);
                   
                    }
                     ppaux.remove(i);
                      i--;
                }

            }
            
        }
        
        Collections.sort(particionesAux, Comparator.comparingInt(ProcesoN::getArrivalTime)
        .thenComparingInt(ProcesoN::getDurationTime));

        //despues pinta sin asco.
        return particionesAux;
    }

    
    
public static List<ProcesoN> getMedia(List<ProcesoN> original, List<ProcesoN> particiones) {
    List<ProcesoN> auxOriginal = new ArrayList<>(original); // Copia independiente de la lista original
    List<ProcesoN> auxParticiones = new ArrayList<>(particiones); // Copia independiente de la lista particiones
    
    List<ProcesoN> aux = new ArrayList<>();
    
    for (ProcesoN proceso : auxOriginal) {
        ProcesoN ppaux = proceso;
        ppaux.setCompletation(ppaux.getArrivalTime() + ppaux.getDurationTime());
        for (ProcesoN procesoAux : auxParticiones) {
            
            if (proceso.getProcessName().equals(procesoAux.getProcessName())) {
                 
                if (proceso.getArrivalTime() < procesoAux.getArrivalTime()) {
                    
                    ppaux.setCompletation((procesoAux.getArrivalTime()-1) + procesoAux.getDurationTime());
               }
            }
            
            
        }
        aux.add(ppaux);
    }
    
    return aux;
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Llegada;
    private javax.swing.JTextField RafagaFD;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private javax.swing.JTable tablaProcesos;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        this.repaint();
    }
}
