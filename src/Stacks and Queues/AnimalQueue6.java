import java.util.LinkedList;

public class AnimalQueue6 {
  abstract class Animal {
    private int order;
    protected String name;
    public Animal(String n) {
      this.name = n;
    }
    public void setOrder(int order) {
      this.order = order;
    }
    public int getOrder() {
      return order;
    }
    public boolean isOlderThan(Animal a) {
      return this.order < a.getOrder();
    }
  }

  public class Dog extends Animal {
    public Dog(String n) {
      super(n);
    }
  }

  public class Cat extends Animal {
    public Cat(String n) {
      super(n);
    }
  }

  LinkedList<Dog> dog = new LinkedList<>();
  LinkedList<Cat> cat = new LinkedList<>();
  private int order = 0;

  public void enqueue(Animal a) {
    a.setOrder(order);
    order++;

    if(a instanceof Dog) dog.add((Dog)a);
    if(a instanceof Cat) cat.add((Cat)a);
  }

  public Animal dequeue() {
    if(dog.size() == 0) {
      return dequeueCats();
    }
    else if(cat.size() == 0) {
      return dequeueDog();
    }

    Dog dog = this.dog.peek();
    Cat cat = this.cat.peek();

    if(dog.isOlderThan(cat)) {
      return dequeueDog();
    } else {
      return dequeueCats();
    }
  }

  public Dog dequeueDog() {
    return dog.poll();
  }

  public Cat dequeueCats() {
    return cat.poll();
  }


}

