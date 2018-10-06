package no.smeaworks.fxcontrols.control;

import javafx.scene.control.Label;
import javafx.scene.control.Skin;

/**
 * A Clipboard Label control.
 *
 * @author sverre
 */
public class ClipboardLabel extends Label {

    public ClipboardLabel(String label) {
        super(label);
    }

    @Override
    protected Skin<?> createDefaultSkin() {
        return new ClipboardLabelSkin(this);
    }

    @Override
    public String getUserAgentStylesheet() {
        return getClass().getResource("clipboard-label.css").toExternalForm();
    }
}
