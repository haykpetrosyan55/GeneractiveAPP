package generactive;

import generactive.mock.ConfigurationMock;
import generactive.mock.GroupMock;
import generactive.mock.ItemMock;
import generactive.model.Basket;
import generactive.model.BasketItem;
import generactive.model.Group;
import generactive.model.Item;
import generactive.repository.GroupRepository;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Group> groups = GroupMock.getGroupsHierarchy();

        List<Item> items = ItemMock.getItems(5);
        List<Item> items1 = ItemMock.getItems(5);
        List<Item> items2 = ItemMock.getItems(5);


        groups.get(groups.size() - 1).addItems(items);
        groups.get(groups.size() - 2).addItems(items1);
        groups.get(groups.size() - 3).addItems(items2);


        GroupRepository groupRepository = GroupRepository.getInstance();
        groupRepository.addGroupAll(groups);

        for (Group group : groupRepository.getGroupsHierarchy()) {
            group.print(0);
        }

        //List<Group> myGroup = groupRepository.findByGroupName("myGroup");
        List<Group> myGroup = GroupRepository.findSubGroupsByParent(groups.get(0));

        for (Group group : myGroup) {
            group.print(0);
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
