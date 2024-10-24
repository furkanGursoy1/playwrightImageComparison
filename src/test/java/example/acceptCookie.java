package example;

import com.microsoft.playwright.Page;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class acceptCookie {
    public static void acceptCookies(Page page) {
        try {
            page.evaluate("() => {" +
                    "const acceptButton = document.querySelector('efilli-layout-dynamic').shadowRoot.querySelector('div[data-name=\"Accept Button\"]');" +
                    "if (acceptButton) {" +
                    "    acceptButton.click();" +
                    "    console.log('Çerez kabul etme pop-upı kapatıldı');" +
                    "} else {" +
                    "    console.log('Kabul butonu bulunamadı');" +
                    "}" +
                    "}");
        } catch (Exception e) {
            System.out.println("Hata: " + e.getMessage());
        }
    }

    public void compareImages(String imgPath1, String imgPath2) throws IOException {
    BufferedImage img1 = ImageIO.read(new File(imgPath1));
    BufferedImage img2 = ImageIO.read(new File(imgPath2));
    int width = img1.getWidth();
    int height = img1.getHeight();
    BufferedImage diff = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

    int diffPixelCount = 0;
    for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
            int rgb1 = img1.getRGB(x, y);
            int rgb2 = img2.getRGB(x, y);
            if (rgb1 != rgb2) {
                diff.setRGB(x, y, 0xFFFF0000);
                diffPixelCount++;
            } else {
                diff.setRGB(x, y, rgb1);
            }
        }
    }

    File diffFile = new File("diff.png");
    if (ImageIO.write(diff, "png", diffFile)) {
        System.out.println("Diff image saved successfully: " + diffFile.getAbsolutePath());
    } else {
        System.out.println("Failed to save diff image.");
    }

    if (diffPixelCount > 0) {
        attachScreenshot("Image Difference", "diff.png");
        // throw new AssertionError("Farklı piksel sayısı: " + diffPixelCount);
    }
    System.out.println("Farklı piksel sayısı: " + diffPixelCount);
}

public byte[] attachScreenshot(String name, String path) throws IOException {
    return Files.readAllBytes(Paths.get(path));
}
}

