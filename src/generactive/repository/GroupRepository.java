package generactive.repository;

import generactive.model.Group;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GroupRepository {

    private static GroupRepository sInstance;

    private final List<Group> groups = new ArrayList<>();

    public static GroupRepository getInstance() {
        if (sInstance == null) {
            sInstance = new GroupRepository();
        }

        return sInstance;
    }

    public void addGroup(Group group) {
        this.groups.add(group);
    }

    public void addGroupAll(List<Group> groups) {
        this.groups.addAll(groups);
    }

    public Group findGroupById(int groupId) {
        for (Group group : groups) {
            if (group.getId() == groupId) {
                return group;
            }
        }

        return null;
    }

    public List<Group> getGroupsHierarchy() {
        List<Group> rootGroups = new ArrayList<>();

        for (Group group : groups) {
            if (group.getParentGroup() == null) {
                rootGroups.add(group);
            }
        }

        return rootGroups;
    }

    public List<Group> findByGroupName(String name) {
        return sInstance.groups.stream()
                .filter(group -> group.getName().equals(name))
                .collect(Collectors.toList());
    }

    public static List<Group> findByGroupId(int id){
        return sInstance.groups.stream()
                .filter(group -> group.getId() == id)
                .collect(Collectors.toList());
    }

    public static List<Group> findSubGroupsByParent(Group parentGroup){
        return sInstance.groups.stream()
                .filter(group -> group.getParentGroup() != null)
                .filter(group -> group.getParentGroup().hashCode() == parentGroup.hashCode())
                .filter(group -> group.getParentGroup().equals(parentGroup))
                .collect(Collectors.toList());
    }

    private GroupRepository() {

    }
}
