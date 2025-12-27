package program.program.exception;

public class ResourceNotFound extends RuntimeException{
    public ResourceNotFound(Object id){
        super("resource not found, with id: " + id);
    }
}
