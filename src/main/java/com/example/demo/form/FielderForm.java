package com.example.demo.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FielderForm {

    @NotNull(message = "入力してください")
    @Min(value = 0, message = "負の値は入力出来ません")
    private Integer uniformNumber;

    @NotBlank(message = "入力してください")
    private String name;

    private Integer teamId;

    private Integer orderNum;

    private Integer position;

    @Max(value = 1, message = "0 ~ 1の値を入力してください")
    @Min(value = 0, message = "0 ~ 1の値を入力してください")
    private double battingAverage;

    @NotNull(message = "入力してください")
    @Min(value = 0, message = "負の値は入力出来ません")
    private Integer hit;

    @NotNull(message = "入力してください")
    @Min(value = 0, message = "負の値は入力出来ません")
    private Integer doubleHit;

    @NotNull(message = "入力してください")
    @Min(value = 0, message = "負の値は入力出来ません")
    private Integer threeHit;

    @NotNull(message = "入力してください")
    @Min(value = 0, message = "負の値は入力出来ません")
    private Integer homerun;

    @NotNull(message = "入力してください")
    @Min(value = 0, message = "負の値は入力出来ません")
    private Integer runBattedIn;

    @NotNull(message = "入力してください")
    @Min(value = 0, message = "負の値は入力出来ません")
    private Integer baseStealing;
}
