package resource;

import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.UserService;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @Autowired
    UserService userService;

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
        return userService.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
    }

    @PostMapping("/insert")
    public User insert(@RequestBody User user){
        return userService.insert(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }

    @PutMapping("/update/{id}")
    public User update(@RequestBody User user, @PathVariable Long id){
        return userService.update(id, user);
    }
}
