package io.project.webapi.auth.common;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;


@Data
@Builder
class ErrorResponse {

    private  LocalDateTime timestamp = LocalDateTime.now();
    private  String message;
    @Builder.Default
    private List<String> details = Collections.emptyList();
}
