package program.program.exception;

public class DatabaseException extends RuntimeException{
    public DatabaseException(String id){
        super(id);
    }
}
