import java.io.*;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Rides
 */
public class Ride implements RideInterface {
    private String name;//The name of the ride
    private int capacity;//capacity
    private Employee operator; //The operator responsible for the operation

    private boolean isOpen;//Whether the rides are open or not

    private Queue<Visitor> visitorQueue;//Queue of tourists
    private LinkedList<Visitor> rideHistory;//Store visitors who have already ridden
    private int maxRider; // The maximum number of guests that can be accommodated per cycle, with a minimum of 1 visitor required to run the ride
    private int numOfCycles; // The number of times the ride was run
    private final ReentrantLock lock = new ReentrantLock(); // A lock used to protect rideHistory

    public Ride() {
        visitorQueue = new LinkedList<>();
        rideHistory = new LinkedList<>();
        maxRider = 1; // Default value
        numOfCycles = 0; // Initial value
    }


    public Ride(String name, int capacity, Employee operator) {
        this.name = name;
        this.capacity = capacity;
        this.operator = operator;

        this.isOpen = true;//Open by default
        this.visitorQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRider = capacity;
        this.numOfCycles = 0;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public Queue<Visitor> getVisitorQueue() {
        return visitorQueue;
    }

    public void setVisitorQueue(Queue<Visitor> visitorQueue) {
        this.visitorQueue = visitorQueue;
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


    /**
     * Used to add visitors to the queue
     * @param visitor
     */
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

    /**
     * Used to print the details of all visitors in the queue in the order in which they joined
     */
    @Override
    public void printQueue() {
        System.out.println("Current visitors in queue:");
        for (Visitor visitor : visitorQueue) {
            System.out.println(visitor);
        }
    }


    /**
     * If no operator is assigned to the ride, the ride will not run and a message will be printed.
     * If there are no waiting guests in the queue, the ride will not run and a message will be printed.
     * If the rides can be run
     * Then separate the people waiting in the visitorQueue and put them in rideHistory
     */
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
        lock.lock(); // Locking
        try {
            for (int i = 0; i < riders; i++) {
                Visitor visitor = visitorQueue.poll();
                rideHistory.add(visitor);
            }
        } finally {
            lock.unlock(); // Unlock
        }
        numOfCycles++;
        System.out.println("The ride has completed " + numOfCycles + " cycles.");
    }

    @Override
    public void printRideHistory() {
        System.out.println("Visitors who have taken the ride:");
        lock.lock(); // Locking
        try {
            Iterator<Visitor> iterator = rideHistory.iterator();
            while (iterator.hasNext()) {
                Visitor visitor = iterator.next();
                System.out.println(visitor);
            }
        } finally {
            lock.unlock(); // Unlock
        }
    }

    public void addVisitorToHistory(Visitor visitor) {
        lock.lock(); // Locking
        try {
            rideHistory.add(visitor);
            System.out.println("Visitor " + visitor + " has been added to the ride history.");
        } finally {
            lock.unlock(); // Unlock
        }
    }

    public boolean isVisitorInHistory(Visitor visitor) {
        lock.lock(); // Locking
        try {
            boolean exists = rideHistory.contains(visitor);
            if (exists) {
                System.out.println("Visitor " + visitor.getName() + " is in the ride history.");
            } else {
                System.out.println("Visitor " + visitor.getName() + " is not in the ride history.");
            }
            return exists;
        } finally {
            lock.unlock(); // Unlock
        }
    }

    public int getNumberOfVisitorsInHistory() {
        lock.lock(); // Locking
        try {
            int count = rideHistory.size();
            System.out.println("There are " + count + " visitors in the ride history.");
            return count;
        } finally {
            lock.unlock(); // Unlock
        }
    }

    public void sortRideHistory() {
        lock.lock(); // Locking
        try {
            Collections.sort(rideHistory, new VisitorComparator());
            System.out.println("Ride history has been sorted.");
        } finally {
            lock.unlock(); // Unlock
        }
    }

    public void exportVisitorsToFile(String filename) {
        lock.lock(); // Locking
        try {
            // Get the file object
            File file = new File(filename);
            // Obtain the directory where the file is located
            File parentDir = file.getParentFile();
            // If the directory does not exist, create a directory
            if (parentDir != null && !parentDir.exists()) {
                parentDir.mkdirs();
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (Visitor visitor : rideHistory) {
                    writer.write(visitor.getName() + "," + visitor.getAge() + "," + visitor.getAddress() + "," +
                            visitor.getTicketType() + "," + visitor.isHasVIPAccess());
                    writer.newLine();
                }
                System.out.println("Visitor details have been exported to " + filename);
            }
        }
        catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        } finally {
            lock.unlock(); // Unlock
        }
    }

    public void importVisitorsFromFile(String filename) {
        lock.lock(); // Locking
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String name = parts[0];
                    int age = Integer.parseInt(parts[1]);
                    String address = parts[2];
                    String ticketType = parts[3];
                    boolean hasVIPAccess = Boolean.parseBoolean(parts[4]);
                    Visitor visitor = new Visitor(name, age, address, ticketType, hasVIPAccess);
                    rideHistory.add(visitor);
                }
            }
            System.out.println("Visitor details have been imported from " + filename);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        } finally {
            lock.unlock(); // Unlock
        }
    }
}

