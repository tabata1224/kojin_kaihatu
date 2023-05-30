
package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "cl_fielder")
public class CLFielder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer playerId;

    @Column(name = "uniform_number")
    private int uniformNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "team_id")
    private Integer teamId;

    @Column(name = "order_num")
    private Integer orderNum;

    @Column(name = "position")
    private Integer position;

    @Column(name = "batting_average")
    private double battingAverage;

    @Column(name = "hit")
    private Integer hit;

    @Column(name = "double_hit")
    private Integer doubleHit;

    @Column(name = "three_hit")
    private Integer threeHit;

    @Column(name = "homerun")
    private Integer homerun;

    @Column(name = "run_batted_in")
    private Integer runBattedIn;

    @Column(name = "base_stealing")
    private Integer baseStealing;
}