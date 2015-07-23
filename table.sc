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
        <button id="addRow">Добавить строку</button>
        <button id="addColumn">Добавить столбец</button>
        <button id="getAllAnswers">Вынести ответы</button>
        
        <div id="allAnswers" class="answerPlace">
            </div> 
        <div id="view">
            
    </div>



css::
/*костыл*/
[class*="view-"] .modal-lg.modal-editor .modal-content {
  height: 609px;}
[class*="view-"] .modal-window .editor-with-buttons.wrapper-comp-settings .list-input.settings-list {
  height: 549px;
}
 /*конец*/ 
 .step-one{display:none}

#allAnswers{
    display: -webkit-box;
}

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
    border: 1px solid white;
    min-width: 100px;
    cursor: pointer;
    background: #D8E6F3;
}

.first{
	background: rgb(170, 222, 226);
	border: 1px solid white;
    background: #AFCDE7;
    min-width: 100px;
}

.dragAnswer{
	border: 1px dashed rgb(163, 55, 55);
    cursor: move;
    margin: 5px;
}

.first:before {
  content: "+";
  margin: 0 auto;
  display: block;
  width: 9px;
  color: gray;
  cursor: pointer;
}

.cell:before {
  content: "+";
  margin: 0 auto;
  display: block;
  width: 9px;
  color: gray;
}


javascriptStudent::

function drag(){
        $('#dragAnswers').sortable({
        items: ".dragAnswer",
        connectWith: '.answerPlace .cell, .answerPlace',
        revert: '100',
        tolerance: "pointer"
    }).disableSelection();

    $('.answerPlace .cell').sortable({
        items: ".dragAnswer",
        connectWith: '.answerPlace .cell, .answerPlace',
        revert: '100',
        tolerance: "pointer"
    }).disableSelection();

}
drag();

javascriptStudio::

//Переменная хранящая таблицу documentTable.innerHTML
var documentTable;

// заблокирована ли первая строка (true/false)
var firstRowIsBlocked = false;

// заблокирован ли первый столбец (true/false)
var firstColumnIsBlocked = false;


function makeStartTable(){
    var table = document.createElement('table');
    var tbody = document.createElement('tbody');

    table.classList.add("answerPlace");
    table.id = "dragAnswers";

    var tr = document.createElement('tr');

    var td = document.createElement('td');
    td.classList.add('cell');
    td.id = generationID();

    var div = document.createElement('div');
    div.classList.add("answer");
    div.id = generationID();

    td.appendChild(div);
    tr.appendChild(td);
    tbody.appendChild(tr);
    table.appendChild(tbody);

    return table;
}

//Установка всех всех атрибутов необходимых для работы перетаскивания
function SetDragAttr(value){
    deleteAttributes(value.getElementsByTagName('table')[0], []);
    value.getElementsByTagName('table')[0].id = "dragAnswers"
    value.getElementsByTagName('table')[0].classList.add("answerPlace");

    forEachInCollection(childList(value.getElementsByTagName('tbody')[0]), function(value){
        deleteAttributes(value, []);
        forEachInCollection(childList(value), function(value){
            deleteAttributes(value, []);
            value.classList.add("cell");
            value.id = generationID();

            if (value.childNodes[0].nodeType = 3){
                var div = document.createElement('div');
                div.innerHTML = value.innerHTML;
//TODO: Костыль
                value.innerHTML="";
                div.classList.add("dragAnswer");
                div.id = generationID();
                value.appendChild(div);
            }
            else {
                forEachInCollection(childList(value), function(value){
                    console.log(value);
                    var div = document.createElement('div');
                    div.innerHTML = value.innerHTML;
                    div.classList.add("dragAnswer");
                    div.id = generationID();
                    value.parentNode.replaceChild(div, value);
                });
            }
        });
    });
};


/***
Удаление атрибутов элемента

value - элемент, у которого нужно удалить атрибуты
undeletableAttributes - массив [] тех атрибутов, которые удалять не нужно
 
***/
function deleteAttributes(value,undeletableAttributes){
    for (var i=0; i< value.attributes.length; i++){
        if(value.attributes[i].name in undeletableAttributes) continue;
        value.removeAttribute(value.attributes[i].name)
    }
}

function Convertation(){
    documentTable =  getValueFild('raw').body;
    SetDragAttr(documentTable);
    setBlockHtml('view', documentTable.innerHTML);
    drag();
}


/*удаляет ВСЕ атрибуты первой строки (включая 1 уровень детей (td))*/
function fixLine(value){
    //console.log('start_event: Фиксация первой строки');
    if(firstRowIsBlocked == false){
    	forEachInCollection(childList(value.getElementsByTagName('tr')[0]), function(value){
        	deleteAttributes(value,[]);
        	value.classList.add("first");
        	forEachInCollection(childList(value), function(value){
            	value.id = generationID();
        	});
    	});
        firstRowIsBlocked = true;
    }
    else{
        forEachInCollection(childList(value.getElementsByTagName('tr')[0]), function(value){
            deleteAttributes(value,[]);
            value.classList.add("cell");
            forEachInCollection(childList(value), function(value){
                deleteAttributes(value,['id']);
            });
        });
        firstRowIsBlocked = false;
    }
    //console.log('end_event: Фиксация первой строки');
}



/*удаляет ВСЕ атрибуты первого столбца (включая 1 уровень детей (td))*/
function fixColumn(value){
    console.log('start_event: Фиксация первой столбца');
    forEachInCollection(value.getElementsByTagName('tr'), function(value){
    	deleteAttributes(childList(value)[0], []);
    	childList(value)[0].classList.add("first");
    	forEachInCollection(childList(childList(value)[0]), function(value){
    		deleteAttributes(value, ['id']);
    	});
    });
    firstColumnIsBlocked = true;
    console.log('end_event: Фиксация первой столбца');
}




