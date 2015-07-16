name::

Table

description:: 

Табличный тест

html::
    <script type="text/javascript" src="http://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>

    <ul id="scMenu">
        <li id="scButtonRaw" scMenuActive="true">Исходный код</li>
        <li id="conraw">Преобразовать HTML</li>
        <li id="scButtonView" scMenuActive="false">Просмотр</li>
    </ul>
    <div id="scWindowRaw">
        <textarea id="raw"></textarea>
    </div>
        <button id="fixLine">Зафиксировать строку</button>
    <button id="fixColumn">Зафиксировать столбец</button>
    <div id="scWindowView" hidden='true'><div id="view">

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
    width: 620px;
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

.first{
	background: rgb(170, 222, 226);
}

.answer{
	border: 1px dashed rgb(163, 55, 55);
}

javascriptStudent::

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

drag();

javascriptStudio::

//var table;

function SetDragAttr(){

//table+='<table class="answerPlace" id="dragAnswers"> <tbody>';
    var documentTable =  getValueFild('raw').body;

    documentTable.getElementsByTagName('table')[0].id = "dragAnswers"
    documentTable.getElementsByTagName('table')[0].classList.add("answerPlace");

    forEachInCollection(childList(documentTable.getElementsByTagName('tbody')[0]), function(value){
        deleteAllAttributes(value);
        forEachInCollection(childList(value), function(value){
            deleteAllAttributes(value);
            value.classList.add("cell");
            value.id = generationID();
            forEachInCollection(childList(value), function(value){
                var div = document.createElement('div');
                div.innerHTML = value.innerHTML;
                div.classList.add("answer");
                div.id = generationID();
                value.parentNode.replaceChild(div, value);
            });
        });
    });





//editor.setValue(documentTable.innerHTML);

return documentTable;
//setBlockHtml('view', table);
};

// !!! ИМЕНИТЬ ФУНКЦИИ !!! ОНИ НЕ РАБОТАЮТ !!!
function fixLine(){

    alert("fix2");

    var documentTableView =  elementDOM.querySelector('#view').querySelector('#dragAnswers');
/*удаляет ВСЕ атрибуты первой строки (включая 1 уровень детей (td))*/
	forEachInCollection(childList(documentTableView.getElementsByTagName('tr')[0]), function(value){
    	deleteAllAttributes(value);
    	value.classList.add("first");
    	forEachInCollection(childList(value), function(value){
        	deleteAllAttributes(value);
    	});
	});

	setBlockHtml('view',  elementDOM.querySelector('#view').innerHTML);
	editor.setValue(elementDOM.querySelector('#view').innerHTML);
    drag();
}

function fixColumn(){

    alert("fix1");

    var documentTableView =  elementDOM.querySelector('#view').querySelector('#dragAnswers')
	/*удаляет ВСЕ атрибуты первого столбца (включая 1 уровень детей (td))*/
	forEachInCollection(documentTableView.getElementsByTagName('tr'), function(value){
    	deleteAllAttributes(childList(value)[0]);
    	childList(value)[0].classList.add("first");
    	forEachInCollection(childList(childList(value)[0]), function(value){
    		deleteAllAttributes(value);
    	});
    });

	setBlockHtml('view',  elementDOM.querySelector('#view').innerHTML);
	 editor.setValue(elementDOM.querySelector('#view').innerHTML);
    drag();
}


function deleteAllAttributes(value)
{
    while(value.attributes.length>0) {
        value.removeAttribute(value.attributes[0].name)
    };
}

function drag(){

    $('#view #dragAnswers').sortable({
        items: ".answer",
        connectWith: '.answerPlace .cell, .answerPlace',
        revert: '100',
        tolerance: "pointer"
    }).disableSelection();

    $('#view .answerPlace .cell').sortable({
        items: ".answer",
        connectWith: '.answerPlace .cell, .answerPlace',
        revert: '100',
        tolerance: "pointer"
    }).disableSelection();

}

function Convertation(){
    //console.log(table);
   // editor.setValue(SetDragAttr().innerHTML);
    setBlockHtml('view', SetDragAttr().innerHTML);
   // SetDragAttr();
    drag();
}

elementDOM.querySelector('#conraw').onclick = Convertation;
elementDOM.querySelector('#fixLine').onclick = fixLine;
elementDOM.querySelector('#fixColumn').onclick = fixColumn;


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

