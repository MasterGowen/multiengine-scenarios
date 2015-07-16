name::

Table

description:: 

Табличный тест

html::
    <script type="text/javascript" src="http://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>

    <ul id="scMenu">
        <li id="scButtonRaw" scMenuActive="true">Исходный код</li>
        <li id="conraw">Преобразовать SVG</li>
        <li id="scButtonView" scMenuActive="false">Просмотр</li>
    </ul>
    <div id="scWindowRaw">
        <textarea id="raw"></textarea>
    </div>
    <div id="scWindowView" hidden='true'><div id="view"></div></div>



css::
/*костыл*/
[class*="view-"] .modal-lg.modal-editor .modal-content {
  height: 609px;}
[class*="view-"] .modal-window .editor-with-buttons.wrapper-comp-settings .list-input.settings-list {
  height: 549px;
}
 /*конец*/ 

#scMenu{
    margin: 10px auto;
    display: block;
    width: 570px;
}

#scMenu li {
    border: 1px solid #e6e6e6;
    padding: 10px;
    display: inline-block;
    width: 28%;
    text-align: center;
    margin: 0px;
}
#scMenu li[scMenuActive=true]{
    background:#e6e6e6;
}

#raw, #view{
    border: 1px solid #e6e6e6;
    width: 100%;
    min-height: 300px;
}
.cell {
    border: 1px solid black;
}




javascriptStudent::
console.log("student");

javascriptStudio::



function SetDragAttr(){

//var table = ''
var items= ''
//table+='<table class="answerPlace" id="dragAnswers"> <tbody>';
    var documentTable =  getValueFild('raw').body;
    forEachInCollection(childList(documentTable.getElementsByTagName('tbody')[0]), function(value){
      //  table+= '<tr>'
        forEachInCollection(childList(value), function(value){
          //  table += '<td class="cell">'

            for (value.attributes.length>0) {
                value.removeAttribute(value.attributes[i].name)
            };
          value.classList.add("cell");
            forEachInCollection(childList(value), function(value){
                var div = document.createElement('div');
                div.innerHTML = value.innerHTML;
                div.classList.add("answer");
                value.parentNode.replaceChild(div ,value);
               //console.log(value);
                //table+='<div class="answer">'+ value.innerHTML +'</div>';
            });
          //  table += '</td>'
        });
       // table+= '</tr>'
    });

//table+='</tbody></table>';

console.log(documentTable);
//setBlockHtml('view', table);
};


function drag(){

        $('#dragAnswers').sortable({
        items: ".answer",
        connectWith: '.answerPlace .cell, .answerPlace',
        revert: '100',
        tolerance: "pointer"
    }).disableSelection();

    $('.answerPlace .cell').sortable({
        items: ".answer",
        connectWith: '.answerPlace .cell, .answerPlace',
        revert: '100',
        tolerance: "pointer"
    }).disableSelection();

}

function Convertation(){
    SetDragAttr();
    drag();
}

elementDOM.querySelector('#conraw').onclick = Convertation;
elementDOM.querySelector('#scButtonView').onclick = function(){
    elementDOM.querySelector('#scButtonRaw').setAttribute('scMenuActive', 'false');
    elementDOM.querySelector('#scButtonView').setAttribute('scMenuActive', 'true');
    elementDOM.querySelector('#scWindowRaw').setAttribute('hidden', 'true'); 
    elementDOM.querySelector('#scWindowView').removeAttribute('hidden');
};
elementDOM.querySelector('#scButtonRaw').onclick = function(){
    elementDOM.querySelector('#scButtonRaw').setAttribute('scMenuActive', 'true');
    elementDOM.querySelector('#scButtonView').setAttribute('scMenuActive', 'false');
    elementDOM.querySelector('#scWindowRaw').removeAttribute('hidden');
    elementDOM.querySelector('#scWindowView').setAttribute('hidden', 'true');
};

