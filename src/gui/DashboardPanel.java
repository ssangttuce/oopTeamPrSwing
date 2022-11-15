package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import dashboard.Dashboard;
import dashboard.Schedule;
import dashboard.Task;
import mgr.Manager;

public class DashboardPanel extends JPanel implements ActionListener, ListSelectionListener {

    private static final long serialVersionUID = 1L;


    public DashboardPanel() {
//        super(new GridBagLayout());
        super(new BorderLayout());
        //GridBagConstraints gbc = new GridBagConstraints();
//        gbc.fill = GridBagConstraints.NONE;
//
//        gbc.weighty = 0.1;
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        add

        setSize(new Dimension(1400, 1200));
        setBackground(Color.GRAY);
        setBorder(BorderFactory.createLineBorder(Color.YELLOW));

        setSearchArea(new SearchPanel());
        makeSchedulePanel(Dashboard.scheduleMgr);
    }

    private void setSearchArea(JPanel searchPanel) {

        JPanel searchArea = new JPanel();
        searchArea.setLayout(new BorderLayout());
        searchArea.setSize(new Dimension(1400, 50));

        searchArea.add(searchPanel, BorderLayout.EAST);
        add(searchArea, BorderLayout.NORTH);
    }

    private void makeSchedulePanel(Manager scheduleMgr) {
        JPanel schedulePanel = new JPanel(new GridLayout(1, scheduleMgr.mList.size()));
        schedulePanel.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        for (Schedule s : Dashboard.scheduleMgr.mList) {
            schedulePanel.add(new SchedulePanel(s));
        }
        add(schedulePanel, BorderLayout.CENTER);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

}
