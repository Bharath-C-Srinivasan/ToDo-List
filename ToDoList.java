import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private static ArrayList<String> tasks = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        while (true) {
            displayMenu();

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    markTaskComplete();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    System.err.println("Exiting......GoodBye!");
                    return;
                default:
                    System.out.println("Invalid choice, please try again..");
            }
        }
    }

    public static void displayMenu(){
        System.out.println("\n----To-Do List Menu----");
        System.out.println("1. Add a Task");
        System.out.println("2. View All Tasks");
        System.out.println("3. Mark a task as Complete");
        System.out.println("4. Delete a Task");
        System.out.println("5. Exit");
        System.out.println("Enter your choice:");
    }

    public static void addTask(){
        System.out.println("Enter the task:");
        String task = sc.nextLine();
        tasks.add(task);
        System.err.println("Task added successfully");
    } 

    public static void viewTasks(){
        if(tasks.isEmpty()){
            System.out.println("No tasks available");
            return;
        }
        System.err.println("\n----Your Tasks----");
        for(int i=0; i<tasks.size(); i++){
            System.out.println((i+1)+"."+tasks.get(i));
        }
    }

    public static void markTaskComplete(){
        if(tasks.isEmpty()){
            System.err.println("No tasks available");
            return;
        }
        viewTasks();
        System.err.println("Enter the task number to mark as complete:");
        int taskNumber = sc.nextInt();
        sc.nextLine();

        if(taskNumber<=0 || taskNumber>tasks.size()){
            System.err.println("Invalid task number.");
        }
        else{
            String completedTask = tasks.get(taskNumber-1)+"[Completed}";
            tasks.set(taskNumber-1, completedTask);
            System.err.println("Task marked as complete!");
        }
    }

    public static void deleteTask(){
        if(tasks.isEmpty()){
            System.err.println("No tasks available");
            return;
        }
        viewTasks();
        System.err.println("Enter the task number to delete:");
        int taskNumber = sc.nextInt();
        sc.nextLine();

        if(taskNumber<=0 || taskNumber>tasks.size()){
            System.err.println("Invalid task number.");
        }
        else{
            tasks.remove(taskNumber-1);
            System.err.println("Task deleted Successfully.");
        }
    }
}
