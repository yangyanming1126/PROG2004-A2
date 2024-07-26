import java.util.LinkedList;
import java.util.Queue;

public class Ride implements RideInterface {
    private String name;
    private int capacity;
    private Employee operator;
    private Queue<Visitor> visitorQueue;
    private LinkedList<Visitor> rideHistory;

    public Ride() {
        visitorQueue = new LinkedList<>();
        rideHistory = new LinkedList<>();
    }

    public Ride(String name, int capacity, Employee operator) {
        this.name = name;
        this.capacity = capacity;
        this.operator = operator;
        this.visitorQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Employee getOperator() {
        return operator;
    }

    public void setOperator(Employee operator) {
        this.operator = operator;
    }

    public void assignOperator(Employee operator) {
        this.operator = operator;
        System.out.println("Operator " + operator.getName() + " has been assigned to the ride " + this.name);
    }

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        visitorQueue.add(visitor);
        System.out.println("Visitor " + visitor.getName() + " has been added to the queue.");
    }

    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        if (visitorQueue.remove(visitor)) {
            System.out.println("Visitor " + visitor.getName() + " has been removed from the queue.");
        } else {
            System.out.println("Visitor " + visitor.getName() + " is not in the queue.");
        }
    }

    @Override
    public void printQueue() {
        System.out.println("Current visitors in queue:");
        for (Visitor visitor : visitorQueue) {
            System.out.println(visitor.getName());
        }
    }

    @Override
    public void runOneCycle() {
        if (operator == null) {
            System.out.println("No operator assigned to the ride. Cannot run the ride.");
            return;
        }
        if (visitorQueue.isEmpty()) {
            System.out.println("No visitors in the queue. Cannot run the ride.");
            return;
        }
        int riders = Math.min(capacity, visitorQueue.size());
        System.out.println("Running one cycle with " + riders + " visitors.");
        for (int i = 0; i < riders; i++) {
            Visitor visitor = visitorQueue.poll();
            rideHistory.add(visitor);
        }
    }

    @Override
    public void printRideHistory() {
        System.out.println("Visitors who have taken the ride:");
        for (Visitor visitor : rideHistory) {
            System.out.println(visitor.getName());
        }
    }
}

