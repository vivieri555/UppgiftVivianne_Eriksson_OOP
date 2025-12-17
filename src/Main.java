import Alerts.AlertBox;
import Alerts.AlertVehicle;
import MemberPackage.*;
import Rental.Inventory;
import Rental.RentalService;
import Vehicle.*;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import File.FileService;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        FileService fileService = new FileService();
        ObservableList<Member> members = fileService.readMembers();
        ObservableList<Vehicle> vehicles = fileService.readVehicles();
        Inventory inventory = new Inventory(vehicles);
        MemberRegistry memberRegistry = new MemberRegistry(members);
        MembershipService membershipService = new MembershipService(memberRegistry);
        RentalService rentalService = new RentalService(inventory, membershipService);
        AlertBox alertBox = new AlertBox(membershipService);
        AlertVehicle alertVehicle = new AlertVehicle(inventory, membershipService, rentalService);
        Bike bike = new Bike();
        Car car = new Car();


        stage.setTitle("Vivis Biluthyrning");
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10, 10, 10, 10));
        Label headLabel = new Label("\tVälkommen\n till Vivis biluthyrning!");
        headLabel.getStyleClass().add("label-green");
        Scene scene1 = new Scene(borderPane, 700, 700);

        TableView<Vehicle> vehicleTable = new TableView<>();

        TableColumn<Vehicle, String> brandColumn = new TableColumn("Märke");
        brandColumn.setMinWidth(200);
        brandColumn.setCellValueFactory(new PropertyValueFactory<>("brand"));
        TextField brandInput = new TextField();
        brandInput.setPromptText("Märke");
        brandInput.setMinWidth(200);

        TableColumn<Vehicle, String> modelColumn = new TableColumn<>("Modell");
        modelColumn.setMinWidth(200);
        modelColumn.setCellValueFactory(new PropertyValueFactory<>("model"));
        TextField modelInput = new TextField("Modell");
        modelInput.setPromptText("Modell");
        modelInput.setMinWidth(200);

        TableColumn<Vehicle, Boolean> loanableColumn = new TableColumn<>("Tillgänglig");
        loanableColumn.setMinWidth(200);
        loanableColumn.setCellValueFactory(new PropertyValueFactory<>("loanable"));
        TextField loanableInput = new TextField();
        loanableInput.setPromptText("Tillgänglig");
        loanableInput.setMinWidth(200);

        TableColumn<Vehicle, String> vehicleTypeColumn = new TableColumn<>("Fordonstyp");
        vehicleTypeColumn.setMinWidth(200);
        vehicleTypeColumn.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        TextField vehicleTypeInput = new TextField();
        vehicleTypeInput.setMinWidth(200);

        TableColumn<Vehicle, String> hasRearCameraColumn = new TableColumn<>("Har backkamera");
        hasRearCameraColumn.setMinWidth(200);
        hasRearCameraColumn.setCellValueFactory(new PropertyValueFactory<>("hasRearCamera"));
        TextField hasRearCameraInput = new TextField();
        hasRearCameraInput.setMinWidth(200);

        TableColumn<Vehicle, String> gearboxColumn = new TableColumn<>("Växellåda");
        gearboxColumn.setMinWidth(100);
        gearboxColumn.setCellValueFactory(new PropertyValueFactory<>("gearbox"));
        TextField gearboxInput = new TextField();
        gearboxInput.setMinWidth(100);

        TableColumn<Vehicle, String> gearsColumn = new TableColumn<>("Antal växlar");
        gearsColumn.setMinWidth(200);
        gearsColumn.setCellValueFactory(new PropertyValueFactory<>("gears"));
        TextField gearsInput = new TextField();
        gearsInput.setMinWidth(200);

        TableColumn<Vehicle, String> basketColumn = new TableColumn<>("Cykelkorg");
        basketColumn.setMinWidth(150);
        basketColumn.setCellValueFactory(new PropertyValueFactory<>("basket"));
        TextField basketInput = new TextField();
        basketInput.setMinWidth(150);

        vehicleTable.setItems(inventory.getVehicleList());
        vehicleTable.getColumns().addAll(brandColumn, modelColumn, loanableColumn, vehicleTypeColumn, hasRearCameraColumn, gearboxColumn, gearsColumn, basketColumn);

        //TableView medlemmar
        TableView<Member> table = new TableView<>();
        TableColumn<Member, Integer> idColumn = new TableColumn<>("Id");
        idColumn.setMinWidth(100);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        table.setItems(membershipService.getMembers());

        TextField idInput = new TextField();
        idInput.setPromptText("ID");
        idInput.setMinWidth(100);

        TableColumn<Member, String> nameColumn = new TableColumn<>("Namn");
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

        TableColumn<Member, String> historyColumn = new TableColumn<>("Historik");
        historyColumn.setMinWidth(200);
        historyColumn.setCellValueFactory(new PropertyValueFactory<>("history"));
        TextField historyInput = new TextField();
        historyInput.setPromptText("Historik");
        historyInput.setMinWidth(200);

        Button returnScene = new Button("Gå tillbaka till huvudmenyn");
        returnScene.setMinWidth(100);
        Button returnScene2 = new Button("Gå tillbaka till huvudmenyn");
        returnScene2.setMinWidth(100);

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


        VBox vBox2 = new VBox();
        vBox2.setPadding(new Insets(10, 10, 10, 10));
        vBox2.setSpacing(10);

        VBox vBox4 = new VBox();
        vBox4.setPadding(new Insets(10, 10, 10, 10));
        vBox4.setSpacing(10);

        //Vbox5 till bilarna
        VBox vBox5 = new VBox();
        vBox5.setPadding(new Insets(10, 10, 10, 10));
        vBox5.setSpacing(10);
        Scene scene3 = new Scene(vBox5, 1500, 1000);

        HBox hBox3 = new HBox();
        hBox3.setPadding(new Insets(10, 10, 10, 10));
        hBox3.setSpacing(10);

        HBox hBox4 = new HBox();
        hBox4.setPadding(new Insets(10, 10, 10, 10));
        hBox4.setSpacing(10);
        Scene scene4 = new Scene(hBox4, 500, 500);

        VBox vBox6 = new VBox();
        vBox6.setPadding(new Insets(10, 10, 10, 10));
        vBox6.setSpacing(10);

        //Button
        returnScene.setOnAction(e -> {
            stage.setScene(scene1);
        });

        returnScene2.setOnAction(e -> {
            stage.setScene(scene1);
        });

        Menu memberMenu = new Menu("Medlemmar");
        MenuItem addMemberM = new MenuItem("Hantera medlemmar...");
        MenuItem searchMemberM = new MenuItem("Sök upp information om medlem...");

        Menu carMenu = new Menu("Fordon");
        MenuItem listCarMenu = new MenuItem("Hantera/Boka fordon...");
        MenuItem availbleMenu = new MenuItem("Filtrera på tillgängliga bilar...");
        MenuItem terminateRental = new MenuItem("Avsluta en uthyrning...");

        Menu revenueMenu = new Menu("Intäkter");
        MenuItem revenue = new MenuItem("Summera intäkter...");
        revenueMenu.getItems().add(revenue);

        Label writerLabel = new Label();
        Button writerButton = new Button("Spara medlemmar till fil");

        Label idLabel = new Label();
        TextField idText = new TextField();
        idText.setPromptText("ID");
        Button searchMButton = new Button("Sök");
        Label saveLabel = new Label();

        Label addNameLabel = new Label();
        TextField addNameText = new TextField();
        addNameText.setPromptText("Namn");
        TextField addName = new TextField();
        addName.setPromptText("Namn");
        Label statusLabel = new Label();
        TextField statusText = new TextField();
        statusText.setPromptText("Standard eller Premium");
        Label addMLabel = new Label();

        Button addButton = new Button("Spara medlem");
        Button deleteButton = new Button("Radera medlem");
        Button changeMButton = new Button("Ändra medlem");
        Label changeLabel = new Label("Markera medlem du vill ändra på och tryck sen Ändra medlem");
        TextField changeName = new TextField();
        changeName.setPromptText("Namn");
        TextField changeStatus = new TextField();
        changeStatus.setPromptText("Standard eller Premium");
        TextField changeHistory = new TextField();
        changeHistory.setPromptText("Historik");
        Label deleteL = new Label("Vilken medlem vill du radera?");
        TextField deleteT = new TextField();
        TextField searchName = new TextField();
        searchName.setPromptText("Namn");

        //Knappar för Vehicle
        Button saveCarB = new Button("Lägg in ny bil");
        Button deleteVButton = new Button("Radera fordon");
        Button changeCarB = new Button("Ändra fordon");
        Button saveBikeB = new Button("Lägg in ny cykel");
        Button bookVehicleButton = new Button("Boka Bil/Cykel");
        Button terminateButton = new Button("Avsluta uthyrning");
        Button availableButton = new Button("Sortera på tillgängliga fordon");
        Button filterBike = new Button("Filtrera på bara cyklar");
        Button unFilterBike = new Button("Ta bort filtreringen");
        Button revenueButton = new Button("Visa intäkter");

        //Label fordon
        Label vehicleLabel = new Label();
        Label bookCarLabel = new Label("Markera en bil/cykel du önskar boka och tryck sen på Boka Bil/cykel");
        Label brandLabel = new Label();
        Label terminate = new Label();
        Label terminateLabel = new Label();
        Label termLabel = new Label();
        Label availableLabel = new Label();
        Label sumLabel = new Label();
        Label sumsLabel = new Label();


        //TextField fordon
        TextField brandText = new TextField();
        brandText.setPromptText("Märke");
        TextField modelText = new TextField();
        modelText.setPromptText("Modell");
        TextField loanableText = new TextField();
        loanableText.setPromptText("Tillgänglig");
        TextField vehicleTypeText = new TextField();
        vehicleTypeText.setPromptText("Typ av fordon");
        TextField hasRearCameraText = new TextField();
        hasRearCameraText.setPromptText("Finns backkamera");
        TextField gearboxText = new TextField();
        gearboxText.setPromptText("Växellåda");
        TextField gearsText = new TextField();
        gearsText.setPromptText("Antal växlar");
        TextField basketText = new TextField();
        basketText.setPromptText("Finns korg");
        TextField bookingText = new TextField();
        TextField daysText = new TextField();
        TextField terminateText = new TextField();
        TextArea textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setPrefSize(400, 200);
        textArea.setWrapText(true);

        //knappar funktionalitet fordon
        listCarMenu.setOnAction(e -> {
            stage.setScene(scene3);
            vehicleTable.refresh();
        });

        availbleMenu.setOnAction(e -> {
            borderPane.setLeft(vBox6);
            availableButton.setOnAction(ev -> {
                String result = rentalService.available();
                textArea.appendText("Fordon tillgängliga: \n" + result);
            });
        });

        revenue.setOnAction(e -> {
            borderPane.setCenter(hBox4);
            revenueButton.setOnAction(ev -> {
                rentalService.sum(sumLabel, sumsLabel);});
        });

        filterBike.setOnAction(e -> {
            inventory.filterV(vehicleTable);
        });

        unFilterBike.setOnAction(ev -> {
            inventory.unFilterV(vehicleTable);
        });

        saveBikeB.setOnAction(e -> {alertVehicle.addBike(bike, brandText,
                modelText, loanableText, gearsText, basketText);});

        saveCarB.setOnAction(e -> {
            alertVehicle.addCar(car, brandText, modelText, loanableText,
                    vehicleTypeText, hasRearCameraText, gearboxText, vehicleTable);
        });
        deleteVButton.setOnAction(e -> {Vehicle vehicleD = rentalService.searchCar(deleteT.getText());
        inventory.remove(vehicleD);
        alertBox.display("Radera", "Bil/cykel raderad");
            deleteT.clear();});

        changeCarB.setOnAction(e -> {
            Car v;
            int valdRad = vehicleTable.getSelectionModel().getSelectedCells().get(0).getRow();
            v = (Car) vehicleTable.getItems().get(valdRad);
            alertVehicle.changeCar(v, brandInput, modelInput, loanableInput, vehicleTypeInput, hasRearCameraInput, gearboxInput, vehicleTable);
            brandInput.getText();
            modelInput.getText();
            loanableInput.getText();
            vehicleTypeInput.getText();
            hasRearCameraInput.getText();
            gearboxInput.getText();
        });

        bookVehicleButton.setOnAction(e -> {
            Vehicle car1;
            int valdRad = vehicleTable.getSelectionModel().getSelectedCells().get(0).getRow();
            car1 = vehicleTable.getItems().get(valdRad);
            alertVehicle.bookCar(car1, vehicleTable, bookingText, brandLabel, daysText);
        });

        terminateRental.setOnAction(e -> {
            borderPane.setCenter(vBox2);
            terminate.setText("Skriv namn på medlemmen du vill avsluta uthyrningen på");
            terminateButton.setOnAction(ev -> {
                String name = terminateText.getText();
                rentalService.terminateRental(name, termLabel, terminateLabel);});
        });

        addMemberM.setOnAction(e -> {
            stage.setScene(scene2);
            idLabel.setText("Ange uppgifter för en ny medlem:");
            idText.getText();
            addNameText.getText();
            statusLabel.setText(statusText.getText());

        });
        addButton.setOnAction(e -> {
            Member member3 = new Member();
            saveLabel.setText(String.valueOf(membershipService.addId(idText, member3)));

            member3.setId(Integer.parseInt(idText.getText()));
            member3.setName(addNameText.getText());
            member3.setStatus(statusText.getText());
            member3.setHistory(historyInput.getText());
            memberRegistry.add(member3);
            String added = "Du har nu lagt till medlem " + idText.getText() + ", "+ addNameText.getText() +", " +statusText.getText();
            addMLabel.setText(added);
            idText.clear();
            addNameText.clear();
            statusText.clear();
            historyInput.clear();
        });
        writerButton.setOnAction(e -> {
            fileService.writeFile(members);
        });

        deleteButton.setOnAction(e -> {
            Member memberDel = membershipService.searchMemberList(deleteT.getText());
            membershipService.delMember(memberDel);
            alertBox.display("Radera medlem", "Medlem raderad");
            deleteT.clear();
        });

        searchMemberM.setOnAction(e -> {
            borderPane.setCenter(vBox3);
            addNameLabel.setText("Skriv in namnet på medlem du vill söka efter:");
            addName.getText();
        });
        searchMButton.setOnAction(e -> {
            Member searchedMember = membershipService.searchMemberList(addName.getText());
            if(searchedMember == null){
                saveLabel.setText("Medlemmen finns inte");
            } else {
                String found = "Hittat medlemmen: " + searchedMember.getId() + ", "+ searchedMember.getName() + ", "
                        + searchedMember.getStatus() + ", " + searchedMember.getHistory();
                saveLabel.setText(found);
                addName.clear();
            }
        });
        changeMButton.setOnAction(e -> {
            Member member;
            int valdRad = table.getSelectionModel().getSelectedCells().get(0).getRow();
            member = table.getItems().get(valdRad);
            alertBox.change("Ändra medlem", "Fyll i ändringar på medlem", member,
                    idInput, addName, changeStatus, changeHistory, table);
            idInput.getText();
            addName.getText();
            changeStatus.getText();
            changeHistory.getText();
        });

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(memberMenu, carMenu, revenueMenu);
        memberMenu.getItems().addAll(addMemberM, searchMemberM);
        carMenu.getItems().addAll(listCarMenu, availbleMenu, terminateRental);

        borderPane.setCenter(headLabel);
        borderPane.setTop(menuBar);

        //Översta Hbox i tableView Medlemmar
        hbox.getChildren().addAll(idInput, nameInput, statusInput, historyInput);
        //Lägga till/ta bort medlemmar/lista tabell
        hBox2.getChildren().addAll(idText, addNameText, statusText, historyInput, addButton);

        vbox1.getChildren().addAll(writerLabel, writerButton, table, returnScene
                , idLabel, hBox2, searchMButton, saveLabel, addMLabel,
                changeLabel, changeMButton, deleteL, deleteT, deleteButton);
        //sökningen medlemmar
        vBox3.getChildren().addAll(addNameLabel, addName, searchMButton, saveLabel);
        //avsluta fordons uthyrning
        vBox2.getChildren().addAll(terminate, terminateText, terminateButton, termLabel, terminateLabel);

        //Intäkter
        hBox4.getChildren().addAll(revenueButton, sumsLabel, sumLabel);

        //Bilars lista, meny
        hBox3.getChildren().addAll(brandInput, modelInput, loanableInput, vehicleTypeInput,
                hasRearCameraInput, gearboxInput, gearsInput, basketInput);
        vBox5.getChildren().addAll(returnScene2, bookCarLabel, bookVehicleButton,
                filterBike, unFilterBike, vehicleTable,
                vehicleLabel, saveCarB, saveBikeB, changeCarB, deleteVButton);
        //söka på tillgängliga bilar
        vBox6.getChildren().addAll(availableButton, availableLabel, textArea);

        borderPane.getChildren().addAll();
        scene3.getStylesheets().add("MenuColors.css");
        scene2.getStylesheets().add("MenuColors.css");
        scene1.getStylesheets().add("MenuColors.css");
        stage.setScene(scene1);
        stage.show();


    }

}