public class Visitor extends Person{
    private String ticketType;
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
}
