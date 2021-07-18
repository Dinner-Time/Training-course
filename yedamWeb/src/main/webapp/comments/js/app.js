// app.js
// 1. ajax와 servlet을 활용

// 'use strict'를 선언하면 브라우저 콘솔에서 error를 더욱 정확하게 잡아낸다.
'use strict'


// 브라우저가 load되었을때 (페이지를 새로 열거나 새로고침 했을때)
window.onload = function () {
    // #commentList에 이미 저장된 게시글을 불러온다.
    loadCommentList();
}

function textEffect(){
    const inputText = document.querySelectorAll('input[type="text"]');
    const labelText = document.querySelectorAll('input[type="text"] ~ label');

    for(let i =0; i<inputText.length; i++){
        if (inputText[i].value != ""){
            labelText[i].classList.remove("active");
            labelText[i].classList.add("inactive");
        } else{
            labelText[i].classList.remove("inactive");
            labelText[i].classList.add("active");
        }
    }
}

// ************************** 페이지 로드 **************************

// 목록조회
function loadCommentList() {
    // 1. 데이터베이스에 저장되어있는 게시글을 불러오는 메서드.
    // 2. ajax를 이용, servlet페이지에 JSON, xml형태로 저장된 텍스트들을 읽어온다.

    // ajax를 이용하기 위한 객체 생성
    let xhtp = new XMLHttpRequest();

    // servlet페이지를 열고(?)
    xhtp.open("get", "../CommentsServ?cmd=selectAll");

    // servlet페이지와 통신(?)
    xhtp.send();
    xhtp.onreadystatechange = loadCommentResult;
}

// 조회결과
function loadCommentResult() {
    // 1. servlet페이지의 데이터들을 불러와서
    // 2. #commentList에 작성한다.
    // 3. 여기서 this의 의미는(???)

    // 아래 조건식은 페이지 연결상태가 정상일때를 의미한다
    if (this.readyState == 4 && this.status == 200) {
        let xmp = new DOMParser(); // xml로 저장된 데이터를 사용하기 위한 객체 생성
        let xmlDoc = xmp.parseFromString(this.responseText, 'text/xml'); // 데이터를 string타입으로 변환
        let code = xmlDoc.getElementsByTagName('code')[0].innerHTML; // java에서 데이터 처리가 제대로 되었는지 확인하기 위한 변수
        let listDiv = document.getElementById('commentList'); // 데이터를 추가할 부모div

        if (code == 'success') { // 데이터 처리가 성공적

            // 추가할 데이터를 처리가능한 형태로 변경
            // JSON은 eval 사용 불가능
            let commentList = eval(xmlDoc.getElementsByTagName('data')[0].innerHTML);

            // commentList는 object를 담은 *Array*이다.
            console.log(commentList); // 데이터 확인(주석 가능)

            for (let row of commentList) {
                // makeCommentView(comment) => 데이터를 읽어와서 div태그를 생성
                listDiv.appendChild(makeCommentView(row)); // 데이터를 하나씩 추가
            }
        } else {
            alert("data Error!! Check on ~DAO.java")
        }
    }
}

// ************************** 페이지 로드 **************************


// ************************** 데이터 작성 **************************

// 한 건을 조회
function makeCommentView(comment) {
    let div = document.createElement('div'); // div태그 생성
    div.setAttribute('id', comment.id); // id속성값을 읽어온 데이터의 id값으로 저장
    div.className = 'comment'; // class 부여(comment)
    div.comment = comment; // (????)
    div.innerHTML = commentView(comment); // 생성한 div태그의 html내용을 작성
    return div;
}

// 출력 내용 작성
function commentView(comment) {
    let str = 
        '<div class="conWrapper">' +
        '<span class="writer">' + comment.name +'</span class="writer">' + // 작성자 이름
        '<span class="content">' + comment.content + '<span class="content">' + // 작성 내용
        '</div>' +
        '<div class="btnWrapper">' +
        '<input type="button" value="수정" onclick="viewUpdateForm(' +
        comment.id + ')">' +
        '<input type="button" value="삭제" onclick="confirmDeletion(' +
        comment.id + ')">' +
        '</div>'
    return str;
}

// ************************** 데이터 작성 **************************


// ************************** 게시글 추가 **************************

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
            addForm.name.value = "";
            addForm.content.value = "";
            textEffect();
        } else if (code = 'error') {
            alert("error");
        }
    }
}

// ************************** 게시글 추가 **************************


// ************************** 게시글 수정 **************************

// 수정 화면
function viewUpdateForm(commentId) {
    let commentDiv = document.getElementById(commentId);
    let updateFormDiv = document.getElementById('commentUpdate');
    updateFormDiv.style.display = "block";

    commentDiv.appendChild(updateFormDiv);
    let comment = commentDiv.comment;
    console.log(updateForm.id);
    updateForm.id.value = comment.id;
    updateForm.name.value = comment.name;
    updateForm.content.value = comment.content;
    textEffect();
}

// 변경 버튼
function updateComment() {
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
    let param = "&id=" + id + "&name=" + name + "&content=" + content;
    console.log(param);
    let xhtp = new XMLHttpRequest();
    xhtp.open("get", "../CommentsServ?cmd=update" + param);
    xhtp.send();
    xhtp.onreadystatechange = updateResult;
}

// 변경 콜백 함수
function updateResult() {
    if (this.readyState == 4 && this.status == 200) {
        let xmp = new DOMParser();
        let xmlDoc = xmp.parseFromString(this.responseText, 'text/xml');
        let code = xmlDoc.getElementsByTagName('code')[0].innerHTML;
        let listDiv = document.getElementById('commentList');
        if (code = 'success') {
            let comment = JSON.parse(xmlDoc.getElementsByTagName('data').item(0).innerHTML);
            let updateFormDiv = document.getElementById('commentUpdate');
            updateFormDiv.style.display = "none";
            listDiv.appendChild(updateFormDiv);
            for (let i of listDiv.children) {
                if (i.id == comment.id) {
                    i.innerHTML = commentView(comment);
                    break;
                }
            }
        } else if (code = 'error') {
            alert("error");
        }
    }
}

// 취소 버튼
function cancelComment() {
    document.getElementById('commentUpdate').style.display = "none";
}

// ************************** 게시글 수정 **************************


// ************************** 게시글 삭제 **************************

// 삭제 버튼
function confirmDeletion(commentId) {
    let xhtp = new XMLHttpRequest();
    xhtp.open("get", "../CommentsServ?cmd=delete&id=" + commentId);
    xhtp.send();
    xhtp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById(commentId).remove();
        }
    }
}

// ************************** 게시글 삭제 **************************