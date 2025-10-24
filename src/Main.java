import MemberPackage.*;
import Vehicle.*;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    boolean running = true;
    Scanner input = new Scanner(System.in);
        ElectricCar electricCar = new ElectricCar();
        Member member1 = new Member(1, "Vivianne", "Premium", "Vet ej");
        MemberRegistry memberRegistry = new MemberRegistry();
        ArrayList<Member> pickUpList = memberRegistry.getMembers();
        memberRegistry.add(member1);

        System.out.println(pickUpList.size());   //lista på antal medlemmar i listan
        System.out.println(memberRegistry.getMembers()); //ger bara adressen till members platsen


    while(running){
        System.out.println("Välkommen till din lokala biluthyrning!");
        System.out.println("Tryck 1 för att fylla i medlemsuppgifter");
        System.out.println("Tryck 2 för att söka på medlemmar");
        System.out.println("Tryck 3 för att ändra på befintlig medlem");
        System.out.println("Tryck 4 för att se vilka fordon som finns");
        System.out.println("Tryck 5 för att söka på fordon");
        System.out.println("Tryck 6 för att boka en bil");
        System.out.println("Tryck 7 för att summera intäkter");
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
                System.out.println("Ange uppgifter för en ny medlem, ange id först");
                Member member3 = new Member();
                member3.setId(input.nextInt());
                input.nextLine();
                System.out.println("Skriv in namnet");
                member3.setName(input.nextLine());
                System.out.println("Skriv in statusen om Standard eller Premium");
                member3.setStatus(input.nextLine());
              // member3 = input.nextLine(); //Hur skriva in member i listan?
                Member member2 = new Member();
                memberRegistry.add(member3);
                break;
            case 2:
                input.nextLine();
                System.out.println("Vilken medlem vill du söka efter?");
                String search = input.nextLine();
                memberRegistry.searchAllMembers(String.valueOf(search));
                break;
            case 3:
                System.out.println("Vilken medlem vill du ändra?");
                String change = input.nextLine();
                //lägga in metod
            case 6:
                System.out.println("Välkommen att boka en bil");
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