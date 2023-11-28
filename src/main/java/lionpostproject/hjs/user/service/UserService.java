package lionpostproject.hjs.user.service;

import jakarta.servlet.http.HttpSession;
import lionpostproject.hjs.user.controller.reqeust.JoinRequest;
import lionpostproject.hjs.user.controller.reqeust.LoginRequest;
import lionpostproject.hjs.user.dto.UserDTO;

public interface UserService {

    //sign
    UserDTO join(final JoinRequest joinRequest , final HttpSession session);


    //login
    UserDTO login(final LoginRequest loginRequest , final HttpSession session);


    //logout
    void logout(final HttpSession session);
}
