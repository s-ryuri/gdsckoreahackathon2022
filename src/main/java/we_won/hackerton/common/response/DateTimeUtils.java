package we_won.hackerton.common.response;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateTimeUtils {

  public static Timestamp timestampOf(LocalDateTime time) {
    return time == null ? null : Timestamp.valueOf(time);
  }

  public static LocalDateTime dateTimeOf(Timestamp timestamp) {
    return timestamp == null ? null : timestamp.toLocalDateTime();
  }

}
