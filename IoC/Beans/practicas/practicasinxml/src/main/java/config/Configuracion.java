package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import beans.Persona;
import beans.Rol;

@Configuration
@ComponentScan(basePackages = "beans")
public class Configuracion {
	@Bean
	public Persona daIgual1() {
		System.out.println("Generando persona");
		return new Persona();
	}

	@Bean
	public Rol daIgual2() {
		System.out.println("Generando rol uno");
		return new Rol("Uno " + System.currentTimeMillis());
	}

	@Bean
	public Rol daIgual3() {
		System.out.println("Generando rol dos");
		return new Rol("Dos " + System.currentTimeMillis());
	}

	@Bean
	@Scope("prototype")
	public String daiGual4() {
		System.out.println("Generando string");
		return "Nombre " + System.currentTimeMillis();
	}
}
