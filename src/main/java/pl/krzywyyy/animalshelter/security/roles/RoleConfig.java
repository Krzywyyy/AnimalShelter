package pl.krzywyyy.animalshelter.security.roles;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.krzywyyy.animalshelter.mappers.mapstruct.RoleMapper;
import pl.krzywyyy.animalshelter.repositories.RoleRepository;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class RoleConfig {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @PostConstruct
    private void saveRolesIfNotPresent() {
        Arrays.stream(SecurityRole.values())
                .map(SecurityRole::name)
                .filter(role -> !rolePresentInDatabase(role))
                .map(roleMapper::nameToRole)
                .forEach(roleRepository::save);
    }

    private boolean rolePresentInDatabase(String role) {
        return roleRepository.findByName(role) != null;
    }
}
