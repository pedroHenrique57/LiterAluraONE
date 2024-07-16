package edu.hiikkie.LiterAlura;

import edu.hiikkie.LiterAlura.application.MainApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

	MainApplication mainApplication;

	@Autowired
	public LiterAluraApplication(MainApplication mainApplication) {
		this.mainApplication = mainApplication;
	}

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		mainApplication.run();
	}
}
