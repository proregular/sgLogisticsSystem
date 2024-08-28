/*
    메소드 선언
*/

/*
    셀렉트 데이터를 가져온다.
    dataLadel(String) : 가져올 데이터 라벨(dept, rank 등)
*/
function cmnSelectListAjax(dataLabel) {
    let ajaxApiUrl = "/api/";
    let successFg = false;
    let resultData = [];

    ajaxApiUrl = ajaxApiUrl + dataLabel;

    $.ajax({
        type: 'GET',
        url: ajaxApiUrl,
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        async: false,
        success: function (result) {
            successFg = true;
            resultData = result;
        },
        error: function (e) {
            alert("Ajax 통신에 실패하였습니다.");
        }
    });

    if(successFg) {
        return resultData;
    } else {
        alert('목록 조회에 실패하였습니다. 목록명: ' + dataLabel);
        return [];
    }

}

/*
 	셀렉트 리스트를 설정 해준다.
*/
function cmnSetSelect(elId, keyField, valueField, list) {
	$(elId).html('');
	
    for(let i=0; i<list.length; i++) {
        $(elId).append(
            `<option value="${list[i][keyField]}">${list[i][valueField]}</option>`
        );
    }
}