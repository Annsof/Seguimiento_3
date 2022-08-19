public class Turn {
    // Values
    private int value;
    // Enlace
    private Turn next;
    private int missed;

    public int getMissed() {
        return missed;
    }

    public void setMissed(int missed) {
        this.missed = missed;
    }

    public Turn getPrev() {
        return prev;
    }

    public void setPrev(Turn prev) {
        this.prev = prev;
    }

    private Turn prev;

    //Creando un arraylist de enteros
    public Turn(int value){
        this.value=value;

    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Turn getNext() {
        return next;
    }

    public void setNext(Turn next) {
        this.next = next;
    }
    @Override
    public String toString(){
        return "Value: "+value;
    }
}
