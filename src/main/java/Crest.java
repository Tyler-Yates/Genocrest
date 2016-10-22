import java.awt.*;
import java.awt.image.BufferedImage;

public class Crest {
    private static final int SHIELD_SIZE = 350;
    private static final int EMBLEM_SIZE = SHIELD_SIZE * 2 / 3;

    private final BufferedImage shield;
    private final Color shieldColor;
    private final BufferedImage emblem;
    private final Color emblemColor;

    public Crest() {
        shield = ResourceLoader.getRandomShield();
        shieldColor = ResourceLoader.getRandomShieldColor();
        emblem = ResourceLoader.getRandomEmblem();
        emblemColor = ResourceLoader.getRandomEmblemColor();
    }

    public void draw(final Graphics g, final int x, final int y) {
        ImageProcessor.drawColorized(g, shield, x, y, SHIELD_SIZE, SHIELD_SIZE, shieldColor);
        ImageProcessor.drawColorized(g, emblem, x + SHIELD_SIZE / 2 - EMBLEM_SIZE / 2, y + SHIELD_SIZE / 2 - EMBLEM_SIZE / 2, EMBLEM_SIZE, EMBLEM_SIZE, emblemColor);
    }
}
