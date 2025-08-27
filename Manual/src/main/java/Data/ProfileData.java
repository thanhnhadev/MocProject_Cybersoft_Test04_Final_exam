package Data;

import java.util.Optional;

public class ProfileData {
    // Dữ liệu hợp lệ để update
    public static final Optional<String> newUsername   = Optional.of("Tào Tháo");
    public static final Optional<String> newEmail      = Optional.of("tuantest0408@hotmail.com");
    public static final Optional<Boolean> isMale       = Optional.of(false); // false = female, true = male
    public static final Optional<String> newSkill      = Optional.of("Play with Python");
    public static final Optional<String> newCertificate= Optional.of("Cybersoft");
    public static final Optional<String> newPhone      = Optional.of("0933361765");
    public static final Optional<String> newBirthday   = Optional.of("08082004");

    // Bộ dữ liệu rỗng để test No Data
    public static final Optional<String> emptyString   = Optional.empty();
    public static final Optional<Boolean> emptyBoolean = Optional.empty();
}
