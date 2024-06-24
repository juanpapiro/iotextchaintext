package br.com.iotextchaincast.external.impl;

import br.com.iotextchaincast.entity.IOTextChainCast;
import br.com.iotextchaincast.entity.TypeHandler;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LongTypeHandler extends TypeHandler {

    @Override
    public Object check(Object obj, IOTextChainCast ioChainCast, Class<?> clazz) {
        if (checkType(clazz))
            return Long.valueOf((String) obj);

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
                .filter(c -> clazz.equals(Long.class) || clazz.equals(long.class))
                .map(c -> true)
                .orElse(false);
    }
}
