package br.com.iotextchaincast.entity;

import br.com.iotextchaincast.external.impl.StringTypeHandler;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public abstract class TypeHandler {

    private TypeHandler nextType;
    private static final String LEFT = "L";

    public static TypeHandler link(TypeHandler typeFirst, TypeHandler... chain) {
        TypeHandler head = typeFirst;
        for(TypeHandler nextTypeInChain : chain) {
            head.nextType = nextTypeInChain;
            head = nextTypeInChain;
        }
        return typeFirst;
    }

    public static TypeHandler link(List<TypeHandler> typeHandlersChain) {
        List<TypeHandler> chain = typeHandlersChain.stream().collect(Collectors.toList());
        return Optional.ofNullable(chain).filter(list -> !list.isEmpty()).map(handlers -> {
            TypeHandler typeFirst = handlers.get(0);
            TypeHandler head = handlers.get(0);
            handlers.remove(0);
            for(TypeHandler nextTypeInChain : handlers) {
                head.nextType = nextTypeInChain;
                head = nextTypeInChain;
            }
            return typeFirst;
        }).orElse(new StringTypeHandler());
    }

    public abstract Object check(Object obj, IOTextChainCast ioChainCast, Class<?> clazz);

    public abstract String check(Object obj, IOTextChainCast ioChainCast);

    public abstract boolean checkType(Class<?> clazz);

    protected Object checkNext(Object obj, IOTextChainCast ioChainCast, Class<?> clazz) {
        return Optional.ofNullable(nextType)
                .map(type -> type.check(obj, ioChainCast, clazz))
                .orElse(null);
    }

    protected String checkNext(Object obj, IOTextChainCast ioChainCast) {
        return Optional.ofNullable(nextType)
                .map(type -> type.check(obj, ioChainCast))
                .orElse(null);
    }


    public String formatString(String txt, IOTextChainCast ioChainCast) {
        return Optional.ofNullable(txt).map(text -> {
            StringBuilder sb = new StringBuilder(text);
            int lengthTrelling = ioChainCast.length() - sb.length();
            Optional.of(ioChainCast.align())
                    .filter(align -> align.equals(LEFT))
                    .ifPresentOrElse(trelling -> sb.append(ioChainCast.trelling().repeat(lengthTrelling)).toString(),
                            () -> sb.insert(0, ioChainCast.trelling().repeat(lengthTrelling)).toString());
            return sb.toString();
        }).orElse(txt);
    }


}
