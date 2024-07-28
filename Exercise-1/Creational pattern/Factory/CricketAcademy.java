// Abstract Product
abstract class CricketPlayer {
    public abstract void train();
    public abstract void play();
}

// Concrete Product: Batsman
class Batsman extends CricketPlayer {
    @Override
    public void train() {
        System.out.println("Batsman training on batting techniques.");
    }

    @Override
    public void play() {
        System.out.println("Batsman playing in the match.");
    }
}

// Concrete Product: Bowler
class Bowler extends CricketPlayer {
    @Override
    public void train() {
        System.out.println("Bowler training on bowling techniques.");
    }

    @Override
    public void play() {
        System.out.println("Bowler playing in the match.");
    }
}

// Concrete Product: AllRounder
class AllRounder extends CricketPlayer {
    @Override
    public void train() {
        System.out.println("AllRounder training on both batting and bowling techniques.");
    }

    @Override
    public void play() {
        System.out.println("AllRounder playing in the match.");
    }
}

// Creator
abstract class CricketPlayerFactory {
    public CricketPlayer createPlayer() {
        CricketPlayer player = createCricketPlayer();
        player.train();
        player.play();
        return player;
    }

    protected abstract CricketPlayer createCricketPlayer();
}

// Concrete Creator: BatsmanFactory
class BatsmanFactory extends CricketPlayerFactory {
    @Override
    protected CricketPlayer createCricketPlayer() {
        return new Batsman();
    }
}

// Concrete Creator: BowlerFactory
class BowlerFactory extends CricketPlayerFactory {
    @Override
    protected CricketPlayer createCricketPlayer() {
        return new Bowler();
    }
}

// Concrete Creator: AllRounderFactory
class AllRounderFactory extends CricketPlayerFactory {
    @Override
    protected CricketPlayer createCricketPlayer() {
        return new AllRounder();
    }
}

// Main class
public class CricketAcademy {
    public static void main(String[] args) {
        CricketPlayerFactory batsmanFactory = new BatsmanFactory();
        CricketPlayer batsman = batsmanFactory.createPlayer();
        System.out.println();

        CricketPlayerFactory bowlerFactory = new BowlerFactory();
        CricketPlayer bowler = bowlerFactory.createPlayer();
        System.out.println();

        CricketPlayerFactory allRounderFactory = new AllRounderFactory();
        CricketPlayer allRounder = allRounderFactory.createPlayer();
        System.out.println();
    }
}
