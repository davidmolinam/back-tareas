package com.dmolina.authorizeservice.services.users;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.dmolina.authorizeservice.error.exception.NewUserWithDifferentPasswordsException;
import com.dmolina.authorizeservice.models.dto.users.CreateUserDto;
import com.dmolina.authorizeservice.models.vo.users.UserEntity;
import com.dmolina.authorizeservice.models.vo.users.UserRole;
import com.dmolina.authorizeservice.repository.users.UserEntityRepository;
import com.dmolina.authorizeservice.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserEntityService extends BaseService<UserEntity, Long, UserEntityRepository> {

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Nos permite buscar un usuario por su nombre de usuario
     *
     * @param username
     * @return
     */
    public Optional<UserEntity> findUserByUsername(String username) {
        return this.repositorio.findByUsername(username);
    }

    /**
     * Nos permite crear un nuevo UserEntity con rol USER
     *
     * @param newUser
     * @return
     */
    public UserEntity nuevoUsuario(CreateUserDto newUser) {

        if (newUser.getPassword().contentEquals(newUser.getPassword2())) {
            UserEntity userEntity = UserEntity.builder().username(newUser.getUsername())
                    .password(passwordEncoder.encode(newUser.getPassword())).avatar(newUser.getAvatar())
                    .fullName(newUser.getFullname()).email(newUser.getEmail())
                    .roles(Stream.of(UserRole.USER).collect(Collectors.toSet())).build();
            try {
                return save(userEntity);
            } catch (DataIntegrityViolationException ex) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre de usuario ya existe");
            }
        } else {
            throw new NewUserWithDifferentPasswordsException();
        }

    }

}