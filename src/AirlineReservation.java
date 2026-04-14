import javax.swing.SwingUtilities;

public class AirlineReservation {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginFrame().setVisible(true));
    }
}