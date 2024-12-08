package Exercise_7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Task6 {
    public static void main(String[] args) throws IOException {
        testMut();
        testImm();
        genomCount();
    }

    public static void testMut() {
        MutableSet set = new MutableSet();
        set.insert("ACC");
        set.insert("AAA");
        System.out.println(set);
    }

    public static void testImm() {
        ImmutableSet empty = new ImmutableSet();
        ImmutableSet set1 = empty.insert("ACC");
        ImmutableSet set2 = set1.insert("AAA");
        System.out.println(set2);
    }

    public static void genomCount() throws IOException {
        MutableSet set = new MutableSet();
        Path filePath = Path.of("src/Exercise_7/sarsgenome.txt"); // Adjust filepath as necessary
        StringBuilder content = new StringBuilder(Files.readString(filePath));

        while (content.length() >= 3) {
            String genome = content.substring(0, 3);
            content.delete(0, 3);
            set.insert(genome);
        }

        System.out.println("Number of extracted genomes: " + set.size());
        System.out.println("Extracted genomes: " + set);
        System.out.println("All codons found? " + (set.size() == Math.pow(4,3) ? "TRUE" : "FALSE"));
    }
}

class MutableSet {
    private final ArrayList<String> entries;

    public MutableSet() {
        this.entries = new ArrayList<>();
    }

    public void insert(String s) {
        for (String entry : entries) {
            if (entry.equals(s)) {
                return;
            }
        }
        entries.add(s);
    }

    public int size() {
        return entries.size();
    }

    @Override
    public String toString() {
        return entries.toString();
    }
}

class ImmutableSet {
    private final ArrayList<String> entries;

    public ImmutableSet() {
        this.entries = new ArrayList<>();
    }

    public ImmutableSet(ArrayList<String> set) {
        this.entries = set;
    }

    ImmutableSet insert(String s) {
        ArrayList<String> retVal = this.entries;
        for (String entry : retVal) {
            if (entry.equals(s)) {
                return new ImmutableSet(retVal);
            }
        }
        retVal.add(s);
        return new ImmutableSet(retVal);
    }

    public int size() {
        return entries.size();
    }

    @Override
    public String toString() {
        return entries.toString();
    }
}