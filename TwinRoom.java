public class TwinRoom extends Room {
    private Guest[] bedsTwin = {null};
    public TwinRoom(int number) {
        super(number);
        this.beds = new Guest[1];
    }

    @Override
    public boolean isEmpty() {
        return this.beds[0] == null || this.bedsTwin[0] == null;
    }

    @Override
    public void addGuest(Guest guest) {
        if (this.beds[0] == null) {
            this.beds[0] = guest;
        } else if (this.bedsTwin[0] == null) {
            this.bedsTwin[0] = guest;
        }
    }
}
