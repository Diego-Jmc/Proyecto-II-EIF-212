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
import logic.ProcesoN;
import logic.ProgramProcess;
import view.ProcessNTableModel;
import view.TableModel;

public class SJFModel extends Observable {
    
    private ProcessNTableModel processTable;
    private int[] col = {0,1,2};
    private List<ProcesoN> processesList;
    private ProcesoN p;

    public SJFModel() {
        p = new ProcesoN();
        processesList = new ArrayList<>();
        processTable = new ProcessNTableModel(processesList,col);
    }
    public void addProcess(ProcesoN p){
        processesList.add(p);
        setProcessTable(this.processesList);  
    }
    
    public ProcessNTableModel getProcessTable() {
        return processTable;
    }

    public void setProcessTable(List<ProcesoN> l) { 
        processTable = new ProcessNTableModel(l,col);
        refresh();
    }

    public List<ProcesoN> getProcessesList() {
        return processesList;
    }

    public void setProcessesList(List<ProcesoN> process) {
        this.processesList = process;
        setProcessTable(process);
    }

    public ProcesoN getP() {
        return p;
    }

    public void setP(ProcesoN p) {
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
