package service;

import com.google.inject.Inject;
import views.View;

import java.util.Stack;

public class BackStack {

    private Stack<View> panelStacks;

    private Stack<View> navStacks;

    @Inject
    public BackStack() {
        panelStacks = new Stack<>();
        navStacks = new Stack<>();
    }

    public void addPanelNode(View view) {
        panelStacks.add(view);
    }

    public View panelTop() {
        return panelStacks.pop();
    }

    public void addNavNode(View view) {
        navStacks.add(view);
    }

    public View navTop() {
        return navStacks.pop();
    }

}
