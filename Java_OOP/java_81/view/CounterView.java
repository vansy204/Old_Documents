package java_81.view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java_81.controller.CounterListener;
import java_81.model.CounterModel;

public class CounterView extends JFrame {
    private CounterModel counterModel;
    private JButton jButton_Up;
    private JButton jButton_Down;
    private JButton jButton_Reset;
    private JLabel jLabel_val;

    public CounterView() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } catch (Exception e) {
            e.printStackTrace();
        }
        this.counterModel = new CounterModel();
        this.init();
        this.setVisible(true);
    }

    public void init() {
        this.setTitle("Counter");
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener ac = new CounterListener(this);

        jButton_Up = new JButton("Up");
        jButton_Up.addActionListener(ac);
        jButton_Down = new JButton("Down");
        jButton_Down.addActionListener(ac);
        jButton_Reset = new JButton("Reset");
        jButton_Reset.addActionListener(ac);
        jLabel_val = new JLabel(this.counterModel.getVal() + "", JLabel.CENTER);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        jPanel.add(jButton_Up, BorderLayout.WEST);
        jPanel.add(jLabel_val, BorderLayout.CENTER);
        jPanel.add(jButton_Down, BorderLayout.EAST);
        jPanel.add(jButton_Reset, BorderLayout.SOUTH);
        this.setLayout(new BorderLayout());
        this.add(jPanel, BorderLayout.CENTER);
    }

    public void incresment() {
        this.counterModel.incresment();
        this.jLabel_val.setText(this.counterModel.getVal() + "");
    }

    public void decrement() {
        this.counterModel.decrement();
        this.jLabel_val.setText(this.counterModel.getVal() + "");
    }

    public void reset() {
        this.counterModel.reset();
        this.jLabel_val.setText(this.counterModel.getVal() + "");
    }
}
