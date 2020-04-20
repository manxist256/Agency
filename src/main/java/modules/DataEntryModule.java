package modules;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Singleton;
import com.google.inject.name.Names;
import constants.DataEntryConstants;
import providers.MainViewProvider;
import service.BackStack;
import views.*;
import views.navs.MainNav;

public class DataEntryModule implements Module {
    @Override
    public void configure(Binder binder) {
        binder.bind(View.class).annotatedWith(Names.named(DataEntryConstants.NAV_BAR_MAIN)).to(MainNav.class).in(Singleton.class);
        binder.bind(View.class).annotatedWith(Names.named(DataEntryConstants.WELCOME_SCREEN)).to(WelcomeView.class).in(Singleton.class);
        binder.bind(View.class).annotatedWith(Names.named(DataEntryConstants.LOGIN_WINDOW)).to(LoginView.class).in(Singleton.class);
        binder.bind(View.class).annotatedWith(Names.named(DataEntryConstants.SIGN_UP_WINDOW)).to(SignUpView.class).in(Singleton.class);
        binder.bind(IMainView.class).to(MainView.class).in(Singleton.class);
        binder.bind(BackStack.class).in(Singleton.class);
        binder.bind(MainViewProvider.class).in(Singleton.class);
    }
}
