package generactive.mock;

import generactive.model.Group;
import generactive.util.idgenerator.IdGenerator;
import generactive.util.idgenerator.Type;
import generactive.util.namegenerator.NameGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class GroupMock {

    public static Group getGroup() {
        return new Group(IdGenerator.getNext(Type.GROUP), NameGenerator.getRandomName());
    }

    public static List<Group> getGroupsHierarchy() {
        Group group1 = getGroup();
        Group group2 = getGroup();
        Group group3 = getGroup();
        Group group4 = getGroup();
        Group group5 = getGroup();
        Group group6 = getGroup();
        Group group7 = new Group(IdGenerator.getNext(Type.GROUP),"myGroup"); //for test

        group1.addSubGroup(group2);
        group2.addSubGroup(group3);

        group4.addSubGroup(group5);
        group5.addSubGroup(group6);

        return Arrays.asList(group1,
                group2,
                group3,
                group4,
                group5,
                group6,
                group7);
    }

    public static List<Group> getGroups(int count) {
        List<Group> rv = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            rv.add(getGroup());
        }

        return rv;
    }

    private GroupMock() {

    }
}
