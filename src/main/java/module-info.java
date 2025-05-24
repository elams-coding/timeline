module timeline {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.logging;

    opens com.sae201.timeline to javafx.fxml;
    exports com.sae201.timeline;

    opens com.sae201.timeline.controller to javafx.fxml;
    exports com.sae201.timeline.controller;
}