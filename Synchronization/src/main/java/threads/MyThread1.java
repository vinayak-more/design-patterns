/**
 * @author Vinayak More
 *
 * @date 23-Dec-2016
 */
package main.java.threads;

import main.java.table.Table;

public class MyThread1 extends Thread {
    Table t;  
    public MyThread1(Table t){  
    this.t=t;  
    }  
    public void run(){  
    t.printTable(5);  
    }  
}
