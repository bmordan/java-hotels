public class SingleRoom extends Room {
    public SingleRoom(int number) {
        super(number);
    }

    @Override
    public boolean isEmpty() {
        return this.beds[0] == null;
    }
}
