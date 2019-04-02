#Java up and running since 1995 c/o James Gosling 🐥

> JVM -> byte code =  "Write once, run everywhere!" 

* access level modifiers! *public* *private*

```java
public class HelloYou {
  private static String javaNess = "☕️";
  
  public static void main(String[] args) {
    System.out.println("Hello " + javaNess);
  }
}
```

* compile: `javac File.java` -> .class file

* executable: `java File`

```haskell
Primitive Data Types

int, double(float?), boolean, char('a'), String

```

```java
// using operators on data types in variable declarations: + - * / == != < > % etc

public class MultAndDivide {
	public static void main(String[] args) {
		double subtotal = 30;
    double tax = 0.0875;
    double total = subtotal + (subtotal * tax);
    System.out.println(total);
    int persons = 4;
    double perPerson = total / persons;
    System.out.println(perPerson);
	}
}
```

## CLASSES! **An instance is a *thing* in itself** `System` is a class

```java
public class Car {// scope of Car class starts here

  public static void main(String[] args) {// scope of main() starts here
    // program tasks
  }// scope of main() ends here

}// scope of Car class ends here
```

> add associated data to an object by introducing instance variables, or _instance fields_ as `STORE` (in Car if cars are different colors then there should be a String color field in state)

## Constructors! Create an instance of that class!

* passs instance fields from the class as parameters in the constructor. Now values can be passed into the method calls

```java
  // constructor method
  public Store(String product) {
    productType = product;
  }

   // main method
  public static void main(String[] args) {
    Store lemonadeStand = new Store("lemonade");
    System.out.println(lemonadeStand.productType);
  }
```

```java
// DOG CLASS practice
public class Dog {
  String breed;
  boolean hasOwner;
  int age;

  public Dog(String dogBreed, boolean dogOwned, int dogYears) {
    System.out.println("Constructor invoked!");
    breed = dogBreed;
    hasOwner = dogOwned;
    age = dogYears;
  }

  public static void main(String[] args) {
    System.out.println("Main method started");
    Dog fido = new Dog("poodle", false, 4);
    Dog nunzio = new Dog("shiba inu", true, 12);
    boolean isFidoOlder = fido.age > nunzio.age;
    int totalDogYears = nunzio.age + fido.age;
    System.out.println("Two dogs created: a " + fido.breed + " and a " + nunzio.breed);
    System.out.println("The statement that fido is an older dog is: " + isFidoOlder);
    System.out.println("The total age of the dogs is: " + totalDogYears);
    System.out.println("Main method finished");
  }
}
```

## METHODS!

`.equals() // person1.equals(person2); true/false)`

> method signatures are available to all instances of the class

* *public* other classes can access this method

* *void* no specific output for this method

call the method on the instance with object notation `subaru.accelerate();`

> returns "We can use a value outside of the method it was created in if we return it from the method"

```java
public int numberOfTires() {
   int tires = 4;
   return tires;
}

public double getPriceWithTax() {
 double totalPrice = price + (price * 0.08);
 return totalPrice;
}
```

* notice the data type for the return type instead of `void` in the declaration!

The precedence of each Boolean operator is as follows:

* ! is evaluated first, && is evaluated second, || is evaluated third

* `ternary operators` exist `char gameResult = (pointsScored > 20) ? 'W' : 'L';`

```java
// switch statement
public class Switch {
	public static void main(String[] args) {

		char penaltyKick = 'L';

		switch (penaltyKick) {

			case 'L': System.out.println("Messi shoots to the left and scores!");
								break;
			case 'R': System.out.println("Messi shoots to the right and misses the goal!");
								break;
			case 'C': System.out.println("Messi shoots down the center, but the keeper blocks it!");
								break;
			default:
				System.out.println("Messi is in position...");

		}

	}
}
```


