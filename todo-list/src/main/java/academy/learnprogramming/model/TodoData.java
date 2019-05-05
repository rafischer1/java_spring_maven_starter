package academy.learnprogramming.model;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.*;

public class TodoData {

    //fields
    private static int idValue = 1;

    private final List<TodoItem> items = new ArrayList<>();

    // constructor
    public TodoData() {
        // dummy data list using addItem method
        addItem(new TodoItem("first", "Warp Core Diagnostic", LocalDate.now()));
        addItem(new TodoItem("second", "Holodeck Training", LocalDate.now()));
        addItem(new TodoItem("third", "Relax in 10 Forward", LocalDate.now()));
        addItem(new TodoItem("fourth", "Upgrade Phaser Array Efficiency", LocalDate.now()));
        addItem(new TodoItem("fifth", "Realign Subspace Communication Signal", LocalDate.now()));

    }

    // ==public CRUD methods==

    // Get All
    public List<TodoItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    // getOne
    public TodoItem getItem(int id) {
        for (TodoItem item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    // Create
    public void addItem(@NonNull TodoItem toAdd) {
        toAdd.setId(idValue);
        items.add(toAdd);
        idValue++;
    }

    // Update
    public void updateItem(@NonNull TodoItem toUpdate) {
        ListIterator<TodoItem> itemIterator = items.listIterator();

        while (itemIterator.hasNext()) {
            TodoItem item = itemIterator.next();

            if (item.equals(toUpdate)) {
                itemIterator.set(toUpdate);
                break;
            }
        }
    }

    // Delete
    public void removeItem(int id) {
        ListIterator<TodoItem> itemIterator = items.listIterator();

        while (itemIterator.hasNext()) {
            TodoItem item = itemIterator.next();

            if (item.getId() == id) {
                itemIterator.remove();
                break;
            }
        }
    }
}
