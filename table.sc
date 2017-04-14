name::

Table

description:: 

Табличный тест

html::
    <a id=viewSettings>Показать основные настройки</a>
    <ul id="scMenu">
        <li id="scButtonRaw" scMenuActive="true">Исходный код</li>
        <li id="conraw">Преобразовать HTML</li>
        <li id="scButtonView" scMenuActive="false">Просмотр</li>
    </ul>

    <div id="scWindowRaw">
        <textarea id="raw"></textarea>
    </div>

    <div id="scWindowView" hidden='true'>
        <div class="scEditButtonView" id="fixLine">@Фиксировать строку</div>
        <div class="scEditButtonView" id="fixColumn">Фиксировать столбец</div>
        <div class="scEditButtonView" id="addRow">+ Добавить строку</div>
        <div class="scEditButtonView" id="addColumn">+ Добавить столбец</div>
        <div id="view"> </div>
    </div>

cssStudent::

.answerPlaceStudent .cell{
	border: 1px solid #3a3a3a !important;
}

.answerPlaceStudent .first{
    border: 1px solid #3a3a3a !important;
}


#allAnswers{
    margin-top: -21px;
    border: 1px solid #e3e3e3;
    min-height: 30px;
}

.xmodule_display.xmodule_CapaModule div.problem table tr,
.xmodule_display.xmodule_CapaModule div.problem table td, 
.xmodule_display.xmodule_CapaModule div.problem table th {
    vertical-align: sub !important;
}
.xmodule_display.xmodule_CapaModule div.problem div>span {
    display: inline !important;
}
.cell {
    border: 1px solid white;
    min-width: 150px;
    //width: 150px;
    height: 60px;
    cursor: pointer;
    background: #D8E6F3;
}

.cell:before {
    font-size: 10px;
    content: "Разместите ответ здесь";
    display: block;
    margin: 0px -10px 0 6px;
    color: cadetblue;
}

.first{
    background: rgb(170, 222, 226);
    border: 1px solid white;
    background: #AFCDE7;
    min-width: 100px;
}

.dragAnswer{
    background-color: #F2F2F9;
    border: 1px dotted #0D72A2;
    cursor: move;
    margin: 5px;
    padding: 2px 10px;
    min-width: 70px;
    max-width: 300px;
    min-height: 25px;
    display: inline-block;
}

.dragAnswer[intable="false"]{
    display: inline-block;
}

.dragAnswer[intable="true"]{
    display: block;
}

.fixAnswer{
    margin: 5px;
}


css::
/*костыл*/
[class*="view-"] .modal-lg.modal-editor .modal-content {
  height: 609px;}
[class*="view-"] .modal-window .editor-with-buttons.wrapper-comp-settings .list-input.settings-list {
  height: 549px;
}
 /*конец*/ 
 .step-one{display:none}

 .scEditButtonView{
    background: #FFD700 none repeat scroll 0% 0%;
    text-align: center;
    display: inline-block;
    padding: 4px 12px;
    margin: 11px 1px;
    cursor: pointer;
 }
  .scEditButtonView:hover{
 background: #FFB400;
}

.scEditButtonConv{
    background: #FF4800 none repeat scroll 0% 0%;
    text-align: center;
    display: inline-block;
    padding: 4px 12px;
    margin: 11px 1px;
    cursor: pointer;
    color: #FFFFFF;
 }

.scEditButtonConv:hover{
 background: #D53C00;
}

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
    cursor: pointer;
}

#scMenu li:hover {
    border-color:gold;
}

#scMenu li[scMenuActive=true]:hover {
    border-color:#e6e6e6;
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
   // min-width: 150px;
    height: 60px;
    cursor: pointer;
    background: #D8E6F3;
}



.first{
    background: rgb(170, 222, 226);
    border: 1px solid white;
    background: #AFCDE7;
    min-width: 100px;
}

.dragAnswer[contenteditable=true], .fixAnswer[contenteditable=true]{
    background: white;
    border: 1px solid grey;
    padding: 2px 10px;
    display: inline-block;
    cursor: text;
}

.dragAnswer{
    border: 1px dashed rgb(163, 55, 55);
    cursor: move;
    margin: 5px;
    padding: 2px 10px;
    display: inline-block;
    position: relative;
    min-height: 15px;
    min-width: 30px;
}

