package com;

import com.service.MailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@ExtendWith(MockitoExtension.class)
public class MailServiceTest {
    @Mock
    private JavaMailSenderImpl javaMailSenderImpl;
    private MailService underTest;

    @BeforeEach
    void setUp() {
        underTest = new MailService(javaMailSenderImpl);
    }

    @Test
    void sendNotification() {
        // given
        User user = new User();
        user.setFirstName("Damian");
        user.setLastName("Kerk");
        user.setId(1L);
        //Mockito.doNothing().when(javaMailSenderImpl).send(Mockito.any(SimpleMailMessage.class));

        // when
        underTest.sendMail(user);

        // then
        Mockito.verify(javaMailSenderImpl).send(Mockito.any(SimpleMailMessage.class));
    }
}
