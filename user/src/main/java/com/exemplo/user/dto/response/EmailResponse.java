package com.exemplo.user.dto.response;

public record EmailResponse(
        String emailTo,
        String emailSubject,
        String body
) {

}
