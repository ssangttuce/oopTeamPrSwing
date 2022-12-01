package gui_Main;

import dashboard.Daily;
import dashboard.Dashboard;
import dashboard.Task;
import gui_Calendar.Calendarmain;
import gui_Calendar.ProgressBar_slide;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class TaskDetailPanel extends JPanel {
    JDialog detail;

    public Task task;
    JPanel detailPanel = new JPanel(new BorderLayout());
    JTextField nameInsert = new JTextField();
    JTextArea tagInsert = new JTextArea(5, 10);
    JTextField startDatePrint = new JTextField();
    JTextField endDatePrint = new JTextField();
    JTextField importance = new JTextField();
    JButton importanceEditBtn = new JButton(); //task.getImportanceLabel
    ProgressBar_slide prgBar = new ProgressBar_slide();
    JTextArea contentInsert = new JTextArea();


    public TaskDetailPanel(Task task) {
        this.task = task;
        detailPanel.setMinimumSize(new Dimension(400, 390));
        detailPanel.setPreferredSize(new Dimension(400, 390));
        detailPanel.setMaximumSize(new Dimension(400, 390));
        detailPanel.setBackground(new Color(0, 0, 0, 0));
        detailPanel.add(setEditPanel());
    }

    public JPanel getDetailPanel() {
        return detailPanel;
    }

    private JPanel setEditPanel() {
        JPanel editPanel = new JPanel();
        editPanel.setLayout(new BoxLayout(editPanel, BoxLayout.Y_AXIS));
        editPanel.setMinimumSize(new Dimension(140, 200));
        editPanel.setPreferredSize(new Dimension(140, 200));
        editPanel.setMaximumSize(new Dimension(140, 200));
        editPanel.setBackground(new Color(0, 0, 0, 0));

        editPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        editPanel.add(setNameEditPanel());
        editPanel.add(setMoreInfoEditPanel());
        editPanel.add(setContentEditPanel());
        editPanel.add(setSaveCancBtn());


        return editPanel;
    }


    private JPanel setNameEditPanel() {
        JPanel nameEditPanel = new JPanel(new BorderLayout());
        nameEditPanel.setMinimumSize(new Dimension(300, 50));
        nameEditPanel.setPreferredSize(new Dimension(300, 50));
        nameEditPanel.setMaximumSize(new Dimension(300, 50));
        nameEditPanel.setBackground(new Color(0, 0, 0, 0));

        JLabel name = new JLabel("Name");
        name.setForeground(Color.WHITE);
        name.setHorizontalAlignment(JLabel.LEFT);


        nameInsert.setText(task.getName());
        nameInsert.setFont(new Font("SansSerif", Font.BOLD, 16));
        nameInsert.setHorizontalAlignment(JTextField.LEFT);
        nameInsert.setMinimumSize(new Dimension(300, 30));
        nameInsert.setPreferredSize(new Dimension(300, 30));
        nameInsert.setMaximumSize(new Dimension(300, 30));
        nameInsert.setForeground(Color.WHITE);
        nameInsert.setCaretColor(Color.WHITE);
        nameInsert.setBackground(new Color(49, 51, 53));
        nameInsert.setBorder(new EmptyBorder(0, 0, 0, 0));

        nameEditPanel.add(name, BorderLayout.NORTH);
        nameEditPanel.add(nameInsert);
        return nameEditPanel;
    }

    private JPanel setMoreInfoEditPanel() {
        JPanel moreInfoEditPanel = new JPanel();
        moreInfoEditPanel.setLayout(new BoxLayout(moreInfoEditPanel, BoxLayout.X_AXIS));
        moreInfoEditPanel.setMinimumSize(new Dimension(360, 170));
        moreInfoEditPanel.setPreferredSize(new Dimension(360, 170));
        moreInfoEditPanel.setMaximumSize(new Dimension(360, 170));
        moreInfoEditPanel.setBackground(new Color(0, 0, 0, 0));


        moreInfoEditPanel.add(setTagEditPanel());
        moreInfoEditPanel.add(Box.createRigidArea(new Dimension(20, 0)));
        moreInfoEditPanel.add(divSouth());
        moreInfoEditPanel.add(Box.createRigidArea(new Dimension(20, 0)));
        moreInfoEditPanel.add(setProgressBar());

        return moreInfoEditPanel;
    }

    private JPanel setTagEditPanel() {
        JPanel tagEditPanel = new JPanel(new BorderLayout());
        tagEditPanel.setMinimumSize(new Dimension(120, 170));
        tagEditPanel.setPreferredSize(new Dimension(120, 170));
        tagEditPanel.setMaximumSize(new Dimension(120, 170));
        tagEditPanel.setBackground(new Color(0, 0, 0, 0));

        JLabel tag = new JLabel("#Tag");
        tag.setPreferredSize(new Dimension(60, 20));
        tag.setForeground(Color.WHITE);
        tag.setHorizontalAlignment(JLabel.LEFT);

        String tagString = task.getTag().replaceAll(" ", "\n");
        tagInsert.insert(tagString, tagInsert.getCaretPosition());
        tagInsert.setForeground(Color.WHITE);
        tagInsert.setCaretColor(Color.WHITE);

        tagInsert.setMinimumSize(new Dimension(120, 150));
        tagInsert.setPreferredSize(new Dimension(120, 150));
        tagInsert.setMaximumSize(new Dimension(120, 150));
        tagInsert.setBackground(new Color(43, 43, 43));
        tagInsert.setBorder(new EmptyBorder(0, 0, 0, 0));

        tagEditPanel.add(tag, BorderLayout.NORTH);
        tagEditPanel.add(tagInsert);

        return tagEditPanel;
    }

    private JPanel divSouth() {
        JPanel div = new JPanel();
        div.setLayout(new BoxLayout(div, BoxLayout.Y_AXIS));
        div.setMinimumSize(new Dimension(150, 170));
        div.setPreferredSize(new Dimension(150, 170));
        div.setMaximumSize(new Dimension(150, 170));
        div.setBackground(new Color(0, 0, 0, 0));

        div.add(setDateEditPanel());
        div.add(Box.createRigidArea(new Dimension(0, 20)));
        div.add(setImportance());
        return div;
    }

    private JPanel setDateEditPanel() {
        JPanel dateEditPanel = new JPanel(new BorderLayout());
        dateEditPanel.setMinimumSize(new Dimension(150, 95));
        dateEditPanel.setPreferredSize(new Dimension(150, 95));
        dateEditPanel.setMaximumSize(new Dimension(150, 95));
        dateEditPanel.setBackground(new Color(0, 0, 0, 0));

        dateEditPanel.add(setStartDate(), BorderLayout.NORTH);
        dateEditPanel.add(setEndDate(), BorderLayout.SOUTH);
//        dateEditPanel.add(Box.createRigidArea(new Dimension(0, 75)), BorderLayout.SOUTH);
        return dateEditPanel;
    }

    private JPanel setStartDate() {
        JPanel datePanel = new JPanel(new BorderLayout());
        datePanel.setMinimumSize(new Dimension(150, 40));
        datePanel.setPreferredSize(new Dimension(150, 40));
        datePanel.setMaximumSize(new Dimension(150, 40));
        datePanel.setBackground(new Color(49, 51, 53));

        JLabel startDate = new JLabel("Start Date");
        startDate.setForeground(Color.WHITE);
        startDate.setPreferredSize(new Dimension(60, 20));
        startDate.setHorizontalAlignment(JLabel.LEFT);
        startDate.setBackground(new Color(0, 0, 0, 0));

        JPanel dateEditPrint = new JPanel(new BorderLayout());
        dateEditPrint.setMinimumSize(new Dimension(150, 20));
        dateEditPrint.setPreferredSize(new Dimension(150, 20));
        dateEditPrint.setMaximumSize(new Dimension(150, 20));
        dateEditPrint.setBackground(new Color(0, 0, 0, 0));


        startDatePrint.setText(task.start_Date);
        startDatePrint.setHorizontalAlignment(JTextField.CENTER);
        startDatePrint.setPreferredSize(new Dimension(120, 20));

        JButton calendarChoice = new JButton();
        calendarChoice.setBorder(new EmptyBorder(0, 0, 0, 0));
        calendarChoice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calendarmain c = new Calendarmain(startDatePrint);
                c.setModal(true);
                c.pack();
//                startDatePrint.setText(c.date);
                System.out.println(startDatePrint.getText());

            }
        });
        calendarChoice.setMinimumSize(new Dimension(30, 20));
        calendarChoice.setPreferredSize(new Dimension(30, 20));
        calendarChoice.setMaximumSize(new Dimension(30, 20));

        dateEditPrint.add(startDatePrint);
        dateEditPrint.add(calendarChoice, BorderLayout.EAST);

        datePanel.add(startDate, BorderLayout.NORTH);
        datePanel.add(dateEditPrint, BorderLayout.CENTER);
        return datePanel;
    }

    private JPanel setEndDate() {
        JPanel datePanel = new JPanel(new BorderLayout());
        datePanel.setMinimumSize(new Dimension(150, 40));
        datePanel.setPreferredSize(new Dimension(150, 40));
        datePanel.setMaximumSize(new Dimension(150, 40));
        datePanel.setBackground(new Color(0, 0, 0, 0));

        JLabel endDate = new JLabel("End Date");
        endDate.setForeground(Color.WHITE);
        endDate.setPreferredSize(new Dimension(60, 20));
        endDate.setHorizontalAlignment(JLabel.LEFT);
        endDate.setBackground(new Color(0, 0, 0, 0));

        JPanel dateEditPrint = new JPanel(new BorderLayout());
        dateEditPrint.setBorder(new EmptyBorder(0, 0, 0, 0));
        dateEditPrint.setMinimumSize(new Dimension(150, 20));
        dateEditPrint.setPreferredSize(new Dimension(150, 20));
        dateEditPrint.setMaximumSize(new Dimension(150, 20));


        endDatePrint.setText(task.end_Date);
        endDatePrint.setHorizontalAlignment(JTextField.CENTER);
        endDatePrint.setPreferredSize(new Dimension(120, 20));

        JButton calendarChoice = new JButton();
        calendarChoice.setMinimumSize(new Dimension(30, 20));
        calendarChoice.setPreferredSize(new Dimension(30, 20));
        calendarChoice.setMaximumSize(new Dimension(30, 20));
        calendarChoice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calendarmain c = new Calendarmain(endDatePrint);
                c.setModal(true);
                c.pack();
                endDatePrint.setText(c.date);
            }
        });

        dateEditPrint.add(endDatePrint);
        dateEditPrint.add(calendarChoice, BorderLayout.EAST);

        datePanel.add(endDate, BorderLayout.NORTH);
        datePanel.add(dateEditPrint, BorderLayout.CENTER);
        return datePanel;
    }

    private JPanel setImportance() {
        JPanel importancePanel = new JPanel();
        importancePanel.setMinimumSize(new Dimension(150, 60));
        importancePanel.setPreferredSize(new Dimension(150, 60));
        importancePanel.setMaximumSize(new Dimension(150, 60));
        importancePanel.setBackground(new Color(49, 51, 53));

        importance.setText(task.getImportanceLabel());
        importance.setHorizontalAlignment(JLabel.CENTER);
        importance.setMinimumSize(new Dimension(30, 20));
        importance.setPreferredSize(new Dimension(30, 20));
        importance.setMaximumSize(new Dimension(30, 20));
        importance.setBackground(new Color(200, 200, 200));
        importance.setBorder(new EmptyBorder(0, 0, 0, 0));
        importance.setText(task.getImportanceLabel());

        importanceEditBtn.setLayout(new BorderLayout());
        importanceEditBtn.setMinimumSize(new Dimension(150, 6));
        importanceEditBtn.setPreferredSize(new Dimension(150, 60));
        importanceEditBtn.setMaximumSize(new Dimension(150, 60));
        importanceEditBtn.setBackground(task.getImportanceColor());
        importanceEditBtn.add(importance, BorderLayout.NORTH);
        importanceEditBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JColorChooser importanceColor = new JColorChooser(new Color(192, 224, 230));
                Color selectedColor = JColorChooser.showDialog(null, "", new Color(192, 224, 230));
                importanceColor.getSelectionModel().addChangeListener(new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        Color selectedColor = importanceColor.getColor();
                    }
                });
                if (selectedColor != null) {
                    importanceEditBtn.setBackground(selectedColor);
                }
            }
        });
        importancePanel.add(importanceEditBtn);
        return importancePanel;
    }


    private JPanel setProgressBar() {
        prgBar.setMinimumSize(new Dimension(40, 170));
        prgBar.setPreferredSize(new Dimension(40, 170));
        prgBar.setMaximumSize(new Dimension(40, 170));
        return prgBar;
    }

    private JPanel setContentEditPanel() {
        JPanel contentEdit = new JPanel(new BorderLayout());
        contentEdit.setMinimumSize(new Dimension(360, 60));
        contentEdit.setPreferredSize(new Dimension(360, 60));
        contentEdit.setMaximumSize(new Dimension(360, 160));
        contentEdit.setBackground(new Color(0, 0, 0, 0));

        JLabel content = new JLabel("Content");
        content.setPreferredSize(new Dimension(60, 20));
        content.setForeground(Color.WHITE);
        content.setHorizontalAlignment(JLabel.LEFT);

        String contentStr = task.getContent().replaceAll("_", "\n");
        contentInsert.setColumns(35);
        contentInsert.insert(contentStr, contentInsert.getCaretPosition());
        contentInsert.setForeground(Color.WHITE);
        contentInsert.setCaretColor(Color.WHITE);
        contentInsert.setAutoscrolls(true);
        contentInsert.setMinimumSize(new Dimension(360, 60));
        contentInsert.setPreferredSize(new Dimension(360, 60));
        contentInsert.setMaximumSize(new Dimension(360, 60));
        contentInsert.setBackground(new Color(43, 43, 43));
        contentInsert.setBorder(new EmptyBorder(0, 0, 0, 0));

        contentEdit.add(content, BorderLayout.NORTH);
        contentEdit.add(contentInsert);

        return contentEdit;
    }

    private JPanel setSaveCancBtn() {
        JPanel savePanel = new JPanel();
        savePanel.setMinimumSize(new Dimension(360, 50));
        savePanel.setPreferredSize(new Dimension(360, 50));
        savePanel.setMaximumSize(new Dimension(360, 50));
        savePanel.setBackground(new Color(0, 0, 0, 0));

        JButton saveBtn = new JButton("Save");
        saveBtn.setPreferredSize(new Dimension(80, 30));
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Scanner scan = new Scanner(
                        nameInsert.getText() + "\n" +
                                tagInsert.getText() + " -\n" +
                                startDatePrint.getText() + "\n" +
                                endDatePrint.getText() + "\n" +
                                "다시쓰기" + "\n" +
                                contentInsert.getText().replaceAll("\n", "_")
                );
                task.setName(scan);
                while (task.setTag(scan)) {
                }
                task.setDate(scan);
                task.setImportance(importance.getText(), importanceEditBtn.getBackground());
                task.setProgressPercent(prgBar.getValue());
                task.setContent(scan);

                Dashboard.classify();
                Dashboard.delDashboard();
                Dashboard.genDashBoard();
            }
        });

        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.setPreferredSize(new Dimension(80, 30));
        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameInsert.setText(task.getName());
                tagInsert.setText(task.getTag().replaceAll(" ", "\n"));
                startDatePrint.setText(task.start_Date);
                endDatePrint.setText(task.end_Date);
                importance.setText(task.getImportanceLabel());
                importanceEditBtn.setBackground(task.getImportanceColor());
                prgBar.setValue(task.getProgressPercent());
                contentInsert.setText(task.getContent().replaceAll("_", "\n"));
                detail.dispose();
            }
        });


        savePanel.add(saveBtn);
        savePanel.add(cancelBtn);

        return savePanel;
    }
}
