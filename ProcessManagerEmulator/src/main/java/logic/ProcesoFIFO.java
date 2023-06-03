/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

/**
 *
 * @author Jordan Villalobos
 */
public class ProcesoFIFO {
    
    
     private String processName;
     private int arrivalTime;
     private int durationTime;

    public ProcesoFIFO(String processName, int arrivalTime, int durationTime) {
        this.processName = processName;
        this.arrivalTime = arrivalTime;
        this.durationTime = durationTime;
    }

    public ProcesoFIFO() {
    }
     
     

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(int durationTime) {
        this.durationTime = durationTime;
    }
     
     
     
}
