name::
Forces

description:: 
Выбор действующий сил и моментов на объект или обекты

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
    	<div id="view"></div>
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

#raw{
	background-color: #F9F9F9
}







javascriptStudent::
mengine.xq = 'текст';
mengine.console = function(){console.log(this.xq)};
mengine.console()

javascriptStudio::

//дизайн страницы
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

elementSVG = {
	NS: 'http://www.w3.org/2000/svg',
	createElement: function(name){
        var element = document.createElementNS(this.NS, name);
        return element;
    }
};

console.log(elementSVG.createElement('svg'));



elementDOM.querySelector('#conraw').onclick = function(){
stringSVG = elementDOM.querySelector('#raw').value;
parser = new DOMParser();
doc = parser.parseFromString(stringSVG, "image/svg+xml");
console.log(doc);
elementDOM.querySelector('#view').appendChild(doc.svg);
}