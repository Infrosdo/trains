package priv.huke.service;

import priv.huke.entity.Edge;
import priv.huke.entity.Graph;
import priv.huke.entity.Town;
import priv.huke.entity.TownTreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TreeFactory {

    Graph graph;

    static int SEARCH_DEEP = 10;

    public TreeFactory() {
    }

    public TreeFactory(Graph graph) {
        this.graph = graph;
    }

    public Map<Town, Set<Edge>> getReachableTown() {
        Map<Town, Set<Edge>> reachableTown = new HashMap<>();
        Set<Edge> edges = graph.getEdges();
        for (Edge edge : edges) {
            Town startTown = edge.getStart();
            Set<Edge> edgeSet = new HashSet<>();
            if (reachableTown.containsKey(startTown)) {
                edgeSet = reachableTown.get(startTown);
            }
            edgeSet.add(edge);
            reachableTown.put(startTown, edgeSet);
        }
        return reachableTown;
    }

    public TownTreeNode generateTree(TownTreeNode tree) {
//        TownTreeNode tree = new TownTreeNode();
        Map<Town, Set<Edge>> reachableTown = getReachableTown();

//        if (!reachableTown.containsKey(startTown)) {
////            System.out.println("Illegal start");
////        }

        if (tree.getDeep() <= 0) {
            tree.setDeep(1);
        }
        for (Edge edge : reachableTown.get(tree.getNode())) {
            Set<TownTreeNode> childSet;
            if (tree.getChildrenNode() == null) {
                childSet = new HashSet<>();
            } else {
                childSet = tree.getChildrenNode();
            }
            TownTreeNode childTreeNode = new TownTreeNode();
            childTreeNode.setNode(edge.getEnd());
            childTreeNode.setDeep(tree.getDeep()+1);
            childSet.add(childTreeNode);
            tree.setChildrenNode(childSet);
        }
        return tree;
    }

    public TownTreeNode deepGrow(TownTreeNode tree) {

        Set<TownTreeNode> nodeSet = tree.getChildrenNode();
        for (TownTreeNode childrenNode : nodeSet) {
            if (childrenNode.getDeep()>=SEARCH_DEEP){
                break;
            }
            TownTreeNode child = generateTree(childrenNode);
            childrenNode.setChildrenNode(child.getChildrenNode());
            deepGrow(childrenNode);
        }
        return tree;
    }

    public TownTreeNode getTree(Town town){
        TownTreeNode tree = new TownTreeNode();
        tree.setNode(town);
        tree = generateTree(tree);
        tree = deepGrow(tree);
        return tree;
    }



    public TownTreeNode generateDistanceTree(TownTreeNode tree) {
        Map<Town, Set<Edge>> reachableTown = getReachableTown();

        if (tree.getDeep() <= 0) {
            tree.setDeep(1);
            tree.setDistance(0);
        }
        for (Edge edge : reachableTown.get(tree.getNode())) {
            Set<TownTreeNode> childSet;
            if (tree.getChildrenNode() == null) {
                childSet = new HashSet<>();
            } else {
                childSet = tree.getChildrenNode();
            }
            TownTreeNode childTreeNode = new TownTreeNode();
            childTreeNode.setNode(edge.getEnd());
            childTreeNode.setDeep(tree.getDeep()+1);
            childTreeNode.setDistance(tree.getDistance() + edge.getDistance());
            childSet.add(childTreeNode);
            tree.setChildrenNode(childSet);
        }
        return tree;
    }

    public TownTreeNode distanceDeepGrow(TownTreeNode tree) {

        Set<TownTreeNode> nodeSet = tree.getChildrenNode();
        for (TownTreeNode childrenNode : nodeSet) {
            if (childrenNode.getDeep()>=SEARCH_DEEP){
                break;
            }
            TownTreeNode child = generateDistanceTree(childrenNode);
            childrenNode.setChildrenNode(child.getChildrenNode());
            distanceDeepGrow(childrenNode);
        }
        return tree;
    }

    public TownTreeNode getDistanceTree(Town town){
        TownTreeNode tree = new TownTreeNode();
        tree.setNode(town);
        tree = generateDistanceTree(tree);
        tree = distanceDeepGrow(tree);
        return tree;
    }

}
