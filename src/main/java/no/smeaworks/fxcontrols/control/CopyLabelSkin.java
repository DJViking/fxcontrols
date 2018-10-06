package no.smeaworks.fxcontrols.control;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.skin.TextFieldSkin;
import javafx.scene.text.Text;

/**
 * @author sverre
 */
class CopyLabelSkin extends TextFieldSkin {

    CopyLabelSkin(CopyLabel labeled) {
        super(labeled);

        getSkinnable().setPadding(Insets.EMPTY);
        getSkinnable().setFocusTraversable(false);
        getSkinnable().setEditable(false);

        final double width = calculateTextWidth();
        getSkinnable().setPrefWidth(width);
        getSkinnable().setMaxWidth(width);
    }

    /**
     * Calculate text height.
     * <p>
     * In lack of public FontMetrics API in JavaFX.
     *
     * @return the text layout bounds width
     */
    private double calculateTextWidth() {
        final Text text = new Text(getSkinnable().getText());
        final Scene scene = new Scene(new Group(text));
        scene.getStylesheets().addAll(getSkinnable().getScene().getStylesheets());
        text.applyCss();
        final double widthtVal = text.getLayoutBounds().getWidth();
        return widthtVal;
    }

}
