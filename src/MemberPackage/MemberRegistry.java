package MemberPackage;

import java.util.ArrayList;

public class MemberRegistry {
    private ArrayList<Member> members = new ArrayList<Member>();
//lägga till medlem
    public void add(Member member){
        members.add(member);
    }
public MemberRegistry(){}
    public MemberRegistry(ArrayList<Member> members){
    this.members = members;
    }
//för att hämta medlemmar i main sen
public ArrayList<Member>getMembers(){
    return members;
}
public void changeMember(String change){
        for(Member member: members){
            if (member.getName().equals(change)) {
                System.out.println("Vad vill du ändra på medlemmen?");
                members.remove(member);
            }
            //else if(){
             //   System.out.println("Medlemmen finns inte");
            //}
        }
}
public void searchAllMembers(String searchedMember){
        for(Member member: members){
            if(searchedMember.equals(member.toString())){
                System.out.println("Här är medlemmen " + searchedMember);
            }
            else {
                System.out.println("Medlemmen finns inte");
            }
        }
}
}
