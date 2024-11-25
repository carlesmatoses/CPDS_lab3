public class Neighbor extends Thread {
    private Flags flags;
    public Neighbor(Flags flags) {
        this.flags = flags;
    }

    public void run() {
        while (true) {
            try {
                String name = Thread.currentThread().getName() ;
                String other = name.equals("alice") ? "bob" : "alice";
                System.out.println("try again, my name is: "+ name);
                Thread.sleep((int)(200*Math.random()));
                flags.set_true(name);
                if (!flags.query_flag(other)) {
                    System.out.println(name + " enter");
                    Thread.sleep(400);
                    System.out.println(name + " exits");
                }
                Thread.sleep((int)(200*Math.random()));
                flags.set_false(name); ;
            }
            catch (InterruptedException e) {};
        }
    }
}