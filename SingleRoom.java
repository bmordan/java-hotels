public class SingleRoom extends Room {
    public SingleRoom(int number) {
        super(number);
        super.beds = new Guest[1];
    }
}
