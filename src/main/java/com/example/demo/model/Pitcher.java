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
@Table(name = "pitcher")
public class Pitcher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer playerId;

    @Column(name = "uniform_number")
    private Integer uniformNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "team_id")
    private Integer teamId;

    @Column(name = "pitched")
    private Integer pitched;

    @Column(name = "earned_runs_average")
    private double earnedRunsAverage;

    @Column(name = "win")
    private Integer win;

    @Column(name = "lose")
    private Integer lose;

    @Column(name = "save")
    private Integer save;

    @Column(name = "hold")
    private Integer hold;

    @Column(name = "innings_pitched")
    private double inningsPitched;

    @Column(name = "strike_out")
    private Integer strikeOut;
}