$(document).ready(function () {
    $("#ckAll").click(ckAll);
    $("tbody td input").click(
        function () {
            if (this.ckecked == true){
                $(this).parents("tr").addClass("tr_hover");
            } else {
                $(this).parents("tr").removeClass("tr_hover");
            }
            
        }
    );

    $("tbody tr:even").addClass("tr_odd");
    $("tbody tr:odd").addClass("tr_even");

});

var ckAll = function () {
    if(this.checked == true){
        $("tbody input").attr("ckecked","true");
    }else {
        $("tbody input").attr("ckecked","false");
    }
}