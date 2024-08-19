package pe.todotic.starwars.exception;

//@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends  RuntimeException{

    public BadRequestException(){
        super();
    }
    public BadRequestException(String message)  {
        super(message);
    }
}
