var variable = 10;
variable = {};
document.write('Hello DOM');
console.log('log');

var f = function(vari) {
    console.log(r);
    document.write('Hello' + vari);
    var r === 9;
};

f = function f (f){
    function b() {

    }
}();
f();


for (var i=0; i<10; i++) {

}


{
  var variable = 11;
  console.log(variable);
}


$(document).ready(init);

function init() {
    show();
    $('#add_contact').bind('click', addContact);
}

function addContact() {
    var tr = $('<tr></tr>');
    tr.append($('<td></td>').append('<input type="checkbox" name="toDelete[]" value="0" id="checkbox_0"/>'));
    tr.append($('<td></td>').text('name'));
    tr.append($('<td></td>').text('surname'));
    tr.append($('<td></td>').text(''));
    tr.append($('<td></td>').text(''));
    tr.append($('<td></td>').text(''));

    $('#table').append(tr);
}

function show() {
    $.ajax({
        //dataType: 'json',
        //type: 'GET',
        url: '/contacts',
        success: function (jsondata) {
            //alert(jsondata);
            for (var i = 0; i < jsondata.length; i++) {
                var contact = jsondata[i];
                var tr = $('<tr></tr>');
                tr.append($('<td></td>').append('<input type="checkbox" name="toDelete[]" value="' + contact.id + '" id="checkbox_' + contact.id +'"/>'));
                tr.append($('<td></td>').text(contact.name));
                tr.append($('<td></td>').text(contact.surname));
                tr.append($('<td></td>').text(contact.email));
                tr.append($('<td></td>').text(contact.groupName));
                tr.append($('<td></td>').text(contact.phone));

                $('#table').append(tr);
            }
        },
        error: function (a, b, c) {
            alert(a + b + c);
        }
    });
    //alert($('#login').val());
    var login = $('#login').val();
    var pass = $('#pass').val();
    var tr = $('<tr></tr>');
    tr.append($('<td></td>').text(login));
    tr.append($('<td></td>').text(pass));

    /*    $('#table').append(tr);
        $('#one').css({background:"red", color:"white"});
        $('#two').css("border", "red");
        $('#two, #three').css("fontWeight", "bold");*/
}
