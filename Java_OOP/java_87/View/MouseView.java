package java_87.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java_87.Controller.MouseController;
import java_87.Model.MouseModel;

public class MouseView  extends JFrame{
    private MouseModel model;
    private JPanel jPanel_Mouse;
    private JPanel jPanel_infor;
    private JLabel jLabel_position;
    private JLabel jLabel_x;
    private JLabel jLabel_y;
    private JLabel jLabel_count;
    private JLabel jLabel_count_value;
    private JLabel jLabel_empty_1;
    private JLabel jLabel_check_in;
    private JLabel jLabel_check_in_value;
    private JLabel jLabel_empty_2;
    private MouseController MSC;
    Font font = new Font("Arial", Font.BOLD, 17);
    public MouseView() throws HeadlessException{
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        init();
    }
    public void init(){
        this.setTitle("Mouse Click");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,300);
        this.setLocationRelativeTo(null);
        model = new MouseModel();    
        this.setLayout(new BorderLayout());
        setPanelMouse();
        setPanelInfor();
        this.setVisible(true);   
    }
    public void setPanelMouse(){
        jPanel_Mouse = new JPanel();
        jPanel_Mouse.setBackground(Color.cyan);
        MSC = new MouseController(this);
        jPanel_Mouse.addMouseListener(MSC);
        jPanel_Mouse.addMouseMotionListener(MSC);
        this.add(jPanel_Mouse,BorderLayout.CENTER);
    }
    public void setPanelInfor(){
        jPanel_infor = new JPanel(new GridLayout(3,3));
        jLabel_position = new JLabel("Position");
        jLabel_position.setFont(font);
        jLabel_x = new JLabel("x= ");
        jLabel_x.setFont(font);
        jLabel_y = new JLabel("y= ");
        jLabel_y.setFont(font);
        jLabel_count = new JLabel("Number of click: ");
        jLabel_count.setFont(font);
        jLabel_count_value = new JLabel(this.model.getCount()+"");
        jLabel_count_value.setFont(font);
        jLabel_empty_1 = new JLabel();
        jLabel_check_in = new JLabel("Mouse is in component: ");
        jLabel_check_in.setFont(font);
        jLabel_check_in_value = new JLabel("No");
        jLabel_check_in_value.setFont(font);
        jLabel_empty_2 = new JLabel();
        jPanel_infor.add(jLabel_position);
        jPanel_infor.add(jLabel_x);
        jPanel_infor.add(jLabel_y);
        jPanel_infor.add(jLabel_count);
        jPanel_infor.add(jLabel_count_value);
        jPanel_infor.add(jLabel_empty_1);
        jPanel_infor.add(jLabel_check_in);
        jPanel_infor.add(jLabel_check_in_value);
        jPanel_infor.add(jLabel_empty_2);
        this.add(jPanel_infor,BorderLayout.SOUTH);
    }
    public void click(){
        this.model.addClick();
        this.jLabel_count_value.setText(this.model.getCount()+"");
    }
    public void enter(){
        this.model.enter();
        this.jLabel_check_in_value.setText(this.model.getCheckIn());
    }
    public void exit(){
        this.model.exit();
        this.jLabel_check_in_value.setText(this.model.getCheckIn());
    }
    public void update(int x,int y){
        this.model.setX(x);
        this.model.setY(y);
        jLabel_x.setText(this.model.getX()+"");
        jLabel_y.setText(this.model.getY() +"");
    }
}
