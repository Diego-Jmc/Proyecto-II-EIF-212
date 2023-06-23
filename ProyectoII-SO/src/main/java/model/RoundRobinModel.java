/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import logic.FifoProcess;
import logic.ProgramProcess;
import view.TableModel;

/**
 *
 * @author diego
 */
public class RoundRobinModel extends Observable{
    
    private TableModel processTable;
    private int[] col = {0,1,2};
    private List<ProgramProcess> processesList;
    private ProgramProcess p;

    public RoundRobinModel() {
        p = new FifoProcess();
        processesList = new ArrayList<>();
        processTable = new TableModel(processesList,col);
        
    }

        
    public void addProcess(ProgramProcess p){
        processesList.add(p);
        setProcessTable(this.processesList);  
    }
    
    public TableModel getProcessTable() {
        return processTable;
    }

    public void setProcessTable(List<ProgramProcess> l) { 
        processTable = new TableModel(l,col);
        refresh();
    }

    public List<ProgramProcess> getProcessesList() {
        return processesList;
    }

    public void setProcessesList(List<ProgramProcess> process) {
        this.processesList = process;
        setProcessTable(process);
    }

    public ProgramProcess getP() {
        return p;
    }

    public void setP(ProgramProcess p) {
        this.p = p;
        refresh();
    }
    
    
    
    
    @Override
    public void addObserver(Observer o){
        super.addObserver(o);
        refresh();
    }
    
     private void refresh(){
        setChanged();
        notifyObservers();
    }
}
