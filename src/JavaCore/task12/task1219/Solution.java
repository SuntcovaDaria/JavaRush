package JavaCore.task12.task1219;

/* 
Создаем человека
*/

public class Solution {
    public static void main(String[] args) {

    }

    public interface Fly {
        public void fly();
    }

    public interface Run {
        public void run();
    }

    public interface Swim {
        public void swim();
    }


    public class Human implements Swim, Run{
        @Override
        public void run() {

        }

        @Override
        public void swim() {

        }
    }

    public class Duck implements Fly, Run, Swim{
        @Override
        public void swim() {

        }

        @Override
        public void run() {

        }

        @Override
        public void fly() {

        }
    }

    public class Penguin implements Run, Swim{
        @Override
        public void run() {

        }

        @Override
        public void swim() {

        }
    }

    public class Airplane implements Fly, Run {
        @Override
        public void fly() {

        }

        @Override
        public void run() {

        }
    }
}
