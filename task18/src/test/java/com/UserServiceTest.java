package com;

import com.service.MailService;
import com.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private MailService emailService;
    @Mock
    private UserRepository userRepository;
    private UserService underTest;

    @BeforeEach
    public void setUp() {
        underTest = new UserService(userRepository, emailService);
    }

    @Test
    void create() {
        // given
        User user = new User();
        user.setFirstName("Damian");
        user.setLastName("Kerk");

        // when
        underTest.saveUser(user);

        // then
        ArgumentCaptor<User> userArgumentCaptor =
                ArgumentCaptor.forClass(User.class);

        Mockito.verify(userRepository).save(userArgumentCaptor.capture());
        Mockito.verify(emailService).sendMail(userArgumentCaptor.capture());

        User capturedUser = userArgumentCaptor.getValue();
        Assertions.assertThat(capturedUser).isEqualTo(user);
    }

    @Test
    void readAll() {
        // given
        User user = new User();
        user.setFirstName("Damian");
        user.setLastName("Kerk");

        Mockito.when(userRepository.findAll()).thenReturn(List.of(user));

        // when
        List<User> expected = underTest.readAll();

        // then
        Mockito.verify(userRepository).findAll();
        Assertions.assertThat(expected).isNotNull();
        Assertions.assertThat(expected.size()).isEqualTo(1);
        Assertions.assertThat(expected.get(0).getFirstName()).isEqualTo(user.getFirstName());
        Assertions.assertThat(expected.get(0).getLastName()).isEqualTo(user.getLastName());
    }

    @Test
    void read() {
        // given
        User user = new User();
        user.setFirstName("Damian");
        user.setLastName("Kerk");
        user.setId(1L);
        Mockito.when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));

        // when
        User expected = underTest.read(user.getId());

        // then
        Mockito.verify(userRepository).findById(user.getId());
        Assertions.assertThat(expected).isEqualTo(user);
    }

    @Test
    void update() {
        // given
        User user = new User();
        user.setFirstName("Damian");
        user.setLastName("Kerk");
        user.setId(1L);

        // when
        underTest.update(user, user.getId());

        // then
        Mockito.verify(userRepository).save(user);
    }

    @Test
    void delete() {
        // given
        User user = new User();
        user.setFirstName("Damian");
        user.setLastName("Kerk");
        user.setId(1L);

        // when
        underTest.deleteUser(user.getId());

        // then
        Mockito.verify(userRepository).deleteById(user.getId());
    }

    @Test
    void findUsersByFirstName() {
        // given
        User user = new User();
        user.setFirstName("Damian");
        user.setLastName("Kerk");

        Mockito.when(userRepository.findAllByFirstName(user.getFirstName())).thenReturn(List.of(user));

        // when
        List<User> existed = underTest.findUsersByFirstName(user.getFirstName());

        // then
        Assertions.assertThat(existed).isNotNull();
        Assertions.assertThat(existed.size()).isEqualTo(1);
        Assertions.assertThat(existed.get(0).getFirstName()).isEqualTo(user.getFirstName());
        Assertions.assertThat(existed.get(0).getLastName()).isEqualTo(user.getLastName());
    }

    @Test
    void findUsersByLastName() {
        // given
        User user = new User();
        user.setFirstName("Damian");
        user.setLastName("Kerk");

        Mockito.when(userRepository.findAllByLastName(user.getLastName())).thenReturn(List.of(user));

        // when
        List<User> existed = underTest.findUsersByLastName(user.getLastName());

        // then
        Assertions.assertThat(existed).isNotNull();
        Assertions.assertThat(existed.size()).isEqualTo(1);
        Assertions.assertThat(existed.get(0).getFirstName()).isEqualTo(user.getFirstName());
        Assertions.assertThat(existed.get(0).getLastName()).isEqualTo(user.getLastName());
    }
}
