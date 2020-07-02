package br.com.sicredi.vote.exception;

import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Order(value = 0)
public class RestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<?> handleVoteException(VoteException voteException){
        return ResponseEntity.unprocessableEntity().body("Valor do voto invalido");
    }

    @ExceptionHandler
    public ResponseEntity<?> handlePautaException(PautaException pautaException){
        return ResponseEntity.unprocessableEntity().body(pautaException.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<?> handleUsuarioException(UsuarioException usuarioException){
        return ResponseEntity.unprocessableEntity().body(usuarioException.getMessage());
    }
}
