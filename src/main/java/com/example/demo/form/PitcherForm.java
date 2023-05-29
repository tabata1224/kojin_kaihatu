package com.example.demo.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PitcherForm {

    @NotNull(message = "入力してください")
    @Min(value = 0, message = "負の値は入力出来ません")
    private Integer uniformNumber;

    @NotBlank(message = "入力してください")
    private String name;

    private Integer teamId;

    @NotNull(message = "入力してください")
    @Min(value = 0, message = "負の値は入力出来ません")
    private Integer pitched;

    @NotNull(message = "入力してください")
    @Min(value = 0, message = "負の値は入力出来ません")
    private double earnedRunsAverage;

    @NotNull(message = "入力してください")
    @Min(value = 0, message = "負の値は入力出来ません")
    private Integer win;

    @NotNull(message = "入力してください")
    @Min(value = 0, message = "負の値は入力出来ません")
    private Integer lose;

    @NotNull(message = "入力してください")
    @Min(value = 0, message = "負の値は入力出来ません")
    private Integer save;

    @NotNull(message = "入力してください")
    @Min(value = 0, message = "負の値は入力出来ません")
    private Integer hold;

    @NotNull(message = "入力してください")
    @Min(value = 0, message = "負の値は入力出来ません")
    private double inningsPitched;

    @NotNull(message = "入力してください")
    @Min(value = 0, message = "負の値は入力出来ません")
    private Integer strikeOut;
}
