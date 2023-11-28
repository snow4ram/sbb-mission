package lionpostproject.hjs.user.repostiory;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lionpostproject.hjs.user.dto.UserDTO;
import lombok.RequiredArgsConstructor;

import static lionpostproject.hjs.user.entity.QUser.user;


@RequiredArgsConstructor
public class UserRepostioryCustomImpl implements UserRepositoryCustom{


    private final JPAQueryFactory query;


    @Override
    public UserDTO findEmail(String userId) {

       return query.select(Projections.bean(
                UserDTO.class,
                user.email
                ))
                .from(user)
                .where(user.email.eq(userId))
                .fetchOne();

    }
}
