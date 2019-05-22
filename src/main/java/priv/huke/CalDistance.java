package priv.huke;

import priv.huke.entity.Edge;
import priv.huke.entity.Graph;
import priv.huke.entity.Town;

import java.util.Set;

public class CalDistance {

    String routeStr;
    Graph graph;

    public CalDistance(){
    }

    public CalDistance(String routeStr,
            Graph graph){
        this.graph = graph;
        this.routeStr = routeStr;
    }

    public String distance() {
//        if (routeStr==null && routeStr.isEmpty()) {
//            return "NO SUCH ROUTE";
//        }
        boolean flag;
        int distance = 0;
        String[] split = routeStr.split("-");
        for (int i = 0; i < split.length - 1; i++) {
            flag = true;
            Edge edge = new Edge(new Town(split[i]), new Town(split[i + 1]));
            Set<Edge> edges = graph.getEdges();
            for (Edge e : edges) {
                if (e.equals(edge)) {
                    distance += e.getDistance();
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return "NO SUCH ROUTE";
            }
        }
        return String.valueOf(distance);
    }


}
