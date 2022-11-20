package gui;

import javax.swing.*;
import java.awt.*;

public class SearchPanel extends JPanel{
    public SearchPanel(){
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(240, 40));
        setBackground(new Color(0, 0 ,0, 0));

        JTextField searchField = new JTextField("검색어를 입력하세요.");
        searchField.setPreferredSize(new Dimension(200, 40));

        JButton searchButton = new JButton("검색");
        searchButton.setFont(new Font("search", Font.PLAIN, 10));
        searchButton.setMargin(new Insets(0,0,0,0));
        searchButton.setPreferredSize(new Dimension(40, 40));
        searchButton.setBackground(new Color(191, 246 ,253, 255));

        add(searchField, BorderLayout.CENTER);
        add(searchButton, BorderLayout.EAST);
    }
}
