package ctci.StackQueue;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by joetomjob on 8/3/19.
 */

abstract class Animal{
    String name;
    int order;
    public Animal(String s){
        this.name = s;
    }
    public void setOrder(int o){
        this.order = o;
    }
    public int getOrder(String s){
        return this.order;
    }

    public boolean isGreaterThan(Animal a){
        return this.order > a.order;
    }
}
public class AnimalShelter {
    LinkedList<Cat> c = new LinkedList<Cat>();
    LinkedList<Dog> d = new LinkedList<Dog>();
    private int order = 0;

    public void enqueue(Animal a){
        a.order = order;
        a.order++;
        if(a instanceof Cat) {
            c.addLast((Cat) a);
        } else if (a instanceof Dog) {
            d.addLast((Dog) a);
        }
    }

    public Animal dequeueCat(){
        return c.pollLast();
    }

    public Animal dequeueDog(){
        return d.pollLast();
    }

    public Animal dequeueAny(){
        if(d.size() == 0) {
            return dequeueCat();
        } else if(c.size() == 0){
            return dequeueDog();
        } else {
            Dog dtemp = d.peek();
            Cat ctemp = c.peek();

            if (dtemp.isGreaterThan(ctemp)) {
                return c.poll();
            } else {
                return d.poll();
            }
        }

    }

}

class Dog extends Animal{
    public Dog(String s) {
        super(s);
    }
}

class Cat extends Animal{
    public Cat(String s) {
        super(s);
    }
}
