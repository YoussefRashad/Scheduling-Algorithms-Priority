/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.util.PriorityQueue;

/**
 *
 * @author User-7
 */
public class AllProcess {

    // all methods must be calculated >> WaitingTimeForEachProc ,, SumWaitingTime ,, AverageWaitingTime ,, response time consider waiting time in this case 
    // TurnaroundTimeForEachProc,, AverageTurnaroundTime 
    // ** calculate waitingtime ,, response time ***
    
    public int[] WaitingTimeForEachProc(OrderingProcesses op[]) {
        int wt[] = new int[op.length];
        for (int i = 0; i < wt.length; i++) {
            wt[i] = 0;
            for (int j = 0; j < i; j++) {
                wt[i] = wt[i] + op[j].getBurstTime();

            }
        }
        return wt;

    }

    public int SumWaitingTime(OrderingProcesses op[]) {
        int sum = 0;
        int wt[] = WaitingTimeForEachProc(op);

        for (int i = 0; i < wt.length; i++) {
            sum += wt[i];
        }
        return sum;
    }

    public float AverageWaitingTime(OrderingProcesses op[]) {

        return ((float) SumWaitingTime(op)) / op.length;
    }
    // *** calculate Turnaround time ***

    public int[] TurnaroundTimeForEachProc(OrderingProcesses op[]) {
        int trn[] = new int[op.length];
        int wt[] = WaitingTimeForEachProc(op);

        for (int i = 0; i < op.length; i++) {
            trn[i] = wt[i] + op[i].getBurstTime();
        }
        return trn;

    }

    public int SumTurnaroundTime(OrderingProcesses op[]) {
        int sum = 0;
        int trn[] = TurnaroundTimeForEachProc(op);

        for (int i = 0; i < trn.length; i++) {
            sum += trn[i];
        }
        return sum;
    }

    public float AverageTurnaroundTime(OrderingProcesses op[]) {
        return (SumTurnaroundTime(op)) / (float) op.length;
    }

}
