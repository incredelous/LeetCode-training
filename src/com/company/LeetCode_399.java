package com.company;

import java.util.*;

public class LeetCode_399 {
    class Pair{
        int point;
        double val;
        public Pair(int point, double val){
            this.point = point;
            this.val = val;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Integer> variables = new HashMap<>();
        int nvar = 0;
        for(List<String> equation: equations){
            if(!variables.containsKey(equation.get(0))) variables.put(equation.get(0), nvar++);
            if(!variables.containsKey(equation.get(1))) variables.put(equation.get(1), nvar++);
        }
        List<Pair>[] edges = new List[nvar];
        for (int i = 0; i < nvar; i++) {
            edges[i] = new ArrayList<Pair>();
        }
        for(int i = 0; i < equations.size(); i++){
            int va = variables.get(equations.get(i).get(0));
            int vb = variables.get(equations.get(i).get(1));
            edges[va].add(new Pair(vb, values[i]));
            edges[vb].add(new Pair(va, 1. / values[i]));
        }
        double[] results = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++){
            if(!variables.containsKey(queries.get(i).get(0)) || !variables.containsKey(queries.get(i).get(1))){
                results[i] = -1.;
                continue;
            }
            int ia = variables.get(queries.get(i).get(0));
            int ib = variables.get(queries.get(i).get(1));
            Queue<Integer> queue = new LinkedList<>();
            double[] ratios = new double[nvar];
            Arrays.fill(ratios, -1.);
            queue.offer(ia);
            ratios[ia] = 1.;
            while(!queue.isEmpty() && ratios[ib] < 0){
                int point = queue.poll();
                for(Pair pair: edges[point]){
                    int y = pair.point;
                    double val = pair.val;
                    ratios[y] = ratios[point] * val;
                    queue.offer(y);
                }
            }
            results[i] = ratios[ib];
        }
        return  results;
    }
}
