package com.exemplo.user.producer;

import com.exemplo.user.domain.UserModel;
import com.exemplo.user.dto.request.EmailRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Component
public class UserProducer {

    private final RabbitTemplate rabbitTemplate;
    final String subject = "Welcome";
    final String body = "We're really happy to have you with us. From now on, you're part of our community "
            + "and will have access to everything we've carefully prepared for you. If you have any questions "
            + "or need help, we're here for you,just reach out. Let's go on this journey together!";

    private static final String routingKey = "email-queue";

    public void publishEvent(UserModel userModel) {
        EmailRequest emailRequest = new EmailRequest(
                userModel.getUserId(), userModel.getEmail(), subject, body);

        System.out.println("Publishing: " + emailRequest); // log


        rabbitTemplate.convertAndSend(
                "",
                routingKey,
                emailRequest);
    }





}
