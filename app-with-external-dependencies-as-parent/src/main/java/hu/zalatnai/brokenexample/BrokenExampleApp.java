package hu.zalatnai.brokenexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BrokenExampleApp {
    /*
    This application won't start, reason:
    - the parent pom locks the version federation-graphql-java-support to 0.6.3
    - the project pom imports graphql-dgs-platform-dependencies version 4.9.25
    - graphql-dgs-platform-dependencies:4.9.25 locks the version of federation-graphql-java-support to 0.7.0
    - Maven's dependency resolution algorithm gives precedence to dependencyManagement sections in the inheritance chain over the imported poms
    - Result: federation-graphql-java-support version 0.6.3 is preferred over 0.7.0. 0.6.3 is missing a method that's used by DGS, rendering the application broken.
     */
    public static void main(String[] args) {
        SpringApplication.run(BrokenExampleApp.class, args);
    }
}
