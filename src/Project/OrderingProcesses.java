/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

/**
 *
 * @author User-7
 */
public class OrderingProcesses implements Comparable<OrderingProcesses> {

    private int Priority;
    private int BurstTime;
    private String NameOfProcess;

    public OrderingProcesses() {
    }

    public void setNameOfProcess(String NameOfProcess) {
        this.NameOfProcess = NameOfProcess;
    }

    public String getNameOfProcess() {
        return NameOfProcess;
    }

    public int getPriority() {
        return Priority;
    }
    

    public void setPriority(int Priority) {
        this.Priority = Priority;
    }

    public int getBurstTime() {
        return BurstTime;
    }

    public void setBurstTime(int BurstTime) {
        this.BurstTime = BurstTime;
    }

    public OrderingProcesses(int Priority, int BurstTime, String NameOfProcess) {
        this.Priority = Priority;
        this.BurstTime = BurstTime;
        this.NameOfProcess = NameOfProcess;
    }

    @Override
    public String toString() {
        return "Priority=" + Priority + ", BurstTime=" + BurstTime + ", NameOfProcess=" + NameOfProcess + '}';
    }

    @Override
    public int compareTo(OrderingProcesses o) {
        if (this.getPriority() > o.getPriority()) {
            return 1;
        }
        if (this.getPriority() < o.getPriority()) {
            return -1;
        } else {
            return 0;
        }
    }

}
