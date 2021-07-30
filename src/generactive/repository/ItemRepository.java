package generactive.repository;

import generactive.model.Item;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ItemRepository {
    private static ItemRepository iInstance;
    private final List<Item> items = new ArrayList<>();

    public static ItemRepository getInstance() {
        if (iInstance == null) {
            iInstance = new ItemRepository();
        }

        return iInstance;
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public void addItemAll(List<Item> items){
        this.items.addAll(items);
    }

    public List<Item> findByItemName(String name){
        return iInstance.items.stream()
                .filter(item -> item.getName().equals(name))
                .collect(Collectors.toList());
    }

    public List<Item> findByItemId(int id){
        return iInstance.items.stream()
                .filter(item -> item.getId() == id)
                .collect(Collectors.toList());
    }

    public Item findHighestPricedItem(){
        return iInstance.items.stream().max(Comparator.comparing(Item::getBasePrice)).orElse(null);
    }

    public List<Item> findAllOrderByPrice(int price){
        return iInstance.items.stream()
                .filter(item -> item.getBasePrice() == price)
                .collect(Collectors.toList());
    }



}
