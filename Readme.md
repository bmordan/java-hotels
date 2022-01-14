# Hotels
Object orientated programming (OOP) is a style of programming. The Java language has been created to capture and express this style of programming. We need to learn about OOP in order to read and write Java code. There is a set of fundamental concepts that will get you started programming OOP you will learn these in this workshop. The main idea behind OOP is that our computer program should model how things are and how things relate to each other, like they do in the real world. For example we are going to build a hotel. Our hotel will have rooms and guests, just like hotels do in the real world.

## new Hotel
We are going to make a Hotel in Java. Our hotel can start off with a name. In a file called `Hotel.java` add the following public class.
```java
public class Hotel {
    private String name;

    public Hotel(String name) {
        this.name = name;
    }
}
```
The class has a property called `name` that is a string. I have added a `constructor` function to my class. The `public Hotel` method on line 4 will be called when I create a new instance of this class like this.
```java
Hotel grand = new Hotel("The Grand");
```
When you see the `new` keyword you know that you are creating a new instance of a Hotel and that the constructor function is also being called. We pass the name of the hotel "The Grand" to the constructor function. When the hotel is constructed (or instantiated) it will be assigned a name. How will you be able to access the name of the hotel?
```java
grand.name // The field Hotel.name is not visible
```
Our hotel does have a name, but it is only visible to the methods of the Hotel class, and here we are on the outside of the class instance trying to read a property that is encapsulated within the class. If we what to access that property we need to add a 'getter' method to the class.
```java
public class Hotel {
    private String name;

    public Hotel(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
```
This is a pattern is called **Encapsulation** you we see in all Java code, by default properties and methods of a class should be private, then you publicly expose _only_ those things that other parts of the program need to read or write to.

