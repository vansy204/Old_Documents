package Controller;

import View.PhimTatView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PhimTatController implements ActionListener {
    private PhimTatView phimTatView;

    public PhimTatController(PhimTatView phimTatView) {
        this.phimTatView = phimTatView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String button = e.getActionCommand();
        if(button.equals("Exit")){
            System.exit(0);
        }else if(button.equals("Toolbar")){
            AbstractButton checkBox = (AbstractButton) e.getSource();
            boolean check = checkBox.getModel().isSelected();
            if(check){
                this.phimTatView.enableToolbar();
            }else{
                this.phimTatView.disableToolbar();
            }
        }else{
            this.phimTatView.setTextJlable("Bạn đã click: " + button);
        }

    }
}
