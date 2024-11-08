package tec.iza.car.infra;

import org.springframework.cglib.proxy.UndeclaredThrowableException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import tec.iza.car.infra.business.BusinessException;
import tec.iza.car.infra.business.RegistroNaoLocalizadoException;
import tec.iza.car.infra.http.Response;
import tec.iza.car.infra.http.ResponseFactory;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGeneral(Exception e, WebRequest request) {
        String message = "";

        // Verifica se a exceção é um UndeclaredThrowableException e se contém uma BusinessException
        if (e instanceof UndeclaredThrowableException) {
            Throwable undeclaredThrowable = ((UndeclaredThrowableException) e).getUndeclaredThrowable();
            if (undeclaredThrowable instanceof BusinessException) {
                return handleBusinessException((BusinessException) undeclaredThrowable, request);
            }
        }

        // Caso contrário, usa a mensagem padrão
        BusinessMessage be = BusinessMessage.E501;
        Response error = ResponseFactory.error(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                be.getMessage().concat(message), be.getSuggestion());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return handleExceptionInternal(e, error, headers, HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(RegistroNaoLocalizadoException.class)
    public ResponseEntity<Response> handleRegistroNaoLocalizado(RegistroNaoLocalizadoException ex) {
        Response error = ResponseFactory.error(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),  // Pegando a mensagem passada na exceção
                "Por favor, verifique o ID fornecido."
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> handleBusinessException(BusinessException be, WebRequest request) {
        Response error = ResponseFactory.error(be.getId(), be.getMessage(), be.getSuggestion());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpStatus status = HttpStatus.resolve(be.getHttpStatus());

        if (status == null) {
            status = HttpStatus.INTERNAL_SERVER_ERROR; // Valor padrão caso o código seja inválido
        }

        return handleExceptionInternal(be, error, headers, status, request);
    }
}
