package br.com.fiap.hackathon.time.tracking.driver.rest.resource.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterTimeTrackingRequest {
    private LocalDateTime timestamp;
}