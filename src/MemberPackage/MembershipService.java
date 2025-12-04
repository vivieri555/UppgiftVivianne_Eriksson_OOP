package MemberPackage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.Scanner;

public class MembershipService{
    Scanner input = new Scanner(System.in);
    MemberRegistry memberRegistry;

    public MembershipService(MemberRegistry memberRegistry){
        this.memberRegistry = memberRegistry;
    }

    //Hämta observablelist  objekt istället för arraylistMembers
    public Member searchMemberList(String searchedMember){
        for(Member member: memberRegistry.getMembers()){
            if(member.getName().contains(searchedMember)){
                return member;
            }
        } return null;
    }

    public ObservableList<Member> getMembers() {
        return memberRegistry.getMembers();
    }
    public void searchMException () {
        if (memberRegistry.getMembers() == null) {
            Label searchML = new Label("Användaren finns inte");
        }
    }
    public void changeHistory(Member member){
        System.out.println("Skriv in ändring till historiken");
        member.setHistory(input.nextLine());
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
            changeHistory(sMember);
            break;
            default:
                System.out.println("Inte gjort ett giltigt val");
                break;
                }
            }
            public Boolean addId(TextField addMemText, Member member3) {
                try {
                  int id = Integer.parseInt(addMemText.getText());
                    member3.setId(id);
                    return true;
                }
                catch (NumberFormatException e2) {
                    addMemText.setText("Inte ett giltigt nummer");
                    return false;
        }
    }
    public void searchResult(Member searchedMember) {
        if (searchedMember == null) {
            System.out.println("Medlemmen finns inte");
        } else {
            memberRegistry.delete(searchedMember);
        }
    }
    public String readFile (String string) {
        TextField writerText = new TextField();
        //Inventory o memberRegistry läsas in från fil o populera aktuell tabell
        String rentalFile = "data.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rentalFile))) {
            writer.write(memberRegistry.getMembers().toString());
            writerText.setText("Filen har sparats " + rentalFile);
        }
        catch (IOException eFile) {
            writerText.setText("Gick inte att spara");
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(rentalFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writerText.setText(line);
            }
        }
        catch (IOException eFile) {
            writerText.setText("Fel vid utskrift");
        } return writerText.getText();
    }
}
