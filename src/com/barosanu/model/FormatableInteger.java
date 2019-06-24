package com.barosanu.model;

public class FormatableInteger implements Comparable<FormatableInteger> {

    private int size;

    public FormatableInteger(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        if (size <= 0) {
            return "0";
        } else if (size < 1024) {
            return size + " B";
        } else if (size < 1048576) {
            return size / 1024 + " kB";
        } else {
            return size / 1048576 + " MB";
        }
    }

    @Override
    public int compareTo(FormatableInteger formatableInteger) {
        Integer int1 = this.size;
        Integer int2 = formatableInteger.size;
        return int1.compareTo(int2);
    }
}
