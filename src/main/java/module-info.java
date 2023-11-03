module com.example.javafx_tlotr {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.javafx_tlotr to javafx.fxml;
    exports com.example.javafx_tlotr;
    exports com.example.javafx_tlotr.model;
    opens com.example.javafx_tlotr.model to javafx.fxml;
    exports com.example.javafx_tlotr.model.heroes;
    opens com.example.javafx_tlotr.model.heroes to javafx.fxml;
    exports com.example.javafx_tlotr.model.beasts;
    opens com.example.javafx_tlotr.model.beasts to javafx.fxml;
    exports com.example.javafx_tlotr.view;
    opens com.example.javafx_tlotr.view to javafx.fxml;
    exports com.example.javafx_tlotr.model.beasts.beastsTypes;
    opens com.example.javafx_tlotr.model.beasts.beastsTypes to javafx.fxml;
    exports com.example.javafx_tlotr.model.heroes.heroesTypes;
    opens com.example.javafx_tlotr.model.heroes.heroesTypes to javafx.fxml;
}