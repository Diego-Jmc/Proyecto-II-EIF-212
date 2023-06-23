
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import logic.FifoProcess;
import logic.ProcesoFIFO;
import logic.ProgramProcess;
import view.FifoTableModel;
import view.TableModel;


public class FCFSModel extends Observable{
    
    
    
    private FifoTableModel processTable;
    private int[] col = {0,1,2};
    private List<ProcesoFIFO> processesList;
    private ProcesoFIFO p;

    public FCFSModel () {
        p = new ProcesoFIFO();
        processesList = new ArrayList<>();
        processTable = new FifoTableModel(processesList,col);
        
    }

        
    public void addProcess(ProcesoFIFO p){
        processesList.add(p);
        setProcessTable(this.processesList);  
    }
    
    public FifoTableModel getProcessTable() {
        return processTable;
    }

    public void setProcessTable(List<ProcesoFIFO> l) { 
        processTable = new FifoTableModel(l,col);
        refresh();
    }

    public List<ProcesoFIFO> getProcessesList() {
        return processesList;
    }

    public void setProcessesList(List<ProcesoFIFO> process) {
        this.processesList = process;
        setProcessTable(process);
    }

    public ProcesoFIFO getP() {
        return p;
    }

    public void setP(ProcesoFIFO p) {
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
