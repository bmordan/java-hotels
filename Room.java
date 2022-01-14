public abstract class Room {
    private int number;
    protected Guest[] beds = {null, null};

    public Room(int number) {
        this.number = number;
    }

    public boolean isEmpty() {
        return this.beds[0] == null || this.beds[1] == null;
    }

    public void addGuest(Guest guest) {
        if (this.beds[0] == null) {
            this.beds[0] = guest;
        } else if (this.beds[1] == null) {
            this.beds[1] = guest;
        }
    }
}
