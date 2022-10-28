public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {


        GameGui gui = new GameGui();
        Engine engine = Engine.create(gui.bList());



        // Do stuff
    }
}