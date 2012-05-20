package teste;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public final class RelogioErrado extends JFrame implements ActionListener {

    private javax.swing.Timer timer;
    private JLabel label;

    public RelogioErrado() {

        super("Relógio Errado");
        label = new JLabel();
        label.setFont(new Font("Arial", Font.BOLD, 22));
        JPanel panel = new JPanel();
        panel.add(label);
        Container c = getContentPane();
        FlowLayout layout = new FlowLayout();
        layout.setAlignment(FlowLayout.CENTER);
        c.setLayout(layout);
        c.add(panel);

        setResizable(false);
        setBounds(250, 200, 150, 80);
        show();
        disparaRelogio();
    }

    public void disparaRelogio() {
        if (timer == null) {
            timer = new javax.swing.Timer(1, this);
            timer.setInitialDelay(0);
            timer.start();
        } else if (!timer.isRunning()) {
            timer.restart();
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        GregorianCalendar calendario = new GregorianCalendar();
        int h = calendario.get(GregorianCalendar.HOUR);
        int m = calendario.get(GregorianCalendar.MINUTE);
        int s = calendario.get(GregorianCalendar.SECOND);
        int ml = calendario.get(GregorianCalendar.MILLISECOND);

        String hora =
                ((h < 10) ? "0" : "")
                + h
                + ":"
                + ((m < 10) ? "0" : "")
                + m
                + ":"
                + ((s < 10) ? "0" : "")
                + s
                + ":"
                + ((ml < 10) ? "0" : "")
                + ml;

        label.setText(hora);
    }

    public static void main(String args[]) {
        RelogioErrado relogioErrado = new RelogioErrado();
    }
}
