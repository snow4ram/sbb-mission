package lionpostproject.post.lion_school.user.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lionpostproject.post.lion_school.user.application.reqeust.JoinRequest;
import lionpostproject.post.lion_school.user.application.reqeust.LoginRequest;
import lionpostproject.post.lion_school.user.dto.UserDTO;

public interface UserService {

    //sign
    UserDTO join(final JoinRequest joinRequest , final HttpServletRequest servletRequest);


    //login
    UserDTO login(final LoginRequest loginRequest , final HttpSession session);


    //logout
    void logout(final HttpSession session);
}
