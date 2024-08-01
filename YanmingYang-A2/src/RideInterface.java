public interface RideInterface {
    /**
     * Used to add visitors to the queue. It has a parameter of type Visitor
     * @param visitor
     */
    void addVisitorToQueue(Visitor visitor);

    /**
     * Used to remove a guest from the queue. It has a parameter of type Visitor
     * @param visitor
     */
    void removeVisitorFromQueue(Visitor visitor);

    /**
     * Used to print a list of visitors waiting in the queue
     */
    void printQueue();

    /**
     * A cycle used to run the ride
     */
    void runOneCycle();

    /**
     * Used to print a list of visitors to the ride
     */
    void printRideHistory();
}
