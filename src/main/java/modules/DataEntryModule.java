package modules;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.name.Names;
import constants.DataEntryConstants;
import views.*;
import views.navs.MainNav;

public class DataEntryModule implements Module {
    @Override
    public void configure(Binder binder) {
        binder.bind(View.class).annotatedWith(Names.named(DataEntryConstants.NAV_BAR_MAIN)).to(MainNav.class);
        binder.bind(View.class).annotatedWith(Names.named(DataEntryConstants.WELCOME_SCREEN)).to(WelcomeView.class);
        binder.bind(View.class).annotatedWith(Names.named(DataEntryConstants.LOGIN_WINDOW)).to(LoginView.class);
        binder.bind(View.class).annotatedWith(Names.named(DataEntryConstants.SIGN_UP_WINDOW)).to(SignUpView.class);
        binder.bind(IMainView.class).to(MainView.class);
    }
}
