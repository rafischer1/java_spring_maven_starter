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

```haskell
// ==methods==

.equals()  person1.equals(person2); treu/false

```

## CLASSES! **An instance is a *thing* in itself**

```java
public class Car {// scope of Car class starts here

  public static void main(String[] args) {// scope of main() starts here
    // program tasks
  }// scope of main() ends here

}// scope of Car class ends here
```

## Constructors! Create an instance of that class!
