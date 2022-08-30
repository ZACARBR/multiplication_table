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
        StringBuilder result = new StringBuilder();
        for (int i = start; i < end + 1; i++) {

            result.append(generateLine(start, i)).append(System.lineSeparator());
        }
        return result.toString().trim();
    }

    public String generateLine(int start, int row) {
        StringBuilder line = new StringBuilder();
        for(;start <= row; start++){
            line.append(generateSingleExpression(start, row)).append("  ");
        }
        return line.toString().trim();
    }

    public String generateSingleExpression(int multiplicand, int multiplier) {
        return  multiplicand + "*" + multiplier + "=" + (multiplicand * multiplier);
    }
}
