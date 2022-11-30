package gui_Main;

import dashboard.Task;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskPanel extends TaskDetailPanel implements ActionListener {
    JLabel name = new JLabel();
    JTextArea tag = new JTextArea();
    JLabel date = new JLabel();

    public TaskPanel(Task task) {
        super(task);
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setPreferredSize(new Dimension(300, 80));
        setMinimumSize(new Dimension(300, 80));
        setMaximumSize(new Dimension(300, 80));
        setBackground(new Color(27, 45, 56));
        setBorder(new EmptyBorder(0, 0, 0, 0));


        add(setImportanceColor(getImportanceColor()));
        add(setTaskInfoPanel());
        add(setTaskMorePanel());

    }

    private JPanel setTaskInfoPanel() {
        JPanel taskInfo = new JPanel();
        taskInfo.setLayout(new BoxLayout(taskInfo, BoxLayout.Y_AXIS));
        taskInfo.setMinimumSize(new Dimension(135, 80));
        taskInfo.setPreferredSize(new Dimension(135, 80));
        taskInfo.setMaximumSize(new Dimension(135, 80));
        taskInfo.setBackground(new Color(0, 0, 0, 0));

        JPanel namePanel = new JPanel();
        namePanel.setMinimumSize(new Dimension(135, 30));
        namePanel.setPreferredSize(new Dimension(135, 30));
        namePanel.setMaximumSize(new Dimension(135, 30));
        namePanel.setBackground(new Color(0, 0, 0, 0));

        name.setText(task.getName());
        name.setFont(new Font("SansSerif", Font.BOLD, 16));
        name.setHorizontalAlignment(JLabel.LEFT);
        name.setForeground(Color.WHITE);

        namePanel.add(name);

        tag.setAutoscrolls(true);
        tag.setText(task.getTag().replaceAll(" ", "\n"));
        tag.setMinimumSize(new Dimension(95, 30));
        tag.setPreferredSize(new Dimension(95, 30));
        tag.setMaximumSize(new Dimension(95, 30));
        tag.setForeground(Color.WHITE);
        tag.setBackground(new Color(27, 45, 56));

        taskInfo.add(Box.createRigidArea(new Dimension(0, 5)));
        taskInfo.add(namePanel);
        taskInfo.add(Box.createRigidArea(new Dimension(0, 5)));
        taskInfo.add(tag);
        return taskInfo;
    }

    private JPanel setTaskMorePanel() {
        JPanel taskMore = new JPanel();
        taskMore.setLayout(new BoxLayout(taskMore, BoxLayout.X_AXIS));
        taskMore.setMinimumSize(new Dimension(135, 80));
        taskMore.setPreferredSize(new Dimension(135, 80));
        taskMore.setMaximumSize(new Dimension(135, 80));
        taskMore.setBackground(new Color(0, 0, 0, 0));

        JPanel btnPanel = new JPanel(new BorderLayout());
        btnPanel.setMinimumSize(new Dimension(20, 80));
        btnPanel.setPreferredSize(new Dimension(20, 80));
        btnPanel.setMaximumSize(new Dimension(20, 80));
        btnPanel.setBackground(new Color(0, 0, 0, 0));

        JButton viewDetail = new JButton("•••");
        viewDetail.setPreferredSize(new Dimension(20, 20));
        viewDetail.setBackground(new Color(37, 37, 37));
        viewDetail.setForeground(new Color(137, 137, 137));
        viewDetail.setBorder(new EmptyBorder(0, 0, 0, 0));
        viewDetail.addActionListener(this);

        btnPanel.add(viewDetail, BorderLayout.NORTH);

        JPanel taskPrg = new JPanel();
        taskPrg.setLayout(new BoxLayout(taskPrg, BoxLayout.Y_AXIS));
        taskPrg.setMinimumSize(new Dimension(115, 80));
        taskPrg.setPreferredSize(new Dimension(115, 80));
        taskPrg.setMaximumSize(new Dimension(115, 80));
        taskPrg.setBackground(new Color(0, 0, 0, 0));

        JPanel datePanel = new JPanel();
        datePanel.setMinimumSize(new Dimension(115, 30));
        datePanel.setPreferredSize(new Dimension(115, 30));
        datePanel.setMaximumSize(new Dimension(115, 30));
        datePanel.setBackground(new Color(0, 0, 0, 0));

        date.setText(task.getDate());
        date.setHorizontalAlignment(JLabel.LEFT);
        date.setForeground(Color.WHITE);

        datePanel.add(date);

        JPanel progressBar = new JPanel();
        progressBar.setMinimumSize(new Dimension(115, 30));
        progressBar.setPreferredSize(new Dimension(115, 30));
        progressBar.setMaximumSize(new Dimension(115, 30));
        progressBar.setBackground(new Color(0, 0, 0, 0));

        JLabel prgBar = new JLabel(task.getProgressPercent() + "%");
        prgBar.setHorizontalAlignment(JLabel.CENTER);
        prgBar.setFont(new Font("Times", Font.BOLD, 18));
        prgBar.setForeground(Color.WHITE);

        progressBar.add(prgBar);

        taskPrg.add(Box.createRigidArea(new Dimension(0, 5)));
        taskPrg.add(datePanel);
//        taskPrg.add(Box.createRigidArea(new Dimension(0, 5)));
        taskPrg.add(progressBar);

        taskMore.add(taskPrg);
        taskMore.add(btnPanel);


        return taskMore;
    }

    private JPanel setImportanceColor(Color importanceColor) {
        JPanel colorPanel = new JPanel();
        colorPanel.setMinimumSize(new Dimension(30, 80));
        colorPanel.setPreferredSize(new Dimension(30, 80));
        colorPanel.setMaximumSize(new Dimension(30, 80));

        colorPanel.setBackground(importanceColor);
        colorPanel.setBorder(new EmptyBorder(0, 0, 0, 0));

        return colorPanel;
    }

    Color getImportanceColor() {//need to change form to get importance from Task Class
        return task.getImportanceColor();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        detail = new JDialog();
        detail.setTitle("일정 상세보기");
        detail.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);

        detail.setResizable(false);
        detail.setMinimumSize(new Dimension(400, 422));
        detail.setPreferredSize(new Dimension(400, 422));
        detail.setMaximumSize(new Dimension(400, 422));

        detail.setContentPane(super.getDetailPanel());

        detail.setBackground(new Color(49, 51, 53));

        detail.setLocation(700, 250);
        detail.pack();
        detail.setVisible(true);
        detail.setModal(false);
    }
}
