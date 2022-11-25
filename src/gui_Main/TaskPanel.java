package gui_Main;

import dashboard.Task;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskPanel extends JPanel implements ActionListener {
    TaskDetailPanel detail;

    public TaskPanel(Task task) {

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setPreferredSize(new Dimension(300, 80));
        setMinimumSize(new Dimension(300, 80));
        setMaximumSize(new Dimension(300, 80));
        setBackground(new Color(27, 45, 56));
        setBorder(BorderFactory.createLineBorder(new Color(27, 31, 34, 255), 2, true));
        detail = new TaskDetailPanel(task);
        add(setImportanceColor());
        add(setTaskInfoPanel(task));
        add(setTaskProgrsPanel(task));
    }

    private JPanel setTaskInfoPanel(Task task) {
        JPanel taskInfo = new JPanel(new GridLayout(2, 1));
        taskInfo.setMinimumSize(new Dimension(135, 80));
        taskInfo.setPreferredSize(new Dimension(135, 80));
        taskInfo.setMaximumSize(new Dimension(135, 80));
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

    private JPanel setTaskProgrsPanel(Task task) {
        JPanel taskProgress = new JPanel(new BorderLayout());
        taskProgress.setMinimumSize(new Dimension(135, 80));
        taskProgress.setPreferredSize(new Dimension(135, 80));
        taskProgress.setMaximumSize(new Dimension(135, 80));
        taskProgress.setBackground(new Color(0, 0, 0, 0));

        JButton viewDetail = new JButton("•••");
        viewDetail.setPreferredSize(new Dimension(20, 20));
        viewDetail.setBackground(new Color(37, 37, 37));
        viewDetail.setForeground(new Color(137, 137, 137));
        viewDetail.setBorder(new EmptyBorder(0, 0, 0, 0));

        viewDetail.addActionListener(this);


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

    private JPanel setImportanceColor() {
        JPanel colorPanel = new JPanel();
        colorPanel.setMinimumSize(new Dimension(30, 80));
        colorPanel.setPreferredSize(new Dimension(30, 80));
        colorPanel.setMaximumSize(new Dimension(30, 80));

        colorPanel.setBackground(getImportanceColor());
        colorPanel.setBorder(new EmptyBorder(0, 0, 0, 0));

        return colorPanel;
    }

    Color getImportanceColor() {//need to change form to get importance from Task Class
        Color color = new Color(255, 106, 0);
        return color;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        detail.pack();
        detail.setVisible(true);
    }
}
