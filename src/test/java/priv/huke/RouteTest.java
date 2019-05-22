package priv.huke;

import org.junit.BeforeClass;
import org.junit.Test;
import priv.huke.entity.Graph;
import priv.huke.util.XmlReader;

import java.io.IOException;

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
        CalDistance distance = new CalDistance("A-E-D", graph);
        System.out.println(distance.distance());
    }
}
