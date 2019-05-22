package priv.huke;

import priv.huke.entity.Edge;
import priv.huke.entity.Graph;
import priv.huke.entity.Town;

import java.util.LinkedList;
import java.util.List;

public class CalTripsNum {
    Town start;
    Town end;
    int maxStops;
    Graph graph;

    private List<Edge> routeNode = new LinkedList<>();

    public CalTripsNum() {
    }

    public CalTripsNum(Town start, Town end, int maxStops, Graph graph) {
        this.start = start;
        this.end = end;
        this.maxStops = maxStops;
        this.graph = graph;
    }

    public void addEdge(Edge edge){
        routeNode.add(edge);
    }


}
