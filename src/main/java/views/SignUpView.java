package views;

import com.google.inject.Inject;
import constants.DataEntryConstants;
import properties.ViewProperties;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

import static constants.DataEntryConstants.PANEL_HEIGHT;
import static constants.DataEntryConstants.PANEL_WIDTH;

public class SignUpView extends View {

    private ViewProperties viewProperties;

    private JTextField yourName;
    private JTextField userName;
    private JTextField password;

    @Inject
    public SignUpView(ViewProperties viewProperties) {
        this.viewProperties = viewProperties;
        this.setPreferredSize(new Dimension(DataEntryConstants.PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(viewProperties.getColor());
        this.setLayout(null);
        initializeInstances();
        addProperties();
        addComponents();
    }

    private void initializeInstances() {
        yourName = new JTextField("Hello");
        userName = new JTextField("Boom");
        password = new JTextField();
    }

    private void addProperties() {
        userName.setBounds((PANEL_WIDTH / 2) - (PANEL_WIDTH / 7), PANEL_HEIGHT / 2, (PANEL_WIDTH / 5), (PANEL_HEIGHT / 20));
        userName.setBorder( new MatteBorder(0, 0, 1, 0, Color.black));
    }

    private void addComponents() {
        this.add(userName);
    }

    @Override
    public void showView() {
        this.setVisible(true);
    }

    @Override
    public void hideView() {
        this.setVisible(false);
    }

    @Override
    public void back() {

    }
}
