package br.edu.ifspcjo.ads.web2.ifitness.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import br.edu.ifspcjo.ads.web2.ifitness.domain.model.User;
import br.edu.ifspcjo.ads.web2.ifitness.repository.UserRepository;

@Service
public class TokenService {

	@Autowired
	private JwtEncoder encoder;

	@Autowired
	private UserRepository userRepository;

	public String generateToken(Authentication authentication) {
		Instant now = Instant.now();

		String authorities = authentication.getAuthorities().stream()
				.map(GrantedAuthority::getAuthority)
				.filter(authority -> authority.startsWith("ROLE_")) // somente as permissões da aplicação
				.collect(Collectors.joining(" "));

		User user = userRepository.findByEmail(authentication.getName()).get();

		JwtClaimsSet claims = JwtClaimsSet.builder()
				.issuer("ifitness")
				.issuedAt(now)
				.expiresAt(now.plus(1, ChronoUnit.HOURS)) // o token expira em 1 hora
				.subject(authentication.getName())
				.claim("authorities", authorities)
				.claim("user_id", user.getId())
				.claim("name", user.getName())
				.build();

		return this.encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
	}

}
