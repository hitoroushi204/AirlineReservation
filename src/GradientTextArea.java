
import javax.swing.*;
import java.awt.*;

public class GradientTextArea extends JTextArea {

    public GradientTextArea() {
        super();
        initTransparency();
    }

    public GradientTextArea(String text) {
        super(text);
        initTransparency();
    }

    public GradientTextArea(int rows, int columns) {
        super(rows, columns);
        initTransparency();
    }

    private void initTransparency() {
        setOpaque(false);
        setBackground(new Color(0, 0, 0, 0));

        setForeground(new Color(40, 30, 15));
        setCaretColor(new Color(122, 74, 0));
        setFont(new Font("Arial", Font.PLAIN, 13));

        setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));

        setLineWrap(true);
        setWrapStyleWord(true);
    }
}
