package com.tw;

import oracle.jrockit.jfr.openmbean.ProducerDescriptorType;

public class MultiplicationTable {
    public String create(int start, int end) {
        return isValid(start, end) ? generateSingleExpression(start, end) : null;
    }

    public Boolean isValid(int start, int end) {
        return isInRange(start) && isInRange(end) && isStartNotBiggerThanEnd(start, end);
    }

    public Boolean isInRange(int number) {
        return number >=1 && number <=1000;
    }

    public Boolean isStartNotBiggerThanEnd(int start, int end) {
        return start <= end;
    }

    public String generateTable(int start, int end) {
        String result = "";
        for (int i = start; i < end + 1; i++) {

            result += generateLine(start, i) + System.lineSeparator();
        }
        return result.trim();
    }

    public String generateLine(int start, int row) {
        String line = "";
        for(;start <= row; start++){
            line += generateSingleExpression(start, row)+ "  ";
        }
        return line.trim();
//        //System.lineSeparator()

    }

    public String generateSingleExpression(int multiplicand, int multiplier) {
        return  multiplicand + "*" + multiplier + "=" + (multiplicand * multiplier);
    }
}
