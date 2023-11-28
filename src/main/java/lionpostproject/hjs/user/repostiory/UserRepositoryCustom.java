package lionpostproject.hjs.user.repostiory;

import lionpostproject.hjs.user.dto.UserDTO;

public interface UserRepositoryCustom {

    UserDTO findEmail(String userId);
}
