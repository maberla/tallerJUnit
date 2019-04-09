import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.everis.bootcamp.pruebamock.UserRepository;
import com.everis.bootcamp.pruebamock.UserService;

public class UserServiceTest {
	
	private static UserService service;
	
	@BeforeClass
	public static void setUp() {
		UserRepository repo = mock(UserRepository.class);//mockeo creamos un objeto mock de la clase userepositoryç
		//con la linea de abajo decimos que cuando hagamos una llamada a getallnames no devuelve una lista de alumnos sino lo que le pasamos. 
		//Esto es para probar el service. No nos importa lo que haya en  el userrepository. Como una simulacion o preparacion.
		when(repo.getAllNames()).thenReturn(Arrays.asList("Alejandro", "Pablo", "Ruben"));
		when(repo.addNomUser(Mockito.anyString()));
		service = new UserService(repo);
	}
	
	@Test
	public void testGetAll() {
		System.out.println("Test getAll");
//		service.addNomUser("Alejandro");
//		service.addNomUser("Pablo");
//		service.addNomUser("Ruben");
		
		List<String> lista = service.getAllNames();
		
		assertTrue(lista.size() == 3);//comprobacion de que hay 3 alumnos en la lista
		System.out.println("El test va bien");
	}
	
	@Test
	public void testAddName() {
		System.out.println("Test addName");
	}
}
