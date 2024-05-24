package java_85.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java_85.Controller.TimKiemListener;
import java_85.Model.TimKiemModel;

public class TimKiemView extends JFrame {
    private JButton thongKeButton;
    private JPanel outputPanel;
    private JLabel vanBanLabel;
    private JLabel tuKhoaLabel;
    private JLabel ketQuaLabel;
    private JTextField inputTuKhoaField;
    private TimKiemModel timKiemModel;
    private JTextArea vanBanArea;
    TimKiemListener tkl = new TimKiemListener(this);
    public TimKiemView() throws HeadlessException{
        timKiemModel = new TimKiemModel();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } catch (Exception e) {
            e.printStackTrace();
        }
        init();
    }
    public void init(){
        this.setTitle("Tim Kiem");
        this.setSize(500,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        setInputPanel();
        setOutputPanel();
        this.setVisible(true);
    }
    public void setJlabelVanBan(){
        Font font = new Font("Arial", Font.BOLD, 20);
        vanBanLabel = new JLabel("Văn bản");
        vanBanLabel.setFont(font);
        vanBanArea = new JTextArea(300,300);
        vanBanArea.setFont(font);
    }
    public void setTuKhoa(){
        
        inputTuKhoaField = new JTextField();
        tuKhoaLabel = new JLabel("từ khóa");
        Font font = new Font("Arial", Font.BOLD, 20);
        inputTuKhoaField.setFont(font);
        tuKhoaLabel.setFont(font);
        tuKhoaLabel.setBackground(Color.ORANGE);
        tuKhoaLabel.setOpaque(true);
        
    }
    public void setInputPanel(){
        setJlabelVanBan();
        this.add(vanBanLabel,BorderLayout.NORTH);
        this.add(vanBanArea,BorderLayout.CENTER);
        
    }
    public void setButton(){
        thongKeButton = new JButton("Thống kê");
        Font font = new Font("Arial", Font.BOLD, 20);
        thongKeButton.setFont(font);
        thongKeButton.addActionListener(tkl);
        thongKeButton.setBackground(Color.pink);
        thongKeButton.setBorderPainted(false);
    }
    public void setKetQuaLabel(){
        ketQuaLabel = new JLabel();
        Font font = new Font("Arial", Font.BOLD, 20);
        ketQuaLabel.setText(this.timKiemModel.getKetQua());
        ketQuaLabel.setFont(font);
    }
    public void setOutputPanel(){
        setButton();
        setKetQuaLabel();
        setTuKhoa();
        outputPanel = new JPanel(new GridLayout(2,2,20,20));
        outputPanel.add(tuKhoaLabel);
        outputPanel.add(inputTuKhoaField);
        outputPanel.add(thongKeButton);
        outputPanel.add(ketQuaLabel);
        this.add(outputPanel,BorderLayout.SOUTH);
    }
    public void timKiem(){
        this.timKiemModel.setVanBan(vanBanArea.getText());
        this.timKiemModel.setTuKhoa(inputTuKhoaField.getText());
        this.timKiemModel.timKiem();
        this.ketQuaLabel.setText(this.timKiemModel.getKetQua());
    }
}
