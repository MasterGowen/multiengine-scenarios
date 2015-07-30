name::
Forces

description:: 
Выбор действующий сил и моментов на объект или обекты

html::
    <a id=scSave>Сохранить результат</a>
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
elementDOM.querySelector('#viewSettings').onclick = function(){elementDOM.getElementsByClassName('step-one')[0].style.display = 'block';}

function CONRaw(){setBlockHtml('view', getValueFild('raw').body.innerHTML)};
elementDOM.querySelector('#conraw').onclick = CONRaw;
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

function scSave(){
console.log(getValueFild('view').body.innerHTML)
    editor.setValue(getValueFild('view').body.innerHTML);
}

elementDOM.querySelector('#scSave').onclick = scSave;