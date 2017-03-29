<script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>


<script>
$(document).ready(function() {
	$('table').each(function(){
	    $(this).addClass('defaultTable display cell-border compact');
	    $(this).DataTable({
	    	"pageLength": 5
	    });
	});
} );


$(function() {
    $( "#makeCourseDialog" ).dialog({
       autoOpen: false,  
    });
    $( "#opener" ).click(function() {
       $( "#makeCourseDialog" ).dialog( "open" );
    });
 });
 
$(function() {
    $( "#deleteCourseDialog" ).dialog({
       autoOpen: false,  
    });
    $( "#deleteOpener" ).click(function() {
       $( "#deleteCourseDialog" ).dialog( "open" );
    });
 });
 
 
function initialValidation(){
	document.getElementById("submitCourse").click();
}
function makeSelectHappen(){
	document.getElementById("submitSelect").click();
}

</script>