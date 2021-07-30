package generactive;

import generactive.mock.ConfigurationMock;
import generactive.mock.GroupMock;
import generactive.mock.ItemMock;
import generactive.model.*;
import generactive.repository.GroupRepository;
import generactive.repository.ItemRepository;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Group> groups = GroupMock.getGroupsHierarchy();

        List<Item> items = ItemMock.getItems(5);
        List<Item> items1 = ItemMock.getItems(5);
        List<Item> items2 = ItemMock.getItems(5);
        items.add(new GenerativeItem(55,555,"myItem"));
        items.add(new GenerativeItem(56,555,"myItem"));


        groups.get(groups.size() - 1).addItems(items);
        groups.get(groups.size() - 2).addItems(items1);
        groups.get(groups.size() - 3).addItems(items2);


        GroupRepository groupRepository = GroupRepository.getInstance();
        groupRepository.addGroupAll(groups);

        ItemRepository itemRepository = ItemRepository.getInstance();
        itemRepository.addItemAll(items);
        itemRepository.addItemAll(items1);
        itemRepository.addItemAll(items2);

        for (Group group : groupRepository.getGroupsHierarchy()) {
            group.print(0);
        }

        List<Group> myGroup = groupRepository.findByGroupName("myGroup");
        List<Group> idGroups = groupRepository.findByGroupId(5);
        List<Group> subGroups = groupRepository.findSubGroupsByParent(groups.get(0));

        for (Group group : subGroups) {
            group.print(0);
        }

        List<Item> myItem = itemRepository.findByItemName("myItem");
        List<Item> idItem = itemRepository.findByItemId(55);
        itemRepository.findHighestPricedItem().print();
        List<Item> allOrdersByPrice = itemRepository.findAllOrderByPrice(555);

        for (Item item : allOrdersByPrice) {
            item.print();
        }





//
//        Basket basket = new Basket();
//        for (Item item : items) {
//            basket.add(new BasketItem(item, ConfigurationMock.getConfiguration()));
//        }
//
//        basket.print();
//

    }
}
