package MemberPackage;

import java.util.Scanner;


public class MembershipService{
    //innehålla affärslogik
    Scanner input = new Scanner(System.in);
    MemberRegistry memberRegistry;

    public MembershipService(MemberRegistry memberRegistry){
        this.memberRegistry = memberRegistry;
    }
    //ger lista varje gång istället för att bara skriva ut ett objekt

    public Member searchMemberList(String searchedMember){
        for(Member member: memberRegistry.getMembers()){
            if(member.getName().contains(searchedMember)){
                return member;
            }
        } return null;
    }
    public void ifUserNotFound(Member member){
        if(member == null){
            System.out.println("Medlemmen hittas inte");
        }
    }
    //Lägg in som switch case istället?
public void changeNewMethod(Member sMember){
    System.out.println("Vad vill du ändra på medlemmen?");
    System.out.println("Skriv in [namn] eller [status] om du vill ändra");
    if(input.nextLine().equalsIgnoreCase("namn")){
        input.nextLine();
        System.out.println("Skriv in ändringen på namnet");
        sMember.setName(input.nextLine());
        System.out.println("Du har nu ändrat namnet till " + sMember);
    }
    else if(input.nextLine().equalsIgnoreCase("status")){
        //input.nextLine();
        System.out.println("Skriv in status Standard eller Premium");
        sMember.setStatus(input.nextLine());
        System.out.println("Du har nu ändrat statusen på medlem " + sMember);
    }
}
            public void changeSwitch(Member sMember){
                System.out.println("Vad vill du ändra på medlemmen?");
                System.out.println("Skriv in [namn], [status] eller [historik] på det du vill ändra");
                String changeInput = input.nextLine();
                switch(changeInput){
        case "namn":
            System.out.println("Skriv in ändringen på namnet");
            sMember.setName(input.nextLine());
            System.out.println("Du har nu ändrat namnet till " + sMember);
            break;
        case "status":
            System.out.println("Skriv in status Standard eller Premium");
            sMember.setStatus(input.nextLine());
            System.out.println("Du har nu ändrat statusen på medlem " + sMember);
            break;
        case "historik":
            System.out.println("ändra historiken metod");
            break;
            default:
                System.out.println("Inte gjort ett giltigt val");
                break;
                }
            }
//    public void changeMember(){     //Funkar inte
//
//        for(Member member: memberRegistry.getMembers()){
//            if (member.getName().equals(change)) {
//                System.out.println("Vad vill du ändra på medlemmen?");
//                System.out.println("Skriv in [namn] eller [status] om du vill ändra");
//                if(input.nextLine().equalsIgnoreCase("status")){
//                System.out.println("Skriv in status du vill ha på medlemmen antingen Standard eller Premium");
//                member.setStatus(input.nextLine());
//                }
//                else if(input.nextLine().equalsIgnoreCase("namn")){
//                    System.out.println("Skriv in ändringen på namnet");
//                    member.setName(input.nextLine());
//                }
//                //ändra på ett objekts värde
//
//            else {
//            System.out.println("Medlemmen finns inte");
//                }
//            }
//        }
//  }
}
