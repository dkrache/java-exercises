package com.java.example.list;

import com.java.example.model.Player;
import com.java.example.model.Shoot;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamExample {

    List<Player> players;

    public StreamExample() {
        Player pa = new Player("Player A");
        pa.getShoots().add(new Shoot(1,10,pa));
        pa.getShoots().add(new Shoot(1,50,pa));
        pa.getShoots().add(new Shoot(2,50,pa)); // farthest 2

        Player pb = new Player("Player B");
        pb.getShoots().add(new Shoot(1,9,pb)); // closest 1
        pb.getShoots().add(new Shoot(1,51,pb));
        pb.getShoots().add(new Shoot(2,1,pb)); // Closest 2
        pb.getShoots().add(new Shoot(3,100,pb)); // farthest 3

        Player pc = new Player("Player C");
        pc.getShoots().add(new Shoot(3,10,pc)); // Closest 3
        pc.getShoots().add(new Shoot(2,10,pc));

        Player pd = new Player("Player D");
        pd.getShoots().add(new Shoot(1,80,pd)); // farthest 1

        this.players = Arrays.asList(pa,pb,pc,pd);
    }

    public List<Shoot> getClosestShootByPlayer(){
        return players.stream()
                .flatMap((x)->x.getShoots().stream())
                .sorted(Comparator.comparingInt(Shoot::getDistance))
                .filter(distinctByKey(Shoot::getPlayer))
                .collect(Collectors.toList());
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        ConcurrentHashMap.KeySetView<Object, Boolean> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

    public List<Shoot> getFarthestShootByPlayer() {
        return players.stream()
                .flatMap((x)->x.getShoots().stream())
                .sorted(Comparator.comparingInt(Shoot::getDistance).reversed())
                .filter(distinctByKey(Shoot::getPlayer))
                .collect(Collectors.toList());
    }

    public void getBestPlayerPerMatch(){
        players.stream()
                .flatMap(x -> x.getShoots().stream())
                .collect(Collectors.toMap(Shoot::getMatchId, p->p, (p, q)->p.getDistance()>q.getDistance()?p:q))
                .values().stream().forEach(x->System.out.println(x));
    }

    public void test4(){

    }

}
