/** FXControls */
module no.smeaworks.fxcontrols {

    /* JavaFX modules */
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.graphics;
    requires javafx.media;

    exports no.smeaworks.fxcontrols to javafx.graphics, javafx.fxml;

    opens no.smeaworks.fxcontrols to javafx.graphics, javafx.fxml;

}
