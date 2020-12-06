package com.company;

import java.util.List;

public class Tree {
    public char value;
    public List<Tree> childNodes;

    public Tree(char value) {
        this.value = value;
    }

    public void addNode(Tree tree) {
        this.childNodes.add(tree);
    }

}
