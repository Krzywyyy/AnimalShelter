package pl.krzywyyy.animalshelter.model.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class ClientRequest {
    private String firstName;
    private String surname;
    private String phoneNumber;
    private String email;
    private String password;

    @Setter
    private List<String> roles;
}
