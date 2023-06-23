/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;


import java.util.List;
import javax.swing.table.AbstractTableModel;
import logic.ProgramProcess;


/**
 *
 * @author diego
 */


public class TableModel extends AbstractTableModel{
    private List<ProgramProcess> row;
    private int col[];
    private String [] colsName = {"Nombre Proceso","Llegada","Rafaga"};

    public TableModel(List<ProgramProcess> row, int [] col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public int getRowCount() {
    return row.size();
    }

    @Override
    public int getColumnCount() {
        return colsName.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {        
       ProgramProcess p = row.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> p.getName();
            case 1 -> p.getArrivalTime();
            case 2 -> p.getCpuTime();
            default -> "";
        };
    }
    
    @Override
    public String getColumnName(int i){
        return colsName[i];
    }
    
    
    
}
