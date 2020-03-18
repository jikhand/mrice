var projrctOrigin = document.location.origin;
/* Side menu section Start */
$(document).ready(
	function () {
		$.ajax({
			url: "/getSideMenu",
			cache: false,
			type: "GET",
			headers: {
				"Content-Type": "application/json"
			},
			success: function (data) {
				$.each(data, function (index, value) {
					$("#leftMenu").append(
						'<li>' + value[1] + '</li>');
				})

			},
			error: function (jqXHR, textStatus, errorThrown) {
				alert(textStatus);
			}
		})
	})
/* Side menu section End */
$(function () {
	$("#proNext").click(function () {
		$("#productName1").val($("#productName").val())
		$("#prodInfSec").show();
		$("#proCreSec").hide();
	})
})
$(function () {
	$("#productAndInfSave").unbind().click(function () {
		
	    var files = $('#product-image-input')[0].files[0];
	    var data = new FormData();
	    data.append('file',files);
	    
		var productName = $("#productName").val();
		var productDesc = $("#productDesc").val();
		var volume = $("#volume").val();
		var format = $("#format").val();
		var origin = $("#origin").val();
		var weight = $("#weight").val();
		var units = $("#units").val();
		var brand = $("#brand").val();
		var manufacturer = $("#manufacturer").val();
		var specialty = $("#specialty").val();
		

		var dataToPost = {
			"productName": productName,
			"productDesc": productDesc,
			"productInformation": {
				"origin": origin,
				"volume": volume,
				"format": format,
				"weight": weight,
				"units": units,
				"brand": brand,
				"manufacturer": manufacturer,
				"specialty": specialty,
			},"fileUploadEntity" :{"fileName":"gut.png"}		
		}
		data.append('product',JSON.stringify(dataToPost));
		alert(data.product);
		$.ajax({
			url: '/createProduct',
			enctype: 'multipart/form-data',
			type: "POST",
			
			/*headers: {
				"Content-Type": "application/json"
			},*/
			data: data,
			processData: false,
	        contentType: false,
	        cache: false,
	        timeout: 600000,
			success: function (data) {
				alert(data)
			},
			error: function () {
				alert("Not Success")
			}
		});
	})
})
$(function () {
	$("#goToProduct").click(function () {
		$("#prodInfSec").hide();
		$("#proCreSec").show();
	})
})

function filePreview(input) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();
		reader.onload = function (e) {
			$('#product-image-form + img').remove();
			$('#product-image-form').after(''+'<img class="product-image rounded float-right" src='+'"'+ e.target.result +'"'+'/>'+'');
		};
		reader.readAsDataURL(input.files[0]);
	}
}
$(function(){
$("#product-image-input").change(function () {
	
	filePreview(this);
});
});
/* *----Create Case Start------------------------------------------------------------- * */

/* Create menu section Start */
$(function () {
	var menucount = 0;
	$("#createMenuAddFont")
		.click(
			function () {
				menucount++
				var createmenu = '<div id="' +
					menucount +
					'">' +
					'<div class="form-group">' +
					'<label for="menuName">Menu Name:</label> <input type="text" class="form-control menuName" id="menuName">' +
					'</div>' +
					'<div class="form-group">' +
					'<label for="menuPosition">Menu Position:</label> <input type="text" class="form-control menuPosition" id="menuPosition">' +
					'</div>' +
					'<div class="form-group">' +
					'<label for="appendUrl">Url:</label> <input type="text" class="form-control appendUrl" id="appendUrl">' +
					'</div>' + '</div>';
				$("#createMenu").append(createmenu)
			})
	$("#createMenuRemoveFont").click(function () {
		$('#' + menucount).remove()
		menucount--
	})

})
//Dynamic menu field generate
$(function () {
	$("#createMenuSubmit").click(function () {
		var menuName = [];
		var menuPosition = [];
		var appendUrl = [];
		var dataToPost = new Array;
		$('.menuName').each(function () {
			menuName.push($("#menuName").val());
		});
		$('.menuPosition').each(function () {
			menuPosition.push($("#menuPosition").val());
		});
		$('.appendUrl').each(function () {
			appendUrl.push($("#appendUrl").val());
		});

		for (i = 0; i < menuName.length; i++) {
			var arr = {
				menuName: menuName[i],
				menuPosition: menuPosition[i],
				appendUrl: appendUrl[i]
			};
			dataToPost.push(arr);
		}
		//alert(JSON.stringify(dataToPost))
		$.ajax({
			url: "/createMenu",
			method: "POST",
			headers: {
				"Content-Type": "application/json"
			},
			data: JSON.stringify(dataToPost),
			success: function (data) {
				location.reload();
			}
		});
	})
})
/* Create menu section Start */
//Menu table section start
$(function () {
	var tblId = $("#menuTable");
	var bodyOfTable = document.createElement("tbody");
	var dataRow = '';

	$.getJSON("/getAllMenuDiscByDateTime", function (data) {
		$.each(data, function (index, value) {

			dataRow += '<tr>' +
				'<td>' + value.menuId + '</td>' +
				'<td>' + value.menuName + '</td>' +
				'<td>' + value.menuPosition + '</td>' +
				'<td>' + value.appendUrl + '</td>' +
				'<td>' +
				'<button id="mEdit" class="btn btn-info">Edit</button> <button id="mUpdate" style="display:none" class="btn btn-primary">Update</button>' +
				'<button id="mDelete" class="btn btn-danger">Delete</button> <button id="mCancel" style="display:none" class="btn btn-warning">cancel</button>' +
				'</td>' +
				'</tr>';
		})
		var addBody = bodyOfTable.innerHTML = dataRow;
		tblId.append(addBody);
	})
})
$("body").on("click", "#mDelete", function () {
	var mId = $(this).parents("tr").find("td:eq(0)").text()
	$.ajax({
		url: 'deleteMenu/' + mId,
		type: "GET",
		headers: {
			"Content-Type": "application/json"
		},
		success: function () {
			location.reload()
		},
		error: function () {
			alert("Not Success")
		}
	});
});
//Menu edit start
$("body").on("click", "#mEdit", function () {
	$(this).parents("tr").find("td:eq(1)").attr('contenteditable', 'true');
	$(this).parents("tr").find("td:eq(2)").attr('contenteditable', 'true');
	$(this).parents("tr").find("td:eq(3)").attr('contenteditable', 'true');
	$(this).parents("tr").find("#mEdit").hide();
	$(this).parents("tr").find("#mDelete").hide();
	$(this).parents("tr").find("#mUpdate").show();
	$(this).parents("tr").find("#mCancel").show();
});
//Menu edit end
//Menu update start
$("body").on("click", "#mUpdate", function () {
	var mId = $(this).parents("tr").find("td:eq(0)").text();
	var mName = $(this).parents("tr").find("td:eq(1)").text();
	var mPosition = $(this).parents("tr").find("td:eq(2)").text();
	var mUrl = $(this).parents("tr").find("td:eq(3)").text();

	var menudata = {
		menuName: mName,
		menuPosition: mPosition,
		appendUrl: mUrl
	};

	$.ajax({
		url: 'updateMenu/' + mId,
		type: "POST",
		headers: {
			"Content-Type": "application/json"
		},
		data: JSON.stringify(menudata),
		success: function () {
			location.reload()
		},
		error: function () {
			alert("Not Success")
		}
	});
})
//Menu update end
//Menu cancel start
$("body").on("click", "#mCancel", function () {
	location.reload();
});
//Menu cancel end
//Menu table show end
/* *----Create Case End------------------------------------------------------------- * */