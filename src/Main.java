import MemberPackage.*;
import Rental.Inventory;
import Rental.Rental;
import Rental.RentalService;
import Vehicle.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);

        boolean running = true;
        Scanner input = new Scanner(System.in);
        Vehicle vehicle = new Vehicle();
        Inventory inventory = new Inventory();

        Member member1 = new Member(1, "Vivianne", "Premium", "Ingen uthyrnings historik");
        MemberRegistry memberRegistry = new MemberRegistry();
        memberRegistry.add(member1);
        MembershipService membershipService = new MembershipService(memberRegistry);
        RentalService rentalService = new RentalService(inventory);

        inventory.addVehicle(new FamilyCar("VW", "Passat", true, "5", "Manuell", true));
        inventory.addVehicle(new ElectricCar("BMW", "z4", true,"5", "95"));
        inventory.addVehicle(new ElectricCar("Tesla", "X", true, "5", "98"));
        inventory.addVehicle(new CityCar("Mini","Mini Cooper",true, "röd","3"));
        inventory.addVehicle(new CityCar("VW", "Up!", true, "Vit", "3"));
        inventory.addVehicle(new FamilyCar("Volvo", "V90", true, "5","Automat", true));

     /*   while (running) {
//            System.out.println("Tryck 1 för att fylla i ny medlem");
//            System.out.println("Tryck 2 för att söka på medlemmar");
//            System.out.println("Tryck 3 för att ändra på befintlig medlem");
//            System.out.println("Tryck 4 för att ta bort en medlem");
//            System.out.println("Tryck 5 för att lista/söka på fordon");
//            System.out.println("Tryck 6 för att boka en bil");
//            System.out.println("Tryck 7 för att avsluta en uthyrning av bil");
//            System.out.println("Tryck 8 för att summera intäkter");
//            System.out.println("Tryck 9 för att avsluta tjänsten");
            int answer;
            try { answer = input.nextInt(); }
            catch (InputMismatchException e) {
                System.out.println("Du behöver ange ett giltigt menyval mellan 1-9");
                input.next();
                continue;
            }
            switch (answer) {
                case 1:
                    Member member3 = new Member();
                    System.out.println("Ange uppgifter för en ny medlem, ange siffra för id först");
                    try{member3.setId(input.nextInt()); }
                    catch(InputMismatchException e){
                        System.out.println("Ange en siffra");
                        input.nextLine();
                    }
                    input.nextLine();
                    System.out.println("Skriv in namnet");
                    member3.setName(input.nextLine());
                    System.out.println("Skriv in statusen antingen Standard eller Premium");
                    member3.setStatus(input.nextLine());
                    memberRegistry.add(member3);
                    System.out.println("Du har nu lagt till medlemmen " + member3.getName());
                    break;
                case 2:
                    input.nextLine();
                    System.out.println("Skriv in namnet på medlem du vill söka efter:");
                    String search = input.nextLine();
                    membershipService.searchMemberList(search);
                    Member searchedMember = membershipService.searchMemberList(search);
                    if(searchedMember == null){
                        System.out.println("Medlemmen finns inte");
                    } else {
                        System.out.println("Hittat medlemmen ID: " + searchedMember.getId() + ", "+ searchedMember + ", "
                                + searchedMember.getStatus() + ", " + searchedMember.getHistory());
                    }
                    break;
                case 3:
                    input.nextLine();
                    System.out.println("Vilken medlem vill du ändra på?");
                    String changeMember = input.nextLine();
                    Member changeMember1 = membershipService.searchMemberList(changeMember);
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
                case 5:
                    rentalService.cars();
                    break;
                case 6:
                    Rental rental = new Rental();
                    input.nextLine();
                    System.out.println("Ange namn på medlem du vill boka bil på?");
                    String searchName = input.nextLine();
                    Member searchNamed = membershipService.searchMemberList(searchName);
                    if(searchNamed == null){
                        System.out.println("Medlemmen finns inte, skriv in medlemmen i menyval 1");
                    }
                    else{
                        System.out.println("Medlemmen finns Id: " + searchNamed.getId() + ", " + searchNamed.getName());
                        rental.setMember(searchNamed);
                        System.out.println("Vilken bil vill du boka? Ange varumärke");
                        String car = input.nextLine();
                        Vehicle car1 = rentalService.searchCar(car);
                        if(car1 == null || !car1.isLoanable()){
                            System.out.println("Bilen går inte att låna");
                        }
                        else{
                            car1.setLoanable(false);
                            rental.setVehicle(car1);
                            System.out.println("Hur många dagar vill du låna?");
                            int days = input.nextInt();
                            rental.setRentalDays(days);
                            double amount = rentalService.cost(days);
                            System.out.println("Kostnaden blir " + rentalService.cost(days) + " kr.");
                            rental.setCost(amount);
                            rentalService.add(rental);
                            double discount = rentalService.getDiscountedCost(rental);
                            rental.setCost(discount);
                            rentalService.listRental();
                            input.nextLine();
                            System.out.println("Skriv in en ändring på historiken");
                            searchNamed.setHistory(input.nextLine());
                        }
                    }
                    break;
                case 7:
                    input.nextLine();
                    System.out.println("Vilken medlem vill du avsluta bokningen på?");
                    String name = input.nextLine();
                    rentalService.terminateRental(name);
                    vehicle.setLoanable(true);
                    break;
                case 8:
                    rentalService.sum();
                    break;
                 */
    }
    Scene scene1, scene2;

    @Override
    public void start(Stage stage) throws Exception {




        Vehicle vehicle = new Vehicle();
        Inventory inventory = new Inventory();
        Member member1 = new Member(1, "Vivianne", "Premium", "Ingen uthyrnings historik");
        MemberRegistry memberRegistry = new MemberRegistry();
        memberRegistry.add(member1);
        MembershipService membershipService = new MembershipService(memberRegistry);
        RentalService rentalService = new RentalService(inventory);


        stage.setTitle("Vivis Biluthyrning");
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10, 10, 10, 10));
        Label headLabel = new Label("\tVälkommen\n till Vivis biluthyrning!");
        headLabel.getStyleClass().add("label-green");
        Scene scene1 = new Scene(borderPane, 700, 700);

        TextField writerText = new TextField();
        membershipService.readFile(memberRegistry.getMembers().toString());

        //Inventory o memberRegistry läsas in från fil o populera aktuell tabell
      /*  String rentalFile = "data.txt";
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
        } */

        //TableView
        TableView<Member> table;
        TableColumn<Member, Integer> idColumn = new TableColumn<>("Id");
        idColumn.setMinWidth(100);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        table = new TableView<>();
        table.setItems(membershipService.getMembers());
        TextField idInput = new TextField();
        idInput.setPromptText("ID");
        idInput.setMinWidth(100);

        TableColumn<Member, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(150);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        TextField nameInput = new TextField();
        nameInput.setPromptText("Namn");
        nameInput.setMinWidth(150);

        TableColumn<Member, String> statusColumn = new TableColumn<>("Status");
        statusColumn.setMinWidth(100);
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        TextField statusInput = new TextField();
        statusInput.setPromptText("Status");
        statusInput.setMinWidth(100);

        TableColumn<Member, String> historyColumn = new TableColumn<>("History");
        historyColumn.setMinWidth(200);
        historyColumn.setCellValueFactory(new PropertyValueFactory<>("history"));
        TextField historyInput = new TextField();
        historyInput.setPromptText("Historik");
        historyInput.setMinWidth(200);

        TableColumn<Button, String> returnColumn = new TableColumn<>("Återgå till huvudmeny");
        returnColumn.setMinWidth(200);
        returnColumn.setCellValueFactory(new PropertyValueFactory<>("return"));
        Button returnScene = new Button("Gå tillbaka till huvudmenyn");
        returnScene.setMinWidth(100);

        table.getColumns().addAll(idColumn, nameColumn, statusColumn, historyColumn);

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(10, 10, 10, 10));
        hbox.setSpacing(10);

        HBox hBox2 = new HBox();
        hBox2.setPadding(new Insets(10, 10, 10, 10));
        hBox2.setSpacing(10);

        VBox vbox1 = new VBox();
        vbox1.setPadding(new Insets(20, 20, 20, 20));
        Scene scene2 = new Scene(vbox1);

        VBox vBox3 = new VBox();
        vBox3.setPadding(new Insets(10, 10, 10, 10));
        vBox3.setSpacing(10);
        Scene scene3 = new Scene(vBox3, 500, 500);

        VBox vBox2 = new VBox();
        vBox2.setPadding(new Insets(10, 10, 10, 10));
        vBox2.setSpacing(10);



        //Button
        returnScene.setOnAction(e -> {
            stage.setScene(scene1);
        });

        Menu memberMenu = new Menu("Medlemmar");
        MenuItem addMemberM = new MenuItem("Lägg till ny/radera medlem...");
        MenuItem searchMemberM = new MenuItem("Sök på medlemmar...");
        MenuItem changeMemberM = new MenuItem("Ändra på medlemmar...");
        Menu carMenu = new Menu("Bilar");
        carMenu.getItems().add(new MenuItem("Sök/lista bilar..."));
        carMenu.getItems().add(new MenuItem("Boka en bil..."));
        carMenu.getItems().add(new MenuItem("Avsluta en uthyrning..."));
        Menu revenueMenu = new Menu("Intäkter");
        MenuItem revenue = new MenuItem("Summera intäkter...");
        revenueMenu.getItems().add(revenue);

        Label idLabel = new Label();
        TextField idText = new TextField();
        idText.setPromptText("ID");
        TextField search = new TextField();
        Button searchMButton = new Button("Sök");
        Label saveLabel = new Label();

        Label addNameLabel = new Label();
        TextField addNameText = new TextField();
        addNameText.setPromptText("Namn");
        TextField addName = new TextField();

        Label statusLabel = new Label();
        TextField statusText = new TextField();
        statusText.setPromptText("Standard eller Premium");
        Label addM = new Label();

        Label writerLabel = new Label("----------------------\nFilinläsning:\n");
        Button writerButton = new Button("Läs in från fil");
        Button addButton = new Button("Spara medlem");
        Button deleteButton = new Button("Radera medlem");
        Button changeMButton = new Button("Ändra medlem");
        Label changeLabel = new Label("Vilken medlem vill du ändra på?");
        Label changeNameL = new Label("Namn:");
        TextField changeName = new TextField();
        changeName.setPromptText("Namn");
        Label changeStatusL = new Label("Status:");
        TextField changeStatus = new TextField();
        changeStatus.setPromptText("Standard eller Premium");
        Label changeHistoryL = new Label("Historik:");
        TextField changeHistory = new TextField();
        changeHistory.setPromptText("Historik");

        Label deleteL = new Label("Vilken medlem vill du radera?");
        TextField deleteT = new TextField();

        addMemberM.setOnAction(e -> {
            stage.setScene(scene2);
            idLabel.setText("Ange uppgifter för en ny medlem:");
            idText.getText();
            nameInput.getText();
            statusLabel.setText(statusText.getText());

        });
        addButton.setOnAction(e -> {
            Member member3 = new Member();
            saveLabel.setText(String.valueOf(membershipService.addId(idText, member3)));
           // System.out.println(membershipService.addId(idText, member3));
        //Lägga in Label "inte giligt nummer"
            //smäller på integerparse, göra om från boolean elr ny metod som kan skriva ut int variebel
            member3.setId(Integer.parseInt(idText.getText()));
            member3.setName(nameInput.getText());
            member3.setStatus(statusText.getText());
            member3.setHistory(historyInput.getText());
            memberRegistry.add(member3);
            String added = "Du har nu lagt till medlem " + idText.getText() + ", "+ nameInput.getText() +", " +statusText.getText();
            addM.setText(added);
            idText.clear();
            nameInput.clear();
            statusText.clear();
            historyInput.clear();
        });
        deleteButton.setOnAction(e -> {
            deleteL.getText();
            deleteT.getText();
            Member memberD = membershipService.searchMemberList(deleteT.getText());
            membershipService.searchResult(memberD);
            memberRegistry.delete(memberD);
            deleteL.setText("Medlemmen raderad");
        });

        writerButton.setOnAction(e -> {
        String s = membershipService.readFile(memberRegistry.getMembers().toString());
            writerText.setText(s);

        });

        searchMemberM.setOnAction(e -> {
            borderPane.setCenter(vBox3);
            addNameLabel.setText("Skriv in namnet på medlem du vill söka efter:");
            String s = addNameText.getText();
            System.out.println(s);
        });
        searchMButton.setOnAction(e -> {
            Member searchedMember = membershipService.searchMemberList(addNameText.getText());
            System.out.println(searchedMember);
            if(searchedMember == null){
                String s = "Medlemmen finns inte";
                saveLabel.setText(s);
            } else {
                String found = "Hittat medlemmen: " + searchedMember.getId() + ", "+ searchedMember.getName() + ", "
                        + searchedMember.getStatus() + ", " + searchedMember.getHistory();
                saveLabel.setText(found);
            }
        });

        System.out.println("Vad vill du ändra på medlemmen?");
        System.out.println("Skriv in [namn], [status] eller [historik] på det du vill ändra");

        changeMemberM.setOnAction(e -> {
            borderPane.setCenter(vBox2);
            changeLabel.getText();
            nameInput.getText();
            changeName.getText();
            changeStatus.getText();
            changeHistory.getText();
            Member m =  membershipService.searchMemberList(addNameText.getText());
        } );

        changeMButton.setOnAction(e -> {
            //anropa ändringen av member i kod
            // Member m = membershipService.changeSwitch(nameInput.getText());
            nameInput.clear();

        });
        Button revenueButton = new Button("Visa intäkter");
        revenue.setOnAction(e -> {
            borderPane.setCenter(revenueButton);
        });
        revenueButton.setOnAction(e -> {rentalService.sum();});

        //göra en ny knapp som säger Sök och sen ha funktionalitet till metoden i den
        //göra nåt med informationen, spara informationen

       /* addMemLabel.setText("Ange uppgifter för en ny medlem, ange siffra för id först");
        addMemText.getText();
        addMemText.setPromptText("ID");
                Member member3 = new Member();
                System.out.println("Ange uppgifter för en ny medlem, ange siffra för id först");
                try{member3.setId(input.nextInt()); }
                catch(InputMismatchException e3){
                    System.out.println("Ange en siffra");
                    input.nextLine();
                }
                input.nextLine();
                System.out.println("Skriv in namnet");
                member3.setName(input.nextLine());
                System.out.println("Skriv in statusen antingen Standard eller Premium");
                member3.setStatus(input.nextLine());
                memberRegistry.add(member3);
                System.out.println("Du har nu lagt till medlemmen " + member3.getName());});
*/

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(memberMenu, carMenu, revenueMenu);
        memberMenu.getItems().addAll(addMemberM, searchMemberM, changeMemberM);

        borderPane.setCenter(headLabel);
        borderPane.setTop(menuBar);

        //Översta Hbox i tableView
        hbox.getChildren().addAll(idInput, nameInput, statusInput, historyInput);

        //Lägga till/ta bort medlemmar/lista tabell
        hBox2.getChildren().addAll(nameInput, idText, statusText, historyInput, addButton);
        vbox1.getChildren().addAll(table, returnScene, idLabel, hBox2, searchMButton, saveLabel
                , addM, deleteL, deleteT, deleteButton, writerLabel, writerButton, writerText);

        //sökningen medlemmar
        vBox3.getChildren().addAll(addNameLabel, addNameText, searchMButton, saveLabel);
        //Ändra medlem
        vBox2.getChildren().addAll(changeLabel, changeNameL, changeName, changeStatusL
                , changeStatus, changeHistoryL, changeHistory, changeMButton);

        borderPane.getChildren().addAll();

        scene1.getStylesheets().add("MenuColors.css");
        stage.setScene(scene1);
        stage.show();


    }
    //kopiera innehållet till observableList, lyssna på bil på förändringar, när nåt förändras
    //arraylist funkar inte så
    //lägger in startdata i observablelist

}