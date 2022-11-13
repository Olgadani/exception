public class Main {
    public static void main(String[] args) {
        System.out.println(check("login", "password", "passwrd"));
    }

    public static boolean check(String login, String password, String confirmPassword) {
        try {
            return CheckValues.validate(login, password, confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println("Ошибка при проверке логина " + e.getMessage());
            return false;
        } catch (WrongPasswordException e) {
            System.out.println("Ошибка при проверке пароля " + e.getMessage());
            return false;
        }
    }
}