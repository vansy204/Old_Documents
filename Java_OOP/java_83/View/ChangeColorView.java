package java_83.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import java_83.Controller.ChangeColorController;
import java_83.Model.ChangeColorModel;

public class ChangeColorView  extends JFrame{
    public ChangeColorModel myChangeColorModel;
    private ChangeColorController ccc = new ChangeColorController(this);
    private JLabel jLabel;
    private JPanel jPanel;

    public ChangeColorView() {
        this.myChangeColorModel = new ChangeColorModel();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } catch (Exception e) {
            e.printStackTrace();
        }
        init();
        
    }
    public void init(){
        this.setTitle("Change Color");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        labelSet();
        panelSet();
        this.setLayout(new BorderLayout());
        this.add(jLabel,BorderLayout.NORTH);
        this.add(jPanel,BorderLayout.CENTER);
        this.setVisible(true);
    }
    public void labelSet(){
        jLabel = new JLabel("TEXT",JLabel.CENTER);
        Font font_text = new Font("Arial", Font.BOLD, 50);
        jLabel.setFont(font_text);
        
    }
    public void panelSet(){
        Font font = new Font("Arial", Font.BOLD, 20);

        jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(2,3));
        JButton jButtonTextRed = new JButton("Red Text");
        jButtonTextRed.setFont(font);
        jButtonTextRed.setForeground(Color.RED);
        jButtonTextRed.addActionListener(ccc);

        JButton jButtonTextYellow = new JButton("Yellow Text");
        jButtonTextYellow.setFont(font);
        jButtonTextYellow.setForeground(Color.YELLOW);
        jButtonTextYellow.addActionListener(ccc);

        JButton jButtonTextBlue = new JButton("Blue Text");
        jButtonTextBlue.setFont(font);
        jButtonTextBlue.setForeground(Color.BLUE);
        jButtonTextBlue.addActionListener(ccc);
        
        JButton jButtonBackgroundRed = new JButton("Red BackGround");
        jButtonBackgroundRed.setFont(font);
        jButtonBackgroundRed.setBackground(Color.RED);
        jButtonBackgroundRed.setBorderPainted(false);
        jButtonBackgroundRed.addActionListener(ccc);

        JButton jButtonBackgroundYellow = new JButton("Yellow BackGround");
        jButtonBackgroundYellow.setFont(font);
        jButtonBackgroundYellow.setBackground(Color.YELLOW);
        jButtonBackgroundYellow.setBorderPainted(false);
        jButtonBackgroundYellow.addActionListener(ccc);

        JButton jButtonBackgroundBlue = new JButton("Blue BackGround");
        jButtonBackgroundBlue.setFont(font);
        jButtonBackgroundBlue.setBackground(Color.BLUE);
        jButtonBackgroundBlue.setBorderPainted(false);
        jButtonBackgroundBlue.addActionListener(ccc);

        jPanel.add(jButtonTextRed);
        jPanel.add(jButtonTextYellow);
        jPanel.add(jButtonTextBlue);
        jPanel.add(jButtonBackgroundRed);
        jPanel.add(jButtonBackgroundYellow);
        jPanel.add(jButtonBackgroundBlue);
    }
    public void changeRedText(){
        this.jLabel.setForeground(Color.RED);
    }
    public void changeYellowText(){
        this.jLabel.setForeground(Color.YELLOW);
    }
    public void changeBlueText(){
        this.jLabel.setForeground(Color.BLUE);
    }
    public void changeBackGroundColor(Color color){
        this.jLabel.setBackground(color);
        this.jLabel.setOpaque(true);
    }
}
