package pe.todotic.starwars.exception;

//@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(){
        super();
    }
    public ResourceNotFoundException(String message){
        super(message);
    }

}
