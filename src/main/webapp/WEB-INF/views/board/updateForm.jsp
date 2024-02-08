<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<div class="container p-5">
    <div class="card">
        <div class="card-header"><b>익명 글수정 화면입니다</b></div>
        <div class="card-body">
            <form action="/board/${board.no}/update" method="post">
                <div class="mb-3">
                    <input type="text" class="form-control" placeholder="Enter author" name="author" disabled value="${board.username}">
                </div>
                <div class="mb-3">
                    <input type="text" class="form-control" placeholder="Enter title" maxlength="20" name="title" value="${board.title}">
                </div>
                <div class="mb-3">
                    <textarea class="form-control" rows="5" maxlength="20" name="content">${board.content}</textarea>
                </div>
                <button type="submit" class="btn btn-primary form-control">글수정완료</button>
            </form>
        </div>
    </div>
</div>
