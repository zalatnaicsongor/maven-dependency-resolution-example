package hu.zalatnai.workingexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WorkingExampleApp {
    /*
    This application will start, reason:
    - the project pom imports hu.zalatnai:external-dependencies
    - hu.zalatnai:external-dependencies locks the version of federation-graphql-java-support to 0.6.3
    - the project pom imports graphql-dgs-platform-dependencies version 4.9.25
    - graphql-dgs-platform-dependencies:4.9.25 locks the version of federation-graphql-java-support to 0.7.0
    - Maven's dependency resolution algorithm gives precedence to the version defined in graphql-dgs-platform-dependencies over the version defined in hu.zalatnai:external-dependencies
    - Result: federation-graphql-java-support version 0.7.0 is preferred over 0.6.3. The application starts as intended.
     */
    public static void main(String[] args) {
        SpringApplication.run(WorkingExampleApp.class, args);
    }
}
