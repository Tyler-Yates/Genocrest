import com.google.common.collect.ImmutableList;
import org.apache.commons.io.FilenameUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ResourceLoader {
    private static final Random RANDOM = new Random();

    private static final List<BufferedImage> shields = new ArrayList<>();
    private static final List<Color> shieldColors;
    private static final List<BufferedImage> emblems = new ArrayList<>();
    private static final List<Color> emblemColors;

    static {
        loadImages(shields, "shields");
        loadImages(emblems, "emblems");
        shieldColors = ImmutableList.of(Color.BLACK, Color.DARK_GRAY);
        emblemColors = ImmutableList.of(Color.RED, Color.BLUE, Color.GREEN);
    }

    private static void loadImages(final List<BufferedImage> images, final String folderName) {
        final URL resource = ResourceLoader.class.getClassLoader().getResource(folderName);
        if (resource == null) {
            System.err.println("Resource folder does not exist");
        } else {
            final File folder = new File(resource.getFile());
            final File[] files = folder.listFiles();
            if (files == null) {
                System.err.println("Resource folder does not exist");
                return;
            }
            for (final File file1 : files) {
                if (FilenameUtils.getExtension(file1.getName()).equals("png")) {
                    try {
                        images.add(ImageIO.read(file1));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static BufferedImage getRandomShield() {
        return getShieldImage(RANDOM.nextInt(shields.size()));
    }

    static Color getRandomShieldColor() {
        return getShieldColor(RANDOM.nextInt(shieldColors.size()));
    }

    static BufferedImage getRandomEmblem() {
        return getEmblemImage(RANDOM.nextInt(emblems.size()));
    }

    static Color getRandomEmblemColor() {
        return getEmblemColor(RANDOM.nextInt(emblemColors.size()));
    }

    private static BufferedImage getShieldImage(final int index) {
        return getImage(shields, index);
    }

    private static BufferedImage getEmblemImage(final int index) {
        return getImage(emblems, index);
    }

    private static BufferedImage getImage(List<BufferedImage> images, int index) {
        if (index >= 0 && index < images.size()) {
            return images.get(index);
        }
        return new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
    }

    private static Color getShieldColor(int index) {
        return getColor(shieldColors, index);
    }

    private static Color getEmblemColor(int index) {
        return getColor(emblemColors, index);
    }

    private static Color getColor(final List<Color> colors, final int index) {
        if (index >= 0 && index < colors.size()) {
            return colors.get(index);
        }
        return Color.BLACK;
    }
}
