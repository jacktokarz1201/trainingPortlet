<script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>


<script>



$(function() {
    $( ".dialog" ).dialog({
       autoOpen: false,  
    });
    
    $( "#opener" ).click(function() {
       $( "#makeCourseDialog" ).dialog( "open" );
    });

    $( "#deleteOpener" ).click(function() {
       $( "#deleteCourseDialog" ).dialog( "open" );
    });

    $( "#startOpener" ).click(function() {
       $( "#startAssignmentDialog" ).dialog( "open" );
    });

    $( "#updateOpener" ).click(function() {
       $( "#updateAssignmentDialog" ).dialog( "open" );
    });
 });

function initialValidation(){
	document.getElementById("submitCourse").click();
}
function makeSelectHappen(){
	document.getElementById("submitSelect").click();
}

function openUpdate(id) {
	console.log("This is the id "+id);
	var theID= "#updateAssignment"+id+"Dialog";
	consle.log(theID);
	document.getElementById(theID).dialog("open");
}

</script>