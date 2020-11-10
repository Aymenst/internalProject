package org.techniu.isbackend.exception;

import org.springframework.stereotype.Component;

/**
 * A helper class to generate RuntimeExceptions
 */
@Component
public class MainException {

    /**
     * Returns new RuntimeException based on template and args
     *
     * @param messageTemplate messageTemplate
     * @param args            args
     * @return RuntimeException
     */
    public static RuntimeException throwException(String messageTemplate, String... args) {
        return new RuntimeException(format(messageTemplate, args));
    }

    /**
     * Returns new RuntimeException based on EntityType, ExceptionType and args
     *
     * @param entityType    entityType
     * @param exceptionType exceptionType
     * @param args          args
     * @return RuntimeException
     */
    public static RuntimeException throwException(EntityType entityType, ExceptionType exceptionType, String... args) {
        String messageTemplate = getMessageTemplate(entityType, exceptionType);
        return throwException(exceptionType, messageTemplate, args);
    }

    static class EntityNotFoundException extends RuntimeException {
        EntityNotFoundException(String message) {
            super(message);
        }
    }

    static class DuplicateEntityException extends RuntimeException {
        DuplicateEntityException(String message) {
            super(message);
        }
    }

    static class OtherEntityException extends RuntimeException {
        OtherEntityException(String message) {
            super(message);
        }
    }

    /**
     * Returns new RuntimeException based on template and args
     *
     * @param messageTemplate messageTemplate
     * @param args            args
     * @return RuntimeException
     */
    private static RuntimeException throwException(ExceptionType exceptionType, String messageTemplate, String... args) {
        if (ExceptionType.ENTITY_NOT_FOUND.equals(exceptionType)) {
            return new EntityNotFoundException(format(messageTemplate, args));
        } else if (ExceptionType.DUPLICATE_ENTITY.equals(exceptionType)) {
            return new DuplicateEntityException(format(messageTemplate, args));
        }
        return new OtherEntityException(format(messageTemplate, args));
    }

    /**
     * Concat the entity type with the exception type and make them in lowercase
     *
     * @param entityType    entityType
     * @param exceptionType exceptionType
     * @return String
     */
    public static String getMessageTemplate(EntityType entityType, ExceptionType exceptionType) {
        /*aid*/
        return /*entityType.name().concat(".").concat*/(exceptionType.getValue()).toLowerCase();
    }

    /**
     * Format error message
     *
     * @param template template
     * @param args args
     * @return String
     */
    private static String format(String template, String... args) {
        return String.format(template, (Object) args);
    }
}
