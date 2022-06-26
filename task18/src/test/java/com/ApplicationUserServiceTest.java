package com;

import com.security.AppUser;
import com.security.AppUserRepository;
import com.service.ApplicationUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@ExtendWith(MockitoExtension.class)
public class ApplicationUserServiceTest {
    @Mock
    private AppUserRepository userRepository;
    ApplicationUserService underTest;

    @BeforeEach
    public void setUp() {
        underTest = new ApplicationUserService(new BCryptPasswordEncoder(10), userRepository);
    }

    @Test
    public void getUsers() {
        // given
        AppUser user = new AppUser();
        user.setUsername("user");

        // when
        Mockito.when(userRepository.findUserByUsername(user.getUsername())).thenReturn(user);

        // then
        Assertions.assertEquals(user.getUsername(), underTest.loadUserByUsername(user.getUsername()).getUsername());
    }

    @Test
    public void saveOrUpdate() {

    }
}
