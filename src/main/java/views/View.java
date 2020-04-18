package views;

import javax.swing.*;

public abstract class View extends JPanel {

    public abstract void showView();

    public abstract void hideView();

    public abstract void back();
}
