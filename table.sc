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

    <div id="scWindowView" hidden='true'>
    <button id="fixLine">Зафиксировать строку</button>
    <button id="fixColumn">Зафиксировать столбец</button>

    <div id="view">
    </div></div>



css::
/*костыл*/
[class*="view-"] .modal-lg.modal-editor .modal-content {
  height: 609px;}
[class*="view-"] .modal-window .editor-with-buttons.wrapper-comp-settings .list-input.settings-list {
  height: 549px;
}
 /*конец*/ 
 .step-one{display:none}

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
	border: 1px solid black;
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

//Переменая хранящая таблицу documentTable.innerHTML
var documentTable;
//Установка всех всех атрибутов необхадимых для работы перетаскивания
function SetDragAttr(value){
    deleteAllAttributes(value.getElementsByTagName('table')[0]);
    value.getElementsByTagName('table')[0].id = "dragAnswers"
    value.getElementsByTagName('table')[0].classList.add("answerPlace");

    forEachInCollection(childList(value.getElementsByTagName('tbody')[0]), function(value){
        deleteAllAttributes(value);
        forEachInCollection(childList(value), function(value){
            console.log(value);
            deleteAllAttributes(value);
            value.classList.add("cell");
            value.id = generationID();
            forEachInCollection(childList(value), function(value){
                console.log(value);
                var div = document.createElement('div');
                div.innerHTML = value.innerHTML;
                div.classList.add("answer");
                div.id = generationID();
                value.parentNode.replaceChild(div, value);
            });
        });
    });
};

//Удаление всех имеющихся атрибутов
//TODO: Сделать дополнительную переменную которая будет хранить те атрибуты которые не нужно удалять
function deleteAllAttributes(value){
    while(value.attributes.length>0) {
        value.removeAttribute(value.attributes[0].name)
    };
}

function Convertation(){
    documentTable =  getValueFild('raw').body;
    SetDragAttr(documentTable);
    setBlockHtml('view', documentTable.innerHTML);
    drag();
}

function fixLine(value){
    console.log('start_event: Фиксация первой строки');
    /*удаляет ВСЕ атрибуты первой строки (включая 1 уровень детей (td))*/
	forEachInCollection(childList(value.getElementsByTagName('tr')[0]), function(value){
    	deleteAllAttributes(value);
    	value.classList.add("first");
    	forEachInCollection(childList(value), function(value){
        	deleteAllAttributes(value);
    	});
	});
    console.log('end_event: Фиксация первой строки');
}

function fixColumn(value){

    console.log('start_event: Фиксация первой столбца');

    
	/*удаляет ВСЕ атрибуты первого столбца (включая 1 уровень детей (td))*/
	forEachInCollection(value.getElementsByTagName('tr'), function(value){
    	deleteAllAttributes(childList(value)[0]);
    	childList(value)[0].classList.add("first");
    	forEachInCollection(childList(childList(value)[0]), function(value){
    		deleteAllAttributes(value);
    	});
    });
    console.log('ebd_event: Фиксация первой столбца');
}




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





elementDOM.querySelector('#conraw').onclick = function(){
    documentTable =  getValueFild('raw').body;
    SetDragAttr(documentTable);
    setBlockHtml('view', documentTable.innerHTML);
    drag();
};

elementDOM.querySelector('#fixLine').onclick = function(){
    console.log('start_event: нажатие кнопки "Зафиксировать строку"');
    fixLine(documentTable);
    //TODO: вынести в отдельную функцию
    setBlockHtml('view', documentTable.innerHTML);
    editor.setValue(documentTable.innerHTML);
    drag();
    console.log('end_event: нажатие кнопки "Зафиксировать строку"');
};
elementDOM.querySelector('#fixColumn').onclick = function(){
    console.log('start_event: нажатие кнопки "Зафиксировать столбец"');
    fixColumn(documentTable);
    //TODO: вынести в отдельную функцию
    setBlockHtml('view', documentTable.innerHTML);
    editor.setValue(documentTable.innerHTML);
    drag();
    console.log('end_event: нажатие кнопки "Зафиксировать столбец"');
};


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

/*
// функция генерирует JSON-объект из клеток у которых есть атрибут "id"
  forEachInCollection(childList(document.getElementsByTagName('tbody')[0]), function(value){
        forEachInCollection(childList(value), function(value){
        	if(value.id!=""){
            	var cellId = value.id;
        		var vals = [];
          		forEachInCollection(childList(value), function(value){ 
          			vals.push(value.id); 
         		 });
				j[cellId]=vals;
            }
        });
    });
*/



