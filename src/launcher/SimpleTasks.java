package launcher;

import hometask.Task1;
import hometask.Task2;
import hometask.Task3p1;
import hometask.Task3p2;
import hometask.Task4;

class SimpleTasks {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Home tasks:");

        Task1.run();
        System.out.println("---------------------------------------");

        Task2.run();
        System.out.println("---------------------------------------");

        Task3p1.run();
        System.out.println("---------------------------------------");

        Task3p2.run();
        System.out.println("---------------------------------------");

        Task4.run();
        System.out.println("---------------------------------------\n"); //end of code execution output separator
    }
}