
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class GradientTable {

    public static void apply(JTable table) {
        table.setOpaque(true);
        table.setBackground(new Color(255, 248, 231, 180));

        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable t, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {

                Component c = super.getTableCellRendererComponent(t, value, isSelected, hasFocus, row, column);

                JComponent component = (JComponent) c;
                component.setOpaque(true);

                if (!isSelected) {
                    if (row % 2 == 0) {
                        c.setBackground(new Color(255, 248, 231, 200));
                    } else {
                        c.setBackground(new Color(245, 235, 210, 200));
                    }
                    c.setForeground(new Color(60, 40, 20));
                } else {
                    c.setBackground(new Color(122, 74, 0, 220));
                    c.setForeground(Color.WHITE);
                }

                setPadding(c, 5, 10);
                return c;
            }
        });

        JTableHeader header = table.getTableHeader();
        if (header != null) {
            header.setOpaque(false);
            header.setBackground(new Color(0, 0, 0, 0));
            header.setDefaultRenderer(new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable t, Object value,
                        boolean isSelected, boolean hasFocus, int row, int column) {

                    JPanel panel = new JPanel() {
                        @Override
                        protected void paintComponent(Graphics g) {
                            super.paintComponent(g);
                            Graphics2D g2d = (Graphics2D) g;
                            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                            GradientPaint gp = new GradientPaint(0, 0, new Color(122, 74, 0),
                                    0, getHeight(), new Color(255, 215, 122));
                            g2d.setPaint(gp);
                            g2d.fillRect(0, 0, getWidth(), getHeight());
                        }
                    };
                    panel.setLayout(new BorderLayout());
                    panel.setOpaque(false);

                    JLabel label = new JLabel(value != null ? value.toString() : "");
                    label.setHorizontalAlignment(SwingConstants.CENTER);
                    label.setForeground(Color.WHITE);
                    label.setFont(new Font("Arial", Font.BOLD, 12));
                    label.setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));
                    panel.add(label);

                    return panel;
                }
            });

            header.setPreferredSize(new Dimension(header.getWidth(), 40));
        }

        table.setShowGrid(true);
        table.setGridColor(new Color(100, 70, 40, 100));
        table.setRowHeight(32);
        table.setFont(new Font("Arial", Font.PLAIN, 12));
        table.setIntercellSpacing(new Dimension(5, 3));
    }

    public static void apply(JScrollPane scrollPane) {
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(122, 74, 0), 2));
    }

    private static void setPadding(Component c, int topBottom, int leftRight) {
        if (c instanceof JLabel) {
            ((JLabel) c).setBorder(BorderFactory.createEmptyBorder(topBottom, leftRight, topBottom, leftRight));
        }
    }
}
