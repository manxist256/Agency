package views.navs;

import com.google.inject.Inject;
import constants.DataEntryConstants;
import properties.NavViewProperties;
import views.View;

import java.awt.*;

public class MainNav extends View {

    private final NavViewProperties navViewProperties;

    @Inject
    public MainNav(NavViewProperties navViewProperties) {
        this.navViewProperties = navViewProperties;
        this.setPreferredSize(new Dimension((int)(DataEntryConstants.SCREEN_DIMENSION.getWidth() / 10 * 1.8), (int)DataEntryConstants.SCREEN_DIMENSION.getHeight()));
        this.setBackground(navViewProperties.getColor());
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