package Controller;

import View.PhimTatView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ChuotPhaiListener implements MouseListener {

    PhimTatView phimTatView;

    public ChuotPhaiListener(PhimTatView phimTatView) {
        this.phimTatView = phimTatView;
    }
    @Override
    public void mousePressed(MouseEvent e) {
        if(e.isPopupTrigger()){
            this.phimTatView.jPopupMenu.show(e.getComponent(),e.getX(),e.getY());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }


    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.isPopupTrigger()){
            this.phimTatView.jPopupMenu.show(e.getComponent(),e.getX(),e.getY());
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
