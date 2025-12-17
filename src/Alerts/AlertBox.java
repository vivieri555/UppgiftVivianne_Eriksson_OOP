package Alerts;

import MemberPackage.Member;
import MemberPackage.MembershipService;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {
    Button closeButton = new Button("Ok");
    MembershipService membershipService;
    Label labelName = new Label();

    public AlertBox(MembershipService membershipService) {this.membershipService = membershipService;}

    public void display (String title, String message) {
        Stage stage2 = new Stage();
        stage2.setTitle(title);
        stage2.initModality(Modality.APPLICATION_MODAL);
        stage2.setMinWidth(250);
        Label label = new Label(message);
        closeButton.setOnAction(e -> { stage2.close(); } );

        VBox layout = new VBox();
        layout.setPadding(new Insets(10,10, 10,10));
        layout.setSpacing(10);
        layout.setStyle("-fx-background-color: #FFB6C1;");
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        stage2.setScene(scene);
        stage2.showAndWait();
    }
    public void change (String title, String message, Member member, TextField idInput,
                        TextField nameInput, TextField changeStatus, TextField changeHistory, TableView <Member> table) {
        Stage stage3 = new Stage();
        stage3.setTitle(title);
        stage3.initModality(Modality.APPLICATION_MODAL);
        stage3.setMinWidth(250);
        Label label2 = new Label(message);
        labelName.setText("Ändra namn");

        idInput.setText(String.valueOf(member.getId()));
        nameInput.setText(member.getName());
        changeStatus.setText(member.getStatus());
        changeHistory.setText(member.getHistory());

        closeButton.setOnAction(e -> {
            membershipService.change(member, idInput, nameInput, changeStatus, changeHistory);
            table.refresh();
            stage3.close(); } );
        VBox layout2 = new VBox();
        layout2.setPadding(new Insets(10,10, 10,10));
        layout2.setSpacing(10);
        layout2.setStyle("-fx-background-color: #FFB6C1;");
        layout2.getChildren().addAll(label2, idInput, nameInput, changeStatus, changeHistory, closeButton);
        layout2.setAlignment(Pos.CENTER);

        Scene scene2 = new Scene(layout2);
        stage3.setScene(scene2);
        stage3.showAndWait();
    }
}
