package priv.huke.service;

import priv.huke.entity.Edge;
import priv.huke.entity.Graph;
import priv.huke.entity.Route;
import priv.huke.entity.Town;

import java.util.*;

public class RouteService {

    Graph graph;

    final static int SEARCH_DEEP = 10;

    public RouteService() {
    }

    public RouteService(Graph graph) {
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

    public Set<Route> getAllRoute(Town start, Town end) {
        Set<Route> allRoute = new HashSet<>();
        Map<Town, Set<Edge>> reachableTown = getReachableTown();
        Set<Edge> edges = reachableTown.get(start);
        for (Edge edge : edges) {
            Route route = new Route();
            LinkedList<Edge> edgeList = new LinkedList<>();
            edgeList.add(edge);
            route.setRouteNode(edgeList);
            route.setFirstTown(edge.getStart());
            route.setFinalTown(edge.getEnd());
            allRoute.add(route);
        }

        return allRoute;
    }

    public Route copy(Route original){
        Route route = new Route();
        route.setFirstTown(original.getFirstTown());
        route.setFinalTown(original.getFinalTown());
        route.getRouteNode().addAll(original.getRouteNode());
        return route;
    }
}
