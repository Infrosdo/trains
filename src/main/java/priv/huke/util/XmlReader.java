package priv.huke.util;

import priv.huke.entity.Edge;
import priv.huke.entity.Graph;
import priv.huke.entity.Town;

import java.io.*;

public class XmlReader {

    private Graph graph = new Graph();

    /**
     * 从文件中读取图信息
     *
     * @param file
     * @throws IOException
     */
    public Graph init(String file) throws IOException {
        InputStream stream = Reader.class.getResourceAsStream(file);
        InputStreamReader reader = new InputStreamReader(stream);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String str = bufferedReader.readLine();
        while ((str != null) && (str.trim().length() != 0)) {
            resolveLine(str);
            str = bufferedReader.readLine();
        }
        return graph;
    }

    /**
     * 解析行
     */
    public void resolveLine(String line) {
        String[] edges = line.split(",");
        for (String edgeStr : edges) {
            if (isBlank(edgeStr)) {
                continue;
            }
            edgeStr = edgeStr.trim();
            if (edgeStr.length() != 3) {
                System.out.println("illegal graph format:" + edgeStr);
                continue;
            }
            Town start = new Town();
            start.setName(String.valueOf(edgeStr.charAt(0)));
            Town end = new Town();
            end.setName(String.valueOf(edgeStr.charAt(1)));
            int distance = Integer.parseInt(edgeStr.substring(2));

            Edge edge = new Edge();
            edge.setStart(start);
            edge.setEnd(end);
            edge.setDistance(distance);
            graph.addEdge(edge);
        }
    }

    private static boolean isBlank(String edge) {
        return edge == null ? true : edge.trim().length() == 0;
    }


    public static void main(String[] args) throws IOException {
        XmlReader xmlReader = new XmlReader();
        xmlReader.init("/graph");
        System.out.println(xmlReader.graph.getEdges());
    }

}
