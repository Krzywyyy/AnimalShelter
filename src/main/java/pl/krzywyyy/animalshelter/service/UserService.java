package pl.krzywyyy.animalshelter.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.krzywyyy.animalshelter.mapper.mapstruct.RoleMapper;
import pl.krzywyyy.animalshelter.model.entity.abstracts.User;
import pl.krzywyyy.animalshelter.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        final User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(email);
        }
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                roleMapper.rolesToGrantedAuthorities(user.getRoles())
        );
    }
}
