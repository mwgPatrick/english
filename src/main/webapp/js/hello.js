function getTranslation() {
    var word = $('#english').val();
    $.get("http://localhost:8090/getByWord?word=" + word,function (data,status) {
        console.log(data);
        var tra = data.translation;
        var chinese = document.getElementById("chinese");
        chinese.innerText = tra;
    })
}
function getRand() {
    $.ajax({
        type:"get",
        url:"http://localhost:8090/getRandomWord",
        data:null,
        async:false,
        dataType:'json',
        success:function (res) {
            var word = res.word;
            var translation = res.translation;
            var ran_word = document.getElementById("ran_word");
            var ran_translation = document.getElementById("ran_trans")
            ran_word.innerText = word;
            ran_translation.innerText = translation;
        },
        error:function (res) {
            alert("请求失败。")
        }
    })
}