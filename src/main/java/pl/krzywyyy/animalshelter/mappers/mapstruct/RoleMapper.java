package pl.krzywyyy.animalshelter.mappers.mapstruct;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import pl.krzywyyy.animalshelter.model.entities.Role;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface RoleMapper {
    default List<SimpleGrantedAuthority> rolesToGrantedAuthorities(List<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "users", ignore = true)
    })
    Role nameToRole(String name);
}
