package prep;

class BookNotAvailableException extends RuntimeException {
   public BookNotAvailableException(String message){
    super(message);
   }
}

class BorrowLimitExceededException extends RuntimeException{
    public BorrowLimitExceededException(String message){
        super(message);
    }
}
