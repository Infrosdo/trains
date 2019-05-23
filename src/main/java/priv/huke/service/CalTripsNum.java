package priv.huke.service;

import priv.huke.entity.Town;
import priv.huke.entity.TownTreeNode;

import java.util.Set;

public class CalTripsNum {
    Town start;
    Town end;


    TreeFactory treeFactory;

    public CalTripsNum() {
    }

    public CalTripsNum(Town start, Town end, TreeFactory treeFactory) {
        this.start = start;
        this.end = end;
        this.treeFactory = treeFactory;
    }

    public int tripsNum(int stops) {
        final int DEEP = stops + 1;
        int tripsNum = 0;
        TownTreeNode tree = treeFactory.getTree(start);
        return treeIter(tree, DEEP, tripsNum);
    }

    public int treeIter(TownTreeNode tree, int deep, int tripsNum) {
        Set<TownTreeNode> childrenNode = tree.getChildrenNode();
        if (childrenNode != null) {
            for (TownTreeNode childTree : childrenNode) {
                if (childTree.getDeep() <= deep && childTree.getNode().equals(end)) {
                    tripsNum++;
                }
                tripsNum = treeIter(childTree, deep, tripsNum);
            }
        }
        return tripsNum;
    }

    public int equalsTripsNum(int stops) {
        final int DEEP = stops + 1;
        int tripsNum = 0;
        TownTreeNode tree = treeFactory.getTree(start);
        return equalsIter(tree, DEEP, tripsNum);
    }

    public int equalsIter(TownTreeNode tree, int deep, int tripsNum) {
        Set<TownTreeNode> childrenNode = tree.getChildrenNode();
        if (childrenNode != null) {
            for (TownTreeNode childTree : childrenNode) {
                if (childTree.getDeep() == deep && childTree.getNode().equals(end)) {
                    tripsNum++;
                }
                tripsNum = equalsIter(childTree, deep, tripsNum);
            }
        }
        return tripsNum;
    }


    public int length() {
        TownTreeNode tree = treeFactory.getDistanceTree(start);
        return lengthIter(tree, -1);
    }

    public int lengthIter(TownTreeNode tree, int distance) {
        Set<TownTreeNode> childrenNode = tree.getChildrenNode();
        if (childrenNode != null) {
            for (TownTreeNode childTree : childrenNode) {
                if (childTree.getNode().equals(end)) {
                    if (distance <= 0 || childTree.getDistance() < distance) {
                        distance = childTree.getDistance();
                    }
                }
                distance = lengthIter(childTree, distance);
            }
        }
        return distance;
    }

    public int lenthNum(int distace) {
        int lenthNum = 0;
        TownTreeNode tree = treeFactory.getDistanceTree(start);
        return lenthNumIter(tree, lenthNum,distace);
    }

    public int lenthNumIter(TownTreeNode tree, int lenthNum,int distace) {
        Set<TownTreeNode> childrenNode = tree.getChildrenNode();
        if (childrenNode != null) {
            for (TownTreeNode childTree : childrenNode) {
                if (childTree.getDistance() < distace && childTree.getNode().equals(end)) {
                    lenthNum++;
                }
                lenthNum = lenthNumIter(childTree,lenthNum,distace);
            }
        }
        return lenthNum;
    }
}
