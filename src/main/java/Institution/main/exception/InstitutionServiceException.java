package Institution.main.exception;

    public class InstitutionServiceException extends RuntimeException {
        public InstitutionServiceException(String message) {
            super(message);
        }

        public InstitutionServiceException(String message, Throwable cause) {
            super(message, cause);
        }
}
