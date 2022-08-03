$(function () {

    // Start counting from the third row
    var counter = 3;

    $("#insertRow").on("click", function (event) {
        event.preventDefault();

        var newRow = $("<tr>");
        var cols = '';

        // Table columns
        cols += '<th scrope="row">' + counter + '</th>';
        cols += '<td><input class="form-control rounded-0" type="text" name="level" placeholder="Level"></td>';
        cols += '<td><input class="form-control rounded-0" type="text" name="subject" placeholder="Subject"></td>';
        cols += '<td><input class="form-control rounded-0" type="text" name="staff" placeholder="Staff in Charge"></td>';
        cols += '<td><input class="form-control rounded-0" type="text" name="seats" placeholder="Availability"></td>';
        cols += '<td><input class="form-control rounded-0" type="text" name="fee" placeholder="Fee Monthly"></td>';
        cols += '<td><button class="btn btn-danger rounded-0" id ="deleteRow"><i class="fa fa-trash"></i></button</td>';

        // Insert the columns inside a row
        newRow.append(cols);

        // Insert the row inside a table
        $("table").append(newRow);

        // Increase counter after each row insertion
        counter++;
    });

    // Remove row when delete btn is clicked
    $("table").on("click", "#deleteRow", function (event) {
        $(this).closest("tr").remove();
        counter -= 1
    });
});
