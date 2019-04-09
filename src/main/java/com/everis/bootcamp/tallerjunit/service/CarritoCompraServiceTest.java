package com.everis.bootcamp.tallerjunit.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Test;

import com.everis.bootcamp.tallerjunit.Articulo;
import com.everis.bootcamp.tallerjunit.CarritoCompraService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)//orden alfabetico de test

public class CarritoCompraServiceTest {

	CarritoCompraService service;
	static CarritoCompraService servicereto;
	
	@BeforeClass //se ejecuta el primero siempre
	public static void InitReto() {
		System.out.println("Inicializamos el servicio 2");
		servicereto = new CarritoCompraService();
	}
	
	@Before 
	public void Inicialización() {
		System.out.println("Inicializamos el servicio 1");
		service = new CarritoCompraService();
	}
	
	@Test
	public void aaddArtTest() {
		System.out.println("\nPrimer test - añadimos articulo");
		
		assertTrue(service.getArticulos().isEmpty()); //la lista esta vacia
		System.out.println(service.getNumArticulo() + " articulos");
		
		Articulo art1 = new Articulo("balon", 15.70);
		service.addArticulo(art1);
		
		assertFalse(service.getArticulos().isEmpty());//la lista no esta vacia
		System.out.println(service.getNumArticulo() + " articulos");
		
		
		//reto
	
		System.out.println("\nPrimer test reto - añadimos articulo");
		assertTrue(servicereto.getArticulos().isEmpty());
		Articulo art2 = new Articulo("balon", 45.70);
		servicereto.addArticulo(art2);
		System.out.println(servicereto.getNumArticulo() + " articulos");
		assertFalse(servicereto.getArticulos().isEmpty());

	}	
	
	@Test
	public void bcleanListTest() {
		System.out.println("\nSegundo test - limpiar cesta");
		
		assertTrue(service.getArticulos().isEmpty());//comprobamos que esta vacia
		
		Articulo art2 = new Articulo("balon2", 15.75);
		service.addArticulo(art2);
		
		assertFalse(service.getArticulos().isEmpty());//comprobamos que hemos añadido algun articulo
		System.out.println(service.getNumArticulo() + " articulos");
		service.limpiarCesta();
		
		assertTrue(service.getArticulos().isEmpty());//comprobamos de nuevo que esta vacia
		System.out.println(service.getNumArticulo() + " articulos");
	}
	
	@Test
	public void ctotalPriceTest() {
		System.out.println("\nTercer test - total price");
		
		assertTrue(service.getArticulos().isEmpty());//comprobamos que esta vacia
		
		double va1 = 15.80;
		Articulo art2 = new Articulo("balon2", va1);
		double va2 = 20.75;
		Articulo art3 = new Articulo("balon3", va2);
		service.addArticulo(art2);
		service.addArticulo(art3);
		
		double vafinal = va1 + va2;
		
		assertFalse(service.getArticulos().isEmpty());//comprobamos que hemos añadido algun articulo
		service.totalPrice();
		System.out.println(service.getNumArticulo() + " articulos");
		
		double d = service.totalPrice();
		assertEquals(vafinal, d, 2); //suma total de los precios, metodo totalprice, cantidad articulos
		System.out.println(d + " €");
	}
	
	@Test
	public void dcalcularDescuentoTest() {
		System.out.println("\nCuarto test - descuento");
		
		assertEquals(CarritoCompraService.calculadorDescuento(50d, 20d), new Double(40));//es un metodo estatico y no se puede acceder de forma normal

	}
}
