package com.itajiu.Test;

import java.util.*;

public class Main {
    static class Node {
        int x, y, hp, step;
        Node(int x, int y, int hp, int step) {
            this.x = x;
            this.y = y;
            this.hp = hp;
            this.step = step;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt(), n = in.nextInt(), hp0 = in.nextInt();
        String[] map = new String[m];
        for (int i = 0; i < m; i++) map[i] = in.next();

        int[][] dmg = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                dmg[i][j] = map[i].charAt(j) - '0';

        // 每格保存“当前最短步数下的最大剩余生命”
        // 初始为 -1（未到达）
        int[][] best = new int[m][n];
        for (int[] row : best) Arrays.fill(row, -1);

        Queue<Node> q = new ArrayDeque<>();

        int startHP = hp0 - dmg[0][0];
        if (startHP <= 0) { // 起点就炸死
            System.out.println(-1);
            return;
        }

        best[0][0] = startHP;
        q.offer(new Node(0, 0, startHP, 0));

        int minStep = -1;
        int maxHP = -1;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!q.isEmpty()) {
            Node cur = q.poll();

            // 若已超过找到的最短步数，跳过
            if (minStep != -1 && cur.step > minStep) break;

            // 到达终点
            if (cur.x == m - 1 && cur.y == n - 1) {
                if (minStep == -1) {
                    minStep = cur.step;
                    maxHP = cur.hp;
                } else if (cur.step == minStep) {
                    maxHP = Math.max(maxHP, cur.hp);
                }
                continue;
            }

            for (int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;

                int nhp = cur.hp - dmg[nx][ny];
                if (nhp <= 0) continue;

                int nstep = cur.step + 1;

                if (minStep != -1 && nstep > minStep) continue;

                // 剪枝：如果同一步数来到这里生命值不比 best 高，则跳过
                if (nhp <= best[nx][ny]) continue;

                best[nx][ny] = nhp;
                q.offer(new Node(nx, ny, nhp, nstep));
            }
        }

        if (minStep == -1) System.out.println(-1);
        else System.out.println(minStep + " " + maxHP);
    }
}
