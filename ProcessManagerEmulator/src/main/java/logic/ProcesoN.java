/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

/**
 *
 * @author Jordan Villalobos
 */
public class ProcesoN {
    
    private String processName;
     private int arrivalTime;
     private int durationTime;
     private int tiempoEspera;
     private int ct;

    public ProcesoN(String processName, int arrivalTime, int durationTime) {
        this.processName = processName;
        this.arrivalTime = arrivalTime;
        this.durationTime = durationTime;
        this.tiempoEspera = 0;
        this.ct =0 ;
    }

    public ProcesoN() {
    }

    public int getTiempoEspera() {
        return tiempoEspera;
    }

    public void setTiempoEspera(int tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
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

    public int getCt() {
        return ct;
    }

    public void setCt(int ct) {
        this.ct = ct;
    }
    
     
}
