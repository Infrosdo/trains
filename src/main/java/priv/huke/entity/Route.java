package priv.huke.entity;

import java.util.LinkedList;
import java.util.List;

public class Route {

    /**
     * 开始城镇
     */
    private Town firstTown;

    /**
     * 结束城镇
     */
    private Town finalTown;

    /**
     * 途经站点
     */
    private List<Edge> routeNode = new LinkedList<>();

    public Town getFirstTown() {
        return firstTown;
    }

    public void setFirstTown(Town firstTown) {
        this.firstTown = firstTown;
    }

    public Town getFinalTown() {
        return finalTown;
    }

    public void setFinalTown(Town finalTown) {
        this.finalTown = finalTown;
    }

    public List<Edge> getRouteNode() {
        return routeNode;
    }

    public void setRouteNode(List<Edge> routeNode) {
        this.routeNode = routeNode;
    }
}
