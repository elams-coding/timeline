package com.sae201.timeline.util;

import javafx.scene.Node;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.paint.Color;

public abstract class StyleUtilitaire {
    public static void styleBouton(Node node) {
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.rgb(0, 0, 0, 0.3));
        dropShadow.setRadius(10);
        dropShadow.setOffsetX(0);
        dropShadow.setOffsetY(4);

        InnerShadow innerShadow = new InnerShadow();
        innerShadow.setColor(Color.rgb(255, 255, 255, 0.25));
        innerShadow.setRadius(10);
        innerShadow.setOffsetX(0);
        innerShadow.setOffsetY(4);

        dropShadow.setInput(innerShadow);
        node.setEffect(dropShadow);
    }
    
    public abstract void tailleBouton();
}
