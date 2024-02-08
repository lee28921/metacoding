<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<div class="container p-5">
    <div class="card">
        <div class="card-header"><b>ìµëª ê¸ì°ê¸° íë©´ìëë¤</b></div>
        <div class="card-body">
            <form action="#">
                <div class="mb-3">
                    <input type="text" class="form-control" placeholder="Enter author" name="author">
                </div>
                <div class="mb-3">
                    <input type="text" class="form-control" placeholder="Enter title" name="title">
                </div>
                <div class="mb-3">
                    <textarea class="form-control" rows="5" name="content"></textarea>
                </div>
                <button type="submit" class="btn btn-primary form-control">ê¸ì°ê¸°ìë£</button>
            </form>
        </div>
    </div>
</div>

<%@ include file="../layout/footer.jsp" %>