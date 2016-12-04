import java.awt.image.BufferedImage;

public interface Fractal {
    public boolean drawFractal(double xPos, double yPos, long magnification, int iterations);

    public void setSize(int width, int height);

    public BufferedImage getBufferedImage();

    public void cancel();

}