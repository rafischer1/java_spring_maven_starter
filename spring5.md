# Java/Spring5 Notes and project setup ☕️ + 🀦

### Java 8 is the miminum requirement to work with

### kotlin functional programming is supported

### supports JUnit5 for tests, hibernate is -v 5

### Maven

* build automation tool for software - project object model

* allow a developer to understand the complete state of a project in ashort amount of time

* POM - pom.xml is the file project obejct model

> Create new maven project with a name and etc, add subfolder to Java in src and then add class "HmnasdDjdnsfk"

```java
public class HelloMaven {
    public static void main(String[] args) {
        System.out.println("Hello Maven" + " artman");
    }
}
```

* if project doesn't load or run right click and reimport or enable auto imports

* Maven build lifecycle: default, clean, and site

    * `default` handles the project deployment - validate, compile, test, package, verify, install, deploy

    * `clean` handles project cleaning 

    * `site` handles site documentation

* Build phases: stages in the lifecycle: [Full Lifecycle Maven Docs](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html#Lifecycle_Reference)

* Maven plugins - where the real action occurs: "actions" compile, <build/>, <reporting />, must have: groupid, artifactid, version

* a plugin may have one or more goals e.g. Compiler has two goals: compile and testCompile

`clean  install` will rebuild a project from  the maven command line window

### Logging: keeping the record of the programs implementation according to specific developer criteria

> think not just about dev - bugs during production, login, reliable

SL4J - API is used as the application layer, the interface w/ the developer while the implementation will be where calls are made to to get loggin working

Logback - a reliable fast and flexible and configurable for logging in Java using Maven [Logback docs](https://logback.qos.ch/documentation.html)

    * Loggers - caputre logging info

    * Appenders - publish logging info to various destinations

    * layout - format logging info invarious styles

    * filter - ternary layers to compose specific output

`private final static Logger log = LoggerFactory.getLogger(HelloMaven.class);`

```haskell
public static Logger getLogger(String name)
Return a logger named according to the name parameter using the statically bound ILoggerFactory instance.
Parameters:
name - The name of the logger.
Returns:
logger
```

logback is automatically configured at minimal level but can be configured - output to the console

> "root logger" exists by default in a log4j system and cannot be named in the parent/ancestor path

```haskell
Pattern Conversion:

%date : 2019-3-25 13:21:20,006
[%thread] : [main]
[%-5level] : [INFO ] / [DEBUG] //-5 is the max length of that string left justified
%logger{40} - : academy.learnprogramming.HelloMaven - //{max 40 char}
%message%n : message string or whatever
```

```xml
<configuration>
    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <encoder class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
            <pattern>%date [%thread] [%-5level] %logger{30} : %message%n</pattern>
        </encoder>
    </appender>

    <logger name="academy.learnprogramming" level="DEBUG" />
    <root level="INFO">
        <appender-ref ref="STDOUT"/>
    </root>

</configuration>
```

## New Project - Guess the Numbers

* UML - Unified Modeling Language - describe, design, and document software systems - visually describe class diagrams

### Create core module: new module: specify the artifactid and it creates the new module package with the pom file pointing back to the parent - linking parents and children

* Control your dependencies from the POM - DRY even when updating version of a dependency

### IoC - inversion of control container - "beans" lifecycles - an instantiated java object controlled by the IoC container

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="numberGenerator" class="academy.learnprogramming.NumberGeneratorIMPL"/>

</beans>
```
> cached instance of a `singleton bean` created by the spring container - an instance of a bean shared across the whole application

```haskell
2019-03-25 14:50:36,968 [main] [INFO ] academy.learnprogramming.Main - GTN game
2019-03-25 14:50:37,036 [main] [DEBUG] o.s.c.s.ClassPathXmlApplicationContext - Refreshing org.springframework.context.support.ClassPathXmlApplicationContext@1700915
2019-03-25 14:50:37,266 [main] [DEBUG] o.s.b.f.xml.XmlBeanDefinitionReader - Loaded 1 bean definitions from class path resource [beans.xml]
2019-03-25 14:50:37,305 [main] [DEBUG] o.s.b.f.s.DefaultListableBeanFactory - Creating shared instance of singleton bean 'numberGenerator'
2019-03-25 14:50:37,345 [main] [INFO ] academy.learnprogramming.Main - Number = 90
2019-03-25 14:50:37,353 [main] [DEBUG] o.s.c.s.ClassPathXmlApplicationContext - Closing org.springframework.context.support.ClassPathXmlApplicationContext@1700915, started on Mon Mar 25 14:50:37 MDT 2019
```

### Beans and dependency injection

#### Constructor based dep injection w/ bean definition

* xml: `<bean id="game" class="a.lp.GameIMPL" />`

* java: `Game game = context.getBean(Game.class);` passing the class

* GameIMPL container: generate a new container

```java
public GameIMPL(NumG numG) {
    this.numG = numg;
}
```

* change bean definition: `<constuctor-arg ref="numG" \>`

#### setter based dep injection

```java
//  Main.java

public void setNumG(NumG numG) {
    this.numG = numG;
}
```
* bean: `<property name="numG" ref="numG" />`

> "name" is the name of the field while "ref" is the id of bean referenced so these could be different strings...

[Spring Docs: Constructor based dep inj](https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#beans-constructor-injection)

#### differences ->

Constructors are for mandatory dependencies - usually used - should have no more than 3 arguments

Setters are for optional dependencies - default values should be used to avoid having to do a lot of `not null` checks

> Circular dependencies happen when a constructor dep injection gets stuck in a loop. A -> B == B -> A which one goes first? look for a `BeanCurrentlyInCreation` exception. Use setter injection to fix...?

### Bean lifecycle callbacks: where to put them?

* XML: needs consistent naming `<bean id...class.. init-method="reset" />` so all must be "reset"

* XML: `<beans ... default-init="reset" />` bad practice b/c of naming

* javax annotations api: add to dependencies in pom's and use on the method: `@PostContruct` or `@PreDestroy` as lifecycle methods called on the container

### Annotations vs XML callbacks

XML config:

+ outside Java classes means separation of concerns, centralized for editing, no recompilation required

+ more verbose so it is better for beginners

X typos are common

X not typesafe - verbose and error prone not caught by compiler

Annotations:

+ shorter code

+ self documenting

+ typesafe

X annotations ar ein src code and can be rather spread out to make editing decentralized

X no longer a POJO

X recompilation has to happen often

> Bean definition replaced by `@Component`?

#### @Qualifier annotation on a bean and the creation of custom annotations

* Our annotation maxNumber can be applied to fields and methods, retention policy runtime the annotations get compiled by the JVM at runtime

```java
// in Config class file

@Configuration
public class GameConfig {

    // fields
    private int maxNumber = 50;

    private int guessCount = 8;

    // bean methods
    @Bean
    @MaxNumber
    public int maxNumber() {
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount() {
        return guessCount;
    }
}

// in MaxNumber annotation file

@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface MaxNumber {

}

// in IMPL class

@Autowired
@MaxNumber
    private int maxNumber;

```

### Autowiring properties










