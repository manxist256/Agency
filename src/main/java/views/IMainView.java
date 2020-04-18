package views;

public interface IMainView {

    void showable(View component, Object constraints);

    void hideable(View component);

    void showView();

    void hideView();

}