module com.example.TripPrice {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.TripPrice to javafx.fxml;
    exports com.example.TripPrice;
}