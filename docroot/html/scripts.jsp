<script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>


<script>
$(document).ready(function() {
	$('table').each(function(){
	    $(this).addClass('defaultTable display cell-border compact');
	    if( $(this).hasClass("plain")) {
	    	$(this).DataTable({
	    		"paging": false,
	    		"searching": false,
	    		"info": false
	    	});
	    }
	    else {
	    	$(this).DataTable({
	    		"pageLength": 5
	    	});
	    }
	});
} );
</script>