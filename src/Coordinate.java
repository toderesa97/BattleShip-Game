

public class Coordinate {

    private final int xPosition;
    private final int yPosition;



    public Coordinate(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    @Override
    public boolean equals(Object obj){
        return ((Coordinate)obj).xPosition == xPosition &&
                ((Coordinate)obj).yPosition == yPosition;
    }

    @Override
    public int hashCode(){
        return 3*(xPosition+yPosition);
    }
}


