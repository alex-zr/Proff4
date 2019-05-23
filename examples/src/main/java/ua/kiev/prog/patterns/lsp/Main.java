package ua.kiev.prog.patterns.lsp;

public class Main {
    public static void main(String[] args) {
        Rectangle square = new Square(5);
        square.setWidth(10);
        System.out.println(square.calcSquare()); // ожидаем поведение прямоугольника 50
    }
}
