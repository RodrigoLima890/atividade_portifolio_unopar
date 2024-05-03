package services;

import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.UserRepository;
import services.exceptions.ResourceNotFoundException;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        try {
            return userRepository.findAll();
        }catch(ResourceNotFoundException e){
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public Optional<User> findById(Long id){
        try{
            return userRepository.findById(id);
        }catch(ResourceNotFoundException e){
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public User insert(User user){
        return userRepository.save(user);
    }

    public void delete(Long id){
        try{
            userRepository.deleteById(id);
        }
        catch(ResourceNotFoundException e){
            e.printStackTrace();
        }
    }

    public User update(Long id, User user){
        if(userRepository.existsById(id)){
            user.setId(id);
            return userRepository.save(user);
        }else{
            throw new IllegalArgumentException("Usuario não encontrado");
        }
    }
}
