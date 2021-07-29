package generactive.util.StreamAPI;

import generactive.model.GenerativeItem;
import generactive.model.Group;
import generactive.model.Item;
import generactive.model.StockItem;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPIUtil {

    public static List<Group> getGroups() {
        return List.of(
                new Group(10,"Purple Touch"),
                new Group(11,"Junior Chalk"),
                new Group(12,"Quiet Death"),
                new Group(13,"myGroup"),
                new Group(14,"Inadequate Clam"),
                new Group(15,"Excited Morning"),
                new Group(16,"Super Drink")
        );
    }

    public static List<Item> getItems(){
        return List.of(
                new GenerativeItem(100,500,"Sensible Shoe"),
                new GenerativeItem(101,550,"Dutch Clam"),
                new GenerativeItem(102,600,"Dramatic Achiever"),
                new GenerativeItem(103,800,"Controversial Toothpaste"),
                new GenerativeItem(104,4400,"Sound Quince"),
                new GenerativeItem(105,5330,"MyItem"),
                new GenerativeItem(106,9650,"Sound Quince"),
                new StockItem(107,960,"Dirty Caption"),
                new StockItem(108,650,"Medical Front"),
                new StockItem(109,50,"French Slave")
        );
    }

    public static List<Group> findByGroupName(List<Group> groups, String name){
        return groups.stream()
                .filter(group -> group.getName().equals(name))
                .collect(Collectors.toList());
    }

    public static List<Item> findByItemName(List<Item> items, String name){
        return items.stream()
                .filter(item -> item.getName().equals(name))
                .collect(Collectors.toList());
    }

    public static List<Group> findByGroupId(List<Group> groups, int id){
        return groups.stream()
                .filter(group -> group.getId() == id)
                .collect(Collectors.toList());
    }

    public static List<Item> findByItemId(List<Item> items, int id){
        return items.stream()
                .filter(item -> item.getId() == id)
                .collect(Collectors.toList());
    }

    public static List<Group> findSubGroupsByParent(List<Group> groups, Group parentGroup){
        return groups.stream()
                .filter(group -> group.getParentGroup().equals(parentGroup))
                .collect(Collectors.toList());
    }

    public static Item findHighestPricedItems(List<Item> items){
        return items.stream().max(Comparator.comparing(Item::getBasePrice)).orElse(null);
    }

    public static List<Item> findAllOrderByPrice(List<Item> items, int price){
        return items.stream()
                .filter(item -> item.getBasePrice() == price)
                .collect(Collectors.toList());
    }



}
