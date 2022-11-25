package gui_Calendar;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.border.TitledBorder;

public class ProgressBar_slide extends JPanel {
    private JProgressBar pb = new JProgressBar(JProgressBar.VERTICAL, 0, 100);

    private JSlider sb = new JSlider(JSlider.VERTICAL, 0, 100, 60);

    public ProgressBar_slide() {
        setLayout(new GridLayout(1, 2));
        add(pb);
        sb.setValue(0);
        sb.setPaintTicks(true);
        sb.setMajorTickSpacing(10);
        sb.setMinorTickSpacing(5);
        sb.setBorder(new TitledBorder("Slide Me"));
        pb.setModel(sb.getModel()); // Share model
        add(sb);
    }

    public static void main(String[] args) {
        JPanel p = new ProgressBar_slide();

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(p);
        frame.setSize(300, 300);

        frame.setVisible(true);
    }
}
