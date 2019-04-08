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


