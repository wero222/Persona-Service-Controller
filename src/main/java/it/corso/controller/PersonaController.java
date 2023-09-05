package it.corso.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import it.corso.model.Persona;
import it.corso.service.PersonaService;

@RestController
@RequestMapping("/api/persona")
public class PersonaController
{
	@Autowired
	private PersonaService personaService;
	
	// endpoint per ottenere i dati di una persona in formato testuale  localhost:8080/api/persona/get/text
	@GetMapping(value = "/get/text", produces = "text/plain")
	public String getPersonaText()
	{
		Persona persona = personaService.getPersone().get(0);
		String response = persona.getNome() + " " + persona.getCognome() + " - " + persona.getEta();
		return response;
	}
	
	// endpoint per ottenere elenco di persone in formato xml  localhost:8080/api/persona/get/xml
	@GetMapping(value = "/get/xml", produces = "application/xml")
	public String getPersoneXml()
	{
		List<Persona> persone = personaService.getPersone();
		XmlMapper xmlMapper = new XmlMapper();
		try
		{
			return xmlMapper.writeValueAsString(persone);
		} catch (JsonProcessingException e)
		{
			return null;
		}
	}
	
	// endpoint per ottenere elenco di persone in formato json  localhost:8080/api/persona/get/json
	@GetMapping(value = "/get/json", produces = "application/json")
	public List<Persona> getPersoneJson()
	{
		return personaService.getPersone();
	}
}