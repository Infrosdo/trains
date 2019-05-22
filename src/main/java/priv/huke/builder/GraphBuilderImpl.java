package priv.huke.builder;

import priv.huke.entity.Edge;
import priv.huke.entity.Graph;
import priv.huke.entity.Route;
import priv.huke.entity.Town;

import java.util.Set;

public class GraphBuilderImpl implements GraphBuilder {

    Graph graph;

    private Set<Edge> edges;
//    private Set<Route> routes;

    public void setTowns() {

    }

    public void setEdges() {

    }

    public void addEdges(Edge edge) {
        edges.add(edge);
    }
}
