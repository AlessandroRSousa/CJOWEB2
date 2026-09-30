package br.edu.ifspcjo.ads.web2.ifitiness.resource;
	
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifspcjo.ads.web2.ifitiness.domain.model.Gender;
import br.edu.ifspcjo.ads.web2.ifitiness.domain.model.User;

@RestController 
public class UserResource {

    @GetMapping ("/users")
    public List<User> list(){
        var user1 = new User();
		user1.setId(1L);
		user1.setName("Fernando Duarte");
		user1.setEmail("fernandoduarte@ifsp.edu.br");
		user1.setPassword("cjoweb3");
		user1.setBirthDate(LocalDate.of(1975, 11, 16));
		user1.setGender(Gender.MASCULINO);
		user1.setActive(true);
		
		var user2 = new User();
		user2.setId(2L);
		user2.setName("Adriana Santos");
		user2.setEmail("adrianasantos@ifsp.edu.br");
		user2.setPassword("adriana");
		user2.setBirthDate(LocalDate.of(1980, 1, 1));
		user2.setGender(Gender.FEMININO);
		user2.setActive(true);
		
		return Arrays.asList(user1, user2);	
	}


}

