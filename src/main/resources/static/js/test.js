function clicked() {
    alert("チームCLです。");
}

function clickedFieldAdd() {
    if (clickedFielder.uniformNumber.value == "" || clickedFielder.name.value == ""
        || clickedFielder.battingAverage.value == "" || clickedFielder.hit.value == ""
        || clickedFielder.doubleHit.value == "" || clickedFielder.threeHit.value == ""
        || clickedFielder.homerun.value == "" || clickedFielder.runBattedIn.value == "" ||
        clickedFielder.baseStealing.value == "") {
        alert("未入力項目があります");
        return false;
    }
    else if (clickedFielder.uniformNumber.value < 0
        || clickedFielder.battingAverage.value < 0 || clickedFielder.hit.value < 0
        || clickedFielder.doubleHit.value < 0 || clickedFielder.threeHit.value < 0
        || clickedFielder.homerun.value < 0 || clickedFielder.runBattedIn.value < 0 ||
        clickedFielder.baseStealing.value < 0) {
        alert("負の値の項目があります");
        return false;
    }
    else {
        alert("完了しました。")
        return true;
    }
}

function clickedPitcherAdd() {
    if (clickedPitcher.uniformNumber.value == "" || clickedPitcher.name.value == ""
        || clickedPitcher.pitched.value == "" || clickedPitcher.earnedRunsAverage.value == ""
        || clickedPitcher.win.value == "" || clickedPitcher.lose.value == ""
        || clickedPitcher.save.value == "" || clickedPitcher.hold.value == ""
        || clickedPitcher.inningsPitched.value == "" || clickedPitcher.strikeOut.value == "") {
        alert("未入力項目があります");
        return false;
    }
    else if (clickedPitcher.uniformNumber.value < 0
        || clickedPitcher.pitched.value < 0 || clickedPitcher.earnedRunsAverage.value < 0
        || clickedPitcher.win.value < 0 || clickedPitcher.lose.value < 0
        || clickedPitcher.save.value < 0 || clickedPitcher.hold.value < 0 ||
        clickedPitcher.inningsPitched.value < 0 || clickedPitcher.strikeOut.value < 0) {
        alert("負の値の項目があります");
        return false;
    }
    else {
        alert("完了しました。")
        return true;
    }
}

function check() {

    if (window.confirm('削除してよろしいですか？')) { // 確認ダイアログを表示

        return true; // 「OK」時は送信を実行

    }
    else { // 「キャンセル」時の処理

        window.alert('キャンセルされました'); // 警告ダイアログを表示
        return false; // 送信を中止

    }

}
