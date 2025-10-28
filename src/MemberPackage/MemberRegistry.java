package MemberPackage;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberRegistry {

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
// remove medlem
    public void delete(Member member) {
        {
            members.remove(member);
        }
    }
}
