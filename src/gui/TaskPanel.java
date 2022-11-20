package gui;

import dashboard.Task;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TaskPanel extends TaskDetailPanel {
    public TaskPanel(Task task) {
        setLayout(new GridLayout(1, 2));
        setPreferredSize(new Dimension(300, 80));
        setMinimumSize(new Dimension(300, 80));
        setMaximumSize(new Dimension(300, 80));
        setBackground(new Color(27, 45, 56));
        setBorder(BorderFactory.createLineBorder(new Color(27, 31, 34, 255), 1, true));


        add(setTaskInfoPanel(task));
        add(setTaskProgrsPanel(task));
    }

    private JPanel setTaskInfoPanel(Task task) {
        JPanel taskInfo = new JPanel(new GridLayout(2, 1));
        taskInfo.setPreferredSize(new Dimension(120, 70));
        taskInfo.setBackground(new Color(0, 0, 0, 0));

        JLabel name = new JLabel(task.getName());
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setForeground(Color.WHITE);

        JLabel tag = new JLabel(task.getTag());
        tag.setHorizontalAlignment(JLabel.CENTER);
        tag.setForeground(Color.WHITE);

        taskInfo.add(name);
        taskInfo.add(tag);
        return taskInfo;
    }

    private JPanel setTaskProgrsPanel(Task task){
        JPanel taskProgress = new JPanel(new BorderLayout());
        taskProgress.setSize(new Dimension(120, 70));
        taskProgress.setBackground(new Color(0, 0, 0, 0));

        JButton viewDetail = new JButton("•••");
        viewDetail.setPreferredSize(new Dimension(20, 20));
        viewDetail.setBackground(new Color(37, 37, 37));
        viewDetail.setForeground(new Color(137, 137, 137));
        viewDetail.setBorder(new EmptyBorder(0, 0, 0, 0));


        JPanel btnPanel = new JPanel(new BorderLayout());
        btnPanel.setMinimumSize(new Dimension(120, 20));

        btnPanel.setBackground(new Color(0, 0, 0, 0));

        JLabel date = new JLabel(task.getDate());
        date.setHorizontalAlignment(JLabel.CENTER);
        date.setForeground(Color.WHITE);


        JPanel progressBar = new JPanel();
        progressBar.setPreferredSize(new Dimension(120, 30));
        progressBar.setBackground(new Color(0, 0, 0, 0));
        JLabel prgBar = new JLabel("progress bar");
        prgBar.setForeground(Color.WHITE);
        progressBar.add(prgBar);

        btnPanel.add(viewDetail, BorderLayout.EAST);
        taskProgress.add(btnPanel, BorderLayout.NORTH);

        taskProgress.add(date, BorderLayout.CENTER);
        taskProgress.add(progressBar, BorderLayout.SOUTH);

        return taskProgress;
    }

    private void setImportanceColor() {

    }

}
