module org.example.fourthassignmenthtmlparser {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jsoup;


    opens org.example.fourthassignmenthtmlparser to javafx.fxml;
    exports org.example.fourthassignmenthtmlparser;
}