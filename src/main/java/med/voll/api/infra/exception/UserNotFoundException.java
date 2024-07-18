package med.voll.api.infra.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String menssage) {
        super(menssage);
    }
}
