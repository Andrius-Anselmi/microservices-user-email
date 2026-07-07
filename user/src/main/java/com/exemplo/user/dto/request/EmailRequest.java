package com.exemplo.user.dto.request;

import java.util.UUID;

public record EmailRequest(
        UUID emailId,
        String emailTo,
        String emailSubject,
        String body
) {
}
