import java.io.*;
import java.util.*;

public class Solution {
    private static int n;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};
    private static int[][] map = new int[4001][4001];
    private static int[][] count = new int[4001][4001];
    private static int totalEnergy;
    private static List<Atom> atoms;
    private static Atom[] atomsArr = new Atom[1000];
    private static int atomCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < 1000; i++) {
            atomsArr[i] = new Atom();
        }
        for (int i = 1; i <= t; i++) {
            n = Integer.parseInt(br.readLine());
            atomCnt = 0;
            totalEnergy = 0;
            atoms = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                atomsArr[j].x = (Integer.parseInt(st.nextToken()) + 1000) * 2;
                atomsArr[j].y = (Integer.parseInt(st.nextToken()) + 1000) * 2;
                atomsArr[j].dir = Integer.parseInt(st.nextToken());
                atomsArr[j].energy = Integer.parseInt(st.nextToken());
                atoms.add(atomsArr[j]);
            }
            move();
            sb.append("#").append(i).append(" ").append(totalEnergy).append("\n");
        }
        System.out.println(sb);
    }

    private static void move() {
        while (!atoms.isEmpty()) {
            Iterator<Atom> it = atoms.iterator();
            List<Atom> movedAtom = new ArrayList<>();
            while (it.hasNext()) {
                Atom atom = it.next();
                atom.x += dx[atom.dir];
                atom.y += dy[atom.dir];
                if (atom.x < 0 || atom.x > 4000 || atom.y < 0 || atom.y > 4000) {
                    it.remove();
                    continue;
                }
                if (count[atom.y][atom.x] == 0) {
                    movedAtom.add(atom);
                }
                map[atom.y][atom.x] += atom.energy;
                count[atom.y][atom.x] += 1;
            }
            it = atoms.iterator();
            while (it.hasNext()) {
                Atom atom = it.next();
                if (count[atom.y][atom.x] >= 2) {
                    totalEnergy += map[atom.y][atom.x];
                    map[atom.y][atom.x] = 0;
                    it.remove();
                }
            }
            for (Atom atom : movedAtom) {
                count[atom.y][atom.x] = map[atom.y][atom.x] = 0;
            }
        }
    }

    static class Atom {
        int x;
        int y;
        int dir;
        int energy;

        public Atom() {
        }

        public Atom(int x, int y, int dir, int energy) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.energy = energy;
        }
    }
}