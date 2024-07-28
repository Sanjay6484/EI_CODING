import java.util.ArrayList;
import java.util.List;

class Commentary implements Subject {
    private List<Observer> observers;
    private String commentary;
    
    public Commentary() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(commentary);
        }
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
        notifyObservers();
    }
}
