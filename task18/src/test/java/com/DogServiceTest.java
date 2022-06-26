package com;

import com.service.DogService;
import com.service.MailService;
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
public class DogServiceTest {
    @Mock
    private MailService emailService;
    @Mock
    private DogRepository dogRepository;
    private DogService underTest;

    @BeforeEach
    public void setUp() {
        underTest = new DogService(dogRepository, emailService);
    }

    @Test
    void create() {
        // given
        Dog dog = new Dog();
        dog.setName("Julie");
        dog.setBreed("Pug");

        // when
        underTest.saveDog(dog);

        // then
        ArgumentCaptor<Dog> dogArgumentCaptor =
                ArgumentCaptor.forClass(Dog.class);

        Mockito.verify(dogRepository).save(dogArgumentCaptor.capture());
        Mockito.verify(emailService).sendMail(dogArgumentCaptor.capture());

        Dog capturedDog = dogArgumentCaptor.getValue();
        Assertions.assertThat(capturedDog).isEqualTo(dog);
    }

    @Test
    void readAll() {
        // given
        Dog dog = new Dog();
        dog.setName("Julie");
        dog.setBreed("Pug");

        Mockito.when(dogRepository.findAll()).thenReturn(List.of(dog));

        // when
        List<Dog> expected = underTest.readAll();

        // then
        Mockito.verify(dogRepository).findAll();
        Assertions.assertThat(expected).isNotNull();
        Assertions.assertThat(expected.size()).isEqualTo(1);
        Assertions.assertThat(expected.get(0).getName()).isEqualTo(dog.getName());
        Assertions.assertThat(expected.get(0).getBreed()).isEqualTo(dog.getBreed());
    }

    @Test
    void read() {
        // given
        Dog dog = new Dog();
        dog.setName("Julie");
        dog.setBreed("Pug");
        dog.setId(1L);
        Mockito.when(dogRepository.findById(dog.getId())).thenReturn(Optional.of(dog));

        // when
        Dog expected = underTest.read(dog.getId());

        // then
        Mockito.verify(dogRepository).findById(dog.getId());
        Assertions.assertThat(expected).isEqualTo(dog);
    }

    @Test
    void update() {
        // given
        Dog dog = new Dog();
        dog.setName("Julie");
        dog.setBreed("Pug");
        dog.setId(1L);

        // when
        underTest.update(dog, dog.getId());

        // then
        Mockito.verify(dogRepository).save(dog);
    }

    @Test
    void delete() {
        // given
        Dog dog = new Dog();
        dog.setName("Julie");
        dog.setBreed("Pug");
        dog.setId(1L);

        // when
        underTest.deleteDog(dog.getId());

        // then
        Mockito.verify(dogRepository).deleteById(dog.getId());
    }

    @Test
    void findDogsByName() {
        // given
        Dog dog = new Dog();
        dog.setName("Julie");
        dog.setBreed("Pug");

        Mockito.when(dogRepository.findAllByName(dog.getName())).thenReturn(List.of(dog));

        // when
        List<Dog> existed = underTest.findDogsByName(dog.getName());

        // then
        Assertions.assertThat(existed).isNotNull();
        Assertions.assertThat(existed.size()).isEqualTo(1);
        Assertions.assertThat(existed.get(0).getName()).isEqualTo(dog.getName());
        Assertions.assertThat(existed.get(0).getBreed()).isEqualTo(dog.getBreed());
    }

    @Test
    void findDogsByBreed() {
        // given
        Dog dog = new Dog();
        dog.setName("Julie");
        dog.setBreed("Pug");

        Mockito.when(dogRepository.findAllByBreed(dog.getBreed())).thenReturn(List.of(dog));

        // when
        List<Dog> existed = underTest.findDogsByBreed(dog.getBreed());

        // then
        Assertions.assertThat(existed).isNotNull();
        Assertions.assertThat(existed.size()).isEqualTo(1);
        Assertions.assertThat(existed.get(0).getName()).isEqualTo(dog.getName());
        Assertions.assertThat(existed.get(0).getBreed()).isEqualTo(dog.getBreed());
    }
}
