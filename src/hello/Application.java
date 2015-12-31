package hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.GenericApplicationContext;

@Configuration
@ComponentScan
public class Application {

	@Bean
	// @Scope("prototype")
	MessageService mockMessageService() {
		return new MessageService() {

			@Override
			public String getMessage() {
				return "Hello World motherfucker" + "";
			}
		};
	}

	public static void main(String[] args) {

		GenericApplicationContext context = new AnnotationConfigApplicationContext(
				Application.class);

		MessagePrinter printer = context.getBean(MessagePrinter.class);
		printer.printMessage();
		context.close();

	}

}
