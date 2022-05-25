package pl.krzywyyy.animalshelter.testing;

import lombok.experimental.UtilityClass;
import pl.krzywyyy.animalshelter.model.dto.commands.create.CreateAddressCommand;
import pl.krzywyyy.animalshelter.model.dto.commands.create.CreateAdoptionCommand;
import pl.krzywyyy.animalshelter.model.dto.commands.create.CreateAnimalCommand;
import pl.krzywyyy.animalshelter.model.dto.commands.create.CreateClientCommand;
import pl.krzywyyy.animalshelter.model.dto.commands.create.CreateEmployeeCommand;
import pl.krzywyyy.animalshelter.model.enums.AnimalType;
import pl.krzywyyy.animalshelter.model.enums.Gender;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@UtilityClass
public class TestData {
    final List<CreateAnimalCommand> animals = List.of(
            new CreateAnimalCommand("Boris", AnimalType.DOG.name(), Gender.MALE.name(), dateOf(5, 3, 2020), Collections.emptyList()),
            new CreateAnimalCommand("Alfred", AnimalType.CAT.name(), Gender.MALE.name(), dateOf(7, 1, 2006), Collections.emptyList()),
            new CreateAnimalCommand("Kamil", AnimalType.CAT.name(), Gender.MALE.name(), dateOf(12, 10, 2021), Collections.emptyList()),
            new CreateAnimalCommand("Matylda", AnimalType.BIRD.name(), Gender.FEMALE.name(), dateOf(21, 4, 2018), Collections.emptyList()),
            new CreateAnimalCommand("Max", AnimalType.RABBIT.name(), Gender.MALE.name(), dateOf(3, 8, 2013), Collections.emptyList())
    );
    final List<CreateAddressCommand> addresses = List.of(
            new CreateAddressCommand("Wymyślona", "5", "13", "00-123", "Warszawa", 1),
            new CreateAddressCommand("Magiczna", "10", "13", "11-993", "Przemyśl", 2),
            new CreateAddressCommand("Rozkoszna", "52a", "4", "02-121", "Kraków", 3),
            new CreateAddressCommand("Kwiatowa", "12", "1", "05-143", "Sopot", 4)
    );
    final List<CreateClientCommand> clients = List.of(
            new CreateClientCommand("Karol", "Nowak", "601231946", "k.nowak@gmail.com", "Haslo123!"),
            new CreateClientCommand("Paweł", "Grzywacz", "677122362", "p.grzywacz@gmail.com", "Haslo123!"),
            new CreateClientCommand("Józef", "Robak", "784222371", "j.robak@gmail.com", "Haslo123!"),
            new CreateClientCommand("Piotr", "Pasternak", "765654543", "p.pasternak@gmail.com", "Haslo123!"),
            new CreateClientCommand("Adam", "Leszczyński", "777653721", "a.leszczynski@gmail.com", "Haslo123!")
    );
    final List<CreateEmployeeCommand> employees = List.of(
            new CreateEmployeeCommand("Janusz", "Kowalkiewicz", "508129333", "j.kowalkiewicz@gmail.com", "Haslo123!", dateOf(1, 10, 2015), "Dyrektor", 10000),
            new CreateEmployeeCommand("Adrianna", "Kononowicz", "566756432", "a.kononowicz@gmail.com", "Haslo123!", dateOf(1, 11, 2015), "Kierownik", 7000),
            new CreateEmployeeCommand("Aleksander", "Boruta", "657444634", "a.boruta@gmail.com", "Haslo123!", dateOf(1, 5, 2016), "Pracownik zmiany", 4000)
    );
    final List<CreateAdoptionCommand> adoptions = List.of(
            new CreateAdoptionCommand(dateOf(12, 5, 2021), 1, 2, 6),
            new CreateAdoptionCommand(dateOf(4, 3, 2021), 4, 1, 7)
    );

    private Date dateOf(int day, int month, int year) {
        final LocalDate localDate = LocalDate.of(year, month, day);
        return Date.from(localDate.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }
}
