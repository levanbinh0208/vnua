package vnua.controller;

import org.springframework.web.bind.annotation.*;
import vnua.model.Login;

@RestController
@RequestMapping("/api")
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestBody Login loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        if ("admin".equals(username) && "123456".equals(password)) {
            return "Đăng nhập thành công!";
        } else {
            throw new RuntimeException("Sai tên đăng nhập hoặc mật khẩu");
        }
    }
}
