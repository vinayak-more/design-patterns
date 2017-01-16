/**
 * @author Vinayak More
 *
 * @date 23-Dec-2016
 */
package main.java.table;

public class MyThread2 extends Thread{
    Table t;  
    public MyThread2(Table t){  
    this.t=t;  
    }  
    public void run(){  
    t.printTable(100);  
    }  
}
