// app.js
// 1. ajax와 servlet을 활용

'use strict' // 브라우저 콘솔에서 error를 더욱 정확하게 잡아낸다.

window.onload = function () {
    loadCommentList();
}

// 목록조회
function loadCommentList() {
    // ajax 호출, servlet 호출
    let xhtp = new XMLHttpRequest();
    xhtp.open("get", "../CommentsServ?cmd=selectAll");
    xhtp.send();
    xhtp.onreadystatechange = loadCommentResult;
}

// 조회결과
function loadCommentResult() {
    if (this.readyState == 4 && this.status == 200) {
        let xmp = new DOMParser();
        let xmlDoc = xmp.parseFromString(this.responseText, 'text/xml');
        let code = xmlDoc.getElementsByTagName('code')[0].innerHTML;
        let listDiv = document.getElementById('commentList');
        if (code == 'success') {
            let commentList = eval(xmlDoc.getElementsByTagName('data')[0].innerHTML);
            console.log(commentList);
            for (let i = 0; i < commentList.length; i++) {
                listDiv.appendChild(makeCommentView(commentList[i]));
            }
        }
    }
}

// 한 건을 조회
function makeCommentView(comment) {
    let div = document.createElement('div');
    div.setAttribute('id', comment.id);
    div.className = 'comment';
    div.comment = comment;
    div.innerHTML = commentView(comment);
    return div;
}

// 출력 내용 작성
function commentView(comment){
    let str = '<strong>' + comment.name + '</strong>';
    str += comment.content;
    str += '<input type="button" value="수정" onclick="viewUpdateForm(';
    str += comment.id + ')">';
    str += '<input type="button" value="삭제" onclick="confirmDeletion(';
    str += comment.id + ')">';
    return str;
}

function addComment() {
    let name = addForm.name.value;
    if (name == "") {
        alert('please...');
        addForm.name.focus();
        return;
    }
    let content = addForm.content.value;
    if (content == "") {
        alert('please...');
        addForm.content.focus();
        return;
    }
    let param = "&name=" + name + "&content=" + content;
    console.log(param);
    let xhtp = new XMLHttpRequest();
    xhtp.open("get", "../CommentsServ?cmd=insert" + param);
    xhtp.send();
    xhtp.onreadystatechange = addResult;
}

// 등록 콜백 함수
function addResult() {
    if (this.readyState == 4 && this.status == 200) {
        let xmp = new DOMParser();
        let xmlDoc = xmp.parseFromString(this.responseText, 'text/xml');
        let code = xmlDoc.getElementsByTagName('code')[0].innerHTML;
        let listDiv = document.getElementById('commentList');
        if (code = 'success') {
            let comment = JSON.parse(xmlDoc.getElementsByTagName('data').item(0).innerHTML);
            console.log(comment);
            listDiv.appendChild(makeCommentView(comment));
            addForm.name.value="";
            addForm.content.value="";
        } else if (code = 'error') {
            alert("error");
        }
    }
}

// 수정 화면
function viewUpdateForm(commentId){
    let commentDiv = document.getElementById(commentId);
    let updateFormDiv = document.getElementById('commentUpdate');
    updateFormDiv.style.display = "block";

    commentDiv.appendChild(updateFormDiv);
    let comment = commentDiv.comment;
    console.log(updateForm.id);
    updateForm.id.value = comment.id;
    updateForm.name.value = comment.name;
    updateForm.content.value = comment.content;
}

// 변경 버튼
function updateComment(){
    let name = updateForm.name.value;
    if (name == "") {
        alert('please...');
        updateForm.name.focus();
        return;
    }
    let content = updateForm.content.value;
    if (content == "") {
        alert('please...');
        updateForm.content.focus();
        return;
    }
    let id = updateForm.id.value;
    let param = "&id="+ id +"&name=" + name + "&content=" + content;
    console.log(param);
    let xhtp = new XMLHttpRequest();
    xhtp.open("get", "../CommentsServ?cmd=update" + param);
    xhtp.send();
    xhtp.onreadystatechange = updateResult;
}

// 변경 콜백 함수
function updateResult(){
    if (this.readyState == 4 && this.status == 200) {
        let xmp = new DOMParser();
        let xmlDoc = xmp.parseFromString(this.responseText, 'text/xml');
        console.log(xmlDoc);
        let code = xmlDoc.getElementsByTagName('code')[0].innerHTML;
        let listDiv = document.getElementById('commentList');
        if (code = 'success') {
            let comment = JSON.parse(xmlDoc.getElementsByTagName('data').item(0).innerHTML);
            let updateFormDiv = document.getElementById('commentUpdate');
            updateFormDiv.style.display = "none";
            listDiv.appendChild(updateFormDiv);
            listDiv.children[comment.id-1].innerHTML = commentView(comment);
        } else if (code = 'error') {
            alert("error");
        }
    }
}

// 취소 버튼
function cancelComment(){
    document.getElementById('commentUpdate').style.display = "none";
}

// 삭제 버튼
function confirmDeletion(commentId){
    let xhtp = new XMLHttpRequest();
    xhtp.open("get", "../CommentsServ?cmd=delete&id=" + commentId);
    xhtp.send();
    xhtp.onreadystatechange = function(){
        if (this.readyState == 4 && this.status == 200){
            document.getElementById(commentId).remove();
        }
    }

}