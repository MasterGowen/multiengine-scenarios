name::

arduino

description:: 

Ардуино

html::
    <ul id="scMenu">
        <li id="scButtonRaw" scMenuActive="true">Исходный код</li>
        <li id="conraw">Преобразовать SVG</li>
        <li id="scButtonView" scMenuActive="false">Просмотр</li>
    </ul>

    <div id="scWindowRaw">
        <textarea id="raw"></textarea>
    </div>

    <div id="scWindowView" hidden='true'>
        <div class="scEditButtonView" id="fixLine">Фиксировать строку</div>
        <div class="scEditButtonView" id="fixColumn">Фиксировать столбец</div>
        <div class="scEditButtonView" id="addRow">+ Добавить строку</div>
        <div class="scEditButtonView" id="addColumn">+ Добавить столбец</div>
        <div id="view"></div>
        <!--<div class="scEditButtonConv" id="getAllAnswers">Вынести ответы</div>
        <div class="scEditButtonConv" id="generateCorrectAnswer">Собрать JSON</div>-->
    </div>



cssStudent::
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
    padding: 2px 10px;
    display: inline-block;
}


.fixAnswer{
    border: 1px dashed white;
    margin: 5px;
}

css::
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


.dragAnswer[contenteditable=true], .fixAnswer[contenteditable=true]{
    background: white;
    border: 1px solid grey;
    padding: 2px 10px;
    display: inline-block;
}

.dragAnswer{
	border: 1px dashed rgb(163, 55, 55);
    cursor: move;
    margin: 5px;
    padding: 2px 10px;
    display: inline-block;
}


.fixAnswer{
    border: 1px dashed white;
    margin: 5px;
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

function drag(){
    $('#dragAnswers, .answerPlace .cell, .answerPlace').sortable({
        items: ".dragAnswer",
        connectWith: '.answerPlace .cell, .answerPlace',
        revert: '100',
        tolerance: "pointer",
        stop: generateStudentAnswer
    }).disableSelection();
}
//TODO: Зачем здесь вызов функции
drag();

//вызывается для того, чтобы полю 'answer' присвоился json (backend требует ключи для поверки)
//если жмем "Сохранить" впервые (без перетаскиваний), то json будет присвоен (только ключи)
generateStudentAnswer();

function generateStudentAnswer(){
  var studentTable = document.querySelector('#dragAnswers');
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
  studentAnswer = generationAnswerJSON(studentAnswer);
  console.log(studentAnswer);

  document.getElementsByName("answer")[0].value = studentAnswer;
  document.getElementsByName("answer")[0].val = studentAnswer;

}




javascriptStudio::
/**
* JavaScript работаюший со сторновы студии
*/

// Показывает все скрытые поля отноящиеся к XBlock'у в целом.
elementDOM.querySelector('#viewSettings').onclick = function(){elementDOM.getElementsByClassName('step-one')[0].style.display = 'block';}


function scenarioSave(){

    generateCorrectAnswer(documentTable);
    getAllAnswers();
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
            forEachInCollection(childList(value), function(value){
                value.id = generationID();
                deleteAttributes(value, []);
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
                value.id = generationID();
                deleteAttributes(value, []);
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
    editor.setValue(documentTable.innerHTML);
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
    setBlockHtml('view', documentTable.innerHTML); // надо ли?! наверно надо
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
        
        if(elementDOM.querySelector('#raw').value == ''){
            documentTable = makeStartTable();
        }
        else{  
            documentTable =  getValueFild('raw').body;
            SetDragAttr(documentTable);
        }
    
    setBlockHtml('view', documentTable.innerHTML);
    firstRowIsBlocked = false;
    firstColumnIsBlocked = false;
    drag();
    editAnswers();

    }

    if (elementDOM.querySelector('#scButtonView').getAttribute('scmenuactive') == "true") {
    
    var tst = getValueFild('view').body;
    console.log(tst.innerHTML);
    elementDOM.querySelector('#raw').value = tst.innerHTML;
    
    }


    
};


// TODO: редактирование по двойному клику 
/*elementDOM.querySelector("#view").ondblclick = function(event){
   var target = event.target; 
        if (target.classList.contains('dragAnswer') || target.classList.contains('fixAnswer')){
            //console.log(target.id + " is contenteditable?");
            elementDOM.querySelector('#' + target.id ).setAttribute('contenteditable', 'true');
            elementDOM.querySelector('#' + target.id).focus();
        } 
        if (target.parentNode.classList.contains('dragAnswer') || target.parentNode.classList.contains('fixAnswer')){
            //console.log(target.parentNode.id + " is contenteditable?");
            elementDOM.querySelector('#' + target.parentNode.id ).setAttribute('contenteditable', 'true');
            elementDOM.querySelector('#' + target.parentNode.id).focus();
        } 
        else return; 
};
*/
/*elementDOM.querySelector("#view").onblur = function(event){
    var target = event.target;
    console.log(target.id);

}
*/

function editAnswers(){  
// не работает .fixAnswer так так у них нет id
$(".dragAnswer, .fixAnswer").dblclick(function (){
    $("#"+this.id).attr("contenteditable",true);
    $("#"+this.id).css("background",'white');
    $("#"+this.id).css("cursor","text");

    document.getElementById(this.id).focus();
});

$(".dragAnswer, .fixAnswer").blur(function (){
    $("#"+this.id).attr("contenteditable",false);
    $("#"+this.id).css("background","");
    $("#"+this.id).css("cursor","move");
});

} 


//фиксация строки
elementDOM.querySelector('#fixLine').onclick = function(){
    fixLine(documentTable);
    setBlockHtml('view', documentTable.innerHTML);
    editor.setValue(documentTable.innerHTML);
    drag();
    editAnswers();
};

//фиксация столбца 
elementDOM.querySelector('#fixColumn').onclick = function(){
    fixColumn(documentTable);
    setBlockHtml('view', documentTable.innerHTML);
    editor.setValue(documentTable.innerHTML);
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
  console.log(correctAnswer+" : "+generationAnswerJSON(correctAnswer));
  correctAnswer = generationAnswerJSON(correctAnswer);

  elementDOM.querySelector('#correct_answer').setAttribute('value', correctAnswer);
  var studentView = elementDOM.querySelector("#view");
  editor.setValue(studentView.innerHTML);
}



/*перенос всех ответов в отдельное поле*/
function getAllAnswers(){

    var allAnswersList = elementDOM.querySelector('#view').querySelectorAll('.dragAnswer');
    var allAnswersDiv = document.createElement('div');
    allAnswersDiv.id = "allAnswers";
    allAnswersDiv.classList.add("answerPlace");
    forEachInCollection(allAnswersList, function(value){ 
        allAnswersDiv.appendChild(value);
    });
    elementDOM.querySelector('#view').appendChild(allAnswersDiv);
    //перемешивание
    for (var i = allAnswersDiv.children.length; i >= 0; i--) {
        allAnswersDiv.appendChild(allAnswersDiv.children[Math.random() * i | 0]);
    }
    documentTable.innerHTML = elementDOM.querySelector("#view").getElementsByTagName("table")[0].outerHTML;
    drag();
    editAnswers();

    var studentView = elementDOM.querySelector("#view");
    editor.setValue(studentView.innerHTML);

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




