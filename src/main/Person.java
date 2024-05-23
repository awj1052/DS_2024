package main;

public record Person(String name, int age, int prioirty) {
    @Override
    public String toString() {
        return name + " " + age;
    }
}