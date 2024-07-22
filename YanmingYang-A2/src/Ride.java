public class Ride {
    private String name;
    private int capacity;
    private Employee operator;

    public Ride(){
    }

    public Ride(String name, int capacity, Employee operator) {
        this.name = name;
        this.capacity = capacity;
        this.operator = operator;
    }

    public  String getName() {
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
        System.out.println("Operator " + operator.getName() + "has been assigned to the ride " + this.name);
    }
}
