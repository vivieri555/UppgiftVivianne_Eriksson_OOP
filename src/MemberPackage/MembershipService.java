package MemberPackage;

import java.util.ArrayList;
import java.util.Scanner;


public class MembershipService{
    //innehålla affärslogik
    Scanner input = new Scanner(System.in);
    MemberRegistry memberRegistry;

    public MembershipService(MemberRegistry memberRegistry){
        this.memberRegistry = memberRegistry;
    }
    //ger lista varje gång istället för att bara skriva ut ett objekt
    public void searchAllMembers(String searchedMember){
        for (Member member : memberRegistry.getMembers()) {
            if (searchedMember.equals(member.toString())) {
                System.out.println("Här är medlemmen " + searchedMember);
            } else {
                System.out.println("Medlemmen finns inte");
            }
        }
    }

    public void changeMember(){     //Funkar inte
        System.out.println("Vilken medlem vill du ändra på?");
        String change = input.nextLine();
        for(Member member: memberRegistry.getMembers()){
            if (member.getName().equals(change)) {
                System.out.println("Vad vill du ändra på medlemmen?");
                System.out.println("Skriv in [namn] eller [status] om du vill ändra");
                if(input.nextLine().equalsIgnoreCase("status")){
                System.out.println("Skriv in status du vill ha på medlemmen antingen Standard eller Premium");
                member.setStatus(input.nextLine());
                }
                else if(input.nextLine().equalsIgnoreCase("namn")){
                    System.out.println("Skriv in ändringen på namnet");
                    member.setName(input.nextLine());
                }
                //ändra på ett objekts värde

            else {
            System.out.println("Medlemmen finns inte");
                }
            }
        }

    }
}
