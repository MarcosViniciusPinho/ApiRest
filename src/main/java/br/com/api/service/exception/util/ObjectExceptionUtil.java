package br.com.api.service.exception.util;

import br.com.api.service.exception.ObjectNotFoundException;

import java.util.List;
import java.util.Optional;

public class ObjectExceptionUtil {

    public static void addObjectNotFound(Object valor, ObjectNotFoundException objectNotFoundException, List<ObjectNotFoundException> exceptions){
        Optional<Object> valorOther = Optional.ofNullable(valor);
        if(!valorOther.isPresent()){
            exceptions.add(objectNotFoundException);
        }
    }

    public static void throwObjectNotFound(List<ObjectNotFoundException> exceptions){
        if(!exceptions.isEmpty()){
            throw new ObjectNotFoundException(exceptions);
        }
    }

}
