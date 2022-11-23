package gui;

import dashboard.Schedule;
import dashboard.Task;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;


public class SchedulePanel extends JPanel {
    public SchedulePanel(Schedule schedule) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setMinimumSize(new Dimension(340, 600));
        setPreferredSize(new Dimension(340, 600));
        setMaximumSize(new Dimension(340, 600));
        setBackground(new Color(27, 31, 34, 255));
        read(schedule);
    }

    void read(Schedule schedule) {
        add(setNamePanel(schedule));
        JScrollPane taskScroll = new JScrollPane(setTaskBoardPanel(schedule), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//        taskScroll.setMinimumSize(new Dimension(340, 80));
//        taskScroll.setMaximumSize(new Dimension(340, 600));
        taskScroll.setPreferredSize(new Dimension(340, 600));
        taskScroll.setBackground(new Color(0, 0, 0, 0));
        taskScroll.setBorder(new EmptyBorder(0, 0, 0, 0));
//        taskScroll.getVerticalScrollBar().setBackground(Color.BLACK);
//        taskScroll.getVerticalScrollBar().setBorder(new EmptyBorder(0, 0, 0, 0));
//        taskScroll.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
//            @Override
//            protected void configureScrollBarColors() {
//                this.thumbColor = Color.BLACK;
//            }
//        });
        taskScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        add(taskScroll);

    }

    private JPanel setNamePanel(Schedule schedule) {
        JPanel namePanel = new JPanel(new BorderLayout());
        namePanel.setPreferredSize(new Dimension(300, 40));
        namePanel.setMinimumSize(new Dimension(300, 40));//boxlayout,
        namePanel.setMaximumSize(new Dimension(300, 40));//boxlayout,
        namePanel.setBackground(new Color(0, 0, 0, 0));


        JLabel name = new JLabel(schedule.name);
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setForeground(Color.WHITE);
        namePanel.add(name, BorderLayout.WEST);

        return namePanel;
    }

    private JPanel setTaskBoardPanel(Schedule schedule) {
        JPanel taskBoard = new JPanel();
        taskBoard.setLayout(new BoxLayout(taskBoard, BoxLayout.Y_AXIS));
        taskBoard.setSize(new Dimension(340, 540));
//        taskBoard.setMinimumSize(new Dimension(340, 540)); //if you set preferredsize, scroll never show
//        taskBoard.setPreferredSize(new Dimension(340, 540));
//        taskBoard.setMaximumSize(new Dimension(340, 540));
        taskBoard.setBackground(new Color(0, 0, 0, 0));
        taskBoard.setBorder(new EmptyBorder(0, 0, 0, 0));

        for (Task task : schedule.taskList) {
            taskBoard.add(new TaskPanel(task));
        }
        taskBoard.add(setAddBtnPanel());

        return taskBoard;
    }

    private JPanel setAddBtnPanel() {
        JPanel addPanel = new JPanel();
        addPanel.setMinimumSize(new Dimension(300, 40));
        addPanel.setPreferredSize(new Dimension(300, 40));
        addPanel.setMaximumSize(new Dimension(300, 40));
        addPanel.setBackground(new Color(0, 0, 0, 0));

        JButton addBtn = new JButton("+add");
        addBtn.setPreferredSize(new Dimension(100, 40));
        addBtn.setBackground(Color.DARK_GRAY);
        addBtn.setForeground(Color.WHITE);
        addBtn.setBorder(new EmptyBorder(0, 0, 0, 0));

        addPanel.add(addBtn);
        return addPanel;
    }
}
