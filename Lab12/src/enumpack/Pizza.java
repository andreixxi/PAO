package enumpack;

public class Pizza {

    private PizzaStatus pizzaStatus;

    public boolean isDeliverable() {
        if (this.pizzaStatus == PizzaStatus.READY) {
            return true;
        }
        return false;
    }

    public int getTimeOfDeliveryInHours() {
//        switch (pizzaStatus) {
//            case ORDERED: return 2;
//            case READY: return 1;
//            case DELIVERED: return 0;
//        }
//        return 0;
        return pizzaStatus.getHoursToDeliver();
    }

    public enum PizzaStatus {
        ORDERED(2) {
            @Override
            public void abstractMethod() {
                System.out.println("ordered");
            }
        }, READY(1) {
            @Override
            public void abstractMethod() {
                System.out.println("ready");
            }
        }, DELIVERED(0) {
            @Override
            public void abstractMethod() {
                System.out.println("delivered");
            }
        };

        private int hoursToDeliver;

        PizzaStatus(int hoursToDeliver) { // private by default
            this.hoursToDeliver = hoursToDeliver;
        }

        public int getHoursToDeliver() {
            return hoursToDeliver;
        }

        public abstract void abstractMethod();
    }

    public void setPizzaStatus(PizzaStatus pizzaStatus) {
        this.pizzaStatus = pizzaStatus;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "pizzaStatus=" + pizzaStatus +
                '}';
    }
}
