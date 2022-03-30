package SpringProj.AdvicesAndExceptions;



public class TargetNotFoundException extends RuntimeException{

    public TargetNotFoundException (String message){
        super (message);
    }

}
