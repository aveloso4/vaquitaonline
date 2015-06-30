function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#imgPrev').attr('src', e.target.result);
        }

        reader.readAsDataURL(input.files[0]);
    }
}



function changeInput(elemId1, elemId2, elFrom) {
    var elfr = elFrom;
    if (elfr.checked) {
        // do something when checked
        var el = document.getElementById(elemId1);
        var el2 = document.getElementById(elemId2);

        el.disabled = false;
        el.value = "";
        el.required = true;

        el2.disabled = true;
        el2.value = "";
        el2.required = false;
    }

}

function disableInput(elemId, elemId2, elFrom) {
    var elfr = elFrom;
    if (elfr.checked) {
        var el = document.getElementById(elemId);
        var el2 = document.getElementById(elemId2);

        el.disabled = true;
        el.value = "";
        el.required = false;

        el2.disabled = true;
        el2.value = "";
        el2.required = false;
    }
}

function requiredChanger(elemId, elFrom) {
    var elfr = elFrom;
    var el = document.getElementById(elemId);
    if (elfr.checked) {
        el.required = true;
        el.disabled = false;
    } else {
        el.required = false;
        el.disabled = true;
        el.value = "";
        el.checked = false;
    }
}

$(document).ready(function(){
    $('ul.tabs').tabs();
     $('.modal-trigger').leanModal();
  });