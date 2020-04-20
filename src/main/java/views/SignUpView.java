package views;

import com.google.inject.Inject;
import constants.DataEntryConstants;
import properties.ViewProperties;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

import static constants.DataEntryConstants.*;

public class SignUpView extends View {

    private ViewProperties viewProperties;

    private JTextField yourName;
    private JTextField userName;
    private JTextField password;
    private JLabel signUpLabel;
    private JButton signUp;

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
        signUpLabel = new JLabel(DataEntryConstants.PLEASE_ENTER_DETAILS_SIGN_UP);
        yourName = new JTextField();
        userName = new JTextField();
        password = new JTextField();
        signUp = new JButton(SIGN_UP);
    }

    private void addProperties() {
        signUpLabel.setBounds((PANEL_WIDTH / 2) - (PANEL_WIDTH / 3), PANEL_HEIGHT / 5, (PANEL_WIDTH), (PANEL_HEIGHT / 15));
        signUpLabel.setFont(new Font("Courier", Font.BOLD, PANEL_WIDTH / 30));
        yourName.setBounds((PANEL_WIDTH / 2) - (PANEL_WIDTH / 7), PANEL_HEIGHT / 3, (PANEL_WIDTH / 5), (PANEL_HEIGHT / 20));
        yourName.setBorder( new MatteBorder(0, 0, 1, 0, Color.black));
        userName.setBounds((PANEL_WIDTH / 2) - (PANEL_WIDTH / 7), PANEL_HEIGHT / 3 + (PANEL_HEIGHT / 15), (PANEL_WIDTH / 5), (PANEL_HEIGHT / 20));
        userName.setBorder( new MatteBorder(0, 0, 1, 0, Color.black));
        password.setBounds((PANEL_WIDTH / 2) - (PANEL_WIDTH / 7), PANEL_HEIGHT / 3 + (PANEL_HEIGHT / 15) * 2, (PANEL_WIDTH / 5), (PANEL_HEIGHT / 20));
        password.setBorder( new MatteBorder(0, 0, 1, 0, Color.black));
        signUp.setBounds((PANEL_WIDTH / 2) - (PANEL_WIDTH / 7), PANEL_HEIGHT / 3 + (PANEL_HEIGHT / 15) * 3, (PANEL_WIDTH / 5), (PANEL_HEIGHT / 20));
    }

    private void addComponents() {
        this.add(signUpLabel);
        this.add(yourName);
        this.add(userName);
        this.add(password);
        this.add(signUp);
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
