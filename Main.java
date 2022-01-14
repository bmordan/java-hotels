public class Main {
    public static void main(String[] args) {
        Hotel grand = new Hotel("The Grand");
        Guest robinson = new Guest("Robinson");
        Guest bobson = new Guest("Bob Sun");
        Guest smitty = new Guest("M Smitty");
        grand.checkIn(robinson);
        grand.checkIn(bobson);
        grand.checkIn(smitty);
        System.out.print(grand.getName());
    }
}
