
import javax.swing.*;
import java.awt.*;

public class GradientColor extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        Color topColor = new Color(122, 74, 0);
        Color middleColor = new Color(255, 215, 122);
        Color bottomColor = new Color(255, 248, 231);

        int height = getHeight();
        int width = getWidth();

        float[] fractions = new float[]{0.0f, 0.5f, 1.0f};
        Color[] colors = new Color[]{topColor, middleColor, bottomColor};

        LinearGradientPaint gradient = new LinearGradientPaint(
                0, 0,
                0, height,
                fractions,
                colors
        );

        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, width, height);
    }
}
