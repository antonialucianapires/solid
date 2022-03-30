public class OpenClosedPrinciple {
    public static void main(String[] args) {

        var quadrado = new FormaGeometricaSemSolid();
        quadrado.setTipo("retangulo");
        quadrado.setLargura(50);
        quadrado.setAltura(50);

        var areaQuadrado = quadrado.calcularArea();
        System.out.println(areaQuadrado);

        var circulo = new FormaGeometricaSemSolid();
        circulo.setTipo("circulo");
        circulo.setRaio(30);

        var areaCirculo = circulo.calcularArea();
        System.out.println(areaCirculo);

    }
}

class FormaGeometricaSemSolid {

    private String tipo;
    private double largura;
    private double altura;
    private double raio;

    double calcularArea() {
        double area = 0;

        if (tipo.equals("retangulo")) {
            area = this.largura * this.altura;
        } else if (tipo.equals("circulo")) {
            area = this.raio * this.raio * Math.PI;
        }

        return area;
    }

    public double getAltura() {
        return altura;
    }

    public double getLargura() {
        return largura;
    }

    public double getRaio() {
        return raio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

class FormaGeometricaComSolid {

    public static void main(String[] args) {
        FormaGeometrica quadrado = new Retangulo(50, 50);
        var areaQuadrado = quadrado.calcularArea();
        System.out.println(areaQuadrado);

        FormaGeometrica circulo = new Circulo(30);
        var areaCirculo = circulo.calcularArea();
        System.out.println(areaCirculo);
    }

}

class Circulo extends FormaGeometrica {

    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }

    @Override
    public double calcularArea() {
        return this.raio * this.raio * Math.PI;
    }

}

class Retangulo extends FormaGeometrica {

    private double largura;
    private double altura;

    Retangulo(double largura, double altura) {
        this.largura = largura;
        this.altura = altura;
    }

    public double getAltura() {
        return altura;
    }

    public double getLargura() {
        return largura;
    }

    @Override
    public double calcularArea() {
        return this.altura * this.largura;
    }

}

abstract class FormaGeometrica {
    public abstract double calcularArea();
}