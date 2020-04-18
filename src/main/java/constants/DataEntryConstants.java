package constants;

import java.awt.*;

public class DataEntryConstants {

    public static final Dimension SCREEN_DIMENSION  = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int PANEL_WIDTH = (int)(DataEntryConstants.SCREEN_DIMENSION.getWidth() / 10 * 8.2);
    public static final int PANEL_HEIGHT = (int)DataEntryConstants.SCREEN_DIMENSION.getHeight();

    public static final String NAV_BAR_MAIN = "NAV_BAR_MAIN";
    public static final String WELCOME_SCREEN = "WELCOME_SCREEN";
    public static final String LOGIN_WINDOW = "LOGIN_WINDOW";
    public static final String SIGN_UP_WINDOW = "SIGN_UP_WINDOW";

    public static final String USER_NAME = "UserName";
    public static final String PASSWORD = "Password";
    public static final String PLEASE_LOGIN = "Please login to continue";
    public static final String LOGIN = "LOGIN";
    public static final String CREATE_NEW_ACCOUNT = "Create New Account?";

}
