import java.util.Arrays;
import java.util.Scanner;

class Process {
    int index;
    int id;
    boolean isActive;

    public Process(int index, int id) {
        this.index = index;
        this.id = id;
        this.isActive = true;
    }

    @Override
    public String toString() {
        return "Process{" + "Index=" + index + ", ID=" + id + ", Active=" + isActive + '}';
    }
}

public class RingElection {
    static Scanner scanner = new Scanner(System.in);
    static Process[] processes;

    public static void main(String[] args) {
        System.out.print("Enter number of processes: ");
        int n = scanner.nextInt();
        processes = new Process[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter ID for process " + i + ": ");
            int id = scanner.nextInt();
            processes[i] = new Process(i, id);
        }

        // Sort processes by ID
        Arrays.sort(processes, (p1, p2) -> Integer.compare(p1.id, p2.id));

        // Make the last one inactive (assume crashed)
        processes[n - 1].isActive = false;

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Start Election");
            System.out.println("2. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    startElection();
                    break;
                case 2:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (choice != 2);
    }

    static void startElection() {
        System.out.print("Enter index of process to initiate election: ");
        int initiatorIndex = scanner.nextInt();
        if (!processes[initiatorIndex].isActive) {
            System.out.println("Process is inactive and cannot start election.");
            return;
        }

        int n = processes.length;
        int currentIndex = initiatorIndex;
        int maxId = processes[initiatorIndex].id;

        System.out.println("Election started by process " + processes[initiatorIndex].id);
        do {
            currentIndex = (currentIndex + 1) % n;
            if (processes[currentIndex].isActive) {
                System.out.println("Message passed to process " + processes[currentIndex].id);
                if (processes[currentIndex].id > maxId) {
                    maxId = processes[currentIndex].id;
                }
            }
        } while (currentIndex != initiatorIndex);

        System.out.println("Leader elected with Process ID: " + maxId);
    }
} 