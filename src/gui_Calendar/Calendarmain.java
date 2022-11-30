package gui_Calendar;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Calendarmain extends JDialog implements ActionListener {
    public JTextField datePrint;
    public String date;
    Container container = getContentPane();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();

    JButton buttonBefore = new JButton("Before");
    JButton buttonAfter = new JButton("After");

    JLabel label = new JLabel("00년 0월");

    JButton[] buttons = new JButton[49];
    String[] dayNames = {"Su", "Mo", "Tu", "We", "Th", "Fr", "Sa"};

    public CalendarFunction cF = new CalendarFunction();

    public Calendarmain(JTextField datePrint) {
        this.datePrint = datePrint;
        setTitle("만년 달력");
        setSize(550, 400);
        setLocation(720, 300);
        init();
        start();
        setVisible(true);
    }

    private void init() {
        container.setLayout(new BorderLayout());
        container.add("North", panel1);
        container.add("Center", panel2);

        panel1.setLayout(new FlowLayout());
        panel1.add(buttonBefore);
        panel1.add(label);
        panel1.add(buttonAfter);

        Font font = new Font("SansSerif", Font.BOLD, 20);
        buttonAfter.setFont(font);
        buttonBefore.setFont(font);
        label.setFont(font);

        label.setText(cF.getCalText());

        panel2.setLayout(new GridLayout(7, 7, 5, 5));
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            panel2.add(buttons[i]);

            buttons[i].setFont(new Font("SansSerif", Font.BOLD, 24));

            if (i < 7) buttons[i].setText(dayNames[i]);

            if (i % 7 == 0) buttons[i].setForeground(Color.RED);
            if (i % 7 == 6) buttons[i].setForeground(Color.BLUE);
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    Object source = e.getSource();
                    if (source instanceof JButton) {
                        JButton btn = (JButton)source;
                        date = cF.month +"."+ btn.getText();
                        datePrint.setText(date);
                    }
                }
            });
        }
        cF.setButtons(buttons);
        cF.calSet();
    }

    private void start() {
        buttonAfter.addActionListener(this);
        buttonBefore.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int gap = 0;
        if (e.getSource() == buttonAfter) {                // 1달 후
            gap = 1;
        } else if (e.getSource() == buttonBefore) {        // 1달 전
            gap = -1;
        }
        cF.allInit(gap);
        label.setText(cF.getCalText());        // 년월 글자 갱신
    }
}