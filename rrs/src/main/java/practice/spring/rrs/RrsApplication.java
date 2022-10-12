package practice.spring.rrs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class RrsApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(RrsApplication.class, args);
        GreetingClient greetingClient = context.getBean(GreetingClient.class);
        // We need to block for the content here or the JVM might exit before the message is logged
        System.out.println(">> message = " + greetingClient.getMessage().block());
    }

	@RestController
	class Day1Controller {
		@GetMapping("/day1")
		public List<String> day1() {
			return Arrays.asList("Thursday","Friday");

		}
	}
}