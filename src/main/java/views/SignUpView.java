package views;

import com.google.inject.Inject;
import constants.DataEntryConstants;
import properties.ViewProperties;
import providers.MainViewProvider;
import service.BackStack;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static constants.DataEntryConstants.*;

public class SignUpView extends View {

    private ViewProperties viewProperties;

    private JLabel yourNameLabel;
    private JLabel userNameLabel;
    private JLabel passwordLabel;
    private String passwordValue;

    private JTextField yourName;
    private JTextField userName;
    private JTextField password;
    private JLabel signUpLabel;
    private JButton signUp;
    private JButton cancelButton;

    private BackStack backStack;

    private MainViewProvider mainViewProvider;

    @Inject
    public SignUpView(ViewProperties viewProperties, BackStack backStack, MainViewProvider mainViewProvider) {
        this.viewProperties = viewProperties;
        this.backStack = backStack;
        this.mainViewProvider = mainViewProvider;
        this.setPreferredSize(new Dimension(DataEntryConstants.PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(viewProperties.getColor());
        this.setLayout(null);
        initializeInstances();
        addProperties();
        addComponents();
        addListeners();
    }

    private void initializeInstances() {
        signUpLabel = new JLabel(DataEntryConstants.PLEASE_ENTER_DETAILS_SIGN_UP);
        yourName = new JTextField();
        userName = new JTextField();
        password = new JTextField();
        signUp = new JButton(SIGN_UP);
        yourNameLabel = new JLabel(NAME);
        passwordLabel = new JLabel(PASSWORD);
        userNameLabel = new JLabel(USER_NAME);
        passwordValue = "";
        cancelButton = new JButton(CANCEL);
    }

    private void addProperties() {
        signUpLabel.setBounds((PANEL_WIDTH / 2) - (PANEL_WIDTH / 3), PANEL_HEIGHT / 5, (PANEL_WIDTH), (PANEL_HEIGHT / 15));
        signUpLabel.setFont(new Font("Courier", Font.BOLD, PANEL_WIDTH / 30));
        yourName.setBounds((PANEL_WIDTH / 2) - (PANEL_WIDTH / 7), PANEL_HEIGHT / 3, (PANEL_WIDTH / 5), (PANEL_HEIGHT / 20));
        yourName.setBorder( new MatteBorder(0, 0, 1, 0, Color.black));
        yourNameLabel.setBounds((PANEL_WIDTH / 2) - (PANEL_WIDTH / 7), PANEL_HEIGHT / 3, (PANEL_WIDTH / 5), (PANEL_HEIGHT / 20));
        userName.setBounds((PANEL_WIDTH / 2) - (PANEL_WIDTH / 7), PANEL_HEIGHT / 3 + (PANEL_HEIGHT / 15), (PANEL_WIDTH / 5), (PANEL_HEIGHT / 20));
        userName.setBorder( new MatteBorder(0, 0, 1, 0, Color.black));
        userNameLabel.setBounds((PANEL_WIDTH / 2) - (PANEL_WIDTH / 7), PANEL_HEIGHT / 3 + (PANEL_HEIGHT / 15), (PANEL_WIDTH / 5), (PANEL_HEIGHT / 20));
        password.setBounds((PANEL_WIDTH / 2) - (PANEL_WIDTH / 7), PANEL_HEIGHT / 3 + (PANEL_HEIGHT / 15) * 2, (PANEL_WIDTH / 5), (PANEL_HEIGHT / 20));
        password.setBorder( new MatteBorder(0, 0, 1, 0, Color.black));
        passwordLabel.setBounds((PANEL_WIDTH / 2) - (PANEL_WIDTH / 7), PANEL_HEIGHT / 3 + (PANEL_HEIGHT / 15) * 2, (PANEL_WIDTH / 5), (PANEL_HEIGHT / 20));
        signUp.setBounds((PANEL_WIDTH / 2) - (PANEL_WIDTH / 7), PANEL_HEIGHT / 3 + (PANEL_HEIGHT / 15) * 3, (PANEL_WIDTH / 5), (PANEL_HEIGHT / 20));
        cancelButton.setBounds((PANEL_WIDTH / 2) - (PANEL_WIDTH / 7), PANEL_HEIGHT / 3 + (PANEL_HEIGHT / 15) * 4, (PANEL_WIDTH / 5), (PANEL_HEIGHT / 20));
    }

    private void addComponents() {
        this.add(signUpLabel);
        this.add(yourNameLabel);
        this.add(userNameLabel);
        this.add(passwordLabel);
        this.add(yourName);
        this.add(userName);
        this.add(password);
        this.add(signUp);
        this.add(cancelButton);
    }

    private void addListeners() {
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainViewProvider.getMainView().hideable(SignUpView.this);
                mainViewProvider.getMainView().showable(backStack.panelTop(), BorderLayout.EAST);
            }
        });
        userName.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                userNameLabel.setText("");
            }
            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) { }
        });
        yourName.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                yourNameLabel.setText("");
            }
            @Override
            public void keyPressed(KeyEvent e) { }
            @Override
            public void keyReleased(KeyEvent e) { }
        });
        password.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) { }
            @Override
            public void keyPressed(KeyEvent e) {
            }

            private void applySecurity() {
                String m = "";
                for (int i = 0; i < passwordValue.length(); i++) {
                    m = m + "*";
                }
                password.setText(m);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (!passwordLabel.getText().equals(""))
                    passwordLabel.setText("");
                int keyCode = e.getKeyCode();
                int c = e.getKeyChar();
                if ((c >= 48 && c <= 57) || (c >= 65 && c <= 90) || (c >= 97 && c <= 122) || (char)c == '@') {
                    passwordValue = passwordValue + e.getKeyChar();
                    applySecurity();
                } else if (keyCode == KeyEvent.VK_BACK_SPACE || keyCode == KeyEvent.VK_DELETE) {
                    if (passwordValue.length() >= 1)
                        passwordValue = passwordValue.substring(0, passwordValue.length() - 1);
                    applySecurity();
                }
            }
        });
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
