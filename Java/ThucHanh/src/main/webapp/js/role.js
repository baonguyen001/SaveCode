
/*Đoạn mã bên trong hàm sẽ được thực thi khi html đã load xong
 */
$(document).ready(function() {
	//Khi click vào thẻ chứa class "btn-xoa"
	$('.btn-xoa').click(function() {
		// lấy giá trị của thuộc tính "role-id" từ phần tử đang đc chọn
		var id = $(this).attr("id-role")
		var row = $(this).closest('tr')
		
		/*Sử dụng ajax để gọi post ngầm với data được truyền là id
		của thẻ được chọn thì sẽ xóa được phần tử ở database*/
		$.ajax({
			method: "POST",
			url: "http://localhost:8443/ThucHanh/api/role",
			data: { id: id }
		})
		//Đoạn mã bên trong sẽ được thực thi
		// khi yêu cầu Ajax hoàn thành thành công
			.done(function( msg ) {
					console.log(msg)
			});

	})


})