package gui;

import javax.swing.*;
import java.awt.*;

public class SearchPanel extends JPanel{
    public SearchPanel(){
        setLayout(new BorderLayout());
        setSize(new Dimension(200, 50));
        setBorder(BorderFactory.createLineBorder(Color.RED));

        JTextField searchField = new JTextField("검색어를 입력하세요.");
        JButton searchButton = new JButton("검색");

        add(searchField, BorderLayout.WEST);
        add(searchButton, BorderLayout.EAST);
    }
}
