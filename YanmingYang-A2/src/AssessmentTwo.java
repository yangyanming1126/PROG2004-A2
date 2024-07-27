public class AssessmentTwo {
    public static void main(String[] args) {
        // 你的代码将在这里开始
    }

    public void partThree(){
        Ride rollerCoaster = new Ride("Roller Coaster", 2, null);

        // 创建一些Visitor对象
        Visitor visitor1 = new Visitor("Jack", 25, "123 Street", "Regular", false);
        Visitor visitor2 = new Visitor("Sharon", 30, "456 Avenue", "Regular", false);
        Visitor visitor3 = new Visitor("Benny", 22, "789 Boulevard", "Regular", false);
        Visitor visitor4 = new Visitor("Leo", 28, "101 Road", "VIP", true);
        Visitor visitor5 = new Visitor("Nehemia", 35, "202 Lane", "Regular", false);

        // 添加Visitor到队列
        rollerCoaster.addVisitorToQueue(visitor1);
        rollerCoaster.addVisitorToQueue(visitor2);
        rollerCoaster.addVisitorToQueue(visitor3);
        rollerCoaster.addVisitorToQueue(visitor4);
        rollerCoaster.addVisitorToQueue(visitor5);

        // 从队列中移除一个Visitor
        rollerCoaster.removeVisitorFromQueue(visitor1);

        // 打印队列中的所有Visitor
        rollerCoaster.printQueue();
    }

    public void partFourA(){
        Ride thunderstorm = new Ride("Thunderstorm", 4, null);

        // 创建一些Visitor对象
        Visitor visitor1 = new Visitor("Tom", 25, "123 Street", "Regular", false);
        Visitor visitor2 = new Visitor("Sherly", 30, "456 Avenue", "Regular", false);
        Visitor visitor3 = new Visitor("Ben", 22, "789 Boulevard", "Regular", false);
        Visitor visitor4 = new Visitor("David", 28, "101 Road", "VIP", true);
        Visitor visitor5 = new Visitor("Jack", 35, "202 Lane", "Regular", false);

        // 添加Visitor到ride history
        thunderstorm.addVisitorToHistory(visitor1);
        thunderstorm.addVisitorToHistory(visitor2);
        thunderstorm.addVisitorToHistory(visitor3);
        thunderstorm.addVisitorToHistory(visitor4);
        thunderstorm.addVisitorToHistory(visitor5);

        // 检查某个Visitor是否在ride history中
        thunderstorm.isVisitorInHistory(visitor1);

        // 打印ride history中的游客数量
        thunderstorm.getNumberOfVisitorsInHistory();

        // 打印ride history中的所有游客
        thunderstorm.printRideHistory();
    }

    public void partFourB(){
        Ride thunderstorm = new Ride("Thunderstorm", 4, null);

        // 创建一些Visitor对象
        Visitor visitor1 = new Visitor("Tom", 25, "123 Street", "Regular", false);
        Visitor visitor2 = new Visitor("Sherly", 30, "456 Avenue", "Regular", false);
        Visitor visitor3 = new Visitor("Ben", 22, "789 Boulevard", "Regular", false);
        Visitor visitor4 = new Visitor("David", 28, "101 Road", "VIP", true);
        Visitor visitor5 = new Visitor("Jack", 35, "202 Lane", "Regular", false);

        // 添加Visitor到ride history
        thunderstorm.addVisitorToHistory(visitor1);
        thunderstorm.addVisitorToHistory(visitor2);
        thunderstorm.addVisitorToHistory(visitor3);
        thunderstorm.addVisitorToHistory(visitor4);
        thunderstorm.addVisitorToHistory(visitor5);

        // 打印排序前的ride history
        System.out.println("Before sorting:");
        thunderstorm.printRideHistory();

        // 对ride history进行排序
        thunderstorm.sortRideHistory();

        // 打印排序后的ride history
        System.out.println("After sorting:");
        thunderstorm.printRideHistory();
    }

    public void partFive(){
        Ride rollerCoaster = new Ride("Roller Coaster", 3, new Employee("John", 30, "789 Boulevard", "Operator", 3000));

        // 创建一些Visitor对象
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

        // 添加Visitor到队列
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

        // 打印队列中的所有Visitor
        rollerCoaster.printQueue();

        // 运行一个周期
        rollerCoaster.runOneCycle();

        // 打印运行一个周期后的队列中的所有Visitor
        rollerCoaster.printQueue();

        // 打印集合中的所有Visitor
        rollerCoaster.printRideHistory();
    }

    public void partSix(){
        Ride thunderstorm = new Ride("Thunderstorm", 4, new Employee("Alice", 28, "789 Boulevard", "Operator", 3500));

        // 创建一些Visitor对象
        Visitor visitor1 = new Visitor("Tom", 25, "123 Street", "Regular", false);
        Visitor visitor2 = new Visitor("Sherly", 30, "456 Avenue", "Regular", false);
        Visitor visitor3 = new Visitor("Ben", 22, "789 Boulevard", "Regular", false);
        Visitor visitor4 = new Visitor("David", 28, "101 Road", "VIP", true);
        Visitor visitor5 = new Visitor("Jack", 35, "202 Lane", "Regular", false);

        // 添加Visitor到ride history
        thunderstorm.addVisitorToHistory(visitor1);
        thunderstorm.addVisitorToHistory(visitor2);
        thunderstorm.addVisitorToHistory(visitor3);
        thunderstorm.addVisitorToHistory(visitor4);
        thunderstorm.addVisitorToHistory(visitor5);

        // 将游客信息导出到文件
        thunderstorm.exportVisitorsToFile("ride_history.txt");
    }

    public void partSeven(){
    }
}
