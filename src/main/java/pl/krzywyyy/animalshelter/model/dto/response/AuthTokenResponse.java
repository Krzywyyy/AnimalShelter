package pl.krzywyyy.animalshelter.model.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AuthTokenResponse {
    private final String bearer;
}
