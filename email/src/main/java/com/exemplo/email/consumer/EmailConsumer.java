package com.exemplo.email.consumer;

import com.exemplo.email.dto.response.EmailResponse;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @RabbitListener(queues = "email-queue")
    public void listenEmail(@Payload EmailResponse emailResponse) {
        System.out.println(emailResponse.emailTo());
    }

}
