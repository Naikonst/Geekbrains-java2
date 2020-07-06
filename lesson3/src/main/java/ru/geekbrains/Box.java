package ru.geekbrains;

public class Box implements Comparable<Box>{

    int length;
    int height;

    public Box(int length, int height) {
        this.length = length;
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        return true;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString() {
        return "Box{" +
                length + ", " +
                height +
                '}';
    }

    private int square() {
        return length * height;
    }

    @Override
    public int compareTo(Box o) {
        return this == o ? 0 : (this.square() - o.square());
    }
}
