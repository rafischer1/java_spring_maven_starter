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











