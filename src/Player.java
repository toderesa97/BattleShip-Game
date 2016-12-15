import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by tdrs on 10/12/16.
 */
public class Player {
    private State currentState;
    private List<BoardType> pendingBoatsList;
    private List<Boat> board;
    private Map<Integer, BoardType> translate;
    private final String name;

    public Player(String playerName) {
        name = playerName;
        init();
    }

    public String getName() {
        return name;
    }

    private void init(){
        this.currentState = State.PLACING;
        this.pendingBoatsList = new ArrayList();
        this.pendingBoatsList.add(BoardType.TWO);
        this.pendingBoatsList.add(BoardType.TWO);
        this.pendingBoatsList.add(BoardType.TWO);
        this.pendingBoatsList.add(BoardType.THREE);
        this.pendingBoatsList.add(BoardType.THREE);
        this.pendingBoatsList.add(BoardType.FOUR);
        this.pendingBoatsList.add(BoardType.FOUR);
        this.pendingBoatsList.add(BoardType.FIVE);
        this.board = new ArrayList();
        this.translate = new TreeMap();
        this.translate.put(Integer.valueOf(2), BoardType.TWO);
        this.translate.put(Integer.valueOf(3), BoardType.THREE);
        this.translate.put(Integer.valueOf(4), BoardType.FOUR);
        this.translate.put(Integer.valueOf(5), BoardType.FIVE);
    }

    public State getState() {
        return this.currentState;
    }

    public int pendingBoats() {
        return this.pendingBoatsList.size();
    }

    public boolean placeBoat(Boat boat) {
        if(this.currentState != State.PLAYING) {
            if(this.translate.get(boat.length()) != null) {
                List allCoordinates = (List)this.board.stream()
                        .flatMap((boat1) -> boat1.getCoordinatesList().stream())
                        .collect(Collectors.toList());
                Boolean found = boat.getCoordinatesList().stream().anyMatch((coordinate1) -> {
                    Iterator var2 = allCoordinates.iterator();

                    Coordinate coordinate2;
                    do {
                        if (!var2.hasNext()) {
                            return false;
                        }
                        coordinate2 = (Coordinate) var2.next();
                    } while (!coordinate1.equals(coordinate2));

                    return true;
                });
                if(!found && this.pendingBoatsList.remove(this.translate.get(boat.length()))) {
                    this.board.add(boat);
                }

                if(this.board.size() == 8 && 0 == this.pendingBoats()) {
                    this.currentState = State.PLAYING;
                }
                return !found;
            }
        }
        return false;
    }

    public List<Boat> board() {
        return this.board;
    }
}