function drag(){
    $('#dragAnswers, .answerPlace .cell, .answerPlace').sortable({
        items: ".dragAnswer",
        connectWith: '.answerPlace .cell, .answerPlace',
        revert: '100',
        tolerance: "pointer",
        stop: updateTable
    }).disableSelection();
    editor.setValue(documentTable.innerHTML);
}



function updateTable() { 
    //TODO: разобраться как это делать
    documentTable.innerHTML = elementDOM.querySelector("#view").getElementsByTagName("table")[0].outerHTML;
}


/*вынести сюда добавление строки*/
function addRow(){

}


/*добавлялка перетаскивающихся штучек*/
elementDOM.querySelector("#view").onclick = function(event){
   var target = event.target; 
        if (target.tagName != 'TD') return; 
        var div = document.createElement('div');
        div.innerHTML = "answer";
        if(target.classList.contains('cell')){
            div.classList.add("dragAnswer");  
        }
        div.id = generationID();
        target.appendChild(div);
    documentTable.innerHTML = elementDOM.querySelector("#view").getElementsByTagName("table")[0].outerHTML;
};


/* добавление строки к таблице*/
elementDOM.querySelector("#addRow").onclick = function(){
    documentTable.innerHTML = elementDOM.querySelector("#view").getElementsByTagName("table")[0].outerHTML;
    var newRow = document.createElement('tr');
    forEachInCollection(childList(documentTable.getElementsByTagName('tr')[0]), function(value){
            var newCell = document.createElement('td');
            newCell.classList.add("cell");
            newCell.id = generationID();
            newRow.appendChild(newCell);
    });
    if(firstColumnIsBlocked){
        deleteAttributes(newRow.firstChild, []);
        newRow.firstChild.classList.add("first");
    }
    documentTable.getElementsByTagName('tbody')[0].appendChild(newRow);
    setBlockHtml('view', documentTable.innerHTML); // надо ли?! наверно надо
    drag();
};


/*добавление столбца к таблице*/
elementDOM.querySelector("#addColumn").onclick = function(){
    documentTable.innerHTML = elementDOM.querySelector("#view").getElementsByTagName("table")[0].outerHTML;
    forEachInCollection(documentTable.getElementsByTagName('tr'), function(value){
        var newCell = document.createElement('td');
        newCell.classList.add("cell");
        newCell.id = generationID();
        value.appendChild(newCell);
    });
    if(firstRowIsBlocked){
        fixLine(documentTable);
    }
        setBlockHtml('view', documentTable.innerHTML); 
        drag();
};


elementDOM.querySelector('#conraw').onclick = function(){

    if(elementDOM.querySelector('#raw').value == '')
    {
        console.log("new table");
        documentTable = makeStartTable();
        console.log(documentTable.outerHTML);
        setBlockHtml('view', documentTable.outerHTML);
   }
    else
        {   
            console.log("load table");
            documentTable =  getValueFild('raw').body;
            SetDragAttr(documentTable);
            console.log(documentTable.innerHTML);
            setBlockHtml('view', documentTable.innerHTML);
    // TODO: elementDOM.querySelector("#view").appendChild(documentTable);
        }

      
    //костыль
    elementDOM.querySelector('#scWindowView').querySelector('#allAnswers').innerHTML="";
        
    firstRowIsBlocked = false;
    firstColumnIsBlocked = false;

    drag();
};

//редактирование по двойному клику 
// TODO: НЕ РАБОТАЕТ С <P></P>

elementDOM.querySelector("#view").ondblclick = function(event){
   var target = event.target; 
        if (target.classList.contains('dragAnswer')){
            console.log(target.id + " is contenteditable?");
            elementDOM.querySelector('#' + target.id ).setAttribute('contenteditable', 'true');
        } 
        else return; 
};



//фиксация строки
elementDOM.querySelector('#fixLine').onclick = function(){
    fixLine(documentTable);
    setBlockHtml('view', documentTable.innerHTML);
    editor.setValue(documentTable.innerHTML);
    drag();
   // console.log('end_event: нажатие кнопки "Зафиксировать строку"');
};

//фиксация столбца 
elementDOM.querySelector('#fixColumn').onclick = function(){
    //console.log('start_event: нажатие кнопки "Зафиксировать столбец"');
    fixColumn(documentTable);
    //TODO: вынести в отдельную функцию
    setBlockHtml('view', documentTable.innerHTML);
    editor.setValue(documentTable.innerHTML);
    drag();
    //console.log('end_event: нажатие кнопки "Зафиксировать столбец"');
};

/*перенос всех ответов в отдельное поле*/
elementDOM.querySelector("#getAllAnswers").onclick = function(){

    var allAnswersList = elementDOM.querySelector('#view').querySelector('#dragAnswers').querySelectorAll('.dragAnswer');
    
    var allAnswersDiv = elementDOM.querySelector('#allAnswers');
    //var ul = document.querySelector('ul'); 

    //перемешивание

    forEachInCollection(allAnswersList, function(value){ 
        allAnswersDiv.appendChild(value);
    });

    for (var i = allAnswersDiv.children.length; i >= 0; i--) {
        allAnswersDiv.appendChild(allAnswersDiv.children[Math.random() * i | 0]);
    }
    
    //setBlockHtml('AllAnswers', AllAnswers.outerHTML);
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



