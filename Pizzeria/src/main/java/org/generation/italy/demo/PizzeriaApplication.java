package org.generation.italy.demo;

import java.util.List;

import org.generation.italy.demo.pojo.Pizza;
import org.generation.italy.demo.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PizzeriaApplication implements CommandLineRunner {

	@Autowired
	private PizzaService pizzaService;
	
	public static void main(String[] args) {
		SpringApplication.run(PizzeriaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		// INSERIMENTO PIZZE

		Pizza p1 = new Pizza("Margherita", "La classica pizza napoletana", 4);
		Pizza p2 = new Pizza("Marinara", "Leggera ed essenziale, la tradizione", 3);
		Pizza p3 = new Pizza("Diavola", "Un sapore piccante su un letto di pomodoro", 5);
		Pizza p4 = new Pizza("Pizza fritta", "Ripieno fritto tradizionale", 7);

		pizzaService.save(p1);
		pizzaService.save(p2);
		pizzaService.save(p3);
		pizzaService.save(p4);
		
		List<Pizza> pizzas = pizzaService.findAll();
		System.err.println(pizzas);
		
		for(Pizza pizza : pizzas) {
			System.err.println("\n" + pizza);
		}
		
	}

}
