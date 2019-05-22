package priv.huke.entity;

import java.util.HashSet;
import java.util.Set;

public class Graph {

    private Set<Edge> edges = new HashSet<Edge>();

    public Set<Edge> getEdges() {
        return edges;
    }

    public void setEdges(Set<Edge> edges) {
        edges = edges;
    }

    public void addEdge(Edge edge){
        edges.add(edge);
    }

    @Override
    public String toString() {
        String result = "";
        for (Edge e : edges) {
            result.concat(e+"  ");
        }
        return result;
    }

    //    private Set<Route> routes;

//    public Graph(Builder builder) {
//        this.towns = builder.towns;
//        this.routes = builder.routes;
//    }
//
//    public static class Builder{
//        private Set<Town> towns;
//        private Set<Route> routes;
//
//        public Builder(Set<Town> towns,Set<Route> routes) {
//            this.towns = towns;
//            this.routes = routes;
//        }
//
//        public Graph build(){
//            return new Graph(this);
//        }
//    }

}
