<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <script>
  //헤더에 들어가기전에 알람이 뜨는 장소와 자기가 있는 현재 페이지가 같다면
  // 알람을 띄우지 않게 하기위해 자신의위치를 알려주는 flag
  var flagPage="board-register";
  </script>
    
<%@ include file="../includes/header.jsp" %>  
<!-- MAIN -->
<div class="main">
	<!-- MAIN CONTENT -->
	<%@ include file="../includes/alarm.jsp"%>
	<div class="main-content">
		<div class="container-fluid">
			<h3 class="page-title">Posting</h3>
			<div class="row">
				<div class="col-md-8">				
					<!-- INPUTS -->
					<div class="panel">
						<div class="panel-heading">
							<h3 class="panel-title">글쓰기</h3>
						</div>
						<div class="panel-body">
							<form action="/${group.groupCode }/board/register" method="post" id="form">
								<div>
									<label for="title"></label>
									<input type="text" class="form-control input-lg" name="title" id="title" value=""  placeholder="제목을 입력하세요">
								</div>						
								<div>
									<label for="edit"></label>
									<textarea class="form-control" id="edit" name="content"></textarea>
								</div>
								<input type="hidden" name="writer" value="${login.member.nickName }"/>
							</form>
						</div>
						<div class="panel-body">
							<div class="text-right">
								<button type="button" class="btn btn-primary" id="register"><i class="fa fa-pencil"></i><span>&ensp;</span>등록</button>											
								<button type="button" class="btn btn-info" id="list"><i class="fa fa-list"></i><span>&ensp;</span>목록</button>										
							</div>
						</div>
					</div>
					<!-- END INPUTS -->
				</div>
			</div>
		</div>
	</div>
	<!-- END MAIN CONTENT -->
</div>
<!-- END MAIN -->
<div class="clearfix"></div>
<footer>
	<div class="container-fluid">
		<p class="copyright">Shared by <i class="fa fa-love"></i><a href="https://bootstrapthemes.co">BootstrapThemes</a></p>
	</div>
</footer>
<script>
	$(function(){	
		CKEDITOR.replace('edit', {
			height: 500
		});	
			
			
		$("#register").on("click",function(){				
			var content = CKEDITOR.instances.edit.getData();
			console.log(content);
			$("#edit").val(content);		
			$("#form").submit();
		})
		
		
		
		
	})
</script>
<%@ include file="../includes/footer.jsp" %>