package br.com.iotextchaincast.external.impl;

import br.com.iotextchaincast.entity.IOTextChainCast;
import br.com.iotextchaincast.entity.TypeHandler;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StringTypeHandler extends TypeHandler {
    @Override
    public Object check(Object obj, IOTextChainCast ioChainCast, Class<?> clazz) {
        if (checkType(clazz))
            return String.valueOf(obj).trim();

        return this.checkNext(obj, ioChainCast, clazz);
    }

    @Override
    public String check(Object obj, IOTextChainCast ioChainCast) {
        if (checkType(obj.getClass()))
            return formatString(String.valueOf(obj), ioChainCast);

        return this.checkNext(obj, ioChainCast);
    }

    @Override
    public boolean checkType(Class<?> clazz) {
        return Optional.ofNullable(clazz)
                .filter(c -> clazz.equals(String.class))
                .map(c -> true)
                .orElse(false);
    }
}
