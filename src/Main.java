import controller.Controller;
import view.View;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {


        View gui = new View();
        Controller controller = Controller.create(gui.bList());



        // Do stuff
    }
}