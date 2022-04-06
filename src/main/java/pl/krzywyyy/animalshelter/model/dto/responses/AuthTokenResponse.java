package pl.krzywyyy.animalshelter.model.dto.responses;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AuthTokenResponse {
    private final String bearer;
}
