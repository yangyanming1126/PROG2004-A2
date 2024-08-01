/**
 * tourists
 */
public class Visitor extends Person{
    private String ticketType;//Ticket type
    private boolean hasVIPAccess;

    public Visitor() {
    }

    public Visitor(String name, int age, String address, String ticketType, boolean hasVIPAccess) {
        super(name, age, address);
        this.ticketType = ticketType;
        this.hasVIPAccess = hasVIPAccess;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public boolean isHasVIPAccess() {
        return hasVIPAccess;
    }

    public void setHasVIPAccess(boolean hasVIPAccess) {
        this.hasVIPAccess = hasVIPAccess;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "person='" + super.toString() + '\'' +','+
                "ticketType='" + ticketType + '\'' +
                ", hasVIPAccess=" + hasVIPAccess +
                '}';
    }
}
//arraylist <Visitor> apps = new arraylist
