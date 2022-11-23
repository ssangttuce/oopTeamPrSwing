package gui;

import dashboard.Task;

import javax.swing.*;
import java.awt.*;

public class TaskDetailPanel extends JDialog {
    public TaskDetailPanel(Task task) {
        setTitle("일정 상세보기");
        setMinimumSize(new Dimension(340, 292));
        setPreferredSize(new Dimension(340, 292));
        setMaximumSize(new Dimension(340, 292));
        setBackground(new Color(32, 32, 32));

        JPanel detailPanel = new JPanel(new BorderLayout());
        detailPanel.setMinimumSize(new Dimension(340, 260));
        detailPanel.setPreferredSize(new Dimension(340, 260));
        detailPanel.setMaximumSize(new Dimension(340, 260));
        detailPanel.setBackground(new Color(0, 0, 0, 0));

        detailPanel.add(setInfoEditPanel(task), BorderLayout.WEST);



        setContentPane(detailPanel);
    }

    protected JPanel setInfoEditPanel(Task task) {
        JPanel infoEditPanel = new JPanel();
        infoEditPanel.setLayout(new BoxLayout(infoEditPanel, BoxLayout.Y_AXIS));
        infoEditPanel.setMinimumSize(new Dimension(140, 200));
        infoEditPanel.setPreferredSize(new Dimension(140, 200));
        infoEditPanel.setMaximumSize(new Dimension(140, 200));
        infoEditPanel.setBackground(new Color(0, 0, 0, 0));

        infoEditPanel.add(setNameEditPanel(task));
        infoEditPanel.add(setTagEditPanel(task));

        return infoEditPanel;
    }

    private JPanel setNameEditPanel(Task task) {
        JPanel nameEditPanel = new JPanel();
        nameEditPanel.setMinimumSize(new Dimension(140, 50));
        nameEditPanel.setPreferredSize(new Dimension(140, 50));
        nameEditPanel.setMaximumSize(new Dimension(140, 50));
        nameEditPanel.setBackground(new Color(0, 0, 0, 0));

        JLabel name = new JLabel("Name");
        name.setForeground(Color.WHITE);
        name.setHorizontalAlignment(JLabel.LEFT);

        JTextField nameInsert = new JTextField(task.getName(), 12);
        nameInsert.setMinimumSize(new Dimension(140, 30));
        nameInsert.setPreferredSize(new Dimension(140, 30));
        nameInsert.setMaximumSize(new Dimension(140, 30));


        nameEditPanel.add(name);
        nameEditPanel.add(nameInsert);
        return nameEditPanel;
    }

    private JPanel setTagEditPanel(Task task) {
        JPanel tagEditPanel = new JPanel();
        tagEditPanel.setMinimumSize(new Dimension(140, 150));
        tagEditPanel.setPreferredSize(new Dimension(140, 150));
        tagEditPanel.setMaximumSize(new Dimension(140, 150));
        tagEditPanel.setBackground(new Color(0, 0, 0, 0));

        JLabel tag = new JLabel("#Tag");
        tag.setForeground(Color.WHITE);
        tag.setHorizontalAlignment(JLabel.LEFT);


        JTextArea tagInsert = new JTextArea(5, 12);
        tagInsert.setPreferredSize(new Dimension(140, 200));
        String tagString = task.getTag().replaceAll(" ", "\n");
        tagInsert.insert(tagString, tagInsert.getCaretPosition());
        JScrollPane tagScroll = new JScrollPane(tagInsert);
        tagScroll.setPreferredSize(new Dimension(140, 100));
        tagScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        tagScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        tagEditPanel.add(tag);
        tagEditPanel.add(tagScroll);

        return tagEditPanel;
    }

    private JPanel setDateEditPanel(Task task) {
        JPanel dateEditPanel = new JPanel();
        dateEditPanel.setMinimumSize(new Dimension(140, 90));
        dateEditPanel.setPreferredSize(new Dimension(140, 90));
        dateEditPanel.setMaximumSize(new Dimension(140, 90));


        return dateEditPanel;
    }

    protected JPanel setMoreInfoEditPanel(Task task) {
        JPanel moreInfoEditPanel = new JPanel();
        moreInfoEditPanel.setMinimumSize(new Dimension(300, 110));
        moreInfoEditPanel.setPreferredSize(new Dimension(300, 110));
        moreInfoEditPanel.setMaximumSize(new Dimension(300, 110));


        return moreInfoEditPanel;
    }

}
