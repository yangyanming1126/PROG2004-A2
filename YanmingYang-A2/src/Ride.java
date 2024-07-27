import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Ride implements RideInterface {
    private String name;
    private int capacity;
    private Employee operator;
    private Queue<Visitor> visitorQueue;
    private LinkedList<Visitor> rideHistory;
    private int maxRider; // 每个周期最多可以容纳的游客数
    private int numOfCycles; // 游乐设施运行的次数

    public Ride() {
        visitorQueue = new LinkedList<>();
        rideHistory = new LinkedList<>();
        maxRider = 1; // 默认值
        numOfCycles = 0; // 初始值
    }

    public Ride(String name, int capacity, Employee operator) {
        this.name = name;
        this.capacity = capacity;
        this.operator = operator;
        this.visitorQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRider = capacity;
        this.numOfCycles = 0;
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
        int riders = Math.min(maxRider, visitorQueue.size());
        System.out.println("Running one cycle with " + riders + " visitors.");
        for (int i = 0; i < riders; i++) {
            Visitor visitor = visitorQueue.poll();
            rideHistory.add(visitor);
        }
        numOfCycles++;
        System.out.println("The ride has completed " + numOfCycles + " cycles.");
    }

    @Override
    public void printRideHistory() {
        System.out.println("Visitors who have taken the ride:");
        Iterator<Visitor> iterator = rideHistory.iterator();
        while (iterator.hasNext()) {
            Visitor visitor = iterator.next();
            System.out.println(visitor.getName());
        }
    }

    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor);
        System.out.println("Visitor " + visitor.getName() + " has been added to the ride history.");
    }

    public boolean isVisitorInHistory(Visitor visitor) {
        boolean exists = rideHistory.contains(visitor);
        if (exists) {
            System.out.println("Visitor " + visitor.getName() + " is in the ride history.");
        } else {
            System.out.println("Visitor " + visitor.getName() + " is not in the ride history.");
        }
        return exists;
    }

    public int getNumberOfVisitorsInHistory() {
        int count = rideHistory.size();
        System.out.println("There are " + count + " visitors in the ride history.");
        return count;
    }

    public void sortRideHistory() {
        Collections.sort(rideHistory, new VisitorComparator());
        System.out.println("Ride history has been sorted.");
    }

    // 新增的方法：将所有游客详细信息写入文件
    public void exportVisitorsToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Visitor visitor : rideHistory) {
                writer.write(visitor.getName() + "," + visitor.getAge() + "," + visitor.getAddress() + "," +
                        visitor.getTicketType() + "," + visitor.isHasVIPAccess());
                writer.newLine();
            }
            System.out.println("Visitor details have been exported to " + filename);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
