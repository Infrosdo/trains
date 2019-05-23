package priv.huke.entity;

import java.util.Set;

public class TownTreeNode {

    Town node;
    Set<TownTreeNode> childrenNode;

    int deep;
    int distance;

    public Town getNode() {
        return node;
    }

    public void setNode(Town node) {
        this.node = node;
    }

    public Set<TownTreeNode> getChildrenNode() {
        return childrenNode;
    }

    public void setChildrenNode(Set<TownTreeNode> childrenNode) {
        this.childrenNode = childrenNode;
    }

    public int getDeep() {
        return deep;
    }

    public void setDeep(int deep) {
        this.deep = deep;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
