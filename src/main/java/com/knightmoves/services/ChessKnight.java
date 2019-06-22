package com.knightmoves.services;

import java.lang.Math;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.HashMap;

public class ChessKnight {
    private static int[] row = { 2, 2, -2, -2, 1, 1, -1, -1 };
    private static int[] column = { -1, 1, 1, -1, 2, -2, 2, -2 };

    public static int getYCoordinate(String position) {
        for (int i = position.length() - 1; i >= 0; i--) {
            if (Character.isLetter(position.charAt(i))) {
                return Integer.valueOf(position.substring(i + 1)) - 1;
            }
        }

        return -1;
    }

    public static int getXCoordinate(String position) {
        int result = 0, stop = 0;

        for (int i = 0; i < position.length(); i++) {
            if (Character.isDigit(position.charAt(i))) {
                stop = i - 1;
                break;
            }
        }

        for (int i = 0, j = stop; i <= stop; i++, j--) {
            result += ((int) Character.toLowerCase(position.charAt(i)) - 96) * Math.pow(26.0, j);
        }

        return result - 1;
    }

    public static int count(int x1, int y1, int x2, int y2, int width, int height) {
        return bfs(new Node(x1, y1), new Node(x2, y2), width, height);
    }

    public static boolean valid(int x, int y, int width, int height) {
        if (x < 0 || y < 0 || x >= width || y >= height)
            return false;

        return true;
    }

    public static int bfs(Node start, Node end, int width, int height) {
        Map<Node, Boolean> visited = new HashMap<>();
        Queue<Node> q = new ArrayDeque<>();

        q.add(start);

        while (!q.isEmpty()) {
            Node node = q.poll();

            int x = node.x;
            int y = node.y;
            int distance = node.distance;

            if (x == end.x && y == end.y)
                return distance;

            if (visited.get(node) == null) {
                visited.put(node, true);

                for (int i = 0; i < 8; i++) {
                    int x1 = x + row[i];
                    int y1 = y + column[i];

                    if (valid(x1, y1, width, height))
                        q.add(new Node(x1, y1, distance + 1));
                }
            }
        }

        return -1;
    }
}