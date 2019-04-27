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


                    



