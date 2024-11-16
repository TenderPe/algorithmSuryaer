package com.leetcode;


import java.util.*;

public class LeetCode1584 {

    public static int minCostConnectPoints(int[][] points) {
        unionFind unionFind = new unionFind();
        PriorityQueue<Edge> heap = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });
        HashMap<Integer, Node> nodes = new HashMap<>();
        for (int[] point : points) {
            nodes.put(point.hashCode(), new Node(point));
        }

        for (int[] point : points) {
            Node node = nodes.get(point.hashCode());
            ArrayList<Node> list = new ArrayList<>();
            list.add(node);
            unionFind.nodeMap.put(node, list);
            for (int[] p : points) {
                if (p != point) {
                    int weight = Math.abs(point[0] - p[0]) + Math.abs(point[1] - p[1]);
                    heap.add(new Edge(weight, node, nodes.get(p.hashCode())));
                }
            }
        }
        int res = 0;
        while (!heap.isEmpty()) {
            Edge edge = heap.poll();
            //from和to不在一个集合
            if (!unionFind.isSameSet(edge.from, edge.to)) {
                res += edge.weight;
                unionFind.union(edge.from, edge.to);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 2}, {3, -1}, {6, 3}, {3, 10}
        };
        System.out.println(minCostConnectPoints(arr));
    }
}

class unionFind {
    public HashMap<Node, ArrayList<Node>> nodeMap;

    public unionFind() {
        nodeMap = new HashMap<Node, ArrayList<Node>>();
    }

    public boolean isSameSet(Node from, Node to) {
        ArrayList<Node> l1 = nodeMap.get(from);
        ArrayList<Node> l2 = nodeMap.get(to);
        return l1 == l2;
    }

    public void union(Node from, Node to) {
        ArrayList<Node> l1 = nodeMap.get(from);
        ArrayList<Node> l2 = nodeMap.get(to);
        for (Node node : l2) {
            l1.add(node);
            nodeMap.put(node, l1);
        }
    }
}

class Edge {
    public int weight;
    public Node from;
    public Node to;

    public Edge(int w, Node f, Node t) {
        weight = w;
        from = f;
        to = t;
    }
}

class Node {
    public int x;
    public int y;

    public Node(int[] point) {
        x = point[0];
        y = point[1];
    }
}