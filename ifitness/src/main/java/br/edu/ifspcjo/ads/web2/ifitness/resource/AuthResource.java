package br.edu.ifspcjo.ads.web2.ifitness.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifspcjo.ads.web2.ifitness.service.TokenService;

@RestController
@RequestMapping("/api/auth")
public class AuthResource {

	@Autowired
	private TokenService tokenService;

	@Autowired
	private AuthenticationManager authenticationManager;

	// objetos que representam o JSON da requisição e o JSON da resposta
	public record LoginRequest(String username, String password) {}
	public record LoginResponse(String accessToken) {}

	@PostMapping("/login")
	public LoginResponse login(@RequestBody LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password()));

		String accessToken = tokenService.generateToken(authentication);
		return new LoginResponse(accessToken);
	}

}
