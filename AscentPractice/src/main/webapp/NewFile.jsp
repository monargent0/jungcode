<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
	<style>
	.container{
	     	position: absolute;
	      	/* top : 50%; */
	      	left : 50%;
	      	transform : translate(-50%,0%);
	      	float: center;
	    }
	    
	</style>
	
<body  bgcolor="#FFFAF6">
<div class="container">
  <main>
    
    <div class="titletext">
      <h2>회원가입</h2>
    </div>

	<div id="contents">
     <h4 class="#">정보를 입력해 주세요.</h4>
        <form class="needs-validation" novalidate>
          <div class="#">
	            <div class="이름">
	              <label for="firstName" class="form-label">Name</label>
	            </div>
	            <div>
	              <input type="text" class="form-control" id="firstName" placeholder="이름" value="" required>
	            </div>
	            <div class="invalid-feedback">
	                Valid first name is required.
	            </div> 
           </div>

            <div class="#">
              <label for="username" class="form-label">ID</label>
              <div class="input-group has-validation">
                <span class="input-group-text">@</span>
                <input type="text" class="form-control" id="username" placeholder="Username" required>
              <div class="invalid-feedback">
                  Your username is required.
                </div>
              </div>
            </div>

            <div class="col-12">
              <label for="email" class="form-label">Email <span class="text-muted">(Optional)</span></label>
              <input type="email" class="form-control" id="email" placeholder="you@example.com">
              <div class="invalid-feedback">
                Please enter a valid email address for shipping updates.
              </div>
            </div>

            <div class="col-12">
              <label for="address" class="form-label">phone</label>
              <input type="text" class="form-control" id="address" placeholder="1234 Main St" required>
              <div class="invalid-feedback">
                Please enter your shipping address.
              </div>
            </div>

            <div class="col-12">
              <label for="address2" class="form-label">pw <span class="text-muted">(Optional)</span></label>
              <input type="text" class="form-control" id="address2" placeholder="Apartment or suite">
            </div>

          </div>
           <hr class="my-4">

          <button class="w-100 btn btn-primary btn-lg" type="submit">Continue to checkout</button>
       	 </form>
      </div>
      </main>
    
  </div>
</body>
</html>