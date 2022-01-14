public class Hotel {
    private String name;
    private Room[] rooms;

    public Hotel(String name) {
        this.name = name;
        this.rooms = new Room[10];
        rooms[0] = new SingleRoom(1);
        rooms[1] = new DoubleRoom(2);
        rooms[2] = new DoubleRoom(3);
        rooms[3] = new DoubleRoom(4);
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