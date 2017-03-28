<script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>


<script>
$(document).ready(function() {
	$('table').each(function(){
	    $(this).DataTable();
	    $(this).addClass('defaultTable display cell-border compact');
	});
} );
</script>