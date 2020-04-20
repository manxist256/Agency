import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Stage;
import lombok.Data;
import modules.DataEntryModule;
import providers.MainViewProvider;
import views.MainView;

@Data
public class DataEntryApplication {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(Stage.PRODUCTION,
                new DataEntryModule());
        MainView mainView = injector.getInstance(MainView.class);
        MainViewProvider mainViewProvider = injector.getInstance(MainViewProvider.class);
        mainViewProvider.setMainView(mainView);
        mainView.showView();
    }

}
