// 삭제 기능
const deleteButton = document.getElementById('delete-btn')

if(deleteButton){
    deleteButton.addEventListener('click', event => {
        let id = document.getElementById('article-id').value;
        fetch('/api/articles/${id}',{
            method: 'DELETE'
        })
            .then(()=> {
                alert('삭제가 완료되었습니다');
                location.replace('/articles')
            });
    });
}

// 수정 기능
// 수정 기능
const modifyButton = document.getElementById('modify-btn');

if(modifyButton) {
    modifyButton.addEventListener('click', event => {
        // 수정 버튼 클릭 시 해당 게시글의 id를 가져오는 부분
        let id = document.getElementById('article-id').value; // 올바른 id 값을 가져오도록 수정

        fetch('/api/articles/' + id, { // 여기서 ${id} 대신에 올바른 id 값을 사용하도록 수정
            method: 'PUT',
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                title: document.getElementById('title').value,
                content: document.getElementById('content').value
            })
        })
            .then(() => {
                alert('수정이 완료되었습니다.');
                location.replace('/articles/' + id); // 여기서도 ${id} 대신에 올바른 id 값을 사용하도록 수정
            });
    });
}
