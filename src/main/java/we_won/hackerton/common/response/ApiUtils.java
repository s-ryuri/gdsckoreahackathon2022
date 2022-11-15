package we_won.hackerton.common.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiUtils {

  public static <T> ApiResult<T> success(T response) {
    return new ApiResult<>(true, response, null);
  }

  public static ApiResult<?> error(Throwable throwable, HttpStatus status) {
    return new ApiResult<>(false, null, new ApiError(throwable, status));
  }

  public static ApiResult<?> error(String message, HttpStatus status) {
    return new ApiResult<>(false, null, new ApiError(message, status));
  }

  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  public static class ApiError {
    private String message;
    private int status;

    ApiError(Throwable throwable, HttpStatus status) {
      this(throwable.getMessage(), status);
    }

    ApiError(String message, HttpStatus status) {
      this.message = message;
      this.status = status.value();
    }

    public String getMessage() {
      return message;
    }

    public int getStatus() {
      return status;
    }

    @Override
    public String toString() {
      return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
        .append("message", message)
        .append("status", status)
        .toString();
    }
  }

  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  public static class ApiResult<T> {
    private boolean success;
    private T response;
    private ApiError error;

    private ApiResult(boolean success, T response, ApiError error) {
      this.success = success;
      this.response = response;
      this.error = error;
    }

    public boolean isSuccess() {
      return success;
    }

    public ApiError getError() {
      return error;
    }

    public T getResponse() {
      return response;
    }

    @Override
    public String toString() {
      return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
        .append("success", success)
        .append("response", response)
        .append("error", error)
        .toString();
    }
  }

}