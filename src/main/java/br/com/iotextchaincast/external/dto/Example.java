package br.com.iotextchaincast.external.dto;

import br.com.iotextchaincast.entity.IOTextChainCast;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Example {


    @IOTextChainCast(length = 2, order = 1, align = "R", trelling = "0")
    private Integer numInteger;

    @IOTextChainCast(length = 3, order = 2, align = "R", trelling = "0")
    private int numInt;

    @IOTextChainCast(length = 2, order = 3, align = "R", trelling = "0")
    private Long numLong;

    @IOTextChainCast(length = 3, order = 4, align = "R", trelling = "0")
    private long numLongPrimitive;

    @IOTextChainCast(length = 5, order = 5)
    private String strValue;


//    @IOChainCast(length = 20, order = 3, align = "R", trelling = "0",
//            decimalPrecision = 2, decimalMovePoint = 2)
//    private BigDecimal bdValue;
//
//    @IOChainCast(length = 14, order = 4, pattern = "ddMMyyyyHHmmss")
//    private LocalDateTime date;
//
//    @IOChainCast(length = 20, order = 5, align = "R", trelling = "0",
//            decimalPrecision = 2, decimalMovePoint = 2)
//    private Double doubleValue;
//
//    @IOChainCast(length = 20, order = 6, align = "R", trelling = "0",
//            decimalPrecision = 3, decimalMovePoint = 3)
//    private float floatValue;



}
