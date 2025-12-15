package org;

class MyThread extends Thread {
   @Override
   public void run(){
       for (int k=1;k<=3;k++){
           System.out.println("run "+k);
       }
   }
}


public class example{
    public static void main(String[] args) {
        MyThread myThread=new MyThread();
        myThread.start();
        for (int k=1;k<=3;k++){
            System.out.println("main "+k);
        }
    }
}
