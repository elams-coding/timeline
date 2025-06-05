module timeline {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.logging;
	requires javafx.base;
	requires com.fasterxml.jackson.databind;
	requires com.fasterxml.jackson.core;

    opens com.sae201.timeline to javafx.fxml;

    exports com.sae201.timeline;

    opens com.sae201.timeline.controller to javafx.fxml;

    exports com.sae201.timeline.controller;
    
    opens com.sae201.timeline.pojo to com.fasterxml.jackson.databind;
    
    exports com.sae201.timeline.pojo;
}