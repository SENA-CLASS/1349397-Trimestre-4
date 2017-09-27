package co.edu.sena.lesson07;

public class ClaseGenerica <T1, T2, T3> {
    private T1 atributoNumero1;
    private T2 atributoNumero2;
    private T3 atributoNumero3;

    public T1 getAtributoNumero1() {
        return atributoNumero1;
    }

    public void setAtributoNumero1(T1 atributoNumero1) {
        this.atributoNumero1 = atributoNumero1;
    }

    public T2 getAtributoNumero2() {
        return atributoNumero2;
    }

    public void setAtributoNumero2(T2 atributoNumero2) {
        this.atributoNumero2 = atributoNumero2;
    }

    public T3 getAtributoNumero3() {
        return atributoNumero3;
    }

    public void setAtributoNumero3(T3 atributoNumero3) {
        this.atributoNumero3 = atributoNumero3;
    }

    @Override
    public String toString() {
        return "ClaseGenerica{" +
                "atributoNumero1=" + atributoNumero1 +
                ", atributoNumero2=" + atributoNumero2 +
                ", atributoNumero3=" + atributoNumero3 +
                '}';
    }
}
