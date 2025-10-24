package MemberPackage;

import java.util.ArrayList;

public class MemberRegistry {
    private ArrayList<Member> members = new ArrayList<Member>();

    public void add(Member member){
        members.add(member);
    }
public MemberRegistry(){}
    public MemberRegistry(ArrayList<Member> members){
    this.members = members;
    }
//för att hämta medlemmer i main sen
public ArrayList<Member>getMembers(){
    return members;
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
