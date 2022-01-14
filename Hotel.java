public class Hotel {
    private String name;
    private Room[] rooms;

    public Hotel(String name) {
        this.name = name;
        this.rooms = new Room[10];
        for(int i = 0; i < 10; i++) {
            rooms[i] = new Room(i + 1);
        }
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