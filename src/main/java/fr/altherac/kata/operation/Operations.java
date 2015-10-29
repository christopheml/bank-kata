package fr.altherac.kata.operation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Operations implements Iterable<Operation> {

    private final List<Operation> operations = new ArrayList<>();

    public void add(Operation operation) {
        operations.add(operation);
        Collections.sort(operations, (o1, o2) -> o1.getDate().compareTo(o2.getDate()));
    }

    @Override
    public Iterator<Operation> iterator() {
        return operations.iterator();
    }

}
