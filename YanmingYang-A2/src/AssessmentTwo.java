public class AssessmentTwo {
    public static void main(String[] args) {
        AssessmentTwo assessmentTwo = new AssessmentTwo();


        //pt3
//        System.out.println("--------------part3---------------");
//        assessmentTwo.partThree();
        //pt4
//        System.out.println("--------------part4---------------");
//        assessmentTwo.partFourA();
//        assessmentTwo.partFourB();
//        //pt5
//        System.out.println("--------------part5---------------");
//        assessmentTwo.partFive();

        //pt6
//        System.out.println("--------------part6---------------");
//        assessmentTwo.partSix();
//
//        //pt7
//        System.out.println("--------------part7---------------");
//        assessmentTwo.partSeven();
    }



    public void partThree(){
        Employee employee = new Employee("Administrator", 33, "Beijing", "Device administrator", 5000);
        Ride rollerCoaster = new Ride("Roller Coaster", 2, employee);

        // Create some Visitor objects
        Visitor visitor1 = new Visitor("Jack", 25, "123 Street", "Regular", false);
        Visitor visitor2 = new Visitor("Sharon", 30, "456 Avenue", "Regular", false);
        Visitor visitor3 = new Visitor("Benny", 22, "789 Boulevard", "Regular", false);
        Visitor visitor4 = new Visitor("Leo", 28, "101 Road", "VIP", true);
        Visitor visitor5 = new Visitor("Nehemia", 35, "202 Lane", "Regular", false);

        // Add a Visitor to the queue
        rollerCoaster.addVisitorToQueue(visitor1);
        rollerCoaster.addVisitorToQueue(visitor2);
        rollerCoaster.addVisitorToQueue(visitor3);
        rollerCoaster.addVisitorToQueue(visitor4);
        rollerCoaster.addVisitorToQueue(visitor5);

        // Remove a Visitor from the queue
        rollerCoaster.removeVisitorFromQueue(visitor1);

        // Print all visitors in the queue
        rollerCoaster.printQueue();
    }

    public void partFourA(){
        Ride thunderstorm = new Ride("Thunderstorm", 4, null);

        // Create some Visitor objects
        Visitor visitor1 = new Visitor("Tom", 25, "123 Street", "Regular", false);
        Visitor visitor2 = new Visitor("Sherly", 30, "456 Avenue", "Regular", false);
        Visitor visitor3 = new Visitor("Ben", 22, "789 Boulevard", "Regular", false);
        Visitor visitor4 = new Visitor("David", 28, "101 Road", "VIP", true);
        Visitor visitor5 = new Visitor("Jack", 35, "202 Lane", "Regular", false);

        // Add Visitor to ride history
        thunderstorm.addVisitorToHistory(visitor1);
        thunderstorm.addVisitorToHistory(visitor2);
        thunderstorm.addVisitorToHistory(visitor3);
        thunderstorm.addVisitorToHistory(visitor4);
        thunderstorm.addVisitorToHistory(visitor5);

        // Check a certain one VisitorWhether it is in or not in ride history
        thunderstorm.isVisitorInHistory(visitor1);

        // Print the number of visitors in ride history
        thunderstorm.getNumberOfVisitorsInHistory();

        // Print all visitors in Ride History
        thunderstorm.printRideHistory();
    }

    public void partFourB(){
        Employee employee = new Employee("Administrator", 33, "Beijing", "Device administrator", 5000);
        Ride thunderstorm = new Ride("Thunderstorm", 4, employee);

        // Create some Visitor objects
        Visitor visitor1 = new Visitor("Tom", 25, "123 Street", "Regular", false);
        Visitor visitor2 = new Visitor("Sherly", 30, "456 Avenue", "Regular", false);
        Visitor visitor3 = new Visitor("Ben", 22, "789 Boulevard", "Regular", false);
        Visitor visitor4 = new Visitor("David", 28, "101 Road", "VIP", true);
        Visitor visitor5 = new Visitor("Jack", 35, "202 Lane", "Regular", false);

        // Add Visitor to ride history
        thunderstorm.addVisitorToHistory(visitor1);
        thunderstorm.addVisitorToHistory(visitor2);
        thunderstorm.addVisitorToHistory(visitor3);
        thunderstorm.addVisitorToHistory(visitor4);
        thunderstorm.addVisitorToHistory(visitor5);

        // Before printing sorting ride history
        System.out.println("Before printing sorting ride history");
        thunderstorm.printRideHistory();

        // Sort the ride history
        thunderstorm.sortRideHistory();

        // Printed sorted ride history
        System.out.println("Printed sorted ride history");
        thunderstorm.printRideHistory();
    }

    public void partFive(){
        Employee employee = new Employee("Administrator", 33, "Beijing", "Device administrator", 5000);
        Ride rollerCoaster = new Ride("Roller Coaster", 3, employee);

        // Add at least 10 visitors to the queue
        Visitor visitor1 = new Visitor("Jack", 25, "123 Street", "Regular", false);
        Visitor visitor2 = new Visitor("Sharon", 30, "456 Avenue", "Regular", false);
        Visitor visitor3 = new Visitor("Benny", 22, "789 Boulevard", "Regular", false);
        Visitor visitor4 = new Visitor("Leo", 28, "101 Road", "VIP", true);
        Visitor visitor5 = new Visitor("Nehemia", 35, "202 Lane", "Regular", false);
        Visitor visitor6 = new Visitor("Tom", 25, "123 Street", "Regular", false);
        Visitor visitor7 = new Visitor("Sherly", 30, "456 Avenue", "Regular", false);
        Visitor visitor8 = new Visitor("Ben", 22, "789 Boulevard", "Regular", false);
        Visitor visitor9 = new Visitor("David", 28, "101 Road", "VIP", true);
        Visitor visitor10 = new Visitor("Jack", 35, "202 Lane", "Regular", false);

        // Add a Visitor to the queue
        rollerCoaster.addVisitorToQueue(visitor1);
        rollerCoaster.addVisitorToQueue(visitor2);
        rollerCoaster.addVisitorToQueue(visitor3);
        rollerCoaster.addVisitorToQueue(visitor4);
        rollerCoaster.addVisitorToQueue(visitor5);
        rollerCoaster.addVisitorToQueue(visitor6);
        rollerCoaster.addVisitorToQueue(visitor7);
        rollerCoaster.addVisitorToQueue(visitor8);
        rollerCoaster.addVisitorToQueue(visitor9);
        rollerCoaster.addVisitorToQueue(visitor10);

        // Print all visitors in the queue
        System.out.println("Print all visitors in the queue");
        rollerCoaster.printQueue();

        // Run a cycle
        System.out.println("Run a cycle");
        rollerCoaster.runOneCycle();

        // Prints all visitors in the queue after running for one cycle
        System.out.println("Prints all visitors in the queue after running for one cycle");
        rollerCoaster.printQueue();

        // Print all Visitors in the collection
        System.out.println("Print all Visitors in the collection");
        rollerCoaster.printRideHistory();
    }

    public void partSix(){
        Ride thunderstorm = new Ride("Thunderstorm", 4, new Employee("Alice", 28, "789 Boulevard", "Operator", 3500));

        // Create some Visitor objects
        Visitor visitor1 = new Visitor("Tom", 25, "123 Street", "Regular", false);
        Visitor visitor2 = new Visitor("Sherly", 30, "456 Avenue", "Regular", false);
        Visitor visitor3 = new Visitor("Ben", 22, "789 Boulevard", "Regular", false);
        Visitor visitor4 = new Visitor("David", 28, "101 Road", "VIP", true);
        Visitor visitor5 = new Visitor("Jack", 35, "202 Lane", "Regular", false);

        // Add Visitor to ride history
        thunderstorm.addVisitorToHistory(visitor1);
        thunderstorm.addVisitorToHistory(visitor2);
        thunderstorm.addVisitorToHistory(visitor3);
        thunderstorm.addVisitorToHistory(visitor4);
        thunderstorm.addVisitorToHistory(visitor5);

        // Export visitor information to a file
        String projectRoot = System.getProperty("user.dir");//Get a dynamic path
        String filePath = projectRoot + "/data/visitors.txt";
        thunderstorm.exportVisitorsToFile(filePath);
    }

    public void partSeven(){
        Ride rollerCoaster = new Ride("Roller Coaster", 3, new Employee("John", 30, "789 Boulevard", "Operator", 3000));

        // Import visitor information from a file
        String projectRoot = System.getProperty("user.dir");//Get a dynamic path
        String filePath = projectRoot + "/data/visitors.txt";
        rollerCoaster.importVisitorsFromFile(filePath);

        // Print the number of imported visitors
        System.out.println("Number of visitors imported: " + rollerCoaster.getNumberOfVisitorsInHistory());

        // Print all imported visitor information
        rollerCoaster.printRideHistory();
    }
}
