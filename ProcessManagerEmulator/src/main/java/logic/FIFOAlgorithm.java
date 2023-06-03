/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Jordan Villalobos
 */
public class FIFOAlgorithm {
    
    public static void main(String[] args) {
       
    }
    
    
   public void runFIFO(List<ProcesoFIFO> procesos){
        procesos.sort((p1, p2) -> p1.getArrivalTime() - p2.getArrivalTime());

        
    }
    
}
