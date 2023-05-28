
package logic;

/*

 This class represents a basic structure for every process to use

*/

public abstract class Process {
    
    private String processName;
    private int processPriority;
    private int durationTime;

    public Process(String processName, int processPriority, int durationTime) {
        this.processName = processName;
        this.processPriority = processPriority;
        this.durationTime = durationTime;
    }

   
    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public int getProcessPriority() {
        return processPriority;
    }

    public void setProcessPriority(int processPriority) {
        this.processPriority = processPriority;
    }

    public int getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(int durationTime) {
        this.durationTime = durationTime;
    }
    
    
    
}
