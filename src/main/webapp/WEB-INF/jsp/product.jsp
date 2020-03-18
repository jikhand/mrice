<style>
	#hCreateProduct {
		margin-left: 12em;
		padding-bottom: 20px;
	}

	#prodInfSec {
		display: none;
	}

	.card {
		box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
		transition: 0.3s;
		width: 10em;
		height: 10em;
		margin: 3em 4em 1em 14em;
	}
</style>

<!-- product create section start -->
<div id="proCreSec">
	<div class="container">
		<h2 id="hCreateProduct">Add Product</h2>

		<form id="product-image-form" enctype="multipart/form-data" class="form-horizontal">
			<label for="product-image-input" class="control-label col-sm-2"></label>
			<div class="col-sm-10">
				<input type="file" id="product-image-input" name="productImage" accept="*">
			</div>
		</form>

		<div class="form-horizontal" id="creatProductForm">
			<div class="form-group">
				<label class="control-label col-sm-2" for="name">Name:</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="productName" placeholder="Enter Product Name"
						name="productName">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="description">Description:</label>
				<div class="col-sm-6">
					<textarea class="form-control" rows="5" id="productDesc" name="productDesc"
						style="max-width: 100%"></textarea>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-success" id="proNext">
						Next</button>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- product create section end -->
<!-- product information section start -->
<div id="prodInfSec">
	<div class="container-fluid">
		<h2>Add Product Information</h2>

		<div class="col-sm-6">
			<div class="form-group">
				<label for="productName">ProductName:</label> <input type="text" class="form-control" id="productName1"
					readonly>
			</div>
			<div class="form-group">
				<label for="Volume"> ProductVolume:</label> <input type="text" class="form-control" id="volume">
			</div>

			<div class="form-group">
				<label for="format">ProductFormat:</label> <input type="text" class="form-control" id="format">
			</div>

			<div class="form-group">
				<label for="weight">Product Weight :</label> <input type="text" class="form-control" id="weight">
			</div>
			<div class="form-group">
				<label for="units">Product Units:</label> <input type="text" class="form-control" id="units">
			</div>
		</div>
		<div class="col-sm-6">

			<div class="form-group">
				<label for="origin">Product Origin :</label> <input type="text" class="form-control" id="origin">
			</div>
			<div class="form-group">
				<label for="brand">Product Brand:</label> <input type="text" class="form-control" id="brand">
			</div>
			<div class="form-group">
				<label for="manufacturer">Product Manufacturer :</label> <input type="text" class="form-control"
					id="manufacturer">
			</div>
			<div class="form-group">
				<label for="speciality">Product Specialty:</label> <input type="text" class="form-control"
					id="specialty">
			</div>
			<div class="form-group">
				<div class="col-sm-6 well" id="goToProduct">Go Back</div>
				<div class="col-sm-6 well" id="productAndInfSave">Save Next</div>
			</div>
		</div>

	</div>
</div>
<!-- product information section end -->