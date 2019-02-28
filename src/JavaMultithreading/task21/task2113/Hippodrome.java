package JavaMultithreading.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private  List<Horse> horses = new ArrayList<>();
    static Hippodrome game;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public void run()throws InterruptedException{
        for (int i = 1; i <= 100; i++){
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move() {
        for (Horse horse : horses){
            horse.move();
        }
    }

public void print() {
        for (Horse horse : horses){
            horse.print();
        }
        for (int i = 0; i < 10; i++){
        System.out.println();
        }
    }

public Horse getWinner(){
        Horse winner = new Horse(null, 0,0);
        for (int i = 0; i < horses.size(); i++){
        if (horses.get(i).getDistance() > winner.getDistance()){
        winner = horses.get(i);
            }
        }
        return winner;
    }

public void printWinner(){
        System.out.printf("Winner is %s!%n",getWinner().getName());
    }


public static void main(String[] args) {
        game = new Hippodrome(new ArrayList<>(3));
        game.getHorses().add(new Horse("Bill", 3,0));
        game.getHorses().add(new Horse("Tim",3,0));
        game.getHorses().add(new Horse("Molly", 3,0));
        try {
        game.run();
        game.printWinner();
        }catch (InterruptedException e){
        e.printStackTrace();
        }
    }
}
