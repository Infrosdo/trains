package priv.huke.entity;

public class Edge {

    Town start;
    Town end;

    int distance;

    public Edge() {

    }

    public Edge(Town start, Town end) {
        this.start = start;
        this.end = end;
    }

    public Town getStart() {
        return start;
    }

    public void setStart(Town start) {
        this.start = start;
    }

    public Town getEnd() {
        return end;
    }

    public void setEnd(Town end) {
        this.end = end;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "start=" + start +
                ", end=" + end +
                ", distance=" + distance +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (!Edge.class.isInstance(obj)){
            return false;
        }
        if(this.start.equals(Edge.class.cast(obj).start) && this.end.equals(Edge.class.cast(obj).end)){
            return true;
        }
        return false;
    }
}
