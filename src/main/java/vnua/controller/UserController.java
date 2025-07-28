package vnua.controller;

import org.springframework.web.bind.annotation.*;
import vnua.model.User;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final Map<Long, User> userList = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @GetMapping
    public Collection<User> getAll() {
        return userList.values();
    }

    @PostMapping
    public User create(@RequestBody User user) {
        long id = idGenerator.getAndIncrement();
        user.setId(id);
        userList.put(id, user);
        return user;
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        if (!userList.containsKey(id)) {
            throw new RuntimeException("Không tìm thấy người dùng ID: " + id);
        }
        user.setId(id);
        userList.put(id, user);
        return user;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userList.remove(id);
    }
}
