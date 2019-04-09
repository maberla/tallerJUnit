package com.everis.bootcamp.tallerjunit;

import java.util.ArrayList;
import java.util.List;

public class CarritoCompraService {
	
	List<Articulo> articulos = new ArrayList<Articulo>();
	
	static List<Articulo> articulos2 = new ArrayList<Articulo>();
	
	public void limpiarCesta(){
		articulos = new ArrayList<Articulo>();
	}
	
	public void addArticulo(Articulo a){
		articulos.add(a);
	}
	
	public int getNumArticulo(){
		return articulos.size();
	}
	
	//stream. de todos los articulos los convierte en string y llama de cada uno de ellos a la funcion getprecio, los almacena y realiza una suma de todos (se ahorra codigo)
	public Double totalPrice(){
		double precioTotal = articulos.stream().  	
			     mapToDouble(Articulo::getPrecio).
			     sum();
		return precioTotal;
	}
	
	public static Double calculadorDescuento(double precio, double porcentajeDescuento){
		return precio - (precio * (porcentajeDescuento/100));
	}

	public List<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}
}
