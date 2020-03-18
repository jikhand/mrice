
<!-- Create menu section  Start-->
<div class="row form-inline">
	<input type="submit" class="btn btn-default" id="createMenuAddFont"
		value="+"> <input type="submit" class="btn btn-default"
		id="createMenuRemoveFont" value="-">
</div>
<div class="row form-inline" id="createMenu">
	<div>
		<div class="form-group">
			<label for="menuName">Menu Name:</label> <input type="text"
				class="form-control menuName" id="menuName">
		</div>
		<div class="form-group">
			<label for="menuPosition">Menu Position:</label> <input type="text"
				class="form-control menuPosition" id="menuPosition">
		</div>
		<div class="form-group">
			<label for="appendUrl">Url:</label> <input type="text"
				class="form-control appendUrl" id="appendUrl">
		</div>
		<div class="form-group">
			<input type="submit" class="btn btn-success" id="createMenuSubmit">
		</div>
	</div>
</div>


<div></div>
<!-- Create menu section  End-->
<!-- Menu Data Table for showing editing and deleting -->

<div class="row" style="margin: 2em 0em 0em 4em">
	<table id="menuTable" class="display nowrap table table-bordered"
		style="width: 90%">
		<thead>
			<tr>
				<th>Menu id</th>
				<th>Menu name</th>
				<th>Menu position</th>
				<th>Menu Url</th>
			</tr>
		</thead>
		<tbody>
		</tbody>

	</table>
</div>
