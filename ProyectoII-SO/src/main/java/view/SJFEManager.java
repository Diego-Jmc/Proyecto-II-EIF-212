
package view;

import controller.SJFController;
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
import logic.ProcesoN;
import logic.ProgramProcess;
import model.SJFModel;
import painters.SJFExpulsivoPainter;
import painters.SJFNoExpulsivoPainter;

public class SJFEManager extends javax.swing.JFrame implements Observer {

   

     private SJFModel model;
     private SJFController controller;
     SJFExpulsivoPainter painter;
     
     public SJFModel getModel() {
        return model;
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
   
   
    public void setModel(SJFModel model) {
        this.model = model;
        model.addObserver(this);
    }

    public SJFController getController() {
        return controller;
    }

    public void setController(SJFController controller) {
        this.controller = controller;
    }
     
    
    public SJFEManager() {
        initComponents();
    }

  private String getProcessName(){
        return "P" + (model.getProcessesList().size());
    }
    
    private boolean processExists(int arrival){
        return model.getProcessesList().stream().anyMatch(e-> e.getArrivalTime() == arrival);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        processTableSJF = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        arrivalTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cpuTimeTxt = new javax.swing.JTextField();
        addProcessBtn = new javax.swing.JButton();
        startBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        processTableSJF.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(processTableSJF);

        jLabel1.setText("Llegada");

        arrivalTxt.setPreferredSize(new java.awt.Dimension(100, 22));

        jLabel2.setText("Rafaga");

        cpuTimeTxt.setMinimumSize(new java.awt.Dimension(100, 22));
        cpuTimeTxt.setPreferredSize(new java.awt.Dimension(100, 22));

        addProcessBtn.setBackground(new java.awt.Color(204, 255, 204));
        addProcessBtn.setText("Agregar");
        addProcessBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProcessBtnActionPerformed(evt);
            }
        });

        startBtn.setText("Comenzar");
        startBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startBtnActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("ALGORITMO SFJ  EXPULSIVO");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(startBtn)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(33, 33, 33)
                                    .addComponent(arrivalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(92, 92, 92)
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(cpuTimeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(45, 45, 45)
                                    .addComponent(addProcessBtn)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jButton1)))
                .addContainerGap(148, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(arrivalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cpuTimeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addProcessBtn))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(startBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addProcessBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProcessBtnActionPerformed


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


    }//GEN-LAST:event_addProcessBtnActionPerformed

    private void startBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startBtnActionPerformed
   
        List<ProcesoN> originales = new ArrayList<>(model.getProcessesList());

        List<ProcesoN> particiones = aplicarSJFExpulsivo(model.getProcessesList());
        
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

        int tamañoRectanguloAncho = 120; // Ancho del rectángulo en píxeles
        int tamañoRectanguloAlto = 60; // Alto del rectángulo en píxeles
        int espaciadoHorizontal = 25; // Espaciado horizontal entre rectángulos en píxeles
        int espaciadoVertical = 25; // Espaciado vertical entre rectángulos en píxeles
        List<ProcesoN> originales2 = getMedia(originales, particiones);
        SwingUtilities.invokeLater(() -> {

            // Crear el marco principal y agregar el componente personalizado
            JFrame frame = new JFrame("Resolucion del algoritmo");
            frame.setSize(1200, 700);

            painter = new SJFExpulsivoPainter(matrizEjemplo, tamañoRectanguloAncho, tamañoRectanguloAlto,
                    espaciadoHorizontal, espaciadoVertical, particiones, originales2);
            frame.add(painter);

            frame.setVisible(true);

        
          
        });

        
    }//GEN-LAST:event_startBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
           controller.returnToMainMenu();
    }//GEN-LAST:event_jButton1ActionPerformed


    
    
    
    @Override
    public void update(Observable o, Object arg) {
       processTableSJF.setModel(model.getProcessTable());
     
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addProcessBtn;
    private javax.swing.JTextField arrivalTxt;
    private javax.swing.JTextField cpuTimeTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable processTableSJF;
    private javax.swing.JButton startBtn;
    // End of variables declaration//GEN-END:variables
}
