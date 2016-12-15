import java.util.List;

public class Boat {
    private List<Coordinate> coordinatesList;

    public Boat(List<Coordinate> coordinates) {
        this.coordinatesList = coordinates;
    }

    public Integer length() {
        return coordinatesList.size();
    }

    public List<Coordinate> getCoordinatesList() {
        return coordinatesList;
    }
}