Can you think why that might be the case?
```java
grand.getName() // The Grand
```
|OOP Hotel|A real world Hotel|
|:--|:--|
<span style="display:flex;align-items:center;height:200px;">`Hotel@182decdb`</span>|![the Grand Hotel](https://images.trvl-media.com/hotels/1000000/50000/45700/45673/385e0d93.jpg?)

## OOP Design
When you are thinking about the design of an object orientated program there are some principles of good practice that you should know about.

1. Single responsibility
1. Open for extension closed for modification
1. Build complexity with simplicity
1. Minimal interfaces
1. Backwards compatibility

This is a simplified version of the [SOLID principles](https://www.digitalocean.com/community/conceptual_articles/s-o-l-i-d-the-first-five-principles-of-object-oriented-design). To practice the principle of single responsibility we should think about different objects owning different properties. For example instead of the Hotel class having all the properties and methods for each room defined within it we should make a new different class for a room, then add instances of the `Room` class to the `Hotel` instance. 

## new Room
A room will have a room number. A room might be a Single, Twin or Double room, those different rooms will have different rates, and we'll want to check and see if the room is available or not. Finally we want to be able to place guests into the room. In a new file called `Room.java` can you create the following class definition.
```java
public class Room {
    private int number;
    private String type = "Double";
    
    public Room(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public String getType() {
        return this.type;
    }
}
```
Very similar to our `Hotel` class. Can you create a `Guest.java` with a `Guest` class that we can instantiate with a `String` that will have the property surname.
```java
public class Guest {
    private String surname;

    public Guest(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return this.surname;
    }
}
```

We can now make 3 types of object in our program. Finally in a `Main.java` class we can start to create these objects in the OOP style!
```java
public class Main {
    public static void main(String[] flags) {
        Hotel grand = new Hotel("The Grand");
        Guest simmonds = new Guest("Simmonds");
        Room room3 = new Room(3);
        System.out.println(grand.getName());
    }
}
```

## Relating objects
At present our hotel has only a name. We will want to create a hotel and say how many rooms it has. When we instantiate a new hotel it would be good if we could also passing the number of rooms that we like that hotel to have. It will be an integer. Can you update your code when you create a new hotel to also accept an integer that will represent the number of rooms we want a hotel to have.

Now if you think about your data structures what is the best data structure to hold an array of rooms? It is going to be an Array! We can use the number of rooms that the hotel needs to create an empty array and then we will iterate over it in a for loop and fill that array with rooms.
```java
public class Hotel {
    private String name;
    private Room[] rooms;

    public Hotel(String name, int numOfRooms) {
        this.name = name;
        this.rooms = new Room[numOfRooms];
        for(int i = 0; i < numOfRooms; i++) {
            this.rooms[i] = new Room(i + 10); // I'm using the index to create room numbers
        }
    }
}
```

## Debugging

We should have a Hotel with rooms, but how can we be sure? At present our code runs; prints out a few things and then exits. To examine more closely what the state of our program is as it runs, and verify that values and variables are being set correctly we need to learn to debug our code.

|Debugging|Admiral Grace Hopper|
|:--------|:------------------:|
_This is an odd term. Back in the early days of computing, computers were large constructions with physical valves and relays - they were bright warm and dusty things - very attractive to moths. The Mark II which was being built and run in Harvard University showed some unusual failing and faults. It got the engineering team curious as to what the problem was, upon closer investigation [Admiral Grace Hopper](https://en.wikipedia.org/wiki/Grace_Hopper) discovered a dead moth was blocking one of the relays. They went looking for other bugs interfering with other parts of the system and told their team they needed to "debug" the system!_|![Admiral Grace Hopper](https://upload.wikimedia.org/wikipedia/commons/thumb/a/ad/Commodore_Grace_M._Hopper%2C_USN_%28covered%29.jpg/440px-Commodore_Grace_M._Hopper%2C_USN_%28covered%29.jpg "James S. Davis - This image was released by the United States Navy with the ID DN-SC-84-05971 © Public Domain. Created: 20 January 1984")


Let's use the debugger to inspect the objects in our code and verify that we do have a hotel with rooms in it.

First create a breakpoint on the last line of the main method in your `Main.java` file after you declare and assign your Hotel. You can add a `System.out.println(hotel.getName())` and add the breakpoint to that line.

_you might need to goto: vscode->settings->features->debug->__Allow Breakpoints Everywhere___

![adding a breakpoint](https://user-images.githubusercontent.com/4499581/148397894-e65070c3-73b0-4ede-a6a2-b6eb5ad3cad4.png)

Can you see the red dot that I added to the left of the line numbers? That is a breakpoint. When we run our program in debug mode the program will stop there. Then we will be able to inspect our hotel. Try clicking on 'debug' instead of 'run' to start a debugging session.

![annotated debugging screen](https://user-images.githubusercontent.com/4499581/148399443-a471f985-7560-4284-a50a-a09101af0bf7.jpg)

Take a moment to orientate yourself and inspect your hotel object. Our code is paused at the breakpoint, so what comes after the breakpoint has not yet been executed. While we are paused here we can look around in our program, inspect the local variables, and even interact with our code by writing expressions in the 'DEBUG CONSOLE' tab. Pretty amazing and very useful.

You can also see you have a set of controls, like pause/play, step over, step into etc. These control the execution of your program, so you can step over a function, or into it and move through your program step by step, following the path of execution.

## Adding methods

We have a hotel with rooms for guests. Now we want to be able to plug a guest into a room. To do this our objects will interact. Usually when a guest arrives at the hotel they check-in and the hotel assign them their room. It makes sense for the hotel to take responsibility for placing a guest in a room. At present our hotel has no way for us to check-in a guest. What we need to do is build out the Hotel's interface by adding a method.
```java
public class Hotel {
    private String name;
    private Room[] rooms;

    public Hotel(String name, int numOfRooms) {
        this.name = name;
        this.rooms = new Room[numOfRooms];
        for(int i = 0; i < numOfRooms; i++) {
            this.rooms[i] = new Room(i);
        }
    }

    public String getName() {
        return this.name;
    }

    public void checkIn(Guest guest) {
        // ...
    }
}
```
Now our hotel has a name, rooms, and a method that we can call with a guest. Our `checkIn` method needs to do the work of adding the guest into the first empty room it can find. Can you write this method? Think about how you might do that and the code that you might _want_ to write. For example as I iterate over all the rooms taking one room at a time I will want to ask each room,

> Are you empty?

That might look like:
```java
for(Room room : this.rooms) {
    if (room.isEmpty()) {
        //... more code in here
    }
}
```
This is another method, but this time on the `Room` class. Here we are in the essential point of this workshop which is writing code were classes interact with one another. You will need to update your `Room` class as well at the `Hotel` class to complete the task of adding a guest to a room.

```java
public class Room {
    private int number;
    private String type = "Double";
    private Guest[] beds = {null, null};

    public Room(int roomNumber) {
        this.number = roomNumber;
    }

    public boolean isEmpty () {
        // need logic to check room is empty
    }

    public int getNumber() {
        return this.number;
    }

    public String getType() {
        return this.type;
    }
}
```
Once we've found an empty room, we will need a method to add a guest, and remove them when they check-out. Your `Room` class might now include methods like these.
```java
import java.util.Arrays;

public class Room {
    //... other properties and methods

    public void addGuest(Guest guest) {
        if (this.beds[0] == null) {
            this.beds[0] = guest;
        } else if (this.beds[1] == null) {
            this.beds[1] = guest;
        }
    }

    public Guest removeGuest() {
        if (this.beds[1] != null) {
            Guest guest = this.beds[1];
            this.beds[1] = null;
            return guest;
        } else {
            Guest guest = this.beds[0];
            this.beds[0] = null;
            return guest;
        }        
    }
}
```
Now objects in our code can interact, and we can relate them together. You should now be able to create a guest, and place them into a hotel room!

## Inheritance

Inheritance is a central design concept in OOP. It is a mechanism for sharing code and organising objects. What follows is an example of implementing inheritance and leveraging the design pattern to save us from repeatedly having to write code that basically does the same thing.

Hotels have different room types. For example a double room, a single, a twin or family room. They are all rooms, they will all have a room number, they all need the interface to allow us to add and remove guests. However they diverge. A single room will only accept 1 guest then it will not be empty. Each room type will have their own prices.

There are 4 new keywords you are going to learn to get the hang of inheritance in Java.

1. `extends` - extend a class
1. `super` - access the extended class
1. `abstract class` - a class that you never actually instantiate in your code
1. `@Overide` - overwrite an inherited method

### Extend a class

Instead of relying on the `String` "Double" to indicate that a room is a double room, we should actually have a `DoubleRoom` class that represents this type of room. We are going to treat the `Room` class as the abstract blueprint of all rooms. We can make a "Double" room really easily.

```java
public class DoubleRoom extends Room {
    public DoubleRoom(int roomNumber) {
        super(roomNumber);
    }
}
```
Can you see the `extends` keyword when we define the class? Can you see where we use `super` to pass the room number to the `Room` constructor. What does it mean to inherit or extend the `Room` class? It means you can do things like this.
```java
DoubleRoom room13 = new DoubleRoom(13);

room13.getNumber(); // 13
room13 instanceof Room; // true
room13 instanceof DoubleRoom; // true
room13.addGuest(new Guest("Robinson"));
room13.isEmpty(); // false
```
Rad. We got methods for free! We inherited the functionality of the `Room` class. `DoubleRoom` can be refereed to as a "sub-class" or "child class" of the "parent class" or "base class" or "super class" `Room`. We still need to expose a constructor for our sub-class `DoubleRoom` but we can immediately pass the value up to the parent class `Room` to do the work of assigning the value to the property `number`. We can make the other types of rooms using inheritance.
```java
public class DoubleRoom extends Room {
    private double price = 79.99;
    
    public DoubleRoom(int roomNumber) {
        super(roomNumber);
    }
}

public class SingleRoom extends Room {
    private double price = 59.99;

    public SingleRoom(int roomNumber) {
        super(roomNumber);
    }
}

public class TwinRoom extends Room {
    private double price = 69.99;

    public TwinRoom(int roomNumber) {
        super(roomNumber);
    }
}
```
Can you see we are repeating code in our sub-classes? The price property will be shared by all sub-classes of `Room`. It makes sense for this property to belong to the parent/base/super class. We will want the sub-classes to set this price when they are instantiated. So we want a method that we can call to set the price for that room.
```java
public class Room {
    private double price;
    //... other properties and methods

    protected void setPrice(double price) { // not private, but not as open as public, protected restricts access to the package level
        this.price = price;
    }
}
```
In our sub-class in the constructor method we can set the price depending on the room type.
```java
public class DoubleRoom extends Room {
    public DoubleRoom(int roomNumber) {
        super(roomNumber);
        super.setPrice(79.00);
    }
}
```

### Create an Abstract class

We will never instantiate the `Room` class. We are never going to write the code `new Room(13);`. To express that in our code we can label the `Room` class an `abstract` class. Adding this means we can no longer instantiate this class, trying to will cause a syntax error `Cannot instantiate the type Room`. BUT we can use this abstract class as a basis for spawning other sub classes. 
```java
public class Hotel {
    // class definition...
}
```

### @Override an inherited method

Our abstract class holds the shared properties and methods that all our room types share. But what if we need to alter the behavior of one sub-class? For example to check if a single room is empty we only need to check for 1 guest. Using `@Overide` we can basically overwrite the inherited method and alter its behaviour.

```java
public class SingleRoom extends Room {
    public SingleRoom(int roomNumber) {
        super(roomNumber);
        super.setPrice(59.99);
    }

    @Override
    public boolean isEmpty () {
        return this.beds[0] == null;
    }
}
```
We are going to bump into a problem here when we try to access `this.beds`. We rightly made this private as beds are only for the the guests in the `Room` class. Private means no other class can read or write to that property. But we made `Room` an abstract class. No guests will every use the `Room` class. So its ok to share `this.beds` - but only with the sub-classes and classes in our package. To achieve this we need to use `protected` in the `Room` class when we define the beds property.
```java
public abstract class Room {
    // ...
    protected Guest[] beds = {null, null}; // 'protected' means sub-classes or other classes in the package scope can read/write to this property
    // ...
}
```

### Polymorphism

In our Hotel there are lots of different types of `Room`.

1. `DoubleRoom`
1. `TwinRoom`
1. `SingleRoom`

3 different classes. How will we be able to store them all in one array? We know that in Java we can't mix different types in an array. This is where **polymorphism** starts to come into play. Because of **polymorphism** we can mix different types of sub classes in one polymorphic array.
```java
public class Hotel {
    private Room[] rooms = {
        new SingleRoom(1),
        new DoubleRoom(2),
        new DoubleRoom(3),
        new TwinRoom(4)
    };
}
```
Above we use the parent class or super class `Room` as the _type_ for the array. We have an array of Room's. When we iterate over the array we can use the super class as the type, and know with confidence that each instance that we loop over will respond correctly to the same method calls.
```java
for(Room room : this.rooms) {
    if (room.isEmpty()) 
}
```
If we added another type of `Room` for example a `FamilyRoom` **polymorphism** enables us to do that without having to update code else where. We know that the `FamilyRoom` will respond to `isEmpty`, `addGuest`, `getNumber` etc. Open for extension, closed for modification. This patten of inheritance and the way polymorphism allows us to treat a super class _type_ as a substitute for a sub-class type helps us extend Java code without breaking code that has already been written.

## Build your Hotel

We have looked at:

* Classes
* Debugging
* Encapsulation
* Inheritance
* Polymorphism

These topics are fundamental when working with Java. Your challenge now is to use all these ideas together and create a working Hotel in code. You will need to try and meet the following requirements.

1. Your Hotel needs to have different types of rooms:
    - use `extends` to implement inheritance
    - use the `abstract` keyword correctly
    - use `super` in the sub-classes
    - use `@Override` to alter some inherited methods
1. Guests need to be able to choose which type of room they would like to be in
    - figure a way to place a guest in a single room rather than a double or twin room
1. Only Guests checking in with the same surname can share a double room (I know - very old fashioned!)
    - how could you implement this rule just for double rooms
1. You should be able to check guests out of their rooms

We've used only 1 breakpoint so far. What you can do is create your objects in the main method then add a breakpoint to export your objects in this initial state. Add guests into rooms and set a breakpoint to inspect the updated state of your Hotel. Check out your guests or add some more activity then set another breakpoint to examine the altered state of your Hotel. Life is never dull in the Grand Hotel.

## 🧙‍♀️ For the Wizards

How could you generate a bill for your guests upon checkout? We have not considered in our Hotel how we will deal with the passage of time? For example some guests might like to stay for just one night, other might like to stay for the week.
