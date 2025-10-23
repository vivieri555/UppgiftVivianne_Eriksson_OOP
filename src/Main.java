import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    boolean running = true;
    Scanner input = new Scanner(System.in);
    while(running){
        System.out.println("Välkommen till din lokala biluthyrning!");
        System.out.println("Tryck 1 för att fylla i medlemsuppgifter");
        System.out.println("Tryck 2 för att söka på medlemmar");
        System.out.println("Tryck 3 för att ändra på befintlig medlem");
        System.out.println("Tryck 4 för att se vilka fordon som finns");
        System.out.println("Tryck 5 för att söka på fordon");
        System.out.println("Tryck 6 för att boka en bil");
        System.out.println("Tryck 9 för att avsluta tjänsten");
        int answer = 0;
        try{
            answer = input.nextInt();
        }
        catch(Exception e){
            System.out.println("Du behöver ange ett giltigt menyval mellan 1-9");
        }
        switch(answer){
            case 1:
                break;
            case 9:
                System.out.println("Välkommen åter!");
                running = false;
                break;
            default:
                System.out.println("Prova igen att ange ett giltigt menyval.");
                break;

        }
        System.out.println();
    }
    }
}