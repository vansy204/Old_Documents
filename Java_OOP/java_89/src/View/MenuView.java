package View;

import Controller.MenuController;

import javax.swing.*;
import java.awt.*;

public class MenuView extends JFrame {
    private JMenuBar jMenuBar;
    private JMenu jMenuFile ;
    private JMenu jMenuHelp;
    private JMenuItem jMenuItemOpen;
    private JMenuItem jMenuItemExit;
    private JMenuItem jMenuItemWellcome;
    private JLabel jLabel;
    private MenuController menuController;
    public MenuView(){
        this.setTitle("Menu Example");
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        menuController = new MenuController(this);
        jMenuBar = new JMenuBar();
        jMenuFile = new JMenu("File");
        jMenuItemOpen = new JMenuItem("Open");
        jMenuItemOpen.addActionListener(menuController);
        jMenuItemExit = new JMenuItem("Exit");
        jMenuItemExit.addActionListener(menuController);
        jMenuFile.add(jMenuItemOpen);
        jMenuFile.addSeparator();
        jMenuFile.add(jMenuItemExit);

        jMenuHelp = new JMenu("Help");
        jMenuItemWellcome = new JMenuItem("Wellcome");
        jMenuItemWellcome.addActionListener(menuController);
        jMenuHelp.add(jMenuItemWellcome);

        jMenuBar.add(jMenuFile);
        jMenuBar.add(jMenuHelp);
        this.setJMenuBar(jMenuBar);

        Font font = new Font("Arial",Font.BOLD,15);
        jLabel = new JLabel();

        this.setLayout(new BorderLayout());
        this.add(jLabel,BorderLayout.CENTER);
        this.setVisible(true);
    }
    public void setTextJlable(String s){
        this.jLabel.setText(s);
    }
}
