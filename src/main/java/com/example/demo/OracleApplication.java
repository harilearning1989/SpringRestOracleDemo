package com.example.demo;

import com.example.demo.entity.Person;
import com.example.demo.repos.IPersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@SpringBootApplication
public class OracleApplication implements CommandLineRunner {

    //http://localhost:8081/swagger-ui.html
    //localhost:8082/SpringRestOracleDemo/swagger-ui.html#/  tomcat deployment
    //http://192.168.1.200:8082/SpringRestOracleDemo/swagger-ui.html

    private static final Logger LOGGER = LoggerFactory.getLogger(OracleApplication.class);
    @Autowired
    private IPersonRepository repo;

    @Autowired
    private Environment env;

    public static void main(String[] args) {
        SpringApplication.run(OracleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("=====================Logging Start====================================");
        LOGGER.info("JAVA_HOME==", env.getProperty("JAVA_HOME"));
        LOGGER.info("app.name==", env.getProperty("app.name"));
        LOGGER.info("local.server.port==:", env.getProperty("local.server.port"));

        LOGGER.info("getHostAddress=="+InetAddress.getLocalHost().getHostAddress());
        LOGGER.info("getHostName=="+InetAddress.getLocalHost().getHostName());
        LOGGER.info("======================Logging End======================================");
        System.out.println("=====================SOUT Starting==============================");

        System.out.println("JAVA_HOME=="+ env.getProperty("JAVA_HOME"));
        System.out.println("app.name=="+ env.getProperty("app.name"));
        System.out.println("local.server.port==:"+ env.getProperty("local.server.port"));

        LOGGER.info("getHostAddress=="+InetAddress.getLocalHost().getHostAddress());
        LOGGER.info("getHostName=="+InetAddress.getLocalHost().getHostName());
        System.out.println("=====================SOUT Ending==============================");
        savePersonData();
    }

    private void savePersonData() {
        List<Person> persons = createPersons();
        repo.saveAll(persons);

        System.out.println(" -- getting all persons --");
        Iterable<Person> iterable = repo.findAll();
        List<Person> allPersons = StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
        allPersons.forEach(System.out::println);

        Person person = allPersons.get(0);
        System.out.printf("-- moving person with id %s to history --%n", person.getId());
        String b = repo.movePersonToHistory(person.getId());
        System.out.println("output status: " + b);

        person = allPersons.get(1);
        System.out.printf("-- moving person with id %s to history --%n", person.getId());
        b = repo.movePersonToHistory(person.getId());
        System.out.println("output status: " + b);

        System.out.println("-- getting all persons again --");
        repo.findAll().forEach(System.out::println);

        System.out.println("-- fetching from  person history --");
        //repo.fetchPersonHistory().forEach(System.out::println);
    }

    private List<Person> createPersons() {
        return Arrays.asList(Person.create("Dana", "Whitley", "464 Gorsuch Drive"),
                Person.create("Robin", "Cash", "64 Zella Park"),
                Person.create("Chary", "Mess", "112 Yellow Hill"),
                Person.create("Rose", "Kantata", "2736 Kooter Lane"),
                Person.create("Mike", "Togglie", "111 Cool Dr"));
    }
}
