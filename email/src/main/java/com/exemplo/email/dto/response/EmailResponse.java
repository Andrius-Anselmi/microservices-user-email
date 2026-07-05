package com.exemplo.email.dto.response;

public record EmailResponse(
        String emailTo,
        String emailSubject,
        String body
) {

}
