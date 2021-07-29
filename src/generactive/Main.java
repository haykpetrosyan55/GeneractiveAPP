package generactive;

import generactive.mock.ConfigurationMock;
import generactive.mock.GroupMock;
import generactive.mock.ItemMock;
import generactive.model.Basket;
import generactive.model.BasketItem;
import generactive.model.Group;
import generactive.model.Item;
import generactive.repository.GroupRepository;
import generactive.util.StreamAPI.StreamAPIUtil;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Group> groups = StreamAPIUtil.getGroups();

        List<Item> items = StreamAPIUtil.getItems();


        groups.get(groups.size() - 1).addItems(items);

        for (Group group : groups) {
            group.print(0);
        }

        //search result by group name 'myGroup'
        List<Group> myGroups = StreamAPIUtil.findByGroupName(groups,"myGroup");

        //search result by group Id '13'
        //List<Group> myGroups = StreamAPIUtil.findByGroupId(groups,13);

        Group subGroup0 = new Group(20,"mySubGroup");
        groups.get(0).addSubGroup(subGroup0);
        //Stex inch vor xndir ka. Chem jogum inchn a
        //List<Group> myGroups = StreamAPIUtil.findSubGroupsByParent(groups, groups.get(0)); //????

        for (Group group : myGroups) {
            group.print(0);
        }

        //search result by Item name 'MyItem'
        //List<Item> myItems = StreamAPIUtil.findByItemName(items,"MyItem");

        //search result by Item Id '105'
        //List<Item> myItems = StreamAPIUtil.findByItemId(items,105);

        //search result by Item price '4400'
        List<Item> myItems = StreamAPIUtil.findAllOrderByPrice(items,4400);


        for (Item item : myItems) {
            item.print();
        }

        //search result by Highest Priced Items
        Item myHighestPricedItem = StreamAPIUtil.findHighestPricedItems(items);
        myHighestPricedItem.print();














//        List<Group> groups = GroupMock.getGroupsHierarchy();
//
//        List<Item> items = ItemMock.getItems(5);
//
//
//        List<Item> items1 = ItemMock.getItems(5);
//        List<Item> items2 = ItemMock.getItems(5);
//
//
//
//        groups.get(groups.size() - 1).addItems(items);
//        groups.get(groups.size() - 2).addItems(items1);
//        groups.get(groups.size() - 3).addItems(items2);
//
//
//        GroupRepository groupRepository = GroupRepository.getInstance();
//        groupRepository.addGroupAll(groups);
//
//        for (Group group : groupRepository.getGroupsHierarchy()) {
//            group.print(0);
//        }
//
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
