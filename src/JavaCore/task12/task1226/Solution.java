package JavaCore.task12.task1226;

/* 
Лазать, летать и бегать
*/

public class Solution {
    public interface Fly{
        void fly();
    }
    public interface Climb{
        void climb();
    }
    public interface Run{
        void run();
    }

    public static void main(String[] args) {

    }

    public class Cat implements Climb,Run{
        @Override
        public void run() {
        }

        @Override
        public void climb() {
        }
    }

    public class Dog implements Run{
        @Override
        public void run() {
        }
    }

    public class Tiger extends Cat {
    }

    public class Duck implements Run, Fly{
        @Override
        public void fly() {

        }

        @Override
        public void run() {

        }
    }
}
