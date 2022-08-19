import java.util.Scanner;
public class Main {
    private final Scanner sc;
    private TurnSystem tu;

    public Main() {
        tu = new TurnSystem();
        sc = new Scanner(System.in);
    }

    public static void main(String[] arg) {
        System.out.println("Welcome to the turn system");
        Main ppl = new Main();
        int option = 0;
        do {
            option = ppl.showMenu();
            ppl.runMenu(option);
        } while (option != 0);
    }

    public int showMenu() {
            System.out.println("Choose one of the following options\n" +
                    "(0)Exit\n" +
                    "(1)Give turn\n"+
                    "(2)Show current turn\n"+
                    "(3)Pass turn\n"+
                    "(4)Delete current turn and continue\n"+
                    "(5)Show all turns\n");
            int option = sc.nextInt();
            sc.nextLine();
            return option;
    }

    public void runMenu(int option) {
        switch (option) {
            case 1 :
                tu.addLast();
                break;
            case 2:
                tu.showTurn();
                break;
            case 3:
                tu.passTurn();
                break;
            case 4 :
                tu.attended();
            case 5 :
                tu.print();
            case 0:
                System.out.println("Bye!!");
                break;
            default:
                System.out.println("Choose a valid option!");
                break;
        }
    }
}