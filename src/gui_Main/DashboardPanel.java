package gui_Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dashboard.Dashboard;
import dashboard.Schedule;
import mgr.Manager;

public class DashboardPanel extends JPanel implements ActionListener, ListSelectionListener {
    public DashboardPanel() {
        super(new BorderLayout());
        setSize(new Dimension(1400, 800));
        setBackground(new Color(25, 25, 25, 255));
        setSearchArea(new SearchPanel());

        makeSchedulePanel(Dashboard.scheduleMgr);
        JPanel div = new JPanel();
        div.setPreferredSize(new Dimension(1400, 80));
        div.setBackground(new Color(25, 25, 25, 255));
        add(div, BorderLayout.SOUTH);
    }

    private void setSearchArea(JPanel searchPanel) {

        JPanel searchArea = new JPanel();
        searchArea.setLayout(new BorderLayout());
        searchArea.setSize(new Dimension(1400, 50));
        searchArea.setBackground(new Color(0, 0, 0, 0));
        searchArea.add(searchPanel, BorderLayout.EAST);
        add(searchArea, BorderLayout.NORTH);
    }

    private void makeSchedulePanel(Manager scheduleMgr) {
        JPanel schedulePanel = new JPanel();
        schedulePanel.setLayout(new BoxLayout(schedulePanel, BoxLayout.X_AXIS));
        schedulePanel.setBackground(new Color(0, 0, 0, 0));
        schedulePanel.setMinimumSize(new Dimension(1400, 600));
        schedulePanel.setPreferredSize(new Dimension(1400, 600));
        schedulePanel.setMaximumSize(new Dimension(1400, 600));
        schedulePanel.setBackground(new Color(0, 0, 0, 0));
        for (Schedule s : Dashboard.scheduleMgr.mList) {
            schedulePanel.add(Box.createRigidArea(new Dimension(10, 0)));
            schedulePanel.add(new SchedulePanel(s));
            schedulePanel.add(Box.createRigidArea(new Dimension(10, 0)));
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
