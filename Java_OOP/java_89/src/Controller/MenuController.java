package Controller;

import View.MenuView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController implements ActionListener {
    private MenuView menuView;

    public MenuController(MenuView menuView) {
        this.menuView = menuView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String button = e.getActionCommand();
        if(button.equals("Open")){
            this.menuView.setTextJlable("Bạn đã click JmenuItem Open");
        }else if(button.equals("Exit")){
            System.exit(0);
        }else if(button.equals("Wellcome")){
            this.menuView.setTextJlable("Bạn đã click jmenuItem Wellcome");
        }
    }
}
