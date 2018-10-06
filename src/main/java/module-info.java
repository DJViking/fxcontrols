/** FXControls */
module no.smeaworks.fxcontrols {

    /* JavaFX modules */
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.graphics;
    requires javafx.media;

    /* Log4j modules */
    requires org.apache.logging.log4j;

    exports no.smeaworks.fxcontrols to javafx.graphics, javafx.fxml;

    opens no.smeaworks.fxcontrols to javafx.graphics, javafx.fxml;

}
