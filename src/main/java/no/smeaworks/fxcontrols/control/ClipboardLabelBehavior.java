package no.smeaworks.fxcontrols.control;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

/**
 * ClipboardLabel behavior.
 *
 * @author sverre
 */
class ClipboardLabelBehavior {

    private final ClipboardLabel clipboardLabel;

    private final StringProperty text = new SimpleStringProperty(this, "text", "");

    ClipboardLabelBehavior(ClipboardLabel clipboardLabel) {
        this.clipboardLabel = clipboardLabel;
        text.bind(clipboardLabel.textProperty());
    }

    EventHandler<ActionEvent> copyToClipboard() {
        return event -> {
            final ClipboardContent content = new ClipboardContent();
            content.putString(text.get());
            Clipboard.getSystemClipboard().setContent(content);
        };
    }

    final String getText() {
        return text.getValue() == null ? "" : text.getValue();
    }

    final void setText(String value) {
        textProperty().setValue(value);
    }

    final StringProperty textProperty() {
        return text;
    }
}
