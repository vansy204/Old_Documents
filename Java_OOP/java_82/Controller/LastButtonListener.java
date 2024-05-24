package java_82.Controller;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;

import java_82.Model.LastButtonModel;
import java_82.View.LastButtonView;

public class LastButtonListener implements Action{
    private LastButtonView lbv;
    public LastButtonListener(LastButtonView lbv) {
        this.lbv = lbv;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if(src.equals("1")){
            lbv.changeTo_1();
        }else if(src.equals("2")){
            lbv.changeTo_2();
        }else if(src.equals("3")){
            lbv.changeTo_3();
        }else if(src.equals("4")){
            lbv.changeTo_4();
        }
    }

    @Override
    public Object getValue(String key) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getValue'");
    }

    @Override
    public void putValue(String key, Object value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'putValue'");
    }

    @Override
    public void setEnabled(boolean b) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setEnabled'");
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEnabled'");
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addPropertyChangeListener'");
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removePropertyChangeListener'");
    }
    
}
