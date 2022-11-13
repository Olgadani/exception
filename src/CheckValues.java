import java.util.Objects;

public class CheckValues {
    public static final String INVALID_LENGTH = "Длина может быть от 1 до 20 символов";
    public static final String INVALID_SYMBOL = "Login должен состоять только из латинских букв, цифр или знака подчеркивания";
    public static final String PASSWORD_NOT_MATCH = "Пароль и подтвержение пароля не совпадают";

    public static boolean validate(String login, String password, String confirmPassword) {
        if (isValidLength(login, 1, 20)) {
            throw new WrongLoginException(INVALID_LENGTH);
        }
        if (isValidSymbol(login)) {
            throw new WrongLoginException(INVALID_SYMBOL);
        }
        if (isValidLength(password, 1, 20)) {
            throw new WrongPasswordException(INVALID_LENGTH);
        }
        if (isValidSymbol(password)) {
            throw new WrongPasswordException(INVALID_SYMBOL);
        }
        if (!Objects.equals(password, confirmPassword)) {
            throw new WrongPasswordException(PASSWORD_NOT_MATCH);
        }
        return true;
    }

    private static boolean isValidLength(String value, int min, int max) {
        if (value == null) {
            return true;
        }
        int length = value.length();
        return length < min || length > max;
    }

    private static boolean isValidSymbol(String value) {
        if (value == null || value.isEmpty()) {
            return true;
        }
        for (char c : value.toCharArray()) {
            boolean symbolMatches = (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (Character.isDigit(c) || (c == '_'));
            if (!symbolMatches) {
                return true;
            }
        } return false;
    }

}