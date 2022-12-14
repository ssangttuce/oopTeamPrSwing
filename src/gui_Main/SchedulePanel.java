package gui_Main;

import dashboard.Schedule;
import dashboard.Task;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;


public class SchedulePanel extends JPanel {
    ArrayList<TaskPanel> taskList = new ArrayList<>();

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
        taskScroll.setPreferredSize(new Dimension(340, 600));
        taskScroll.setBackground(new Color(0, 0, 0, 0));
        taskScroll.setBorder(new EmptyBorder(0, 0, 0, 0));
        taskScroll.getVerticalScrollBar().setUnitIncrement(14);
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
        taskBoard.setBackground(new Color(27, 31, 34, 255));
        taskBoard.setBorder(new EmptyBorder(0, 0, 0, 0));
        for (Task t : schedule.taskList) {
            taskList.add(new TaskPanel(t));
            taskBoard.add(taskList.get(taskList.size()-1));
            taskBoard.add(Box.createRigidArea(new Dimension(0, 10)));
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
