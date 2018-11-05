import classes.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class dataBase {

    public static void nav() {
        System.out.println("PRESS GLASS database");
        System.out.println(" ");
        System.out.println("list");
        System.out.println("add worker");
        System.out.println("delete workers");
        System.out.println(" ");
        System.out.println("help");
        System.out.println("quit");
    }

    public static void printWorkers(List<Worker> workers) {

        if (workers.size() == 0){
            System.out.println("Data base is empty");
        } else {
            for (Worker worker : workers){
                System.out.println(worker.name + " / "
                        + worker.surname + " / "
                        + worker.dateOfBirth);
                System.out.println("salary = " + worker.salary + "zł");

                if (worker.position == Position.PRODUCTION) {
                    System.out.println("Production");
                } else if (worker.position == Position.OFFICE) {
                    System.out.println("Office");
                } else if (worker.position == Position.WAREHOUSE) {
                    System.out.println("Warehouse");
                } else if (worker.position == Position.LOGISTICS) {
                    System.out.println("Logistics");
                } else if (worker.position == Position.SUPPLY) {
                    System.out.println("Supply");
                } else  if (worker.position == Position.MANAGEMEN) {
                    System.out.println("Management");
                } else {
                    System.out.println("Wrong number of position");
                }

                System.out.println(" ");
            }
        }

        System.out.println("");
        System.out.println("Now is " + workers.size() + " workers in database");
    }

        public static void removeWorkers(List<Worker> workers) {
            if (workers.size() == 0) {
                System.out.println("Data base is empty");
            } else {
                workers.clear();
            }
        }

        public static void addWorkers(Scanner scanner, List<Worker> workers){

            System.out.println("Add name_ ");
            String name = scanner.nextLine();
            System.out.println("Add surname_ ");
            String surname = scanner.nextLine();
            System.out.println("Add data of birth (xx:xx:xxxx)");
            String dateOfBirth = scanner.nextLine();
            System.out.println("Add salary (gross)");
            double salary = scanner.nextDouble();
            System.out.println("Add department (type 1 - 6):");
            System.out.println("1. Production");
            System.out.println("2. Office");
            System.out.println("3. Warehouse");
            System.out.println("4. Logistics");
            System.out.println("5. Supply");
            System.out.println("6. Management");
            int position = scanner.nextInt();

            Worker worker = new Worker();
            worker.name = name;
            worker.surname = surname;
            worker.dateOfBirth = dateOfBirth;
            worker.salary = salary;

            if(position == 1) {
                worker.position = Position.PRODUCTION;
            } else if (position == 2) {
                worker.position = Position.OFFICE;
            } else if (position == 3) {
                worker.position = Position.WAREHOUSE;
            } else  if (position == 4) {
                worker.position = Position.LOGISTICS;
            } else if (position == 5) {
                worker.position = Position.SUPPLY;
            } else  if (position == 6) {
                worker.position = Position.MANAGEMEN;
            }

            workers.add(worker);
        }

        public static void main(String args[]) {
            Scanner scanner = new Scanner(System.in);
            List<Worker> workers = new ArrayList<>();
            boolean run = true;

            nav();

            while (run){
                String command = scanner.nextLine();

                if (command.equals("quit")){
                    System.out.println("=== GOOD BYE ===");
                    run = false;
                } else if (command.equals("add worker")){
                    addWorkers(scanner, workers);
                    System.out.println("Worker added");
                } else if (command.equals("list")){
                    printWorkers(workers);
                } else if (command.equals("help")){
                    nav();
                } else if (command.equals("delete workers")) {
                    removeWorkers(workers);
                } else {
                    System.out.println("Wrong command");
                }
            }
        }
}