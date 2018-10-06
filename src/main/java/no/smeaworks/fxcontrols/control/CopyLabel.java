package no.smeaworks.fxcontrols.control;

import javafx.scene.control.Skin;
import javafx.scene.control.TextField;

/**
 * @author sverre
 */
public class CopyLabel extends TextField {

    public CopyLabel(String label) {
        super(label);

        getStyleClass().add("copy-label");
    }

    @Override
    protected Skin<?> createDefaultSkin() {
        return new CopyLabelSkin(this);
    }

    @Override
    public String getUserAgentStylesheet() {
        return getClass().getResource("copy-label.css").toExternalForm();
    }

}
