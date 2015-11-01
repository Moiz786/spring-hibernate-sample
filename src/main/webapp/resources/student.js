
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
    $('#edit').submit(function () {

        var id=$('#id').val();
        $.ajax({
            type:'UPDATE',
            url:"/test/student/update/" + id+"/" ,
            dataType:'json',
            success:function (result) {



            },
            error:function (jqXHR, textStatus, errorThrown) {
                alert("Student " + textStatus + " " + errorThrown + " !");
            }

        });
    });
});
