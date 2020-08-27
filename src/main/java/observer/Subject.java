package observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observerList = new ArrayList<>();
    private int state;
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        // 关键点就在于由改变者来通知所有观察者，而非由观察者进行观察！
        notifyAllObservers();
    }

    public void attach (Observer observer) {
        observerList.add(observer);
    }
    public void notifyAllObservers() {
        for (Observer observer : observerList) {
            observer.update();
        }
    }
}
