public class TurnSystem {

    private Turn head;
    private Turn currentTurn;
    private int counter;
    public void addLast(){
        addLast(new Turn(counter));
        counter++;
    }
    private void addLast(Turn input){
        if(head==null){
            head = input;
            head.setNext(input);
            head.setPrev(input);
            currentTurn=head;
            System.out.println("The turn "+input.getValue()+" was added");
        } else {
            Turn tail = head.getPrev();
            tail.setNext(input);
            input.setNext(head);

            head.setPrev(input);
            input.setPrev(tail);
            System.out.println("The turn "+input.getValue()+" was added");
        }
    }
    public void print(){
        print(head);
    }
    //Metodo recursivo
    private void print(Turn current){
        //Caso base
        if(current==null){
            return;
        }
        if(current.getNext()==head){
            System.out.println(current.getValue());
            return;
        }
        //Llamado recursivo
        System.out.println(current.getValue());
        print(current.getNext());
    }

    public void delete(int value){
        delete(value,head);
    }
    private void delete(int goal, Turn current){
        if(head != null && goal == head.getValue()){
            Turn prev = current.getPrev();
            Turn next = current.getNext();
            prev.setNext(next);
            next.setPrev(prev);
            head = next;
            return;
        }
        if(current != null && goal == current.getValue()){
            Turn prev = current.getPrev();
            Turn next = current.getNext();
            prev.setNext(next);
            next.setPrev(prev);
            return;
        }
        if(current != null && current.getNext()==head){
            return;
        }
        if (current != null) {
            delete(goal, current.getNext());
        }
    }
    public void showTurn(){
        if(head==null){
            System.out.println("There is no turns!");
        }else {
            System.out.println("The current turn is "+currentTurn.getValue());
        }
    }
    public void attended(){
        if(head==null){
            System.out.println("There is no turns!");
        }else {
            Turn provisional = currentTurn;
            System.out.println("The turn " + provisional.getValue() + " was attended");
            if(currentTurn.getNext()==head){
                System.out.println("AAAAAAAAAAAAAAAAAA");
                head=null;
                currentTurn=null;
            }else {
                currentTurn = currentTurn.getNext();
            }
            delete(provisional.getValue());
            String msg = "";
            if (currentTurn == null) {
                msg = "none";
            } else {
                msg = String.valueOf(currentTurn.getValue());
            }
            System.out.println("The next turn is " + msg);
        }
    }
    public void passTurn(){
        if(head==null){
            System.out.println("There is no turns!");
        }else {
            currentTurn.setMissed(currentTurn.getMissed()+1);
            if(currentTurn.getMissed()==3){
                Turn provisional = currentTurn;
                currentTurn = provisional.getNext();
                System.out.println("The turn "+provisional.getValue()+" was deleted");
                delete(provisional.getValue());
                String msg = "";
                if (currentTurn == null) {
                    msg = "none";
                } else {
                    msg = String.valueOf(currentTurn.getValue());
                }
                System.out.println("The next turn is " + msg);
            }else {
                currentTurn = currentTurn.getNext();
                System.out.println("The next turn is "+currentTurn.getValue());
            }
        }
    }
}
