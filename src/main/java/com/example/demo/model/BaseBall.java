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
@Table(name = "central")
public class BaseBall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "ranking")
    private int ranking;

    @Column(name = "game")
    private int game;

    @Column(name = "win")
    private int win;

    @Column(name = "lose")
    private int lose;

    @Column(name = "draw")
    private int draw;

    @Column(name = "batting_average")
    private double battingAverage;

    @Column(name = "earned_runs_average")
    private double earnedRunsAverage;
}
