package gui_Main;

import dashboard.Task;
import gui_Calendar.Calendarmain;
import gui_Calendar.ProgressBar_slide;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskDetailPanel extends JDialog {
    public TaskDetailPanel(Task task) {
        setTitle("일정 상세보기");
        setMinimumSize(new Dimension(400, 422));
        setPreferredSize(new Dimension(400, 422));
        setMaximumSize(new Dimension(400, 422));
        setResizable(false);
        setBackground(new Color(49, 51, 53));

        JPanel detailPanel = new JPanel(new BorderLayout());
        detailPanel.setMinimumSize(new Dimension(400, 390));
        detailPanel.setPreferredSize(new Dimension(400, 390));
        detailPanel.setMaximumSize(new Dimension(400, 390));
        detailPanel.setBackground(new Color(0, 0, 0, 0));

        detailPanel.add(setEditPanel(task));
        setContentPane(detailPanel);

        setLocation(700, 250);
        setModal(true);
    }

    private JPanel setEditPanel(Task task) {
//        JPanel editPanel = new JPanel(new BorderLayout());
        JPanel editPanel = new JPanel();
        editPanel.setMinimumSize(new Dimension(140, 200));
        editPanel.setPreferredSize(new Dimension(140, 200));
        editPanel.setMaximumSize(new Dimension(140, 200));
        editPanel.setBackground(new Color(0, 0, 0, 0));

        editPanel.add(setNameEditPanel(task), BorderLayout.NORTH);
        editPanel.add(setMoreInfoEditPanel(task), BorderLayout.CENTER);

        return editPanel;
    }

    private JPanel setNameEditPanel(Task task) {
        JPanel nameEditPanel = new JPanel(new BorderLayout());
        nameEditPanel.setMinimumSize(new Dimension(300, 50));
        nameEditPanel.setPreferredSize(new Dimension(300, 50));
        nameEditPanel.setMaximumSize(new Dimension(300, 50));
        nameEditPanel.setBackground(new Color(0, 0, 0, 0));

        JLabel name = new JLabel("Name");
        name.setForeground(Color.WHITE);
        name.setHorizontalAlignment(JLabel.LEFT);

        JTextField nameInsert = new JTextField(task.getName(), 12);
        nameInsert.setHorizontalAlignment(JTextField.LEFT);
        nameInsert.setMinimumSize(new Dimension(300, 30));
        nameInsert.setPreferredSize(new Dimension(300, 30));
        nameInsert.setMaximumSize(new Dimension(300, 30));
        nameInsert.setForeground(new Color(212, 212, 212));
        nameInsert.setCaretColor(Color.WHITE);
        nameInsert.setBackground(new Color(49, 51, 53));
        nameInsert.setBorder(new EmptyBorder(0, 0, 0, 0));

        nameEditPanel.add(name, BorderLayout.NORTH);
        nameEditPanel.add(nameInsert);
        return nameEditPanel;
    }

    private JPanel setMoreInfoEditPanel(Task task){
        JPanel moreInfoEditPanel = new JPanel(new BorderLayout());
        moreInfoEditPanel.setMinimumSize(new Dimension(360, 170));
        moreInfoEditPanel.setPreferredSize(new Dimension(360, 170));
        moreInfoEditPanel.setMaximumSize(new Dimension(360, 170));
        moreInfoEditPanel.setBackground(new Color(0, 0, 0, 0));


        moreInfoEditPanel.add(setTagEditPanel(task), BorderLayout.WEST);
        moreInfoEditPanel.add(setDateEditPanel(task), BorderLayout.CENTER);
        moreInfoEditPanel.add(setProgressBar(task), BorderLayout.EAST);

        return moreInfoEditPanel;
    }

    private JPanel setTagEditPanel(Task task) {
        JPanel tagEditPanel = new JPanel();
        tagEditPanel.setMinimumSize(new Dimension(120, 170));
        tagEditPanel.setPreferredSize(new Dimension(120, 170));
        tagEditPanel.setMaximumSize(new Dimension(120, 170));
        tagEditPanel.setBackground(new Color(0, 0, 0, 0));

        JLabel tag = new JLabel("#Tag");
        tag.setForeground(Color.WHITE);
        tag.setHorizontalAlignment(JLabel.LEFT);


        JTextArea tagInsert = new JTextArea(5, 12);
        String tagString = task.getTag().replaceAll(" ", "\n");
        tagInsert.insert(tagString, tagInsert.getCaretPosition());
        tagInsert.setForeground(Color.WHITE);
        tagInsert.setCaretColor(Color.WHITE);
        tagInsert.setMinimumSize(new Dimension(120, 150));
        tagInsert.setPreferredSize(new Dimension(120, 150));
        tagInsert.setMaximumSize(new Dimension(120, 150));
        tagInsert.setBackground(new Color(43, 43, 43));
        tagInsert.setBorder(new EmptyBorder(0, 0, 0 ,0));
//        tagInsert.addMouseMotionListener(new MouseMotionAdapter() {
//            public void mouseDragged(MouseEvent e) {
//                tagInsert.setBackground(new Color(43, 43, 43));
//            }
//        });

        tagEditPanel.add(tag);
        tagEditPanel.add(tagInsert);

        return tagEditPanel;
    }

    private JPanel setDateEditPanel(Task task) {
        JPanel dateEditPanel = new JPanel(new BorderLayout());
        dateEditPanel.setMinimumSize(new Dimension(150, 95));
        dateEditPanel.setPreferredSize(new Dimension(150, 95));
        dateEditPanel.setMaximumSize(new Dimension(150, 95));
        dateEditPanel.setBackground(new Color(0, 0, 0, 0));
        dateEditPanel.setBorder(BorderFactory.createLineBorder(Color.YELLOW));

        dateEditPanel.add(setStartDate(task), BorderLayout.NORTH);
        dateEditPanel.add(setEndDate(task), BorderLayout.CENTER);

        return dateEditPanel;
    }

    private JPanel setStartDate(Task task){
        JPanel datePanel = new JPanel(new BorderLayout());
        JLabel startDate = new JLabel("Start Date");
        startDate.setPreferredSize(new Dimension(60, 20));
        startDate.setHorizontalAlignment(JLabel.LEFT);
        startDate.setBackground(new Color(0, 0, 0, 0));

        JPanel dateEditPrint = new JPanel(new BorderLayout());
        dateEditPrint.setMinimumSize(new Dimension(150, 20));
        dateEditPrint.setPreferredSize(new Dimension(150, 20));
        dateEditPrint.setMaximumSize(new Dimension(150, 20));
        dateEditPrint.setBackground(new Color(0, 0, 0, 0));

        JTextField datePrint = new JTextField(task.getDate());
        datePrint.setHorizontalAlignment(JTextField.CENTER);
        datePrint.setPreferredSize(new Dimension(120, 20));


        JButton calendarChoice = new JButton();
        calendarChoice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setModal(false);
                setVisible(false);
                Calendarmain c = new Calendarmain();
                c.setModal(true);
                c.pack();
            }
        });
        calendarChoice.setMinimumSize(new Dimension(30, 20));
        calendarChoice.setPreferredSize(new Dimension(30, 20));
        calendarChoice.setMaximumSize(new Dimension(30, 20));

        dateEditPrint.add(datePrint, BorderLayout.WEST);
        dateEditPrint.add(calendarChoice, BorderLayout.EAST);
        datePanel.add(startDate, BorderLayout.NORTH);
        datePanel.add(dateEditPrint, BorderLayout.SOUTH);
        return datePanel;
    }

    private JPanel setEndDate(Task task){
        JPanel datePanel = new JPanel(new BorderLayout());
        JLabel endDate = new JLabel("End Date");
        endDate.setPreferredSize(new Dimension(60, 20));
        endDate.setHorizontalAlignment(JLabel.LEFT);
        endDate.setBackground(new Color(0, 0, 0, 0));

        JPanel dateEditPrint = new JPanel(new BorderLayout());
        dateEditPrint.setMinimumSize(new Dimension(150, 20));
        dateEditPrint.setPreferredSize(new Dimension(150, 20));
        dateEditPrint.setMaximumSize(new Dimension(150, 20));

        JTextField datePrint = new JTextField(task.getDate());
        datePrint.setHorizontalAlignment(JTextField.CENTER);
        datePrint.setPreferredSize(new Dimension(120, 20));

        JButton calendarChoice = new JButton();
        calendarChoice.setMinimumSize(new Dimension(30, 20));
        calendarChoice.setPreferredSize(new Dimension(30, 20));
        calendarChoice.setMaximumSize(new Dimension(30, 20));

        dateEditPrint.add(datePrint, BorderLayout.WEST);
        dateEditPrint.add(calendarChoice, BorderLayout.EAST);
        datePanel.add(endDate, BorderLayout.NORTH);
        datePanel.add(dateEditPrint, BorderLayout.SOUTH);
        return datePanel;
    }

    private JPanel setProgressBar(Task task){
        ProgressBar_slide prgBar = new ProgressBar_slide();
        prgBar.setMinimumSize(new Dimension(40, 170));
        prgBar.setPreferredSize(new Dimension(40, 170));
        prgBar.setMaximumSize(new Dimension(40, 170));
        return prgBar;
    }

}
