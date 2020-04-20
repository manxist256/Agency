package views.navs;

import com.google.inject.Inject;
import constants.DataEntryConstants;
import properties.NavViewProperties;
import views.View;

import javax.swing.*;
import java.awt.*;

import static constants.DataEntryConstants.NAV_HEIGHT;
import static constants.DataEntryConstants.NAV_WIDTH;
import static constants.DataEntryConstants.Nav.*;

public class MainNav extends View {

    private final NavViewProperties navViewProperties;

    private JLabel mainMenuLabel;
    private JButton purchaseButton;
    private JButton purchaseReports;
    private JButton payment;
    private JButton order;

    @Inject
    public MainNav(NavViewProperties navViewProperties) {
        this.navViewProperties = navViewProperties;
        this.setPreferredSize(new Dimension((int)(DataEntryConstants.SCREEN_DIMENSION.getWidth() / 10 * 1.8), (int)DataEntryConstants.SCREEN_DIMENSION.getHeight()));
        this.setBackground(navViewProperties.getColor());
        this.setLayout(null);
        initializeInstances();
        addProperties();
        addComponents();
    }

    private void initializeInstances() {
        mainMenuLabel = new JLabel(MAIN_MENU);
        purchaseButton = new JButton(PURCHASE);
        purchaseReports = new JButton(PURCHASE_REPORTS);
        payment = new JButton(PAYMENT);
        order = new JButton(ORDER);
    }

    private void addProperties() {
        mainMenuLabel.setBounds(NAV_WIDTH / 5, NAV_HEIGHT / 10, (NAV_WIDTH), NAV_HEIGHT / 20);
        mainMenuLabel.setFont(new Font("Courier", Font.BOLD, NAV_WIDTH / 9));
        mainMenuLabel.setForeground(Color.white.brighter().brighter().brighter());
        purchaseButton.setBounds(NAV_WIDTH / 6, NAV_HEIGHT / 6, (int)(NAV_WIDTH / 1.5), NAV_HEIGHT / 18);
        purchaseButton.setFont(new Font("Courier", Font.BOLD, NAV_WIDTH / 15));
        purchaseReports.setBounds(NAV_WIDTH / 6, NAV_HEIGHT / 6 + NAV_HEIGHT / 18 + 8, (int)(NAV_WIDTH / 1.5), NAV_HEIGHT / 18);
        purchaseReports.setFont(new Font("Courier", Font.BOLD, NAV_WIDTH / 15));
        payment.setBounds(NAV_WIDTH / 6, NAV_HEIGHT / 6 + NAV_HEIGHT / 18 * 2 + 16, (int)(NAV_WIDTH / 1.5), NAV_HEIGHT / 18);
        payment.setFont(new Font("Courier", Font.BOLD, NAV_WIDTH / 15));
        order.setBounds(NAV_WIDTH / 6, NAV_HEIGHT / 6 + NAV_HEIGHT / 18 * 3 + 24, (int)(NAV_WIDTH / 1.5), NAV_HEIGHT / 18);
        order.setFont(new Font("Courier", Font.BOLD, NAV_WIDTH / 15));
    }

    private void addComponents() {
        this.add(mainMenuLabel);
        this.add(purchaseButton);
        this.add(purchaseReports);
        this.add(payment);
        this.add(order);
    }

    @Override
    public void showView() {
        this.setVisible(true);
    }

    @Override
    public void hideView() {

    }

    @Override
    public void back() {

    }
}