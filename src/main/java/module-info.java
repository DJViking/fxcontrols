/**
 * FXControls
 */
module no.smeaworks.fxcontrols {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.graphics;
    requires javafx.media;

    /* Named modules */
    requires jfxtras.controls;
    requires com.jfoenix;

    /* Automatic modules */
    requires controlsfx;

    requires org.apache.logging.log4j;

    exports no.smeaworks.fxcontrols to javafx.graphics, javafx.fxml;

    opens no.smeaworks.fxcontrols to javafx.graphics, javafx.fxml;

}
