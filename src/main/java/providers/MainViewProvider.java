package providers;

import com.google.inject.Inject;
import views.IMainView;

public class MainViewProvider {

    IMainView mainView;

    @Inject
    public MainViewProvider() {

    }

    public void setMainView(IMainView mainView){
        if (this.mainView == null) {
            this.mainView = mainView;
        }
    }

    public IMainView getMainView() {
        return mainView;
    }

}
