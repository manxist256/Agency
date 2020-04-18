package views;

import com.google.inject.Inject;
import constants.DataEntryConstants;
import lombok.Getter;
import properties.NavViewProperties;
import properties.ViewProperties;

import javax.inject.Named;
import javax.swing.*;

import java.awt.*;

import static constants.DataEntryConstants.*;

@Getter
public class MainView extends JFrame implements IMainView {

    private View leftPane;
    private View currentView;
    private View nextView;
    private NavViewProperties navViewProperties;
    private ViewProperties viewProperties;

    @Inject
    public MainView(@Named(NAV_BAR_MAIN) View leftPane, @Named(WELCOME_SCREEN) View nextView, @Named(LOGIN_WINDOW)
            View currentView, NavViewProperties navViewProperties, ViewProperties viewProperties) {
        this.leftPane = leftPane;
        this.nextView = nextView;
        this.currentView = currentView;
        this.navViewProperties = navViewProperties;
        this.viewProperties = viewProperties;

        setResizable(false);
        setSize((int) DataEntryConstants.SCREEN_DIMENSION.getWidth(), (int)DataEntryConstants.SCREEN_DIMENSION.getHeight());
        addPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void addPanel() {
        showable(leftPane, BorderLayout.CENTER);
        showable(currentView, BorderLayout.EAST);
    }

    @Override
    public void showable(View component, Object constraints) {
        this.add(component, constraints);
        component.showView();
    }

    @Override
    public void hideable(View component) {
        component.hideView();;
    }

    @Override
    public void showView() {
        this.setVisible(true);
    }

    @Override
    public void hideView() {
        this.setVisible(false);
    }

    public void forward() {
        this.add(getNextView());
        getNextView().showView();
        hideView();
    }

    public void back() {
        throw new UnsupportedOperationException("Can't go back as this is main screen");
    }
}
