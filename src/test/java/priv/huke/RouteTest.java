package priv.huke;

import org.junit.BeforeClass;
import org.junit.Test;
import priv.huke.entity.Edge;
import priv.huke.entity.Graph;
import priv.huke.entity.Route;
import priv.huke.entity.Town;
import priv.huke.service.RouteService;
import priv.huke.util.XmlReader;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class RouteTest {

    static Graph graph;

    @BeforeClass
    public static void testBefore() {
        XmlReader xmlReader = new XmlReader();
        try {
            graph = xmlReader.init("/graph");
        } catch (IOException exp) {
            throw new RuntimeException("init failed ");
        }
    }

    @Test
    public void testCase1() {
        CalDistance distance = new CalDistance("A-E-S", graph);
        System.out.println(distance.distance());
    }

    @Test
    public void testCase2() {
        RouteService service = new RouteService(graph);
        Map<Town, Set<Edge>> reachableTown = service.getReachableTown();
        System.out.println(reachableTown);
    }

    @Test
    public void testCase3() {
        RouteService service = new RouteService(graph);
        Set<Route> allRoute = service.getAllRoute(new Town("A"), new Town("B"));
        System.out.println(allRoute);

    }
}
