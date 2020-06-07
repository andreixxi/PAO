package app.model;

public class Organiser extends Person {

    private float eventBudget;

    public Organiser() {
        this.eventBudget = 0;
    }

    public Organiser(String name, float eventBudget) {
        super(name);
        this.eventBudget = eventBudget;
    }

    public float getEventBudget() {
        return eventBudget;
    }

    public void setEventBudget(float eventBudget) {
        this.eventBudget = eventBudget;
    }

    @Override
    public String toString() {
        return super.toString() + " eventBudget= " + eventBudget ;
    }
}
