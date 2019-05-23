package ua.kiev.prog.patterns.lsp;

public class Square extends Rectangle {
    public Square(int height) {
        super(height, height);
    }

    // Т.к. квадрат имеет одинаковые стороны то значение устанавливается сразу для высоты и ширины
    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        super.setWidth(height);
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public double calcSquare() {
        return getHeight() * getWidth();
    }
}