.fixAnswer{
    border: 1px dashed white;
    margin: 5px;
    position: relative;
    min-height: 15px;
    min-width: 30px;
}

.deleteItemButton {
    background-image: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAACbklEQVR42qWTXUiTURjH/+/XPt5tbII1lokoSSAV7Cqo0UU5RkVpTIOiUqEb+6DvKKEcBhZhHxfSboS0Dy9aiyxK1rSLWNHdbkQQw5KMZUnb2N53be+7d529OpnOLqLn5jz/85zzO895nnMo/KdRxYIHbpmB2giwn8jfy9bqKoAnUWBSBM6VADRAd295+eU16TTaEok3P4FGMp1aCOttwNBjk8k5odXi1Nzc9QzQsQhggEs9Fkv3vtZWKidJ+DgwgOPJ5MgvYG8+vgp40Wc01m9qaQHFcXjW35+7EIt1ZIEbeYDOBcS8zc1azmZTj8vGYgj5/TgpCKP5BV6DYcdmtxuMxaLGpUgE7T5fOgBYClc4dNFsvn/C6WRpnp+HJBL4EAio/haXC4zJpPqKKKI3GJRvxuNtRD4qLqL7NM8Pnnc4NAWIIgjqSBsMi5t7QqHMXVE8SKS/pAvEdrVrtU+v2O36AqRg+c3XwuGUN51uIvL1im0kZrQC714aDPbqurolgS/j49gjCOHvwDYikysBTGsJeZDjHBurqgBS7SVGujM2PY0DkhSaIZmSmUQxwFQDDPtZdus6qxUUw6iTciajjqxGo465bBafZmfhluX3U8DOPEQF6IDbYzR9prKsjFSMVhdnyImH4/Efef+h2bxaU8hIUTATjWKDotwhr+ysCtADnucs2+nUE4+ikJJlNInit2GgXq0sMOLj+Qo9y5I0cgimUmiU5S4C6Cx+yp4HNH11N8NQDZL0+e385qmFcM12AhniuOpX2WzuiKJ0kct5SrpAkj9WCxydABqI/LqsQ5XryX+YBPoU4N7f2vjP9gfr3dEZbh82JAAAAABJRU5ErkJggg==);
    background-size: cover;
    position: absolute;
    width: 12px;
    height: 12px;
    top: -6px;
    right: -6px;
    cursor: pointer;
}

.first:before, 
.cell:before {
  content: "+";
  margin: 0 auto;
  display: block;
  width: 9px;
  color: gray;
}

.first:before {
  cursor: pointer;
}

javascriptStudent::

shuffle(element.getElementsByClassName("dragAnswer"));

try {
studentAnswer = JSON.parse(studentState);
studentAnswer = studentAnswer["state"];
for (key in studentAnswer) {
                for (i=0; i < studentAnswer[key].length;i++){
                    element.querySelector("#" + key).appendChild(element.querySelector("#" + studentAnswer[key][i]));
                    element.querySelector("#" + studentAnswer[key][i]).setAttribute("intable","true");
                }
            }
}
catch(e){
    console.log(e);
}

function drag(){
    $('.drag-table, .answerPlaceStudent .cell, .answerPlaceStudent').sortable({
        items: ".dragAnswer",
        connectWith: '.answerPlaceStudent .cell, .answerPlaceStudent',
        revert: '100',
        tolerance: "pointer",
        start: function() {
            $('.cell').css('box-shadow', 'inset 1px 0px 6px 2px rgb(175, 205, 231)')
        },
        stop:function(event, ui) {
            if(ui.item.context.parentNode.classList.contains("cell")){
                ui.item.context.setAttribute("intable","true");
            }
            else{
                ui.item.context.setAttribute("intable","false");
        }
            $('.cell').css('box-shadow', 'none')
        },
        //stop: generateStudentAnswer
    }).disableSelection();
}
drag();

mengine.genAnswerObj = (function (){
  var studentTable = element.getElementsByTagName('table')[0];

  // console.log(studentTable);
  var studentAnswer = {};

    forEachInCollection(childList(studentTable.getElementsByTagName('tbody')[0]), function(value){
        forEachInCollection(childList(value), function(value){
            if(value.classList.contains('cell')){
                var cellId = value.id;
                var vals = [];
                forEachInCollection(childList(value), function(value){ 
                    vals.push(value.id); 
                 });
                studentAnswer[cellId]=vals;
            }
        });
    });
  mengine.studentStateJSON = studentAnswer;

  return studentAnswer

});

