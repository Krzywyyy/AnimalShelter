package pl.krzywyyy.animalshelter.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import pl.krzywyyy.animalshelter.mappers.annotations.PasswordEncoder;

@Component
@RequiredArgsConstructor
public class PasswordMapper {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @PasswordEncoder
    public String encodePassword(String plainPassword) {
        return bCryptPasswordEncoder.encode(plainPassword);
    }
}
