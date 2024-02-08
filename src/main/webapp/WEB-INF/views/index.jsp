<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./layout/header.jsp" %>
<div class="container p-5">

    <table class="table table-striped">
        <thead>
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>내용</th>
            <th>작성자</th>
            <th></th>
        </tr>
        </thead>
	        <tbody>
		        <c:forEach var="board" items="${BoardList}">
			        <tr>
			            <td>${board.no}</td>
			            <td>${board.title}</td>
			            <td>${board.content}</td>
			            <td>${board.username}</td>
			            <td>
			                <div class="d-flex">
			                    <form action="/board/${board.no}/delete" method="post">
			                        <button class="btn btn-danger">삭제</button>
			                    </form>
			                    <form action="/board/${board.no}/updateForm" method="get">
			                        <button class="btn btn-warning">수정</button>
			                    </form>
			                </div>
			            </td>
			        </tr>
		        </c:forEach>
	        </tbody>
    </table>
    <c:if test="${BoardList.isEmpty()}">
    	<p id="no--board">게시글 없음</p>
    </c:if>
	<button class="btn btn-primary" onclick="location.href='/board/saveForm'">
		글쓰기
	</button>
</div>

