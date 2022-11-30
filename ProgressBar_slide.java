package gui_Calendar;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class ProgressBar_slide extends JPanel {
    public JProgressBar pb = new JProgressBar(JProgressBar.VERTICAL, 0, 100);
    public JLabel percent = new JLabel();
    //private JSlider sb = new JSlider(JSlider.VERTICAL, 0, 100, 60);

    public void setValue(int n){
        pb.setValue(n);
        percent.setText(pb.getValue()+"");
    }
    public int getValue(){
        return pb.getValue();
    }

    public ProgressBar_slide() {
//        setLayout(new GridLayout(1, 2));
//        sb.setValue(0);
//        sb.setPaintTicks(true);
//        sb.setMajorTickSpacing(10);
//        sb.setMinorTickSpacing(5);
//        sb.setBorder(new TitledBorder("Slide Me"));

        //pb.setModel(sb.getModel()); // Share model
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(40, 150));
        setBackground(new Color(49, 51, 53));


        percent.setText(String.valueOf(pb.getValue()));
        percent.setPreferredSize(new Dimension(40, 20));
        percent.setForeground(Color.WHITE);
        add(percent, BorderLayout.SOUTH);
        pb.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                //Retrieves the mouse position relative to the component origin.
                double mouseY = e.getY();

                //Computes how far along the mouse is relative to the component width then multiply it by the progress bar's maximum value.
                int progressBarVal = (int)Math.round((mouseY / pb.getSize().getHeight()) * pb.getMaximum());
                pb.setValue(100-progressBarVal);
                percent.setText(String.valueOf(pb.getValue()));
            }
        });
        pb.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                double mouseY = e.getY();

                //Computes how far along the mouse is relative to the component width then multiply it by the progress bar's maximum value.
                int progressBarVal = (int)Math.round((mouseY / pb.getSize().getHeight()) * pb.getMaximum());
                pb.setValue(100-progressBarVal);
                percent.setText(String.valueOf(pb.getValue()));
            }
        });
//        add(sb);
        add(pb);


    }
//
//    public static void main(String[] args) {
//        JPanel p = new ProgressBar_slide();
//
//        JFrame frame = new JFrame();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.getContentPane().add(p);
//        frame.setSize(300, 300);
//
//        frame.setVisible(true);
//    }
}
