package com.example.demo.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class EditFielderForm {

    private Integer playerId;

    @NotNull(message = "この項目は入力必須です")
    @Min(value = 0, message = "負の値は入力出来ません")
    private Integer uniformNumber;

    @NotBlank(message = "この項目は入力必須です")
    private String name;

    @NotNull(message = "この項目は入力必須です")
    private Integer teamId;

    private Integer orderNum;

    private Integer position;

    @Max(value = 1, message = "1 ~ 0の値を入力してください")
    @Min(value = 0, message = "1 ~ 0の値を入力してください")
    private double battingAverage;

    @Min(value = 0, message = "負の値は入力出来ません")
    private Integer hit;

    @Min(value = 0, message = "負の値は入力出来ません")
    private Integer doubleHit;

    @Min(value = 0, message = "負の値は入力出来ません")
    private Integer threeHit;

    @Min(value = 0, message = "負の値は入力出来ません")
    private Integer homerun;

    @Min(value = 0, message = "負の値は入力出来ません")
    private Integer runBattedIn;

    @Min(value = 0, message = "負の値は入力出来ません")
    private Integer baseStealing;
}
