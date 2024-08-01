import java.util.Comparator;

public class VisitorComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor v1, Visitor v2) {
        // Start by comparing based on name
        int nameComparison = v1.getName().compareTo(v2.getName());
        if (nameComparison != 0) {
            return nameComparison;
        }

        // If the names are the same, they are compared based on age
        return Integer.compare(v1.getAge(), v2.getAge());
    }
}