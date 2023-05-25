package com.example.demo.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class EditPitcherForm {

    private Integer playerId;

    @NotNull(message = "この項目は入力必須です")
    @Min(value = 0, message = "負の値は入力出来ません")
    private Integer uniformNumber;

    @NotBlank(message = "この項目は入力必須です")
    private String name;

    private Integer teamId;

    @Min(value = 0, message = "負の値は入力出来ません")
    private Integer pitched;

    @Min(value = 0, message = "負の値は入力出来ません")
    private double earnedRunsAverage;

    @Min(value = 0, message = "負の値は入力出来ません")
    private Integer win;

    @Min(value = 0, message = "負の値は入力出来ません")
    private Integer lose;

    @Min(value = 0, message = "負の値は入力出来ません")
    private Integer save;

    @Min(value = 0, message = "負の値は入力出来ません")
    private Integer hold;

    @Min(value = 0, message = "負の値は入力出来ません")
    private double inningsPitched;

    @Min(value = 0, message = "負の値は入力出来ません")
    private Integer strikeOut;
}
