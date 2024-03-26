package com.pruebaMarshall.marshall.Servicio.UserService;


import org.springframework.stereotype.Service;

import com.pruebaMarshall.marshall.JPA.UserRepository;
import com.pruebaMarshall.marshall.Modelo.User.Role;
import com.pruebaMarshall.marshall.Modelo.User.User;
import com.pruebaMarshall.marshall.Modelo.User.UserDTO;
import com.pruebaMarshall.marshall.Modelo.User.UserRequest;
import com.pruebaMarshall.marshall.Modelo.User.UserResponse;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository; 

    @Transactional
    public UserResponse updateUser(UserRequest userRequest) {
       
        User user = User.builder()
        .id(userRequest.getId())
        .firstname(userRequest.getFirstname())
        .lastname(userRequest.getLastname())
        .country(userRequest.getCountry())
        .role(Role.USER)
        .build();
        
        userRepository.updateUser(user.getId(), user.getFirstname(), user.getLastname(), user.getCountry());

        return new UserResponse("El usuario se registró satisfactoriamente");
    }

    public UserDTO getUser(Integer id) {
        User user= userRepository.findById(id).orElse(null);
       
        if (user!=null)
        {
            UserDTO userDTO = UserDTO.builder()
            .id(user.getId())
            .username(user.getUsername())
            .firstname(user.getFirstname())
            .lastname(user.getLastname())
            .country(user.getCountry())
            .build();
            return userDTO;
        }
        return null;
    }
}