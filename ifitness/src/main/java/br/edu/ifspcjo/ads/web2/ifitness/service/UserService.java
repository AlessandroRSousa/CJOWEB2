package br.edu.ifspcjo.ads.web2.ifitness.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.edu.ifspcjo.ads.web2.ifitness.domain.model.Permission;
import br.edu.ifspcjo.ads.web2.ifitness.domain.model.User;
import br.edu.ifspcjo.ads.web2.ifitness.repository.PermissionRepository;
import br.edu.ifspcjo.ads.web2.ifitness.repository.UserRepository;
import br.edu.ifspcjo.ads.web2.ifitness.service.exception.EmailAlreadyRegisteredException;

@Service
public class UserService {

    @Autowired
	private UserRepository userRepository;

	@Autowired
	private PermissionRepository permissionRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public User save(User user) {
		if (userRepository.existsByEmail(user.getEmail())) {
			throw new EmailAlreadyRegisteredException();
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setPermissions(getCommonUserPermissions());
		return userRepository.save(user);
	}

	public User findUserById(Long id) {
		User userSaved = userRepository.findById(id)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		return userSaved;
	}

	// permissão de quem se cadastra: ROLE_SEARCH_USER (1)
	private List<Permission> getCommonUserPermissions() {
		List<Permission> permissions = new ArrayList<>();
		permissions.add(permissionRepository.findById(1L).get());
		return permissions;
	}
}
