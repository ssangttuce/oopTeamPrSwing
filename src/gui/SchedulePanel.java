package gui;

import dashboard.Schedule;
import dashboard.Task;

import javax.swing.*;
import java.awt.*;

public class SchedulePanel extends JPanel {
    public SchedulePanel(Schedule schedule) {
        setLayout(new BorderLayout());
        setSize(new Dimension(340, 600));
        setBorder(BorderFactory.createLineBorder(Color.RED));
        setBackground(Color.BLACK);


        JLabel name = new JLabel();
        name.setSize(new Dimension(100,20));
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setFont(new Font(schedule.name, Font.PLAIN, 14));
        name.setForeground(Color.WHITE);
        add(name, BorderLayout.NORTH);

        JPanel taskBoard = new JPanel();

        for (Task t : schedule.taskList) {
            taskBoard.add(new TaskPanel(t));
        }

        JPanel addPanel = new JPanel();
        addPanel.setPreferredSize(new Dimension(300, 40));
        JButton addBtn = new JButton("+add");
        addBtn.setPreferredSize(new Dimension(100, 40));
        addBtn.setBackground(Color.DARK_GRAY);
        addBtn.setForeground(Color.WHITE);
        addPanel.add(addBtn);

        taskBoard.add(addPanel);

        JScrollPane taskScroll = new JScrollPane(taskBoard);
        add(taskScroll, BorderLayout.CENTER);
    }
}
