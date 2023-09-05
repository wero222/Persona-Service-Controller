package it.corso.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import it.corso.model.Persona;

@Service
public class PersonaServiceImpl implements PersonaService
{
	@Override
	public List<Persona> getPersone()
	{
		List<Persona> persone = new ArrayList<>();
		persone.add(new Persona("Mario", "Rossi", 50));
		persone.add(new Persona("Gianni", "Verdi", 32));
		persone.add(new Persona("Laura", "Gialli", 19));		
		return persone;
	}
}