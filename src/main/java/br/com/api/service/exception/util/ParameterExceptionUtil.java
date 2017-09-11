package br.com.api.service.exception.util;

import br.com.api.service.exception.NullParameterException;

import java.util.Optional;

/**
 * Classe que serve para validar se os parametros sao nulos ou vazios.
 */
public class ParameterExceptionUtil {//NOSONAR desnecessário implementação que acusa o sonar.

    /**
     * Método que serve para validar se o objeto informado é nulo.
     * @param valor valor
     */
    public static void validateObjectNull(Object valor){
        Optional<Object> valorOther = Optional.ofNullable(valor);
        if(!valorOther.isPresent()){
            throw new NullParameterException("Parametro necessário está nulo.");
        }
    }

}
