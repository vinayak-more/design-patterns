/**
 * @author Vinayak More
 *
 * @date 23-Dec-2016
 */
package main.java.table;

public class Table {
    public void printTable(int n){  
        synchronized(this){//synchronized block  
          for(int i=1;i<=5;i++){  
           System.out.println(n*i);  
           try{  
            Thread.sleep(400);  
           }catch(Exception e){System.out.println(e);}  
          }  
        }  
      }//end of the method  
}
