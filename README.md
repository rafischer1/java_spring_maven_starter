# Java Spring Maven Project Starter Pack

## Refer to the markdown in the project file for more information on info and project setup notes

---

### Java notes:

> @Override: Overriding is a feature that allows a subclass or child class to provide a specific implementation of a method that is already provided by one of its super-classes or parent classes. Private methods can not be overridden. must have same return type. 

[Java Docs on Annotation Types incl @Override](https://docs.oracle.com/javase/tutorial/java/annotations/predefined.html)

Spring MVC Introduction - 𖠊 - ToDo List Application
Spring Web MVC design pattern seperating concerns as information goes to the end user
Model - business logic

View - presentation of the information

Control - updating the views based ont he models output

DispatcherServlet expects a WebApplicationContext as an extension of the ApplicationContext and dispatches to special beans to handle req / res cycles

Step 1 - update the properties in pom.xml
  <properties>
        <spring-version>5.1.6.RELEASE</spring-version>
    </properties>


    <dependencies>
        <!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>${spring-version}</version>
        </dependency>
    </dependencies>
Step 2 - Maven WAR plugins
Apache Maven WAR docs

```xml
 <packaging>war</packaging>

   <plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-war-plugin</artifactId>
    <version>3.2.0</version>
   </plugin>

 |-- pom.xml
 `-- src
     `-- main
         |-- java
         |   `-- com
         |       `-- example
         |           `-- projects
         |               `-- SampleAction.java
         |-- resources
         |   `-- images
         |       `-- sampleimage.jpg
         `-- webapp
             |-- WEB-INF
             |   `-- web.xml
             |-- index.jsp
             `-- jsp
                 `-- websource.jsp
```

[ERROR] Failed to execute goal org.apache.maven.plugins:maven-war-plugin:3.2.0:war (default-war) on project todo-list: Error assembling WAR: webxml attribute is required (or pre-existing WEB-INF/web.xml if executing in update mode) -> [Help 1]

```xml

<!-- Add to plugin in pom.xml -->

  <configuration>
     <failOnMissingWebXml>false</failOnMissingWebXml>
   </configuration>
```

Step 3 - Maven Cargo plugin - run tomcat in embedded mode
Cargo Maven2 Plugin

```xml
   <plugin>
     <groupId>org.codehaus.cargo</groupId>
     <artifactId>cargo-maven2-plugin</artifactId>
     <version>1.6.7</version>
     <configuration>
       <container>
         <containerId>tomcat9x</containerId>
         <type>embedded</type>
       </container>
     </configuration>
   </plugin>
```

cargo:run will start the localhost using the tomcat servlet

http://localhost:8080/todo-list/index.html

deployed successfully w/ index.html served on the apache tomcat servlet

Setting up the MVC servlet with a Java code based approach to register dispatcher server:

Java -> WebConfig.java

```java
@EnableWebMvc - [allows registers and bean specific to SpringMVC]
@Configuration
@ComponentScan(basePackages = "academy.learnprogramming")
public class WebConfig {
}
<dependency>
   <groupId>javax.servlet</groupId>
   <artifactId>javax.servlet-api</artifactId>
   <version>${servlet-api-version}</version>
   <scope>provided</scope>
</dependency>

```

CRUD Mapping in Spring
@Controller is the annotation that handles the incoming requests @RequestMapping - media types, headers, http control CRUD maps

must define a view to display back to users

errror: Message Circular view path [hello]: would dispatch back to the current handler URL [/todo-list/hello] again. Check your ViewResolver setup! (Hint: This may be the result of an unspecified view, due to default view name generation.)

Disptacher servlet gets the request and passes it to the Controller to write directly to response body

```java

@Controller
public class DemoController {

    // http://localhost:8080/todo-list/hello
    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
```

Views with ViewResolver
mapping between view names and JSP - java server pages

JavaServer Pages Standard Tag Library - JSTL has control flow and common task events

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "academy.learnprogramming")
public class WebConfig {

    // constants
    public static final String RESOLVER_PREFIX = "/WEB-INF/view/";
    public static final String RESOLVER_SUFFIX = ".jsp";

    // beans
    @Bean
    public ViewResolver viewResolver() {
        UrlBasedViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix(RESOLVER_PREFIX);
        viewResolver.setSuffix(RESOLVER_SUFFIX);
        return viewResolver;
    }
}
Models and Model Attributes
@ModelAttribute - access the attributes in the .jsp file

it is a key: value pair attribute

[INFO ] a.l.controller.DemoController : welcome.jsp served model {user=Stevie}

```haskell

<h4>${welcomeMessage} User: ${user}</h4>

    @ModelAttribute("welcomeMessage")
    public String welcomeMessage() {
        log.info("welcome message called");
        return "welcome to the world new application";
    }
```

@Service - stereotype annotation scanned by Spring holding the business models to process data

Lombok - generate boilerplate code
@Data - generates POJO objecte which combines a lot of these following annotations

@Getter - Lombok automatically generates the getter

@Setter - Lombok automatically generated the setter

@ToString - toString() method

@EqualsAndHashCode - equals() and hashCode() methods

@RequiredArgsConstructor - constructor with required arguments

@Slf4j - private final static field for Logger

```java
@Component
@Slf4j
@Getter
public class GameIMPL implements Game {

    // fields
    @Getter(AccessLevel.NONE)
    private final NumberGenerator numberGenerator;

    @Setter
    private int guess;

    ... }
```