//функция перемешивания DOM-элементов
function shuffle(elems) {
    allElems = (function(){
    var ret = [], l = elems.length;
    while (l--) { ret[ret.length] = elems[l]; }
    return ret;
    })();
 
    var shuffled = (function(){
        var l = allElems.length, ret = [];
        while (l--) {
            var random = Math.floor(Math.random() * allElems.length),
                randEl = allElems[random].cloneNode(true);
            allElems.splice(random, 1);
            ret[ret.length] = randEl;
        }
        return ret; 
    })(), l = elems.length;
 
    while (l--) {
        elems[l].parentNode.insertBefore(shuffled[l], elems[l].nextSibling);
        elems[l].parentNode.removeChild(elems[l]);
    }
 
}

javascriptStudio::
/**
* JavaScript работаюший со сторновы студии
*/
console.log("OLLOLOLOLO");
// Показывает все скрытые поля отноящиеся к XBlock'у в целом.
elementDOM.querySelector('#viewSettings').onclick = function(){

}

function scenarioSave(){
    if( elementDOM.querySelector('#view').innerHTML.length > 1){
        generateCorrectAnswer(documentTable);
        getAllAnswers();
    }
}

//Переменная хранящая таблицу documentTable.innerHTML
var documentTable;

// заблокирована ли первая строка (true/false)
var firstRowIsBlocked = false;

// заблокирован ли первый столбец (true/false)
var firstColumnIsBlocked = false;

