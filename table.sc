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
    <div id="scWindowView" hidden='true'><div id="view">

<!--
    <div class="answerPlace" id="dragAnswers">
            <div class="answer" id="v1">Вариант 1 </div>
            <div class="answer" id="v2">Вариант 2</div>
            <div class="answer" id="v3">Вариант 3</div>
            <div class="answer" id="v4">Вариант 4</div>
            <div class="answer" id="v5">Вариант 5</div>
            <div class="answer" id="v6">Вариант 6</div>
            <div class="answer" id="v7">Вариант 87</div>
    </div>
-->
    </div></div>



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




javascriptStudent::
console.log("student");

javascriptStudio::



function SetDragAttr(){

var table = ''
var items= ''
table+='<table class="dragAnswer" id="dragTable"> <tbody>';
    var documentTable =  getValueFild('raw').body;
    forEachInCollection(childList(documentTable.getElementsByTagName('tbody')[0]), function(value){
        table+= '<tr>'
        forEachInCollection(childList(value), function(value){
            table += '<td>'
            forEachInCollection(childList(value), function(value){
                table+='<div>'+ value.innerHTML +'</div>';
            });
            table += '</td>'
        });
        table+= '</tr>'
    });

table+='</tbody></table>';

console.log(table);
setBlockHtml('view', table);
};

$('#dragAnswers').sortable({ placeholder:".block", items:".answer", connectWith:'.answerPlace .cell, .answerPlace', revert: '100', tolerance:"pointer"}).disableSelection();


elementDOM.querySelector('#conraw').onclick = SetDragAttr;
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