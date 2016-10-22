import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageProcessor {
    public static void drawColorized(final Graphics g, final BufferedImage image, final int x, final int y, final Color color) {
        drawColorized(g, image, x, y, image.getWidth(), image.getHeight(), color);
    }

    public static void drawColorized(final Graphics graphics,
                                     final BufferedImage image,
                                     final int x,
                                     final int y,
                                     final int width,
                                     final int height,
                                     final Color color) {
        final BufferedImage dyed = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        final Graphics2D g = dyed.createGraphics();
        g.drawImage(image, 0, 0, width, height, null);
        g.setComposite(AlphaComposite.SrcAtop);
        g.setColor(color);
        g.fillRect(0, 0, width, height);
        g.dispose();
        graphics.drawImage(dyed, x, y, width, height, null);
    }
}
