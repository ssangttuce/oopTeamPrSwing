package gui;

import dashboard.Task;

import javax.swing.*;
import java.awt.*;

public class TaskPanel extends JPanel {
    public TaskPanel(Task task){
        setLayout(new BorderLayout());
        setSize(new Dimension(300, 80));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setBackground(Color.DARK_GRAY);

        JPanel taskContentPanel = new JPanel(new BorderLayout());
        JPanel taskInfo = new JPanel(new GridLayout(2, 1));
        JPanel taskProgress = new JPanel(new BorderLayout());

        taskContentPanel.setSize(new Dimension(270, 80));
        taskInfo.setPreferredSize(new Dimension(120, 70));
        taskProgress.setSize(new Dimension(120, 70));

        taskContentPanel.setBackground(Color.DARK_GRAY);

        taskInfo.add(new JLabel(task.getName()));
        taskInfo.add(new JLabel(task.getTag()));

        JButton viewDetail = new JButton("?");
        JPanel progressBar = new JPanel();
        viewDetail.setSize(new Dimension(20, 20));

        taskProgress.add(viewDetail, BorderLayout.NORTH);
        taskProgress.add(new JLabel(task.getDate()), BorderLayout.CENTER);
        taskProgress.add(progressBar, BorderLayout.SOUTH);

        taskContentPanel.add(taskInfo, BorderLayout.WEST);
        taskContentPanel.add(taskProgress, BorderLayout.EAST);

        add(taskContentPanel, BorderLayout.EAST);
    }

    private void setImportanceColor(){

    }

}
