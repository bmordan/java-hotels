public class Hotel {
    private String name;
    private Room[] rooms;

    public Hotel(String name) {
        this.name = name;
        this.rooms = new Room[6];
        rooms[0] = new TwinRoom(1);
        rooms[1] = new DoubleRoom(2);
        rooms[2] = new DoubleRoom(3);
        rooms[3] = new DoubleRoom(4);
        rooms[4] = new SingleRoom(5);
        rooms[5] = new SingleRoom(6);
    }

    public String getName() {
        return this.name;
    }

    public void checkIn(Guest guest) {
        for(Room room : this.rooms) {
            if(room.isEmpty()) {
                room.addGuest(guest);
                break;
            }
        }
    }
}