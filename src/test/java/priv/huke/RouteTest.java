package priv.huke;

import org.junit.BeforeClass;
import org.junit.Test;
import priv.huke.entity.*;
import priv.huke.service.CalDistance;
import priv.huke.service.CalTripsNum;
import priv.huke.service.TreeFactory;
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
        CalDistance distance = new CalDistance("A-E-S", graph);
        System.out.println(distance.distance());
    }

    @Test
    public void testCase2() {
        TreeFactory factory = new TreeFactory(graph);
        TownTreeNode tree = factory.getDistanceTree(new Town("B"));
        System.out.println(tree);
    }

    @Test
    public void testCase6() {
        TreeFactory factory = new TreeFactory(graph);
        CalTripsNum calTripsNum = new CalTripsNum(new Town("C"),new Town("C"),factory);
        int tripsNum = calTripsNum.tripsNum(3);
        System.out.println(tripsNum);
    }

    @Test
    public void testCase7() {
        TreeFactory factory = new TreeFactory(graph);
        CalTripsNum calTripsNum = new CalTripsNum(new Town("A"),new Town("C"),factory);
        int tripsNum = calTripsNum.equalsTripsNum(4);
        System.out.println(tripsNum);
    }

    @Test
    public void testCase8() {
        TreeFactory factory = new TreeFactory(graph);
        CalTripsNum calTripsNum = new CalTripsNum(new Town("A"),new Town("C"),factory);
        int length = calTripsNum.length();
        System.out.println(length);
    }

    @Test
    public void testCase9() {
        TreeFactory factory = new TreeFactory(graph);
        CalTripsNum calTripsNum = new CalTripsNum(new Town("B"),new Town("B"),factory);
        int length = calTripsNum.length();
        System.out.println(length);
    }

    @Test
    public void testCase10() {
        TreeFactory factory = new TreeFactory(graph);
        CalTripsNum calTripsNum = new CalTripsNum(new Town("C"),new Town("C"),factory);
        int lenthNum = calTripsNum.lenthNum(30);
        System.out.println(lenthNum);
    }
}
