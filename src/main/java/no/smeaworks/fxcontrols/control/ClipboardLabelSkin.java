package no.smeaworks.fxcontrols.control;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Tooltip;
import javafx.scene.control.skin.LabeledSkinBase;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * ClipboardLabel Skin.
 *
 * @author sverre
 */
class ClipboardLabelSkin extends LabeledSkinBase<ClipboardLabel> {

    private final ClipboardLabelBehavior behavior;

    ClipboardLabelSkin(ClipboardLabel labeled) {
        super(labeled);

        consumeMouseEvents(false);

        behavior = new ClipboardLabelBehavior(labeled);

        final Tooltip tooltip = new Tooltip();
        tooltip.textProperty().bind(getSkinnable().textProperty());
        getSkinnable().setTooltip(tooltip);

        final Button clipboard = new Button();
        clipboard.setFocusTraversable(false);
        clipboard.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        clipboard.setPadding(Insets.EMPTY);
        clipboard.setTooltip(new Tooltip("Copy to Clipboard"));
        clipboard.setOnAction(behavior.copyToClipboard());

        // TODO if empty text, consider disable the clipboard button.

        final double imageHeight = calculateTextHeight();
        final String imageURL = getClass().getResource("clipboard-128x128.png").toExternalForm();
        final boolean preserveRatio = true;
        final boolean smooth = true;
        final Image image = new Image(imageURL, imageHeight, imageHeight, preserveRatio, smooth);
        final ImageView imageView = new ImageView(image);
        clipboard.setGraphic(imageView);

        getSkinnable().setGraphic(clipboard);
        getSkinnable().setGraphicTextGap(5);
        getSkinnable().setContentDisplay(ContentDisplay.RIGHT);
        getSkinnable().setAlignment(Pos.CENTER_LEFT);
        getSkinnable().setTextAlignment(TextAlignment.CENTER);
    }

    /**
     * Calculate text height.
     *
     * <p>
     * In lack of public FontMetrics API in JavaFX.
     *
     * @return the text layout bounds height
     */
    private double calculateTextHeight() {
        final Text text = new Text(getSkinnable().getText());
        final Scene scene = new Scene(new Group(text));
        scene.getStylesheets().addAll(getSkinnable().getScene().getStylesheets());
        text.applyCss();
        final double heightVal = text.getLayoutBounds().getHeight();
        return heightVal;
    }
}
