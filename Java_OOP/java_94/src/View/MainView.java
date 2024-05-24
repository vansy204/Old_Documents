package View;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class MainView extends JFrame {
    JMenu menu,submenu;
    JMenuItem i1,i2,i3,i4,i5;
    JMenuBar mb = new JMenuBar();
    private JButton jButton;
    private JLabel jLabel;

    public MainView() throws HeadlessException {
        this.setTitle("TITV");
        this.setSize(600,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        setMenuBar();
        jLabel = new JLabel();
        jLabel.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("1.jpg "))));
        jButton = new JButton("TEST BUTTON");

        jButton.setFont(new Font("Arial",Font.BOLD,50));
        jButton.setSize(50,50);
        jButton.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("button.png"))));
        setIcon();
        this.add(jLabel,BorderLayout.CENTER);
        this.add(jButton,BorderLayout.SOUTH);
        this.setVisible(true);

    }
    // set cho Jframe
    public void setIcon(){
        URL urlIconNotepad = MainView.class.getResource("notepad.png");
        Image img = Toolkit.getDefaultToolkit().createImage(urlIconNotepad);
        this.setIconImage(img);
    }
    public void setMenuBar(){
        Font font = new Font("Timenew Roman",Font.BOLD,15);
        menu = new JMenu("Menu");
        menu.setFont(font);
        submenu = new JMenu("Submenu");
        submenu.setFont(font);
        i1 = new JMenuItem("new");
        i1.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("new.24.png"))));
        i1.setFont(font);
        i2 = new JMenuItem("save");
        i2.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("save.png"))));
        i2.setFont(font);
        i3 = new JMenuItem("save as");
        i3.setFont(font);
        i4 = new JMenuItem("exit");
        i4.setFont(font);
        i4.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("exit.png"))));
        i5 = new JMenuItem("test");
        i5.setFont(font);
        submenu.add(i4);
        submenu.add(i5);
        menu.add(i1);
        menu.add(i2);
        menu.add(i3);
        menu.add(submenu);
        mb.add(menu);
        this.setJMenuBar(mb);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new MainView();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
