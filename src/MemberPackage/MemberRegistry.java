package MemberPackage;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberRegistry {

Scanner input = new Scanner(System.in);
    private ArrayList<Member> members = new ArrayList<Member>();


public MemberRegistry(){}
    public MemberRegistry(ArrayList<Member> members){
    this.members = members;
    }
//för att hämta medlemmar i main sen med getter
public ArrayList<Member>getMembers(){
    return members;
}
    //lägga till medlem
public void add(Member member){
    members.add(member);
}
// lägg till remove
    public void delete(Member member) {
        {
            System.out.println("Nu har du raderat " + member);
            members.remove(member);
        }
    }
}