// создание таблицы из одной ячейки
function makeStartTable(){
    var table = document.createElement('table');
    var tbody = document.createElement('tbody');
    var body = document.createElement('body');

    table.classList.add("answerPlace");
    table.id = "dragAnswers";

    var tr = document.createElement('tr');
    var td = document.createElement('td');
    td.classList.add('cell');
    td.id = generationID();

    tr.appendChild(td);
    tbody.appendChild(tr);
    table.appendChild(tbody);
    body.appendChild(table);

    return body;
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
            
            if (value.childNodes[0].nodeType == 3 && value.childNodes[0].textContent.trim().length==0){
                value.removeChild(value.childNodes[0]);
            }

            if (value.childNodes[0].nodeType == 3){
                var block = document.createElement('div');
                while (value.childNodes.length > 0 ){
                   if(value.childNodes[0].nodeType == 3){
                        var div = document.createElement('div');
                        div.innerHTML = value.childNodes[0].textContent.trim();
                        div.classList.add("dragAnswer");
                        div.id = generationID();
                        block.appendChild(div);
                    }
                        value.removeChild(value.childNodes[0]);
                }
                block = _.toArray(block.childNodes);
                for(var i = 0; i < block.length; i++){
                    value.appendChild(block[i]);
                }
            }
            else {
                forEachInCollection(childList(value), function(value){
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



/**
* Функция удаляеет все атрибуты элемента переданого в нее, за исключением тех, что перечисленны в массиве исключений
* value = HTMLelement
* undeletableAttributes = [];
*/
function deleteAttributes(value, undeletableAttributes){
    var i = 0;
    while(value.attributes.length-undeletableAttributes.length>0)
    {
        if (value.attributes[i].name in undeletableAttributes){
            i++;
        }
        else{
            value.removeAttribute(value.attributes[i].name);
        }
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
    if(firstRowIsBlocked){
        forEachInCollection(childList(value.getElementsByTagName('tr')[0]), function(value){
            deleteAttributes(value, []);
            value.classList.add("cell");
            value.id = generationID();
            forEachInCollection(childList(value), function(value){
                deleteAttributes(value, []);
                value.id = generationID();
                value.classList.add("dragAnswer");
            });
        });
        firstRowIsBlocked = false;
    }
    else{
        forEachInCollection(childList(value.getElementsByTagName('tr')[0]), function(value){
            deleteAttributes(value, []);
            value.classList.add("first");
            forEachInCollection(childList(value), function(value){
                deleteAttributes(value,[]);
                value.classList.add("fixAnswer");
            });
        });
        firstRowIsBlocked = true;
    }
}

/*удаляет ВСЕ атрибуты первого столбца (включая 1 уровень детей (td))*/
function fixColumn(value){
    if (firstColumnIsBlocked){    
        forEachInCollection(value.getElementsByTagName('tr'), function(value){
            deleteAttributes(childList(value)[0], []);
            childList(value)[0].classList.add("cell");
            childList(value)[0].id = generationID();
            forEachInCollection(childList(childList(value)[0]), function(value){
                deleteAttributes(value, []);
                value.id = generationID();
                value.classList.add("dragAnswer");
            });
        });
        firstColumnIsBlocked = false;
        }

    else{
        forEachInCollection(value.getElementsByTagName('tr'), function(value){
            deleteAttributes(childList(value)[0], []);
            childList(value)[0].classList.add("first");
            forEachInCollection(childList(childList(value)[0]), function(value){
                deleteAttributes(value, []);
                value.classList.add("fixAnswer");
            });
        });
        firstColumnIsBlocked = true;
    }
}


function drag(){
    $('#dragAnswers, .answerPlace .cell, .answerPlace').sortable({
        items: ".dragAnswer",
        connectWith: '.answerPlace .cell, .answerPlace',
        revert: '100',
        tolerance: "pointer",
        stop: updateTable
    }).disableSelection();
    elementDOM.querySelector("#student_view_template").value = documentTable.innerHTML;
}

function updateTable() { 
    //TODO: разобраться как это делать
    documentTable.innerHTML = elementDOM.querySelector("#view").getElementsByTagName("table")[0].outerHTML;
}

/*добавлялка перетаскивающихся штучек*/
elementDOM.querySelector("#view").onclick = function(event){
   var target = event.target; 
        if (target.tagName != 'TD') return; 
        var div = document.createElement('div');
        div.innerHTML = "answer";
        if(target.classList.contains('cell')){
            div.classList.add("dragAnswer");
            div.id = generationID();  
        }
        if(target.classList.contains('first')){
            div.classList.add("fixAnswer");
        }
        var deleteButton = document.createElement('img');
        deleteButton.classList.add("deleteItemButton");
        div.appendChild(deleteButton);
        target.appendChild(div);
    documentTable.innerHTML = elementDOM.querySelector("#view").getElementsByTagName("table")[0].outerHTML;
    editAnswers();
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
    setBlockHtml('view', documentTable.innerHTML);
    drag();
   editAnswers();
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
        fixLine(documentTable);
    }
        setBlockHtml('view', documentTable.innerHTML); 
        drag();
       editAnswers();
};



elementDOM.querySelector('#conraw').onclick = function(){
    if (elementDOM.querySelector('#scButtonView').getAttribute('scmenuactive') == "false") {
        
        if(elementDOM.querySelector('#raw').value == '' && document.getElementsByName("student_view_template")[0].value == ""){
            documentTable = makeStartTable();
            console.log("New table created");
        }
        if(elementDOM.querySelector('#raw').value != ''){
            documentTable =  getValueFild('raw').body;
            SetDragAttr(documentTable);
            var allItems = documentTable.querySelectorAll(".dragAnswer, .fixAnswer");
               for(var i = 0; i < allItems.length; i++ ){
                var deleteButton = document.createElement('img');
                deleteButton.classList.add("deleteItemButton");
                allItems[i].appendChild(deleteButton);
            }
            console.log('Table from "raw" ');
        }

        if(document.getElementsByName("student_view_template")[0].value != "" && elementDOM.querySelector('#raw').value == ''){

            var correctAnswer = elementDOM.querySelector('#correct_answer').value;
            correctAnswer = JSON.parse(correctAnswer);
            correctAnswer = correctAnswer["answer"];
            documentTable =  document.createElement('div');
            documentTable.innerHTML = elementDOM.querySelector("#student_view_template").value;
            documentTable.getElementsByTagName("table")[0].id = "dragAnswers";
            documentTable.querySelector("#dragAnswers").setAttribute("class", "answerPlace");

            for (key in correctAnswer) {
                for (i=0; i < correctAnswer[key].length;i++){
                    documentTable.querySelector("#" + key).appendChild(documentTable.querySelector("#" + correctAnswer[key][i]));
                }
            }
            var allItems = documentTable.querySelectorAll(".dragAnswer, .fixAnswer");
               for(var i = 0; i < allItems.length; i++ ){
                var deleteButton = document.createElement('img');
                deleteButton.classList.add("deleteItemButton");
                allItems[i].appendChild(deleteButton);
            }
            documentTable.querySelector("#allAnswers").remove();
            console.log('Load old table');
        }
    
    setBlockHtml('view', documentTable.innerHTML);
    firstRowIsBlocked = false;
    firstColumnIsBlocked = false;
    drag();
   editAnswers();
    }

    if (elementDOM.querySelector('#scButtonView').getAttribute('scmenuactive') == "true") {
    var tst = getValueFild('view').body;
    elementDOM.querySelector('#raw').value = tst.innerHTML;
    }
};


function editAnswers(){

var editableElements = document.querySelector(".answerPlace").querySelectorAll(".dragAnswer, .fixAnswer, .test");

for(var i =0; i < editableElements.length; i++) { 
    editableElements[i].ondblclick = function(e){
        this.querySelector('.deleteItemButton').style.display = 'none';
        this.setAttribute('contenteditable', 'true'); 
        this.focus();
        }
    editableElements[i].onblur = function(e){
        this.removeAttribute('contenteditable');
        this.querySelector('.deleteItemButton').style.display = 'block';
    }
}

var allItems = document.querySelector("#view").querySelectorAll(".deleteItemButton");
for(var i =0; i < allItems.length; i++) { 
    document.querySelectorAll(".deleteItemButton")[i].onclick = function(){ 
        var item = this.parentNode;
        item.remove();
    }
}
}

//фиксация строки
elementDOM.querySelector('#fixLine').onclick = function(){
    fixLine(documentTable);
    setBlockHtml('view', documentTable.innerHTML);
    elementDOM.querySelector("#student_view_template").value = documentTable.innerHTML;
    drag();
    editAnswers();
};

//фиксация столбца 
elementDOM.querySelector('#fixColumn').onclick = function(){
    fixColumn(documentTable);
    setBlockHtml('view', documentTable.innerHTML);
    elementDOM.querySelector("#student_view_template").value = documentTable.innerHTML;
    drag();
    editAnswers();
};

//генерация json правильного ответа
function generateCorrectAnswer(value){
  var correctAnswer = {};
  forEachInCollection(childList(value.getElementsByTagName('tbody')[0]), function(value){
        forEachInCollection(childList(value), function(value){
            if(value.classList.contains('cell')){
                var cellId = value.id;
                var vals = [];
                forEachInCollection(childList(value), function(value){ 
                    vals.push(value.id); 
                 });
                correctAnswer[cellId]=vals;
            }
        });
    });
  correctAnswer = generationAnswerJSON(correctAnswer);
  elementDOM.querySelector('#correct_answer').setAttribute('value', correctAnswer);
  var studentView = elementDOM.querySelector("#view");
  console.log("studentView.innerHTML:         ", studentView.innerHTML);
  if(typeof(editor) != "undefined"){
        editor.setValue(studentView.innerHTML);
    }
  else{
        elementDOM.querySelector("#student_view_template").value = studentView.innerHTML;
    }
}


/*перенос всех ответов в отдельное поле*/
function getAllAnswers(){
    var allAnswersList = elementDOM.querySelector('#view').querySelectorAll('.dragAnswer');
    var allAnswersDiv = document.createElement('div');
    allAnswersDiv.id = "allAnswers";
    allAnswersDiv.classList.add("answerPlaceStudent");
    forEachInCollection(allAnswersList, function(value){ 
        allAnswersDiv.appendChild(value);
    });
    elementDOM.querySelector('#view').appendChild(allAnswersDiv);
    
    //перемешивание
    for (var i = allAnswersDiv.children.length; i >= 0; i--) {
        allAnswersDiv.appendChild(allAnswersDiv.children[Math.random() * i | 0]);
    }

    elementDOM.querySelector("#view").getElementsByTagName("table")[0].removeAttribute("id");
    elementDOM.querySelector("#view").getElementsByTagName("table")[0].setAttribute('class', 'answerPlaceStudent drag-table');
    documentTable.innerHTML = elementDOM.querySelector("#view").getElementsByTagName("table")[0].outerHTML;
    var allDeleteButtons = document.querySelector("#view").querySelectorAll(".deleteItemButton");
    for(var i =0; i < allDeleteButtons.length; i++) { 
        allDeleteButtons[i].remove();
    }
    var studentView = elementDOM.querySelector("#view");
    elementDOM.querySelector("#student_view_template").value = studentView.innerHTML;
}

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