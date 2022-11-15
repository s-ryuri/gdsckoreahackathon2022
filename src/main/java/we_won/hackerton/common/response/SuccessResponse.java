package we_won.hackerton.common.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SuccessResponse<T> extends BasicResponse{
    private boolean success = true;
    private T data;

    public SuccessResponse() {}

}
