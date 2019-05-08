# Spring Boot Initialzr Demo Project

`logback.xml => logback-spring.xml`

importing `base.xml` in logback so the console logger and spring included logging is hooked up: 

```xml
<configuration>
    <include resource="org/springframework/boot/logging/logback/base.xml" />

    <logger name="academy.learnprogramming" level="DEBUG" />
    <logger name="org.springframework" level="DEBUG" />

</configuration>
```

* color output for logging: `application.properties file` 

```haskell
# enable ansi output
spring.output.ansi.enabled = always
```

## Create Controller class in `boot` src folder to `:8080/demo`

`m.m.a.RequestResponseBodyMethodProcessor : Writing ["Hello Spring Boot!"]`

```java
@Slf4j
@Controller
public class DemoController {

    @ResponseBody
    @GetMapping("demo")
    public String demo() {
        return "Hello Spring Boot!";
    }
}
```

## Generate a simple view

```java
 @GetMapping("welcome")
 public String welcome(Model model) {
        log.info("Welcome model called = {}", model);
        model.addAttribute("message", "welcome to Spring Boot");
        return "welcome";
    }
```

error: `This application has no explicit mapping for /error, so you are seeing this as a fallback.`

solution: in `application.properties` add the path and view file type

```haskell
#spring mvc
spring.mvc.view.prefix = "/WEB-INF/view/"
spring.mvc.view.suffix = ".jsp"
```

error: `This application has no explicit mapping for /error, so you are seeing this as a fallback.`

solution: `.jsp` file has limitations with embedded containers (use thymeleaf!)








