package com.pruebaMarshall.marshall.JPA;

import org.springframework.stereotype.Service;

import com.pruebaMarshall.marshall.Modelo.User.User;

@Service
public class UserQuery {
    private UserRepository userRepository;

    public UserQuery(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void modificarRuta(int userId, String nuevaRuta) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        user.setRuta(nuevaRuta);
        userRepository.save(user);
    }

    public String obtenerRuta(String username){
        User user = userRepository.findByUsername(username).orElse(null);
        String ruta = user.getRuta();
        return ruta;
    }
}
