package com.example.TripPrice;

import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import javafx.util.Duration;

public class Controller {

    @FXML
    private Label calculatedLabel;

    @FXML
    private TextField fuelConsumptionTextField;

    @FXML
    private TextField distanceTextField;

    @FXML
    private TextField fuelPriceTextField;

    @FXML
    private Button calculateButton;

    @FXML
    private CheckBox returnTripCheckBox;

    @FXML
    protected void onButtonClick() {
        TripPrice obj = new TripPrice();
        String fuelConsumptionText = fuelConsumptionTextField.getText();
        String distanceText = distanceTextField.getText();
        String fuelPriceText = fuelPriceTextField.getText();

        if (fuelConsumptionText.isEmpty() || distanceText.isEmpty() || fuelPriceText.isEmpty()) {
            calculatedLabel.setText("Vyplň všechny tři pole prosím.");
        } else {
            try {
                if (returnTripCheckBox.isSelected()) {
                    calculatedLabel.setText(String.format("%.2f", obj.calculatePriceWithReturn(Double.parseDouble(fuelConsumptionText),
                            Double.parseDouble(distanceText), Double.parseDouble(fuelPriceText))));
                } else {
                    calculatedLabel.setText(String.format("%.2f", obj.calculatePrice(Double.parseDouble(fuelConsumptionText),
                            Double.parseDouble(distanceText), Double.parseDouble(fuelPriceText))));
                }

            } catch (NumberFormatException e) {
                calculatedLabel.setText("Pouze čísla. (desetinná místa odděl tečkou)");

            }
        }
    }

    @FXML
    public void initialize() {
        // Inicializace tlačítka s animací
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(100), calculateButton);
        scaleTransition.setFromX(1);
        scaleTransition.setFromY(1);
        scaleTransition.setToX(0.9);
        scaleTransition.setToY(0.9);

        calculateButton.setOnMouseReleased(event -> {
            scaleTransition.setFromX(0.9);
            scaleTransition.setFromY(0.9);
            scaleTransition.setToX(1);
            scaleTransition.setToY(1);
            scaleTransition.play();
            onButtonClick();
        });
    }
}
