/**
 * @author Vinayak More
 *
 * @date 23-Dec-2016
 */
package main.java;

import main.java.table.MyThread2;
import main.java.table.Table;
import main.java.threads.MyThread1;

public class MainClass {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Table obj = new Table();//only one object  
        MyThread1 t1=new MyThread1(obj);  
        MyThread2 t2=new MyThread2(obj);  
        t1.start();  
        t2.start();  
    }

}
