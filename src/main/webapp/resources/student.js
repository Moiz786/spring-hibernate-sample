$(document).ready(function () {

    $('#saveStudent').submit(function (e) {

        /**/
        $.ajax({
            type:'POST',
            url: "/test/student/",
            success:$.post('/test/student/save', $(this).serialize(), function(student) {
                $('#studentTableResponse').last().append(
                    '<tr>' +
                    '<td>' + student.id + '</td>' +
                    '<td>' + student.firstName + '</td>' +
                    '<td>' + student.lastName + '</td>' +
                    '<td>' + student.age + '</td>' +
                    '</tr>'
                );
            })

        });

        /*clearInputs();
         */
        e.preventDefault();
    });


});

$(document).ready(function () {
    $('#button').click(function () {

        var first = $('#firstInput').val();

        $.ajax({
            type:'DELETE',
            url:"/test/student/remove/" + first+"/" ,
            dataType:'json',
            success:function (result) {

                alert("Student: "+first+" "+ "deleted");

            },
            error:function (jqXHR, textStatus, errorThrown) {
                alert("Student " + textStatus + " " + errorThrown + " !");
            }

        });
    });
});


/*function clearInputs() {
 $('input[id*="Input"]').each(function () {
 $(this).val('');
 });
 }*/


/*
$(document).ready(function () {
    $('#search').keyup(function (e) {
        var filter = $('#search').val();
        if (filter.length > 0) {
            loadTable(filter);
        } else {
            $('tr[id*="tr_"]').remove();
        }
    });
});

function loadTable(filter) {
    var url = "/test/student/load/" + filter;

    $('#tbody').load(url, function (response, status, xhr) {
        if (status == "error") {
            var msg = "Sorry but there was an error: ";
            $("#info").html(msg + xhr.status + " " + xhr.statusText);
        }
    });

    return false;
}
*/
