import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GradientButton extends JButton {
    
    private Color startColor = new Color(122, 74, 0);
    private Color endColor = new Color(255, 215, 122);
    private Color pressedStartColor = new Color(100, 60, 0);
    private Color pressedEndColor = new Color(235, 195, 102);
    private boolean isPressed = false;
    private int cornerRadius = 10;
    
    public GradientButton(String text) {
        super(text);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setOpaque(false);
        setFont(new Font("Arial", Font.BOLD, 14));
        setForeground(Color.WHITE);
        
        // Add press effect
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                isPressed = true;
                repaint();
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                isPressed = false;
                repaint();
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                isPressed = false;
                repaint();
            }
        });
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        int width = getWidth();
        int height = getHeight();
        
        // Choose colors based on pressed state
        Color currentStart = isPressed ? pressedStartColor : startColor;
        Color currentEnd = isPressed ? pressedEndColor : endColor;
        
        // Create gradient
        GradientPaint gradient = new GradientPaint(0, 0, currentStart, 0, height, currentEnd);
        g2d.setPaint(gradient);
        
        // Fill button
        g2d.fillRoundRect(0, 0, width, height, cornerRadius, cornerRadius);
        
        // Add shadow effect when pressed
        if (!isPressed) {
            g2d.setColor(new Color(0, 0, 0, 50));
            g2d.fillRoundRect(2, 2, width, height, cornerRadius, cornerRadius);
        }
        
        g2d.dispose();
        super.paintComponent(g);
    }
}