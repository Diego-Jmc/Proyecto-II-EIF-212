
package logic;

public abstract class ProgramProcess {
    String name;
    int arrivalTime;
    int cpuTime;
    int durationTime;
    private int ct;
    private int completation;

    public int getCompletation() {
        return completation;
    }

    public void setCompletation(int completation) {
        this.completation = completation;
    }

    public int getCt() {
        return ct;
    }

    public void setCt(int ct) {
        this.ct = ct;
    }
  
    public int getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(int durationTime) {
        this.durationTime = durationTime;
    }
    
    
    public ProgramProcess() {
        this.durationTime = 0;
        this.ct =0 ;
        this.completation = 0;
    }

    public ProgramProcess(String name, int arrivalTime, int cpuTime) {
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.cpuTime = cpuTime;
        this.durationTime = 0;
        this.ct =0 ;
        this.completation = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getCpuTime() {
        return cpuTime;
    }

    public void setCpuTime(int cpuTime) {
        this.cpuTime = cpuTime;
    }

    @Override
    public String toString() {
        return "ProgramProcess{" + "name=" + name + ", arrivalTime=" + arrivalTime + ", cpuTime=" + cpuTime + '}';
    }
    
    
}
