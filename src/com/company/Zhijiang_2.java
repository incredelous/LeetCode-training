package com.company;
import java.util.Collections;
import java.util.List;

public class Zhijiang_2 {
/**
 * Copyright (C), 2019-2021, citi Group
 * Filename: Zhijiang_2
 * Author: wyf
 * Date: 20210513 
 * Description: 
 * History:
 *
 */
    public void washCards(int n, int t, List<Integer> cards){
        for(int i = 0; i < t; i++){
            washCardsIterative(0, cards.size(), cards);
        }
        for(int i = 0; i < cards.size(); i++){
            System.out.print(cards.get(i));
            System.out.print(" ");
        }
    }

    public void washCardsIterative(int start, int end, List<Integer> cards){
        if(end - start == 2) {
            Collections.swap(cards, start, end-1);
        }
        else{
            washCardsIterative(start, end/2, cards);
            washCardsIterative(end/2, end, cards);
        }
    }

}
