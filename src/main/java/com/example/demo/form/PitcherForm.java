package com.example.demo.form;

import lombok.Data;

@Data
public class PitcherForm {

    private Integer uniformNumber;

    private String name;

    private Integer teamId;

    private Integer pitched;

    private double earnedRunsAverage;

    private Integer win;

    private Integer lose;

    private Integer save;

    private Integer hold;

    private double inningsPitched;

    private Integer strikeOut;
}
