package converter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * UI controller for event and initializing components.
 * @author Pichaaun Popukdeee
 */


public class ConverterController {
    @FXML
    TextField textField1;
    @FXML
    TextField textField2;
    @FXML
    private ComboBox<Length> comboBox1;
    @FXML
    private ComboBox<Length> comboBox2;


    /**
     * Convert a distance from one unit to another.
     */
    @FXML
    public void handleConvert(ActionEvent event) {
        Length unit1 = comboBox1.getValue();
        Length unit2 = comboBox2.getValue();
        if (unit1 == null || unit2 == null) {
            invalid(textField2);
            invalid(textField1);
        }

            try {
                if (event.getSource()==textField1) {
                    String text = textField1.getText().trim();
                    double value = Double.parseDouble(text) * unit1.getValue() / unit2.getValue();
                    textField2.setText(value + "");
                } else {
                    String text = textField2.getText().trim();
                    double value = Double.parseDouble(text) *unit2.getValue() / unit1.getValue();
                    textField1.setText(value + "");
                }
                textField1.setStyle("-fx-border-color: none");
                textField2.setStyle("-fx-border-color: none");
        } catch (Exception e) {
                invalid(textField1);
                invalid(textField2);
            }

    }

    @FXML
    public void handleClear(ActionEvent event) {
        textField1.setStyle("-fx-border-color: none");
        textField2.setStyle("-fx-border-color: none");
        textField2.setText("");
        textField1.setText("");
    }


    /**
     * When there are an error textFields will be red.
     */
    @FXML
    public void invalid (TextField textField) {
            textField.setStyle(" -fx-border-color: darkred");
    }

    /**
     * JavaFX calls the initialize() method of your controller when
     * it creates the UI form, after the components have been created
     * and @FXML annotated attributes have been set.
     *
     * This is a hook to initialize anything your controller or UI needs.
     */
    @FXML
    public void initialize() {
        System.out.println("Running initialize");
        if (comboBox1 != null) {
            comboBox1.getItems().addAll( Length.values());
            comboBox1.getSelectionModel().select(0);
        }
        if (comboBox2 != null) {
            comboBox2.getItems().addAll( Length.values());
            comboBox2.getSelectionModel().select(1);
        }
    }


}
