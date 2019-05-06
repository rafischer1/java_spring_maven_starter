# Spring MVC Introduction - 𖠊 - ToDo List Application

## Spring Web MVC design pattern seperating concerns as information goes to the end user

* Model - business logic

* View - presentation of the information

* Control - updating the views based ont he models output

* `DispatcherServlet` expects a `WebApplicationContext` as an extension of the `ApplicationContext` and dispatches to special beans to handle req / res cycles

### Step 1 - update the properties in `pom.xml`

```xml
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
```
### Step 2 - Maven WAR plugins

[Apache Maven WAR docs](https://maven.apache.org/plugins/maven-war-plugin/)

```haskell

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

> [ERROR] Failed to execute goal org.apache.maven.plugins:maven-war-plugin:3.2.0:war (default-war) on project todo-list: Error assembling WAR: webxml attribute is required (or pre-existing WEB-INF/web.xml if executing in update mode) -> [Help 1]

```xml
<!-- Add to plugin in pom.xml -->

  <configuration>
     <failOnMissingWebXml>false</failOnMissingWebXml>
   </configuration>
```

### Step 3 - Maven Cargo plugin - run tomcat in embedded mode

[Cargo Maven2 Plugin](https://codehaus-cargo.github.io/cargo/Home.html)

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

`cargo:run` will start the localhost using the tomcat servlet

`http://localhost:8080/todo-list/index.html`

deployed successfully w/ index.html served on the apache tomcat servlet

Setting up the MVC servlet with a Java code based approach to register dispatcher server:

Java -> WebConfig.java

```java
@EnableWebMvc - [allows registers and bean specific to SpringMVC]
@Configuration
@ComponentScan(basePackages = "academy.learnprogramming")
public class WebConfig {
}
```

```xml
<dependency>
   <groupId>javax.servlet</groupId>
   <artifactId>javax.servlet-api</artifactId>
   <version>${servlet-api-version}</version>
   <scope>provided</scope>
</dependency>
```

### CRUD Mapping in Spring

`@Controller` is the annotation that handles the incoming requests
`@RequestMapping` - media types, headers, http control CRUD maps

must define a view to display back to users 

> errror: Message Circular view path [hello]: would dispatch back to the current handler URL [/todo-list/hello] again. Check your ViewResolver setup! (Hint: This may be the result of an unspecified view, due to default view name generation.)

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

### Views with ViewResolver

* mapping between view names and JSP - java server pages

* JavaServer Pages Standard Tag Library - JSTL has control flow and common task events

```java
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
```

### Models and Model Attributes

`@ModelAttribute` - access the attributes in the .jsp file

it is a key: value pair attribute 

`[INFO ] a.l.controller.DemoController : welcome.jsp served model {user=Stevie}`

`<h4>${welcomeMessage} User: ${user}</h4>`

```java
    @ModelAttribute("welcomeMessage")
    public String welcomeMessage() {
        log.info("welcome message called");
        return "welcome to the world new application";
    }
```

`@Service` - stereotype annotation scanned by Spring holding the business models to process data

### Request Parameters

[@RequestParam Docs](https://www.baeldung.com/spring-request-param)

```java

   // http://localhost:8080/todo-list/welcome?user=Troi&age=28
    @GetMapping("welcome")
    public String welcome(@RequestParam String user, @RequestParam int age, Model model) {
        model.addAttribute("helloMessage", demoService.getHelloMessage(user));
        model.addAttribute("age", age);
        log.info("welcome.jsp served model {}", model);
        return "welcome";
    }
```

### ToDo List items w and w/o Lombok

```java
// without lombok

public class TodoItem {

    // fields
    private int id;
    private String title;
    private String details;
    private LocalDate deadline;

// constructor
    public TodoItem(String title, String details, LocalDate deadline) {
        this.title = title;
        this.details = details;
        this.deadline = deadline;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    // equals and hash code check
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TodoItem)) return false;

        TodoItem todoItem = (TodoItem) o;

        return id == todoItem.id;

    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", details='" + details + '\'' +
                ", deadline=" + deadline +
                '}';
    }
}
```

[@Data annotation docs - Lombok](https://projectlombok.org/features/Data)


```java
// with lombok for getters/setters/tostring/hash/and check

@Data
@EqualsAndHashCode(of = "id")
public class TodoItem {

    // fields
    private int id;
    private String title;
    private String details;
    private LocalDate deadline;

    // constructor
    public TodoItem(String title, String details, LocalDate deadline) {
        this.title = title;
        this.details = details;
        this.deadline = deadline;
    }

}
```

### CRUD Routes!

```java
public class TodoData {

    //fields
    private static int idValue = 1;

    private final List<TodoItem> items = new ArrayList<>();

    // constructor
    public TodoData() {
    }

    // ==public CRUD methods==

    // Get All
    public List<TodoItem> getItems() {
        return Collection.unmodifiableList(items);
    }

    // getOne
    public TodoItem getItem(int id) {
        for (TodoItem item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    // Create
    public void addItems(@NonNull TodoItem toAdd) {
        toAdd.setId(idValue);
        items.add(toAdd);
        idValue++;
    }

    // Update
    public void updateItem(@NonNull TodoItem toUpdate) {
        ListIterator<TodoItem> itemIterator = items.ListIterator();

        while (itemIterator.hasNext()) {
            TodoItem item = itemIterator.next();

            if (item.equals(toUpdate)) {
                itemIterator.set(toUpdate);
                break;
            }
        }
    }

    // Delete
    public static void removeItem(int id) {
        ListIterator<TodoItem> itemIterator = items.ListIterator();

        while (itemIterator.hasNext()) {
            TodoItem item = itemIterator.next();

            if (item.getId() == id) {
                itemIterator.remove();
                break;
            }
        }
    }


}
```

### JSP file and JSTL tags - standard tag library for control flow

[JSTL Oracle Docs](https://docs.oracle.com/javaee/5/jstl/1.1/docs/tlddocs/)

`<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>`

```xml
<c:forEach var="item" items="${todoData.items}">
    <tr>
        <td><c:out value="${item.title}" /></td>
        <td><c:out value="${item.deadline}" /></td>
    </tr>
</c:forEach>
```

### Spring Form Tags

`<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>`

redirecting the view to another URL w/ the items table

```java
   // post redirect GET method
    @PostMapping(Mappings.ADD_ITEM)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem todoItem) {
        return "redirect:/" + Mappings.ITEMS;
    }
```

```jsp
<%@ import="academy.learnprogramming.util.AttributeNames" %>

<form:form method="POST" modelAttribute="${AttributeName.TODO_ITEM}"

</form:form>
```

#### Mapping and Posting routes referencing view names and attribute class

```java
  @GetMapping(Mappings.ADD_ITEM)
    public String addEditItem(Model model) {
        TodoItem todoItem = new TodoItem("", "", LocalDate.now());
        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
        return ViewNames.ADD_ITEM;
    }

    // post redirect GET method
    @PostMapping(Mappings.ADD_ITEM)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem todoItem) {
        log.info("todoItem from form = {}", todoItem);
        todoItemService.addItem(todoItem);
        return "redirect:/" + Mappings.ITEMS;
    }
```





