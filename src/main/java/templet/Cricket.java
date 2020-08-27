package templet;

public class Cricket extends Game{
    @Override
    void initialize() {
        System.out.println("Cricket Game initialized! ");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game Started!");
    }

    @Override
    void endPlay() {
        System.out.println("Cricket Game Finished!");
    }
}
