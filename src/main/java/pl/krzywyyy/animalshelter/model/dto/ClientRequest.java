package pl.krzywyyy.animalshelter.model.dto;

import lombok.Getter;

@Getter
public class ClientRequest {
    private String firstName;
    private String surname;
    private String phoneNumber;
    private String email;
    private String password;
}
