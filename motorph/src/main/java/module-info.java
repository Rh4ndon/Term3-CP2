module motorph_gui {
    requires javafx.controls;
    requires javafx.fxml;

    opens motorph_gui to javafx.fxml;
    exports motorph_gui;
}
