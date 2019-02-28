package JavaCore.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }

    public static class Thread1 extends Thread{
        @Override
        public void run() {
            while (true){}
        }
    }
    public static class Thread2 extends Thread{
        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(10);
                }catch (InterruptedException e){
                    System.out.println( "InterruptedException");
                }
            }
        }
    }
    public static class Thread3 extends Thread{
        @Override
        public void run() {
            while (true){
                try {
                    System.out.println("Ура");

                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public static class Thread4 extends Thread implements Message, Runnable{


            private boolean myStop = false;

            @Override
            public void showWarning() {
                myStop = true;
            }

            @Override
            public void run() {
                try {
                    while ( !myStop ) {
                        Thread.sleep(0);
                    }
                } catch (InterruptedException e) {}
            }
        }

    public static class Thread5 extends Thread {
        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                int sum = 0;
                while (true) {
                    String s = reader.readLine();
                    if (!s.equals("N")) {
                        sum += Integer.parseInt(s);
                    } else System.out.println(sum);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    public static void main(String[] args) {
    }
}