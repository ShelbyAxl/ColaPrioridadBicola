/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cola.prioridad.bicola;

import static javax.swing.JOptionPane.*;

/**
 *
 * @author luisa
 */
public class PrioridadBicola {
    
    //Properties
    protected Prioridad cola[];
    protected int ini, fin;
    
    public PrioridadBicola(int a){
        cola = new Prioridad[a];
        ini = fin = -1;
    }
    
    //Fuctions
    public boolean isFull(){
        return ini == 0 && fin == cola.length;
    }
    
    public boolean iniFull(){
        return ini == 0;
    }
    
    public boolean finFull(){
        return fin == cola.length-1;
    }
    
    public boolean OnlyOneDope(){
        return ini == fin;
    }
    
    public boolean isEmpty(){
        return ini == -1;
    }
    
    public boolean newIniDato(char dato, int nivel){
        if(isFull())return false;
        if(iniFull())return false;
        if(isEmpty()){
            ini = fin = 0;
            cola[ini] = new Prioridad(dato, nivel);
            return true;
        }
        cola[--ini] = new Prioridad(dato, nivel);
        return true;
    }
    
    public boolean newFinDato(char dato, int nivel){
        if(isFull())return false;
        if(finFull())return false;
        if(isEmpty()){
            ini = fin = 0;
            cola[fin] = new Prioridad(dato, nivel);
            return true;
        }
        cola[++fin] = new Prioridad(dato,nivel);
        return true;
    }
    
    public boolean DeleteIniDato(){
        if(isEmpty())return false;
        if(OnlyOneDope()){
            ini = fin = -1;
            return true;
        }
        ini++;
        return true;
    }
    
    public boolean DeleteFinDato(){
        if(isEmpty())return false;
        if(OnlyOneDope()){
            ini = fin = -1;
            return true;
        }
        fin--;
        return true;
    }
    
    public void Recorrer(){
        Prioridad temp;
        for(int i=ini; i<fin; i++)
            for(int j=ini; j<fin; j++)
                if(cola[j].nivel < cola[j+1].nivel){
                    temp = cola[j];
                    cola[j] = cola[j+1];
                    cola[j+1] = temp;
                }
    }
    
    public String toString(){
        String cad = "";
        if(isEmpty())return cad;
        Recorrer();
        for(int i=ini; i<=fin; i++)cad += "[" + i + "] " + cola[i].toString()+"\n";
        return cad;
    }
}
