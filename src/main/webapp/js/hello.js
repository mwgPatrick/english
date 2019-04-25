function getTranslation() {
    var word = $('#english').val();

    $.post("http://localhost:8090/word/getByWord",{"word" : word}, function (data) {
        // console.log(data);
        var tra
        if(data.translation != null)
            tra = data.translation;
        else
            tra = "没有查询结果，请检查是否输入有误。";
        var chinese = document.getElementById("chinese");
        chinese.innerText = tra;
    })

}
    // $.get("http://localhost:8090/word/getByWord?word=" + word, function (data) {
    //     // console.log(data);
    //     var tra
    //     if(data.translation != null)
    //         tra = data.translation;
    //     else
    //         tra = "没有查询结果，请检查是否输入有误。"
    //     var chinese = document.getElementById("chinese");
    //     chinese.innerText = tra;
    // })

function getRand() {
    $.ajax({
        type:"get",
        url:"http://localhost:8090/word/getRandomWord",
        data:null,
        async:false,
        dataType:'json',
        success:function (res) {
            var word = res.word;
            var translation = res.translation;
            var ran_word = document.getElementById("ran_word");
            var ran_translation = document.getElementById("ran_trans");
            ran_word.innerText = word;
            ran_translation.innerText = translation;
        },
        error:function (res) {
            alert("请求失败。")
        }
    })

}
