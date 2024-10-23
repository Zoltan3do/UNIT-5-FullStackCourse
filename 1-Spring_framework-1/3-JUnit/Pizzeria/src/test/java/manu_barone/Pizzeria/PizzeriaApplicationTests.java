package manu_barone.Pizzeria;

import manu_barone.Pizzeria.entities.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PizzeriaApplicationTests {

	@Autowired
	private Menu menu;

	@Autowired
	private Bevanda bevanda;

	@Autowired
	@Qualifier("peroni")
	private Bevanda peroni;

	@Autowired
	private Tavolo tavolo1;

	static AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(PizzeriaApplication.class);


	@Test
	void testGetAllProducts(){
		List<Prodotto> prodotti = menu.getProdotti();
		assertNotNull(prodotti);
        assertFalse(prodotti.isEmpty(), "Menu vuoto!");
	}


	@Test
	void cocaColaTest(){
		Bevanda cocacola = bevanda;
		System.out.println(cocacola);
		assertNotNull(cocacola,"La cocacola non esiste!");
	}


	@Test
	void peroniTest( ){
		Bevanda peroni2 = peroni;
		System.out.println(peroni2);
		assertNotNull(peroni2,"La peroni non esiste!");
	}


	static Stream<Arguments> copertoPrice(){
		return Stream.of(Arguments.of(5, ctx.getBean("costoCoperto")));
	}
	@ParameterizedTest
	@MethodSource("copertoPrice")
	void creazioneOrdine(int numeroCoperti, double coperto){
		Ordine o;
		o = new Ordine(menu.getProdotti(),numeroCoperti,tavolo1,coperto);
		assertNotNull(o,"L'ordine è null");
	}
	

	@ParameterizedTest
	@CsvSource({"0.45,FUNGHI,333"})
	void creazioneIngrediente(double prezzo, String nome, double calorie) {
		Topping t = new Topping(prezzo, nome, calorie);
		System.out.println(t);
		assertNotNull(t, "Non istanziato correttamente");
	}

}
