package com.hcl.petpeersapp.testservice;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import com.hcl.petpeersapp.persistance.entity.User;
import com.hcl.petpeersapp.persistance.repository.UserRepository;
import com.hcl.petpeersapp.service.UserService;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)

public class UserServiceTest {
	@Autowired
	UserService userService;

	@MockBean
	UserRepository userRepository;

	
	
	@Before
	public void setUp() {
		User alex = new User(1L, "alex", "abc@123");
		Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(alex));
	}

	@Test
	public void whenValidName_thenEmployeeShouldBeFound() {
		Long userId = 1L;
		com.hcl.petpeersapp.domain.User user = userService.getUserById(userId);
		 assertThat(user.getUsername())
	      .isEqualTo("alex");
	}

}
