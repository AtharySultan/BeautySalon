

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.LightBase;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDate;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.Serializable;
import java.util.List;
import org.hibernate.*;


public class HelloApplication extends Application {

ObservableList<String> obCustomerNames = FXCollections.observableArrayList();
ObservableList<String> obCustomerMobiles = FXCollections.observableArrayList();


    ListView<String> stylistsListView;
    ComboBox<String> servicesComboBox;
    Scene beautySalonScene;
    Scene invoiceScene;

    public void start(Stage primaryStage) {


        
        ListView lvCustmer = new ListView(obCustomerNames);
        VBox VBlvName = new VBox(10);

        VBlvName.getChildren().addAll( new Label("Custmer Name: "), new ScrollPane(lvCustmer));
        lvCustmer.setItems(obCustomerNames);

        
        ListView lvNumber = new ListView(obCustomerMobiles);
        VBox VBlvMobile = new VBox(10);
        VBlvMobile.getChildren().addAll(new Label("Custmer Mobile Number: "), new ScrollPane(lvNumber));
        lvNumber.setItems(obCustomerMobiles);

        ObservableList<String> obServices = FXCollections.observableArrayList();
        ListView lvService = new ListView(obServices);

        VBox  VBlvService = new VBox(10);
        VBlvService.getChildren().addAll(new Label("Service: "), new ScrollPane(lvService));
        lvService.setItems(obServices);

        ObservableList<String> obStylists = FXCollections.observableArrayList();
        ListView lvStyle = new ListView(obStylists);
        VBox VBlvStayle = new VBox(10);

        VBlvStayle.getChildren().addAll(new Label("Stylist: "), new ScrollPane(lvStyle));
        lvStyle.setItems(obStylists);

        ObservableList<String> obDateTime = FXCollections.observableArrayList();
        ListView Date = new ListView(obDateTime);
        VBox VBlvDate = new VBox(10);
        VBlvDate.getChildren().addAll(new Label("Data and time: "), new ScrollPane(Date));
        Date.setItems(obDateTime);



        Label lblmsg = new Label("");
        lblmsg.setTextFill(Color.DARKRED);
        lblmsg.setFont(new Font(20));
        lblmsg.setAlignment(Pos.CENTER);
        lblmsg.setTranslateY(-50);


        //root
        BorderPane borderPane = new BorderPane();

        Image img=new Image("https://i.pinimg.com/564x/e7/c6/15/e7c6153a089d426c8322e7348bc800b6.jpg");
        BackgroundSize backgroundSize = new BackgroundSize(1.0, 1.0, true, true, false, false);
        BackgroundImage backgroundImage = new BackgroundImage(img,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, backgroundSize) ;
        Background background = new Background(backgroundImage);
        borderPane.setBackground(background);


        //abrar
        HBox hBox1 = new HBox(10);
        hBox1.setPrefWidth(1100);
        hBox1.setPrefHeight(30);
        HBox hBox2 = new HBox(10);
        VBox vBox1 = new VBox(10);
        VBox empty = new VBox(20);

        //top
        Label customerNamelabel = new Label("Customer Name: ");
        TextField customerNameTxt = new TextField();
        customerNamelabel.setTranslateX(-100);

        Label customerMobile = new Label("Customer Mobile number: ");
        TextField customerMobileTxt = new TextField();
        customerMobile.setTranslateX(-78);
        customerMobileTxt.setTranslateX(-25);



        hBox1.getChildren().addAll(customerNamelabel,customerNameTxt);
        hBox1.setAlignment(Pos.CENTER);
        hBox2.getChildren().addAll(customerMobile,customerMobileTxt);
        hBox2.setAlignment(Pos.CENTER);
        vBox1.getChildren().addAll(empty,hBox1,hBox2);
        vBox1.setAlignment(Pos.CENTER);



        //center
        Label servicesLabel = new Label("Select a service:");
        servicesLabel.setTranslateX(25);

        servicesComboBox = new ComboBox<>();
        servicesComboBox.setTranslateX(135);

        servicesComboBox.getItems().addAll("Hair-cutting", "Hair-Styling", "Hair-Coloring",
                "Makeup", "Manicures", "Pedicures", "Facials and skin care treatments");
        servicesComboBox.setOnAction(e -> updateStylistsListView());

        Label stylistsLabel = new Label("Select a stylist:");
        stylistsLabel.setTranslateX(140);

        stylistsListView = new ListView<>();
        stylistsListView.setPrefWidth(100);
        stylistsListView.setPrefHeight(100);
        stylistsListView.setTranslateY(20);
        stylistsListView.setTranslateX(140);


        HBox hBox3 = new HBox(10);
        hBox3.getChildren().addAll(servicesLabel, servicesComboBox, stylistsLabel, stylistsListView);
        hBox3.setAlignment(Pos.CENTER);

        HBox hbox4 = new HBox(10);
        Label date = new Label("Date: ");
        date.setTranslateX(-120);

        DatePicker datePicker = new DatePicker();
        datePicker.setTranslateX(46);

        hbox4.getChildren().addAll(date,datePicker);
        hbox4.setAlignment(Pos.CENTER);


        HBox hbox5 = new HBox(10);
        Label time = new Label("Time: ");
        time.setTranslateX(-175);

        ComboBox<String> timeCombo = new ComboBox<>();
        timeCombo.setTranslateX(-10);

        timeCombo.getItems().addAll("2:00","3:00","4:00","5:00","6:00");

        hbox5.setAlignment(Pos.CENTER);
        hbox5.getChildren().addAll(time,timeCombo);

        HBox hbox6 = new HBox(20);
        Button bookService = new Button("Book service");
        bookService.setPrefWidth(80);
        bookService.setPrefHeight(30);
        bookService.setTranslateY(30);

        Button clear = new Button("clear");
        clear.setPrefWidth(80);
        clear.setPrefHeight(30);
        clear.setTranslateY(30);

        Button delete = new Button("delete");
        delete.setPrefWidth(80);
        delete.setPrefHeight(30);
        delete.setTranslateY(30);


        bookService.setOnAction(event -> {
        // Get the text from the text fields
        String name = customerNameTxt.getText();
        String mobileNumber = customerMobileTxt.getText();

        // Add the customer name and mobile number to the ObservableLists
            obCustomerNames.add(name);
        obCustomerMobiles.add(mobileNumber);

        // Get the selected item from the ComboBox
             String selectedItem = servicesComboBox.getSelectionModel().getSelectedItem();

            // Add the selected item to the ObservableList
            obServices.add(selectedItem);

            ObservableList<String> stylistItems = stylistsListView.getSelectionModel().getSelectedItems();
            // Add the selected items to the ObservableList
            obStylists.addAll(stylistItems);


            // Get the selected date from the DatePicker
            LocalDate selectedDate = datePicker.getValue();

            // Get the selected time from the ComboBox
            String selectedTime = timeCombo.getSelectionModel().getSelectedItem();

            // Combine the date and time into a single string
            String dateTime = selectedDate.toString() + " at " + selectedTime;

            // Add the combined string to the ObservableList
            obDateTime.add(dateTime);

            });

        clear.setOnAction(event -> {

            // Clear the text fields
            customerNameTxt.clear();
            customerMobileTxt.clear();
            servicesComboBox.setValue(null);
            stylistsListView.getItems().clear();
            datePicker.setValue(null);
            timeCombo.setValue(null);

        });

        //task 2.2 delete
        delete.setOnAction(event -> {
            int selectedIndex = lvCustmer.getSelectionModel().getSelectedIndex();
            
            Customer customer = new Customer(); 
            customer.setCustomerName(obCustomerNames.get(selectedIndex));
            customer.setCustomerPhoneNumber(Integer.valueOf(obCustomerMobiles.get(selectedIndex)));
            customer.setService(obServices.get(selectedIndex));
            customer.setStylist(obStylists.get(selectedIndex));
            customer.setTimeDate(obDateTime.get(selectedIndex));
            
            
             
//            if (selectedIndex >= 0) {
                obCustomerNames.remove(selectedIndex);
                obCustomerMobiles.remove(selectedIndex);
                obServices.remove(selectedIndex);
                obStylists.remove(selectedIndex);
                obDateTime.remove(selectedIndex);

//                String deletedCustomerName = obCustomerNames.get(selectedIndex);
//                lvCustmer.getSelectionModel().clearSelection();
                lblmsg.setText("Customer " + customer.getCustomerName() + " was Deleted");
                
                Session session = HibernateUtil2.getSessionFactory().openSession();
                session.beginTransaction();
                session.delete(customer);
            
                session.getTransaction().commit();
                session.close();
//            }

//              Session session2 = HibernateUtil2.getSessionFactory().openSession();
//              Transaction tx2 = null;
//              tx2 = session2.beginTransaction();
//              String hqlDel = "delete from customer c where c.id="+obCustomerMobiles.get(selectedIndex)+"";
//              Query queryDel = session2.createQuery(hqlDel);
//              int resultD = queryDel.executeUpdate();
//              System.out.println("Rows affected: " + resultD);
//              tx2.commit();
//              session2.close();


        });

        Button ExportTofile = new Button("Exsport to file");
        ExportTofile.setTranslateX(-920);
        ExportTofile.setTranslateY(-20);

        HBox hbox7 = new HBox(10);
        hbox7.getChildren().add(ExportTofile);
        hbox7.setAlignment(Pos.BOTTOM_LEFT);

        ExportTofile.setOnAction(e -> {

            File file = new File("Items.text");

            try {
                PrintWriter output = new PrintWriter(file);
                for (int i = 0; i <obCustomerNames.size(); i++) {
                    output.print(obCustomerNames.get(i) + " "
                            + obCustomerMobiles.get(i) + " "
                            + obServices.get(i) + " " + obStylists.get(i)+ " "
                            + obDateTime.get(i));
                    output.println();}
                output.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        });



        hbox6.setAlignment(Pos.CENTER);
        hbox6.getChildren().addAll(bookService,clear,delete);


        VBox vBox2 = new VBox(20);
        vBox2.setAlignment(Pos.CENTER);
        vBox2.getChildren().addAll(hBox3,hbox4,hbox5,hbox6,lblmsg);










        //jumana
        Button nextSceneButton=new Button("Next Scene");
        nextSceneButton.setTranslateY(-25);
        nextSceneButton.setTranslateX(-20);
        nextSceneButton.setOnAction(e -> primaryStage.setScene(invoiceScene));



        HBox HBforListes = new HBox(10);
        HBforListes.setAlignment(Pos.CENTER);
        HBforListes.setMaxWidth(600);
        HBforListes.setMinWidth(900);
        HBforListes.setMaxHeight(250);
        HBforListes.setMinHeight(250);
        HBforListes.getChildren().addAll(VBlvName,VBlvMobile,VBlvService,VBlvStayle,VBlvDate);





        HBox nextScene =new HBox(10);
        nextScene.setAlignment(Pos.BOTTOM_RIGHT);
        nextScene.getChildren().addAll(hbox7,nextSceneButton);

        VBox vbox3 = new VBox(10);
        vbox3.getChildren().addAll(HBforListes,nextScene);
        vbox3.setAlignment(Pos.CENTER);




        borderPane.setTop(vBox1);
        borderPane.setCenter(vBox2);
        borderPane.setBottom(vbox3);


        beautySalonScene = new Scene(borderPane,1100,700);


        bookService.setOnAction(E -> {
            
            String st = null;
            String selectedStylist = stylistsListView.getSelectionModel().getSelectedItem();
            String selectedDate = datePicker.getValue().toString();
            String selectedTime = timeCombo.getValue();
            if(lvCustmer.getSelectionModel().getSelectedItem()  != null) {
                st = lvCustmer.getSelectionModel().getSelectedItem().toString();
               

            }
            //If any of the TextFields are empty print lblmsg
            if (customerNameTxt.getText().isEmpty() || customerMobileTxt.getText().isEmpty()) {
                lblmsg.setText("Enter Customer name and Mobile phone");
            } else {
                boolean isnumber = true;
                try {
                    Long x = Long.parseLong(customerMobileTxt.getText()); //convert string to int for cheacing
                    isnumber = true;
                } catch (NumberFormatException ex) {
                    isnumber = false;
                }
                if (!isnumber) { // if input is string
                    lblmsg.setText("Mobile number must be digit only");
                } else if (customerMobileTxt.getText().length() != 10) { // length of mobile less than 10 or more
                    lblmsg.setText("The length of mobile number must be 10 digits");
                } else if (obStylists.contains(selectedStylist) && obDateTime.contains(selectedDate + " at " + selectedTime)) {
                    lblmsg.setText("Stylist busy at this time..");
                } else {
                    //To book a new service for a customer
                    obCustomerNames.add(customerNameTxt.getText());
                    obCustomerMobiles.add(customerMobileTxt.getText());
                    obServices.add(servicesComboBox.getValue());
                    obStylists.add(stylistsListView.getSelectionModel().getSelectedItem());
                    obDateTime.add(datePicker.getValue().toString() + " at " + timeCombo.getValue());
String services=servicesComboBox.getValue();
           String Name=customerNameTxt.getText();
           String stylists=stylistsListView.getSelectionModel().getSelectedItem();
           String dateP=datePicker.getValue().toString();

           Customer cus1=new Customer(Name,Integer.parseInt(customerMobileTxt.getText()),services,stylists,dateP);
           
           Session session = HibernateUtil2.getSessionFactory().openSession();
           session = HibernateUtil2.getSessionFactory().openSession();
           Transaction tx = session.beginTransaction();
           int sId = (Integer) session.save(cus1);
           tx.commit();
           session.close();
                }
                
           
            } 
           
          

        });


        //athary

        BorderPane Border=new BorderPane();
        Border.setPadding(new Insets(10));

        Image img2=new Image("https://i.pinimg.com/564x/e7/c6/15/e7c6153a089d426c8322e7348bc800b6.jpg");
        BackgroundSize backgroundSize2=new BackgroundSize(1.0, 1.0, true, true, false, false);
        BackgroundImage backgroundImage2 = new BackgroundImage(img2,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, backgroundSize2) ;
        Background background2 = new Background(backgroundImage2);

        Border.setBackground(background2);

        VBox V=new VBox(20);
        TextField tF = new TextField();

        Label lab=new Label("Enter customer mobile number ",tF);
        lab.setContentDisplay(ContentDisplay.RIGHT);

        Label msg = new Label();
        msg.setTextFill(Color.DARKRED);

        msg.setFont(new Font(20.0));


        HBox h=new HBox(50);
        Button search=new Button("Search");
        h.getChildren().addAll(lab,search);
        h.setAlignment(Pos.CENTER);

        Rectangle r= new Rectangle(1000,400,800,300);
        r.setStroke(Color.BLACK);
        r.setFill(Color.TRANSPARENT);
        Label lab2=new Label("Customer Invoice");
        lab2.setContentDisplay(ContentDisplay.BOTTOM);

        Pane paneForInvoiceData = new Pane();

        paneForInvoiceData.setTranslateX(100);

        Label Invodata = new Label("");
        Invodata.setTranslateY(-350);
        Invodata.setTranslateX(50);
        Font font = Font.font("System", FontWeight.BOLD, 20);
        Invodata.setFont(font);
        
         Session session = HibernateUtil2.getSessionFactory().openSession();
                List<Customer> List = null;
                String qStr = "from Customer";
                Query query = session.createQuery(qStr);
                List = query.list();
                session.close();
                for(Customer customer: List)
                {
                obCustomerNames.add(customer.getCustomerName());
                obCustomerMobiles.add(String.valueOf(customer.getCustomerPhoneNumber()));
                obServices.add(customer.getService());
                obStylists.add(customer.getStylist());
                obDateTime.add(customer.getTimeDate());
                }

        paneForInvoiceData.getChildren().add(Invodata);
        search.setOnAction(e -> {
            //checking if the text field is empty
            if (tF.getText().equals("")) {
                msg.setText("Enter the customer mobile number to print invoice");
            } else {
                boolean isnumber = true;
                try {
                    Long x = Long.parseLong(tF.getText());
                    isnumber = true;
                } catch (NumberFormatException ex) {
                    isnumber = false;
                }
                if (!isnumber) {
                    msg.setText("Mobile number must be digit only");
                } else if (tF.getText().length() != 10) {
                    msg.setText("The length of mobile number must be 10 digits");
                } else if (obCustomerMobiles.isEmpty()) {
                    msg.setText("No customers in the list");
                } else {
                    String phone = tF.getText();
                    int selectedIndex = obCustomerMobiles.indexOf(phone);
                    String name = obCustomerNames.get(selectedIndex);

                    if (!obCustomerMobiles.contains(phone)) {
                        msg.setText("The customer not found.");
                    } else {
                        String invoic = "\n\n\n\nCustomer Name: " + name;
                        invoic += "\nService\t\t\t Stylist\t\t Date and time\n";

                        double price = 0;
                        for (int i = 0; i < obCustomerMobiles.size(); i++) {

                            if (obCustomerMobiles.get(i).equals(phone)) {

                                invoic += obServices.get(i) + "\t\t ";
                                invoic += obStylists.get(i) + "\t\t ";
                                invoic += obDateTime.get(i)+ "\n";
                                switch (obServices.get(i)) {
                                    case "Makeup":         // serves
                                    case "Hair-Coloring":
                                        price+=500;
                                        break;
                                    case "Hair-Styling":
                                        price+=150;
                                        break;
                                    case "Hair-cutting":
                                        price+=80;
                                        break;
                                    case "Manicures":
                                        price+=100;
                                        break;
                                    case "Pedicures":
                                        price+=150;
                                        break;
                                    case "Facials and skin care treatments":
                                        price+=300;
                                        break;
                                }

                            }
                        }
                        invoic +="Price:"+price;
                        Invodata.setText(invoic);
                    }
                }
            }

        });





        V.getChildren().addAll(h,msg,lab2,r);
        V.setAlignment(Pos.CENTER);
        Border.setTop(V);
        Border.setCenter(paneForInvoiceData);




        Button backToBeautySalonButton = new Button("Back");
        backToBeautySalonButton.setOnAction(e -> primaryStage.setScene(beautySalonScene));
        HBox invoiceButtonBox = new HBox(backToBeautySalonButton);
        invoiceButtonBox.setAlignment(Pos.BOTTOM_RIGHT);
        invoiceButtonBox.setPadding(new Insets(10));

        Border.setBottom(invoiceButtonBox);

        invoiceScene = new Scene(Border, 1100, 700);

        primaryStage.setTitle("mini project");

        primaryStage.setScene(beautySalonScene);
        primaryStage.show();
    }

    private void updateStylistsListView() {
        String selectedService = servicesComboBox.getValue();
        if (selectedService == null) {
            stylistsListView.setItems(FXCollections.emptyObservableList());
        } else {
            switch (selectedService) {
                case "Hair-cutting":
                case "Hair-Styling":
                case "Hair-Coloring":
                    stylistsListView.setItems(FXCollections.observableArrayList("Huda", "Mona", "Emmy"));
                    break;
                case "Makeup":
                    stylistsListView.setItems(FXCollections.observableArrayList("Hind", "Lona"));
                    break;
                case "Manicures":
                    stylistsListView.setItems(FXCollections.observableArrayList("Majdooleen"));
                    break;
                case "Pedicures":
                    stylistsListView.setItems(FXCollections.observableArrayList("Majdooleen"));
                    break;

                case "Facials and skin care treatments":
                    stylistsListView.setItems(FXCollections.observableArrayList("Sonya"));
                    break;

            }
        }
    }

                    public static void main(String[] args) {
        launch();
    }
}