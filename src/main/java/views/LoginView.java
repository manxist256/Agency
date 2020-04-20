package views;

import com.google.inject.Inject;
import constants.DataEntryConstants;
import properties.ViewProperties;
import providers.MainViewProvider;
import service.BackStack;

import javax.inject.Named;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static constants.DataEntryConstants.*;

public class LoginView extends View  {

    private ViewProperties viewProperties;
    private View signUpView;
    private BackStack backStack;

    private MainViewProvider mainViewProvider;

    private JLabel userNameLabel;
    private JTextField userName;
    private JLabel passwordLabel;
    private JTextField password;
    private JButton loginButton;

    private JLabel loginLabel;

    private String passwordValue;

    private JButton createNewAccount;

    @Inject
    public LoginView(ViewProperties viewProperties, @Named(SIGN_UP_WINDOW) View signUpView, BackStack backStack, MainViewProvider mainViewProvider) {
        this.viewProperties = viewProperties;
        this.signUpView = signUpView;
        this.backStack = backStack;
        this.mainViewProvider = mainViewProvider;
        this.setPreferredSize(new Dimension(DataEntryConstants.PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(viewProperties.getColor());
        this.setLayout(null);
        initializeInstances();
        addProperties();
        addComponents();
    }

    private void initializeInstances() {
        userName =  new JTextField();
        password = new JTextField();
        loginButton = new JButton(LOGIN);
        userNameLabel = new JLabel(USER_NAME);
        passwordLabel = new JLabel(PASSWORD);
        passwordValue = "";
        loginLabel = new JLabel(PLEASE_LOGIN);
        createNewAccount = new JButton(DataEntryConstants.CREATE_NEW_ACCOUNT);
        addListeners();
    }

    private void addProperties() {
        userName.setBounds((PANEL_WIDTH / 2) - (PANEL_WIDTH / 7), PANEL_HEIGHT / 2, (PANEL_WIDTH / 5), (PANEL_HEIGHT / 20));
        userName.setBorder( new MatteBorder(0, 0, 1, 0, Color.black));
        userNameLabel.setBounds((PANEL_WIDTH / 2) - (PANEL_WIDTH / 7), PANEL_HEIGHT / 2, (PANEL_WIDTH / 5), (PANEL_HEIGHT / 20));
        password.setBounds((PANEL_WIDTH / 2) - (PANEL_WIDTH / 7), PANEL_HEIGHT / 2 + (PANEL_HEIGHT / 20), (PANEL_WIDTH / 5), (PANEL_HEIGHT / 20));
        password.setBorder( new MatteBorder(0, 0, 1, 0, Color.black));
        passwordLabel.setBounds((PANEL_WIDTH / 2) - (PANEL_WIDTH / 7), PANEL_HEIGHT / 2 + (PANEL_HEIGHT / 20) - 1, (PANEL_WIDTH / 5), (PANEL_HEIGHT / 20));
        loginButton.setBounds((PANEL_WIDTH / 2) - (PANEL_WIDTH / 7), PANEL_HEIGHT / 2 + (PANEL_HEIGHT / 20) * 3, (PANEL_WIDTH / 5), (PANEL_HEIGHT / 20));
        userName.setFont(new Font("Courier", Font.BOLD, 16));
        loginLabel.setBounds((PANEL_WIDTH / 2) - (PANEL_WIDTH / 3), PANEL_HEIGHT / 5, (PANEL_WIDTH), (PANEL_HEIGHT / 15));
        loginLabel.setFont(new Font("Courier", Font.BOLD, PANEL_WIDTH/ 24));
        createNewAccount.setBounds((PANEL_WIDTH / 2) - (PANEL_WIDTH / 7), PANEL_HEIGHT / 2 + (PANEL_HEIGHT / 20) * 4,(PANEL_WIDTH / 5), (PANEL_HEIGHT / 20) );
    }

    private void addListeners() {
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
        createNewAccount.addActionListener((e) -> {
            backStack.addPanelNode(this);
            mainViewProvider.getMainView().hideable(this);
            mainViewProvider.getMainView().showable(signUpView, BorderLayout.EAST);
        });
    }

    private void addComponents() {
        this.add(loginLabel);
        this.add(userNameLabel);
        this.add(userName);
        this.add(passwordLabel);
        this.add(password);
        this.add(loginButton);
        this.add(createNewAccount);
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