class Animal{
    private String name;
    private int age;

    public Animal(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void makeSound(){
        System.out.println("Animal is making sound");
    }
}
class Dog extends Animal{
    public Dog(String name, int age){
        super(name, age);
    }

    public void makeSound(){
        System.out.println("Dog is barking");
    }
}
class cat extends Animal{
    public cat(String name, int age){
        super(name, age);
    }

    public void makeSound(){
        System.out.println("Cat is meowing");
    }
}
class Bird extends Animal{
    public Bird(String name, int age){
        super(name, age);
    }

    public void makeSound(){
        System.out.println("Bird is chirping");
    }
}
class AnimalHierarchy{
    public static void main(String[] args){
        Animal animal = new Animal("Animal", 5);
        animal.makeSound();

        Animal dog = new Dog("Dog", 3);
        dog.makeSound();

        Animal cat = new cat("Cat", 2);
        cat.makeSound();

        Animal bird = new Bird("Bird", 1);
        bird.makeSound();
    }
} 
