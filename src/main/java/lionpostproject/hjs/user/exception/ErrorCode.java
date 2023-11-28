package lionpostproject.hjs.user.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorCode {


    private String message;

    private String code;


}
