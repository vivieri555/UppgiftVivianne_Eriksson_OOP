import MemberPackage.*;
import Rental.Inventory;
import Vehicle.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        boolean running = true;
        Scanner input = new Scanner(System.in);
        ElectricCar electricCar = new ElectricCar();
        Vehicle vehicle = new Vehicle();
        Member member1 = new Member(1, "Vivianne", "Premium", "Vet ej");
        Member member = new Member();
        MemberRegistry memberRegistry = new MemberRegistry();
        MembershipService membershipService = new MembershipService(memberRegistry);
        ArrayList<Member> pickUpList = memberRegistry.getMembers();
        memberRegistry.add(member1);

        Inventory inventory = new Inventory();
        addCars(inventory);

        System.out.println(pickUpList.size());   //lista på antal medlemmar i listan
        System.out.println(memberRegistry.getMembers()); //vilka medlemmar som finns i listan

        while (running) {
            writeMenu();
            int answer = 0;
            try { answer = input.nextInt(); }

            catch (InputMismatchException e) {
                System.out.println("Du behöver ange ett giltigt menyval mellan 1-9");
                input.next();
                continue;
            }
                switch (answer) {
                    case 1:                 //random.next nummer på id kanske?
                        System.out.println("Ange uppgifter för en ny medlem, ange id först");
                        Member member3 = new Member();
                        member3.setId(input.nextInt());
                        input.nextLine();
                        System.out.println("Skriv in namnet");
                        member3.setName(input.nextLine());
                        System.out.println("Skriv in statusen om Standard eller Premium");
                        member3.setStatus(input.nextLine());
                        memberRegistry.add(member3);
                        System.out.println("Du har nu lagt till medlemmen " + member3.getName());
                        break;
                    case 2:
                        input.nextLine();
                        System.out.println("Vilken medlem vill du söka efter?");
                        String search = input.nextLine();
                        membershipService.searchMemberList(search);
                        Member searchedMember = membershipService.searchMemberList(search);
                        if(searchedMember == null){
                            System.out.println("Medlemmen finns inte");
                        } else {
                            System.out.println("Hittat medlemmen " + searchedMember);
                        }
                        break;
                    case 3:
                        input.nextLine();
                        System.out.println("Vilken medlem vill du ändra på?");
                        String changeMember = input.nextLine();
                        Member changeMember1 = membershipService.searchMemberList(changeMember);
                        //letat upp medlem
                        if(changeMember1 == null){
                        System.out.println("Medlemmen finns inte");
                        }
                        else{
                            membershipService.changeSwitch(changeMember1);
                        }
                         break;
                    case 4:
                        input.nextLine();
                        System.out.println("Vilken medlem vill du radera?");
                        String answerDelete = input.nextLine();
                        Member memberD = membershipService.searchMemberList(answerDelete);
                        if(memberD == null){
                            System.out.println("Medlemmen finns inte");
                        }
                        else{
                            memberRegistry.delete(memberD);
                            System.out.println("Medlemmen " + memberD + " borttagen");
                        }
                        break;
                    case 7:
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
            //input.nextLine();
        }
    }

    private static void writeMenu() {
        //Ta bort meny som static, ha i Main vanligt
        System.out.println("Välkommen till din lokala biluthyrning!");
        System.out.println("Tryck 1 för att fylla i ny medlem");
        System.out.println("Tryck 2 för att söka på medlemmar");
        System.out.println("Tryck 3 för att ändra på befintlig medlem");
        System.out.println("Tryck 4 för att ta bort en medlem");
        System.out.println("Tryck 5 för att se vilka fordon som finns");
        System.out.println("Tryck 6 för att lista/söka på fordon");
        System.out.println("Tryck 7 för att boka en bil");
        System.out.println("Tryck 8 för att summera intäkter");
        System.out.println("Tryck 9 för att avsluta tjänsten");
    }

    private static void addCars(Inventory inventory) {
        inventory.addVehicle(new FamilyCar("VW", "Passat", "5", "Manuell", true));
        inventory.addVehicle(new ElectricCar("BMW", "z4","5", "95"));
        inventory.addVehicle(new ElectricCar("Tesla", "X", "5", "98"));
        inventory.addVehicle(new CityCar("Mini","Mini Cooper","röd","3"));
        inventory.addVehicle(new CityCar("VW", "Up!", "Vit", "3"));
        inventory.addVehicle(new FamilyCar("Volvo", "V90", "5","Automat", true));
    }
}