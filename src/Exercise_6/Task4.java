package Exercise_6;

public class Task4 {
    public static void main(String[] args) {
        // Create dogs
        DogTeam.Dog otto = new DogTeam.Dog("Otto", 6);
        DogTeam.Dog ada = new DogTeam.Dog("Ada", 9);

        // Create a team
        DogTeam team = new DogTeam("Alpha", 3);

        // Add dogs to the team
        team.join(otto, 0);
        team.join(ada, 1);

        // Clone Otto and add him to the team
        DogTeam.Dog otto2 = DogTeam.Dog.clone(otto);
        team.join(otto2, 2);

        // Print team information
        System.out.println(team);
    }
}

class DogTeam {
    static class Dog {
        String name;
        int age;
        DogTeam team;

        // Constructor to initialize Hund
        Dog(String name, int age) {
            this.name = name;
            this.age = age;
            this.team = null;
        }

        // Constructor for cloning
        Dog(Dog original) {
            this.name = original.name; // Copy the name
            this.age = 1; // Set age to 1
            this.team = null; // Team is not copied
        }

        // Function to clone a dog
        public static Dog clone(Dog original) {
            return new Dog(original);
        }

        @Override
        public String toString() {
            return "Name: " + this.name + ", Age: " + this.age +
                    (this.team != null ? ", Team: " + this.team : ", No Team");
        }
    }
    private final String name; // Name of the team
    private final Dog[] members; // Dogs in the team

    // Constructor for DogTeam
    public DogTeam(String name, int teamSize) {
        this.name = name;
        this.members = new Dog[teamSize];
    }

    public String getName() {
        return this.name;
    }

    public Dog[] getMembers() {
        return this.members;
    }

    // Function to add a dog to a team at a specific position
    public void join(Dog dog, int position) {
        if (position < 0 || position >= members.length) {
            System.out.println("Invalid position. Dog cannot join the team.");
            return;
        }
        members[position] = dog; // Add the dog to the team
        dog.team = this; // Assign this team to the dog
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Team ").append(this.name).append(" Members:\n");
        for (Dog dog : members) {
            if (dog != null) {
                sb.append(dog.name).append(" (Age: ").append(dog.age).append(")\n");
            } else {
                sb.append("Empty Slot\n");
            }
        }
        return sb.toString();
    }
}