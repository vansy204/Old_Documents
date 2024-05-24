package java_85.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java_85.View.TimKiemView;

public class TimKiemListener implements ActionListener{

    TimKiemView timKiemView;
    public TimKiemListener(TimKiemView timKiemView){
        this.timKiemView = timKiemView;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        this.timKiemView.timKiem();
    }
    
}
